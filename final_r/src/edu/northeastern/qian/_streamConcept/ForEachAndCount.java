package edu.northeastern.qian._streamConcept;

import java.util.ArrayList;

public class ForEachAndCount {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("ai");
        list.add("yangzun");
        list.add("angel");
        list.add("qia");
        list.add("zun");

        // forEach：输出
//        list.stream().forEach(System.out::println);

        // count：统计
        long cnt = list.stream().filter(s -> s.startsWith(s)).count();
        System.out.println(cnt);

    }
}
