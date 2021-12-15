package edu.northeastern.qian._streamConcept;

import java.util.ArrayList;

public class Sorted {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("li");
        list.add("yangzun");
        list.add("angel");
        list.add("qia");
        list.add("zun");

        // sorted : 默认为按照字母顺序输出数据
        list.stream().sorted().forEach(System.out::println);

        // sorted： custom sorted：按照字符长度输出数据
        System.out.println("按照字符长度输出数据");
//        list.stream().sorted((s1, s2) -> s1.length() - s2.length()).forEach(System.out::println);

        list.stream().sorted((s1, s2) -> {
            int num = s1.length() - s2.length();
            int num2 = num == 0? s1.compareTo(s2) : num;
            return num2;
        }).forEach(System.out::println);

    }
}
