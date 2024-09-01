package cn.tyy.hash;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class FileUtil {
    /*
    * TODO 读取本地文件，单词表
    * */

    public static Set<String> readWordList(String url){
        Set<String> list = new HashSet<>();
        //TODO 读取文件
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(url), "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line = "";

            //TODO 读取文件内容，放入list
            //  split \t
            while ((line = br.readLine()) != null) {
                String[] ss = line.split("\t");
                list.add(ss[1]);
            }

            br.close();
            isr.close();
        } catch (Exception e) {
            return null;
        }

        //TODO 返回list
        return list;
    }
}
