package edu.northeastern.qian.algorithm_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_3Sum {
    // https://leetcode.com/problems/3sum/
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSum(nums, i, res);
            }
        }
        return res;
    }
    private void twoSum(int[]nums, int i, List<List<Integer>> res) {
        int start = i + 1;
        int end = nums.length - 1;
        while (start < end) {
            int sum = nums[i] + nums[start] + nums[end];
            if (sum > 0) {
                end--;
            }else if (sum < 0){
                start++;
            }else{
                res.add(Arrays.asList(nums[i], nums[start++], nums[end--]));
                while (start < end && (nums[start - 1] == nums[start]) ) {
                    start++;
                }
                while (start < end && (nums[end + 1] == nums[end]) ) {
                    end--;
                }
            }
        }
    }
}
