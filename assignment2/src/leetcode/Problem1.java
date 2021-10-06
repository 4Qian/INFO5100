package leetcode;
import static leetcode.Helper.printMatrix;

public class Problem1 {
    public static void main(String[] args) {
        System.out.println("==============================LeetCode 1============================");

        int[][] matrix_1 = {{1,2,3},{4,5,6},{7,8,9}};// expected [[1,4,7],[2,5,8],[3,6,9]]
        System.out.print("The transpose of matrix is ");
        printMatrix(transpose(matrix_1));

        int[][] matrix_2 = {{1,2,3},{4,5,6}};// expected [[1,4],[2,5],[3,6]]
        System.out.print("The transpose of matrix is ");
        printMatrix(transpose(matrix_2));
        System.out.println();
    }


    /**
     * LeetCode 1:
     * Time complexity: o(m * n), where m and n are the number of rows and columns in the given matrix
     * Space complexity: o(m * n)
     *
     * @param matrix
     * @return
     */

    public static int[][] transpose(int[][] matrix) {
        int[][] res = new int[matrix[0].length][matrix.length];
        //traverse the matrix numbers in the order of one column by column,
        //Correspondingly put these numbers in the newly created "res" in the order of row by row
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }
}
