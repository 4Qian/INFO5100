package edu.northeastern.qian._streamConcept;

import java.util.ArrayList;
import java.util.stream.Stream;

public class ContactAndDistinct {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("li");
        list.add("zun");
        list.add("yan");
        list.add("qian");
        list.add("yong");

        // contact: 合并两个流为一个流
        Stream<String> limited = list.stream().limit(4);
        Stream<String> skipped = list.stream().skip(2);
//        Stream.concat(limited,skipped).forEach(System.out::println);

        // distinct: 只取不重复的元素
        System.out.println("用distinct: 只取不重复的元素");
        Stream.concat(limited,skipped).distinct().forEach(System.out::println);
    }
}
