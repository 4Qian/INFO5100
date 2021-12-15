package edu.northeastern.qian.question2;

import java.util.*;

public class Main {

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = String.valueOf(chars);
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs1 = {"eat","tea","tan","ate","nat","bat"};
        String[] strs2 = {""};
        String[] strs3 = {"a" };

        System.out.println(groupAnagrams(strs1));// [[bat],[nat,tan],[ate,eat,tea]]
        System.out.println(groupAnagrams(strs2));// [[]]
        System.out.println(groupAnagrams(strs3));// [[a]]
    }
}
