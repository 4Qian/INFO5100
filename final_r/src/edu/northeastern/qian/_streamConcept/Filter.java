package edu.northeastern.qian._streamConcept;

import java.util.ArrayList;

public class Filter {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("li");
        list.add("zun");
        list.add("yan");
        list.add("qian");
        list.add("yong");

        // predicate(谓语)
        list.stream().filter(s -> s.startsWith("y")).forEach(System.out::println);
        System.out.println("=========");
        list.stream().filter(s -> s.length() == 3).forEach(System.out::println);
        System.out.println("=========");
        list.stream()
                .filter(s -> s.startsWith("y"))
                .filter(s -> s.length() == 3)
                .forEach(System.out::println);
    }
}
