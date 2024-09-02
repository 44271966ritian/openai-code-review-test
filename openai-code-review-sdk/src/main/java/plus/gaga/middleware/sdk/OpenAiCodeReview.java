package plus.gaga.middleware.sdk;

import com.alibaba.fastjson2.JSON;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import plus.gaga.middleware.sdk.domain.model.ChatCompletionRequest;
import plus.gaga.middleware.sdk.domain.model.ChatCompletionSyncResponse;
import plus.gaga.middleware.sdk.domain.model.Model;
import plus.gaga.middleware.sdk.types.utils.BearerTokenUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class OpenAiCodeReview {

    public static void main(String[] args) throws Exception {
        System.out.println("测试执行");

        // 1. 代码检出

        //输出当前提交与上一个提交之间的差异
        ProcessBuilder processBuilder = new ProcessBuilder("git", "diff", "HEAD~1", "HEAD");
        //指定目录
        processBuilder.directory(new File("."));
        //启动进程
        Process process = processBuilder.start();
        //读取差异内容
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        StringBuilder diffCode = new StringBuilder();//差异代码
        while ((line = reader.readLine()) != null) {
            diffCode.append(line);
        }
        //进程退出码
        int exitCode = process.waitFor();

        System.out.println("Exited with code:" + exitCode);

        System.out.println("diff code：" + diffCode.toString());

        // 2. chatglm 代码评审
        String log = codeReview(diffCode.toString());
        System.out.println("code review：" + log);
    }

    private static String codeReview(String diffCode) throws Exception {

        //用户鉴权的apiKey
        String apiKeySecret = "f324acfa09bb651124bb4ba4f59485b6.JbRNoQBp4ZC8AWS4";
        //得到token
        String token = BearerTokenUtils.getToken(apiKeySecret);

        URL url = new URL("https://open.bigmodel.cn/api/paas/v4/chat/completions");
        //HttpURLConnection
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Authorization", "Bearer " + token);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        connection.setDoOutput(true);

        ChatCompletionRequest chatCompletionRequest = new ChatCompletionRequest();
        //传入所需调用的模型编码
        chatCompletionRequest.setModel(Model.GLM_4_FLASH.getCode());


        chatCompletionRequest.setMessages(new ArrayList<ChatCompletionRequest.Prompt>(){
            private static final long serialVersionUID = -7988151926241837899L;

            {
                add(new ChatCompletionRequest.Prompt("user","你是一个很牛逼的编程架构师，请你根据git diff记录，对以下代码做出评审。代码如下:"));
                add(new ChatCompletionRequest.Prompt("user",diffCode));
            }
        });

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = JSON.toJSONString(chatCompletionRequest).getBytes(StandardCharsets.UTF_8);
            os.write(input);
        }

        int responseCode = connection.getResponseCode();
        System.out.println(responseCode);



        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;

        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        connection.disconnect();

        System.out.println("评审结果：" + content.toString());

        ChatCompletionSyncResponse response = JSON.parseObject(content.toString(), ChatCompletionSyncResponse.class);
        return response.getChoices().get(0).getMessage().getContent();
    }

    private static String writeLog(String token,String log) throws Exception{

        //git操作，指定仓库
        Git git = Git.cloneRepository()
                .setURI("")
                .setDirectory(new File("repo"))
                .setCredentialsProvider(new UsernamePasswordCredentialsProvider(token, ""))
                .call();

        //推送日期
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateFolderName = simpleDateFormat.format(new Date());

        //日志目录
        //例如 repo/2024-09-02
        File dateFolder = new File("repo/" + dateFolderName);
        if(!dateFolder.exists()){
            dateFolder.mkdirs();//没有就生成对应的二级目录
        }

        //日志文件
        //例如 111111111111.md
        String fileName = generateRandomString(12) + ".md";
        File newFile = new File(dateFolder, fileName);

        //往日志中写入内容
        //往 111111111111.md中写入内容
        try(FileWriter fileWriter = new FileWriter(newFile)){
            fileWriter.write(log);
        }

        //git命令
        //编写代码提交代码
        //先在仓库中创建目录
        git.add().addFilepattern(dateFolderName+ "/" + fileName).call();
        //和我们直接操作git控制台的commit一个效果
        git.commit().setMessage("Add new file").call();
        //提交也需要账户和密码，仓库已经在git对象上指定好了，用户需要在提交时确定【为什么git也指定了用户和密码？】
        git.push().setCredentialsProvider(new UsernamePasswordCredentialsProvider(token,"")).call();
    }

    private static String generateRandomString(int length) {
        return null;
    }

}
