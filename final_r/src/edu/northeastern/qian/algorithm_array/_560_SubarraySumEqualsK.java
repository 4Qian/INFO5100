package edu.northeastern.qian.algorithm_array;

public class _560_SubarraySumEqualsK {
    // https://leetcode.com/problems/subarray-sum-equals-k/
    public int subarraySum(int[] nums, int k) {
        // 找出所有subArray，再找出这里面sum等于k的，并计算个数
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum == k) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
