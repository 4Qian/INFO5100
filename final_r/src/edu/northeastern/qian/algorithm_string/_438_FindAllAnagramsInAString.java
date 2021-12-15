package edu.northeastern.qian.algorithm_string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _438_FindAllAnagramsInAString {
    // https://leetcode.com/problems/find-all-anagrams-in-a-string/
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList();
        }

        Map<Character, Integer> cntP = new HashMap();
        Map<Character, Integer> cntS = new HashMap();

        for (char ch : p.toCharArray()) {
            cntP.put(ch, cntP.getOrDefault(ch, 0) + 1);
        }

        List<Integer> res = new ArrayList();
        // sliding window on the string s
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (cntS.containsKey(ch)) {
                cntS.put(ch, cntS.get(ch) + 1);
            }
            else {
                cntS.put(ch, 1);
            }

            // remove one letter from the left side of the window
            if (i >= p.length()) {
                ch = s.charAt(i - p.length());
                if (cntS.get(ch) == 1) {
                    cntS.remove(ch);
                }
                else {
                    cntS.put(ch, cntS.get(ch) - 1);
                }
            }
            // compare hashmap in the sliding window with the reference hashmap
            if (cntP.equals(cntS)) {
                res.add(i - p.length() + 1);
            }
        }
        return res;
    }
}
