package edu.northeastern.qian.algorithm_array;

public class _48_RotateImage {
    // https://leetcode.com/problems/rotate-image/
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
