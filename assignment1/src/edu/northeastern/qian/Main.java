package edu.northeastern.qian;
import static edu.northeastern.qian.Solution.*;

public class Main {

    public static void main(String[] args) {
        //question1
        System.out.println("================question1====================");

        int[] arr = {1, 2, 3, 4, 5};
        int[] arr1 = {1, 2, 3, 2};

        System.out.println("The sum of the unique elements is " + sumOfUnique(arr));//15
        System.out.println("The sum of the unique elements is " + sumOfUnique(arr1));//4
        System.out.println();

        //question2
        System.out.println("================question2====================");

        int[] arr3 = {-4, -1, 0, 3, 10};
        int[] arr_3 = {-3, -2, 0, 4, 10};

        System.out.print("The squares of each number is ");
        printArray(sortedSquares(arr3));//[0,1,9,16,100]
        System.out.println();

        System.out.print("The squares of each number is ");
        printArray(sortedSquares(arr_3));//[0,4,9,16,100]
        System.out.println();
        System.out.println();

        //question3
        System.out.println("================question3====================");

        int[] arr4 = {2,3,4,2,2,3,5,7};
        int[] arr_4 = {3,2,3,2,5,3,3,7};

        System.out.println("The first non repeating number is " + getFirstNonRepeating_1(arr4));//4
        System.out.println("The first non repeating number is " + getFirstNonRepeating_2(arr4));//4
        System.out.println("The first non repeating number is " + getFirstNonRepeating_1(arr_4));//5
        System.out.println("The first non repeating number is " + getFirstNonRepeating_2(arr_4));//5
        System.out.println();

        //question4
        System.out.println("================question4====================");

        String ransomNote = "aabd";
        String magazine = "aabc";

        String ransomNote1 = "aabd";
        String magazine1 = "aabdc";

        System.out.println("Is ransomNote can be constructed from magazine? " +
                canConstruct(ransomNote, magazine));//false
        System.out.println("Is ransomNote can be constructed from magazine? " +
                canConstruct(ransomNote1, magazine1));//true
        System.out.println();

        //question5
        System.out.println("================question5====================");

        String str = "1A3d4s5t";
        String string = "A2bb2d4";

        String str_1 = "1a3f4e5g";
        String string_1 = "d3bbb5d8";

        System.out.println("Are letters followed by digits? " + letterFollowedByDigit1(str));//true
        System.out.println("Are letters followed by digits? " + letterFollowedByDigit1(string));//false
        System.out.println("Are letters followed by digits? " + letterFollowedByDigit2(str));//true
        System.out.println("Are letters followed by digits? " + letterFollowedByDigit2(string));//false
        System.out.println();

        System.out.println("Are letters followed by digits? " + letterFollowedByDigit1(str_1));//true
        System.out.println("Are letters followed by digits? " + letterFollowedByDigit1(string_1));//false
        System.out.println("Are letters followed by digits? " + letterFollowedByDigit2(str_1));//true
        System.out.println("Are letters followed by digits? " + letterFollowedByDigit2(string_1));//false
        System.out.println();
    }

    public static void printArray(int[] nums) {
        System.out.print("[");
        for (int i = 0; i < nums.length - 1; i++) {
            System.out.print(nums[i]);
            System.out.print(", ");
        }
        System.out.print(nums[nums.length - 1]);
        System.out.print("] ");
    }
}
