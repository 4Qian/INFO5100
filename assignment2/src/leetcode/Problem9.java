package leetcode;
import java.util.ArrayDeque;
import java.util.Deque;

public class Problem9 {
    public static void main(String[] args) {
        System.out.println("==============================LeetCode 9============================");

        String s3 = "the sky is blue";
        System.out.println("The string of the words in reverse order concatenated by a single space is " +
                reverseWords(s3));// expected "blue is sky the"

        String s4 = "  Bob    Loves  Alice   ";
        System.out.println("The string of the words in reverse order concatenated by a single space is " +
                reverseWords(s4));// expected "Alice Loves Bob"
        System.out.println();
    }


    /**
     * LeetCode 9:
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        int left = 0;
        int right = s.length() - 1;
        //remove the leading spaces
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }
        //remove the trailing spaces
        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }
        // offer valid word into dq
        Deque<String> dq = new ArrayDeque();
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            if (left <= right && s.charAt(left) != ' ') {
                sb.append(s.charAt(left));
            }else if (sb.length() != 0 && s.charAt(left) == ' ') {
                dq.offerFirst(sb.toString());
                sb.setLength(0);
            }
            left++;
        }
        dq.offerFirst(sb.toString());
        return String.join(" ", dq);
    }
}
