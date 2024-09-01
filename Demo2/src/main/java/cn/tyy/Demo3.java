package cn.tyy;

import java.io.*;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
* TODO 验证扰动函数的作用
* */
public class Demo3 {
    public static void main(String[] args) throws IOException {
        Map<Integer,Integer> map = new HashMap<>(16);
        Set<String> words = list();

        for (String word:words){
            //使用扰动函数
            int idx = Disturb.disturbHashIdx(word,128);

            //不使用扰动函数
            //            int idx = Disturb.hashIdx(word,128);
            if(map.containsKey(idx)){
                Integer integer = map.get(idx);
                map.put(idx,integer+1);
            }else {
                map.put(idx,1);
            }

        }

        System.out.println(map.values());


    }

    private static Set<String> list() throws IOException {
        HashSet<String> hashSet = new HashSet<>();
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("C:\\Users\\ritian\\Desktop\\study-files\\练习\\数据结构与算法\\untitled\\103976个英语单词库.txt"));
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = "";
        while ((line = bufferedReader.readLine())!=null){
            String[] arr = line.split("\t");
            hashSet.add(arr[1]);
        }
        bufferedReader.close();
        inputStreamReader.close();

        return hashSet;
    }

    static class Disturb{
        public static int disturbHashIdx(String key,int size){
            return (size-1)&(key.hashCode()^(key.hashCode()>>>16));
        }
        public static int hashIdx(String key,int size){
            return (size-1)&key.hashCode();
        }
    }
}
