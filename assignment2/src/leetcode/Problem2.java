package leetcode;

public class Problem2 {
    public static void main(String[] args) {
        System.out.println("==============================LeetCode 2============================");

        String[] wordsDict_1 = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "coding";
        String word2 = "practice";
        System.out.println("The shortest distance between these two words in the list is " +
                + shortestDistance(wordsDict_1, word1, word2));// expected 3

        String[] wordsDict_2 = {"practice", "makes", "perfect", "coding", "makes"};
        String word3 = "makes";
        String word4 = "coding";
        System.out.println("The shortest distance between these two words in the list is " +
                shortestDistance(wordsDict_2, word3, word4));// expected 1
        System.out.println();
    }


    /**
     * LeetCode 2:
     * Time complexity: O(n)
     * Space complexity: o(1)
     *
     * @param wordsDict
     * @param word1
     * @param word2
     * @return
     */
    public static int shortestDistance(String[] wordsDict, String word1, String word2) {
        int min = wordsDict.length;
        int index1 = -1;
        int index2 = -1;

        for (int i = 0; i < wordsDict.length; i++) {
            //if we find word1 or word2 position, record the index
            if (wordsDict[i].equals(word1)) {
                index1 = i;
            }else if (wordsDict[i].equals(word2)) {
                index2 = i;
            }
            //calculate the difference and compare with previous "min"
            if(index1 != -1 && index2 != -1) {
                min = Math.min(min, Math.abs(index1 - index2));
            }
        }
        return min;
    }
}
