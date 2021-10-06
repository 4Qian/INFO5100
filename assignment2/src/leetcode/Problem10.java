package leetcode;

public class Problem10 {
    public static void main(String[] args) {
        System.out.println("==============================LeetCode 10============================");

        char[] chars1 = {'a','a','b','b','c','c','c'};
        System.out.println("The new length of the array is " +
                compress(chars1));// expected 6

        char[] chars2 = {'a','a','a','b','b','a','a'};
        System.out.println("The new length of the array is " +
                compress(chars2));// expected 6

        char[] chars3 = {'a'};
        System.out.println("The new length of the array is " +
                compress(chars3));// expected 1
    }


    /**
     * LeetCode 10:
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param chars
     * @return
     */
    public static int compress(char[] chars) {
        int i = 0;
        // Index records the length of the new array at the end
        int index = 0;
        while (i < chars.length) {
            //j-1 is the rightmost part of a continuous identical substring
            int j = i;
            while (j < chars.length && chars[j] == chars[i]) {
                j++;
            }
            chars[index++] = chars[i];
            // If the length of this "group" is greater than 1, we need to add the length of the "group"
            // to the new array
            if (j - i > 1) {
                String cnt = j - i + "";
                for (char c : cnt.toCharArray()) {
                    chars[index++] = c;
                }
            }
            i = j;
        }
        return index;
    }
}
