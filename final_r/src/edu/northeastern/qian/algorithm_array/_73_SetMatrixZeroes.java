package edu.northeastern.qian.algorithm_array;

import java.util.HashSet;
import java.util.Set;

public class _73_SetMatrixZeroes {
    // https://leetcode.com/problems/set-matrix-zeroes/
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        // 记下横坐标和纵坐标
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        // set its entire row and column to 0's
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
