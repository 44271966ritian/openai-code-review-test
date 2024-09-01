package cn.tyy;

import java.util.ArrayList;
import java.util.List;
/*
* TODO 简易散列表的实现
* */
public class Demo1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("jack");
        list.add("hellen");
        list.add("月夜");
        list.add("鉴心");
        list.add("秧秧");
        list.add("mary");

        String arr[] = new String[8];

        for (String key : list) {
            int hashCode = key.hashCode();
            int index = hashCode & (arr.length - 1);

            if (arr[index] == null) {
                arr[index] = key;
            } else {
                System.out.println("发生冲突");
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
