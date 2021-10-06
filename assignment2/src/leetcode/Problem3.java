package leetcode;
import static leetcode.Helper.printArray;

public class Problem3 {
    public static void main(String[] args) {
        System.out.println("==============================LeetCode 3============================");

        int[] nums1 = {0,1,0,3,12};
        System.out.print("The moved zeroes array is ");
        printArray(moveZeroes(nums1));// expected [1,3,12,0,0]

        int[] nums2 = {0};
        System.out.print("The moved zeroes array is ");
        printArray(moveZeroes(nums2));// expected [0]
        System.out.println();
    }


    /**
     * LeetCode 3:
     * Time complexity: O(n)
     * Space complexity: o(1)
     *
     * @param nums
     */
    public static int[] moveZeroes(int[] nums) {
        int index = 0;
        //put all the num that are not equal to zero into the array's front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        //fill the remaining space with 0
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
        return nums;
    }
}
