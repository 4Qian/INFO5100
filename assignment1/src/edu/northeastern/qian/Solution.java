package edu.northeastern.qian;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * Question 1:
     * You are given an integer array nums. The unique elements of an array are the elements that appear
     exactly once in the array.
     * Return the sum of all the unique elements of nums.
     * Example 1:
     * Input: nums = [1,2,3,2]
     * Output: 4
     * Explanation: The unique elements are [1,3], and the sum is 4.
     * Example 2:
     * Input: nums = [1,1,1,1,1]
     * Output: 0
     * Explanation: There are no unique elements, and the sum is 0.
     */

    public static int sumOfUnique(int[] nums) {
        int[] cnt = new int[101];
        for (int n : nums) {
            cnt[n]++;
        }

        int sum = 0;
        for (int n : nums) {
            if (cnt[n] == 1) {
                sum += n;
            }
        }
        return sum;
    }


    /**
     * Question 2:
     * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number
     sorted in non-decreasing order.
     * Example 1:
     * Input: nums = [-4,-1,0,3,10] Output: [0,1,9,16,100]
     * Explanation: After squaring, the array becomes [16,1,0,9,100]. After sorting, it becomes [0,1,9,16,100].
     */

    public static int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            int square;
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                square = nums[right];
                right--;
            }else {
                square = nums[left];
                left++;
            }
            res[i] = square * square;
        }
        return res;
    }


    /**
     * Question 3:
     * Find first non repeated integer in an array.
     * Example: int[] arr = {2,3,4,2,2,3,5,7} Output : 4
     */

    //solution1
    public static int getFirstNonRepeating_1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j;
            for (j = 0; j < arr.length; j++) {
                if (i != j && arr[i] == arr[j]) {
                    break;
                }
            }
            if (j == arr.length) {
                return arr[i];
            }
        }
        return -1;
    }

    //solution2
    public static int getFirstNonRepeating_2(int[] arr) {
        Set<Integer> singles = new HashSet<>();
        Set<Integer> repeats = new HashSet<>();

        for (int n : arr) {
            if (repeats.contains(n)) {
                continue;
            }
            if (singles.contains(n)) {
                singles.remove(n);
                repeats.add(n);
            }else{
                singles.add(n);
            }
        }

        for (int n : arr) {
            if (singles.contains(n)) {
                return n;
            }
        }
        return -1;
    }


    /**
     * Question 4:
     * Given two stings ransomNote and magazine, return true if ransomNote can be constructed from magazine
     * and false otherwise.
     * Each letter in magazine can only be used once in ransomNote.
     * Example 1:
     * Input: ransomNote = "a", magazine = "b" Output: false
     * Example 2:
     * Input: ransomNote = "aa", magazine = "ab" Output: false
     */

    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] count = new int[26];
        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            count[c - 'a']--;
            if (count[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * Question 5:
     * Letter followed by Digit: Given a string str write a function which will check if the string no
     * letter followed by another letter, and no digit followed by another digit.
     * For example: 1A3d4s5t Result : True
     * Input: A2bb2d4 Result : False
     */

    //If we assume the string only contain english letters or digits.
    public static boolean letterFollowedByDigit1(String str) {
        char[] chars = str.toCharArray();
        boolean shouldBeDigit = isDigit(chars[0]);
        for (int i = 0; i < str.length(); i += 1) {
            if (isDigit(chars[i]) != shouldBeDigit) {
                return false;
            }
            shouldBeDigit = !shouldBeDigit;
        }
        return true;
    }

    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }


    // If we assume the string can contain characters other than english letters and digits
    public static boolean letterFollowedByDigit2(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            int cate1 = category(chars[i]);
            int cate2 = category(chars[i+1]);
            if ((cate1 == 1 && cate2 == 1) || (cate1 == 0 && cate2 == 0)) {
                return false;
            }
        }
        return true;
    }

    private static int category(char c) {
        if (c >= '0' && c <= '9') {
            return 0;//digits
        } else if ( (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            return 1;//letters
        }
        return 2;//special characters
    }
}
