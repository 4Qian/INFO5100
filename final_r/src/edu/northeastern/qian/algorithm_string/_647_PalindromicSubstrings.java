package edu.northeastern.qian.algorithm_string;

public class _647_PalindromicSubstrings {
    // https://leetcode.com/problems/palindromic-substrings/
    public int countSubstrings(String s) {
        // 得算出有多少个substrings， substrings里面有多少个palindromic
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s, i, j)) {
                    res = res + 1;
                }
            }
        }
        return res;
    }

    private boolean isPalindrome (String s, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }
        return isPalindrome (s, left + 1, right - 1);
    }
}
