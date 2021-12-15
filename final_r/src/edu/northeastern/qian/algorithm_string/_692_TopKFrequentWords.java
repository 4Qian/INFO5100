//package edu.northeastern.qian.algorithm_string;
//
//import java.util.*;
//
//public class _692_TopKFrequentWords {
//    // https://leetcode.com/problems/top-k-frequent-words/
//
//    public List<String> topKFrequent(String[] words, int k) {
//        //用pq 按照出现的频率排列，小的频率再顶
//        Map<String, Integer> map = new HashMap<>();
//        for (String s : words) {
//            map.put(s, map.getOrDefault(s, 0) + 1);
//        }
//        Queue<String> pq = new PriorityQueue<>(new Comparator<>(){
//            @Override
//            public int compare (String a, String b) {
//                if (map.get(a) == map.get(b)) {// 频率相等
//                    return b.compareTo(a);
//                }
//                return map.get(a) - map.get(b);//最后想要的结果是频率高->低， 字母顺序小->大; 所以pq里面应该频小->低， 字母顺序大->小;
//            }
//        });
//        for (String s : map.keySet()) {
//            pq.add(s);
//            if (pq.size() > k) {
//                pq.poll();
//            }
//        }
//        List<String> res = new ArrayList<>();
//        while (!pq.isEmpty()) {
//            res.add(pq.poll());
//        }
//        Collections.reverse(res);
//        return res;
//    }
//}
