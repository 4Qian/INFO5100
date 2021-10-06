package leetcode;
import java.util.Arrays;

public class Problem6 {
    public static void main(String[] args) {
        System.out.println("==============================LeetCode 6============================");

        String s = "egg";
        String t = "add";
        System.out.println("Are they isomorphic? " + isIsomorphic(s, t));//true

        String g = "paper";
        String h = "title";
        System.out.println("Are they isomorphic? " + isIsomorphic(g, h));//true
        System.out.println();
    }


    /**
     * LeetCode 6:
     * Time complexity: O(n)
     * Space complexity: o(1) -> the size of the ASCII character set is fixed
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isIsomorphic(String s, String t) {
        // int[] for map characters in one String to another String
        int[] mapS = new int[256];
        Arrays.fill(mapS, -1);
        int[] mapT = new int[256];
        Arrays.fill(mapT, -1);

        for (int i = 0; i < s.length(); i++) {
            char char1 = s.charAt(i);
            char char2 = t.charAt(i);
            // No mapping exists in mapS and mapT
            if (mapS[char1] == -1 && mapT[char2] == -1) {
                mapS[char1] = char2;
                mapT[char2] = char1;
                //mapping doesn't exist or mapping exists but doesn't match
            }else if (mapS[char1] != char2 && mapS[char2] != char1) {
                return false;
            }
        }
        return true;
    }
}
