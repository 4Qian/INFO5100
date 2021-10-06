package leetcode;

public class Problem7 {
    public static void main(String[] args) {
        System.out.println("==============================LeetCode 7============================");

        String num1 = "11";
        String num2 = "123";
        System.out.println("The sum of num1 and num2 as a string is " +
                addStrings(num1, num2));// expected "134"

        String num3 = "456";
        String num4 = "77";
        System.out.println("The sum of num1 and num2 as a string is " +
                addStrings(num3, num4));// expected "533"
        System.out.println();
    }


    /**
     * LeetCode 7:
     * Time complexity: O(max(n, m)) -> n and m are length of num1 an num2
     * Space complexity: O(max(n, m))
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String addStrings(String num1, String num2) {
        // for using reverse function by create a StringBuilder
        StringBuilder res = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        // calculate from the end to the beginning
        while (i >= 0 || j >= 0) {
            int x = i >= 0? num1.charAt(i) - '0' : 0;
            int y = j >= 0? num2.charAt(j) - '0' : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            res.append(sum % 10);
            i--;
            j--;
        }
        // taking the possibility of extra carry into account
        if (carry > 0) {
            res.append(carry);
        }
        return res.reverse().toString();
    }
}
