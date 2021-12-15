package edu.northeastern.qian.question3;

public class Main {
    public static int subarraySum(int[] nums, int k) {

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

    public static void main(String[] args) {

        int[] nums = {1,1,1};
        int k = 2;

        int[] nums1 = {1,2,3};
        int k1 = 3;

        int[] nums2 = {};
        int k2 = 1;

        int[] nums3 = {1};
        int k3 = 1;

        System.out.println(subarraySum(nums, k));// 2
        System.out.println(subarraySum(nums1, k1)); //2
        System.out.println(subarraySum(nums2, k2)); // 0
        System.out.println(subarraySum(nums3, k3)); // 1
    }
}
