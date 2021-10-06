package leetcode;
import java.util.List;

public class Helper {
    public static void printMatrix(int[][] matrix) {
        System.out.print("[");
        for (int i = 0; i < matrix.length; i++) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print("[");
            for (int j = 0; j < matrix[0].length; j++) {
                if (j > 0) {
                    System.out.print(",");
                }
                System.out.print(matrix[i][j]);
            }
            System.out.print("]");
        }
        System.out.println("]");
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.print(arr[arr.length - 1]);
        System.out.println("]");
    }

    public static void printList(List<Integer> list) {
        System.out.print("[");
        for (int i = 0; i < list.size() - 1; i++) {
            System.out.print(list.get(i) + ",");
        }
        System.out.print(list.get(list.size() - 1));
        System.out.println("]");
    }
}
