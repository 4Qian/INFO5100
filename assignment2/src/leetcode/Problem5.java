package leetcode;
import java.util.ArrayList;
import java.util.List;
import static leetcode.Helper.printList;

public class Problem5 {
    public static void main(String[] args) {
        System.out.println("==============================LeetCode 5============================");

        int[][] matrix_5 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.print(" The matrix that all elements are in spiral order is ");
        printList(spiralOrder(matrix_5));// expected [1,2,3,4,8,12,11,10,9,5,6,7]

        int[][] matrix_6 = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.print(" The matrix that all elements are in spiral order is ");
        printList(spiralOrder(matrix_6));// expected [1,2,3,6,9,8,7,4,5]
        System.out.println();
    }


    /**
     * LeetCode 5:
     * Time complexity: O(n * m) -> n is the number of rows and m is the number of columns
     * Space complexity: O(n * m)
     *
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        // set up boundaries to let us know when need to change direction
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = cols - 1;
        int up = 0;
        int down = rows - 1;

        while (res.size() < rows * cols) {
            // Traverse from left to right
            for (int col = left; col <= right; col++) {
                res.add(matrix[up][col]);
            }
            // Traverse from up to down
            for (int row = up + 1; row <= down; row++) {
                res.add(matrix[row][right]);
            }
            // make sure that we are not traverse a row that has already been traversed
            if (up != down) {
                // then traverse from right to left
                for (int col = right - 1; col >= left; col--) {
                    res.add(matrix[down][col]);
                }
            }
            // make sure that we are not traverse a column that has already been traversed
            if (left != right) {
                // then traverse from down to up
                for (int row = down - 1; row > up; row--) {
                    res.add(matrix[row][left]);
                }
            }
            // update the left, right, up, and down boundary accordingly
            left++;
            right--;
            up++;
            down--;
        }
        return res;
    }
}
