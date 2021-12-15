package edu.northeastern.qian.algorithm_array;

public class _739_DailyTemperatures {
    // https://leetcode.com/problems/daily-temperatures/
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {// day
            for (int j = i + 1; j < n; j++) {// futureDay
                if (temperatures[j] > temperatures[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }
}
