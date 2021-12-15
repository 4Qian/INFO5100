package edu.northeastern.qian.algorithm_string;

import java.util.*;

public class _49_GroupAnagrams {
    // https://leetcode.com/problems/group-anagrams/
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        // 字谜的共同点是按照字母顺序排序后都是一样的， 把排序后的string作为key， value是各个strs里的string
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();//s 转成char[] 才能排序
            Arrays.sort(chars);
            String sorted = String.valueOf(chars);
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
