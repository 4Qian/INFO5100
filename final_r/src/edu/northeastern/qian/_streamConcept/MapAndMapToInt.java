package edu.northeastern.qian._streamConcept;

import java.util.ArrayList;

public class MapAndMapToInt {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("10");
        list.add("20");
        list.add("30");
        list.add("40");
        list.add("50");

        // map: 转换
        // 字符串转为整数后输出
        list.stream().map(s -> Integer.parseInt(s)).forEach(System.out::println);
//        list.stream().map(Integer::parseInt).forEach(System.out::println);

//        list.stream().mapToInt(s -> Integer.parseInt(s)).forEach(System.out::println);

        // mapToInt 返回为intStream 有sum的方法
//        int res = list.stream().mapToInt(Integer:: parseInt).sum();
//        System.out.println(res);

        System.out.println("reduce res:");
        list.stream().reduce((s1, s2) -> String.valueOf(Integer.parseInt(s1) + Integer.parseInt(s2))).ifPresent(System.out::println);

    }
}
