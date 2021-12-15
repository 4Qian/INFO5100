package edu.northeastern.qian.algorithm_array;

import java.util.HashSet;
import java.util.Set;

public class _128_LongestConsecutiveSequence {
    // https://leetcode.com/problems/longest-consecutive-sequence/
    public int longestConsecutive(int[] nums) {
        // 把所有数放进set， 利用set找到可能的consecutive sequence的开头，再从开头计算在这个数基础上连续的所有数字， 算出后对比找到最长
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLen = 0;
        int cnt = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                cnt = 1;
                int cur = num;
                while (set.contains(cur + 1)) {
                    cur = cur + 1;
                    cnt++;
                }
                maxLen = Math.max(maxLen, cnt);
            }
        }
        return maxLen;
    }
}
