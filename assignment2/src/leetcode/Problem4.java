package leetcode;
import static leetcode.Helper.printMatrix;

public class Problem4 {
    public static void main(String[] args) {
        System.out.println("==============================LeetCode 4============================");

        int[][] matrix_3 = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
                                             // expected [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
        System.out.print("The rotated image is ");
        printMatrix(rotate(matrix_3));

        int[][] matrix_4 = {{1,2},{3,4}};
        System.out.print("The rotated image is ");
        printMatrix(rotate(matrix_4));// [[3,1],[4,2]]
        System.out.println();
    }


    /**
     * LeetCode 4:
     * Time complexity: O(m)  m is the number of cells in matrix
     * Space complexity: o(1)
     *
     * @param matrix
     */
    public static int[][] rotate(int[][] matrix) {
        interchange(matrix);
        return reverse(matrix);
    }
    // reverse the matrix around the main diagonal
    public static void interchange(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    // reverse the numbers in each row
    public static int[][] reverse(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - j - 1];
                matrix[i][matrix.length - j - 1] = temp;
            }
        }
        return matrix;
    }
}
