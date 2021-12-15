package edu.northeastern.qian.algorithm_array;

public class _238_ProductOfArrayExceptSelf {
    // https://leetcode.com/problems/product-of-array-except-self/
    public int[] productExceptSelf(int[] nums) {
        // 左边乘积 * 右边乘积
        int[] res = new int[nums.length];
        int leftProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = leftProduct;
            leftProduct = leftProduct * nums[i];
        }

        int rightProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = res[i] * rightProduct;
            rightProduct = nums[i] * rightProduct;
        }
        return res;
    }
}
