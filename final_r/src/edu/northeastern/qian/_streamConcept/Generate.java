package edu.northeastern.qian._streamConcept;

import java.util.*;
import java.util.stream.Stream;

public class Generate {
    public static void main(String[] args) {
        // collection 体系可用默认方法生成流
        List<String> list = new ArrayList<>();
        list.stream();

        Set<String> set = new HashSet<>();
        Stream<String> setStream = set.stream();

        // map体系的集合间接生成流
        Map<String, Integer> map = new HashMap<>();
        Stream keyStream = map.keySet().stream();
        Stream valueStream = map.values().stream();
        Stream entryStream = map.entrySet().stream();

        // 数组通过stream接口的静态方法生成流
        String[] arr = new String[]{"h", "o","w"};
        Stream<String> stringStream = Stream.of(arr);

        Stream<String> sStream = Stream.of("h", "o","w");
        Stream<Integer> integerStream =  Stream.of(1,2,3);
    }
}
