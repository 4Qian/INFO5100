package edu.northeastern.qian._streamConcept;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collect {
    public static void main(String[] args) {
        ArrayList<String> manList = new ArrayList<>();
        manList.add("cheng");
        manList.add("lia");
        manList.add("jin");
        manList.add("liu");
        manList.add("zhourun");
        // collect : 收集成set， list， map
        manList.stream().filter(s -> s.length() == 3).collect(Collectors.toList());

        Set<Integer> set = new HashSet<>();
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);
        set.add(50);
        set.stream().filter(i -> i > 20).collect(Collectors.toSet());

        // 大于20
        String[] arr = {"lin,30", "li,20", "zhang,41"};
        Stream<String> arrStream = Stream.of(arr)
                .filter(s -> Integer.parseInt(s.split(",")[1]) > 20);

        arrStream.collect(Collectors
                .toMap(str -> str.split(",")[0], str -> Integer.parseInt(str.split(",")[1])));

    }
}
