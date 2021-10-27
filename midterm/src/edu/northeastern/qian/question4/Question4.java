package edu.northeastern.qian.question4;

public class Question4 {
    public String lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return "";
        }
        int longestLen = 0;
        int[] resIndex = new int[2];
        int[] map = new int[256];
        int start = 0;
        // sliding window
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
            while (map[s.charAt(i)] > 1) {
                map[s.charAt(start)]--;
                start++;
            }
            if (i - start + 1 > longestLen) {
                longestLen = i - start + 1;
                resIndex[0] = start;
                resIndex[1] = i;
            }
        }
        return s.substring(resIndex[0], resIndex[1] + 1);
    }
    
    // test
    public static void main(String[] args) {
        Question4 question4 = new Question4();
        System.out.println(question4.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(question4.lengthOfLongestSubstring("abbabcdbb"));
        System.out.println(question4.lengthOfLongestSubstring("abbabbb"));
    }
}

