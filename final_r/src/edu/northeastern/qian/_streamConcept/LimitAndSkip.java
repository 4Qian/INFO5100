package edu.northeastern.qian._streamConcept;

import java.util.ArrayList;

public class LimitAndSkip {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("li");
        list.add("zun");
        list.add("yan");
        list.add("qian");
        list.add("yong");
        // limit： 截取前指定参数个数的数据
        list.stream().limit(3).forEach(System.out::println);
        System.out.println("=======");

        //跳过指定参数个数的数据，返回剩余元素组成的流
        list.stream().skip(3).forEach(System.out::println);

        //  跳过指定参数个数的数据，返回剩余元素前2个组成的流
        list.stream().skip(2).limit(2).forEach(System.out::println);
    }
}
