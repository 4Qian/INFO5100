package edu.northeastern.qian.question3;
import java.util.HashMap;
import java.util.Map;

public class Question3 {
    public int theSumOfDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            if (count == 1) {
                res += num;
            }
            map.put(num, count + 1);
        }
        return res;
    }

    //test
    public static void main(String[] args) {
        int[] input= {1, 3, -1, 3, 4, -1, 3, 3, 3 , 8};
        int res = new Question3().theSumOfDuplicates(input);
        System.out.println(res);
    }
}
