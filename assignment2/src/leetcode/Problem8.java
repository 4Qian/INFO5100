package leetcode;

public class Problem8 {
    public static void main(String[] args) {
        System.out.println("==============================LeetCode 8============================");

        String s1 = "A man, a plan, a canal: Panama";
        System.out.println("Is a palindrome? " + isPalindrome(s1));//true

        String s2 = "race a car";
        System.out.println("Is a palindrome? " + isPalindrome(s2));//false
        System.out.println();
    }


    /**
     * LeetCode 8:
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 1) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // ignore non-alphanumeric characters by continuing to traverse further
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            // Make sure to compare in lowercase letter, if they are not equal, return false
            if (left < right && (Character.toLowerCase(s.charAt(left)) !=
                    Character.toLowerCase(s.charAt(right)))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
