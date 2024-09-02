package plus.gaga.middleware.sdk.domain.model;

import java.util.List;

public class ChatCompletionRequest {

    /**
     * 按照开发文档需求，提供两个必须参数 model、messages
     */
    private String model = Model.GLM_4_FLASH.getCode();
    private List<Prompt> messages;


    /**
     * 调用语言模型时，将当前对话信息列表作为提示输入给模型， 按照 {"role": "user", "content": "你好"}
     * 的json 数组形式进行传参；
     * 可能的消息类型包括 System message、User message、Assistant message 和 Tool message。
     */
    public static class Prompt {
        private String role;
        private String content;

        public Prompt() {
        }

        public Prompt(String role, String content) {
            this.role = role;
            this.content = content;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Prompt> getMessages() {
        return messages;
    }

    public void setMessages(List<Prompt> messages) {
        this.messages = messages;
    }
}
