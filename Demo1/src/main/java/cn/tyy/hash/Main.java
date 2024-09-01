package cn.tyy.hash;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        for (int i = 0; i < 100; i++) {

            list.add(i);
        }

        System.out.println("list.stream().distinct().count() = " + list.stream().distinct().count());

    }
}
