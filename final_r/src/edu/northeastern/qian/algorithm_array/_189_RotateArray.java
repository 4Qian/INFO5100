package edu.northeastern.qian.algorithm_array;

public class _189_RotateArray {
    // https://leetcode.com/problems/rotate-array/
    public void rotate(int[] nums, int k) {
        // 先把整个array反转一遍
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        // 再按照k reverse
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    private void reverse (int[] nums, int i , int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
