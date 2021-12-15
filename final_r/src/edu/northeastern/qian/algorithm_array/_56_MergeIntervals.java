package edu.northeastern.qian.algorithm_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _56_MergeIntervals {
    // https://leetcode.com/problems/merge-intervals/
    public int[][] merge(int[][] intervals) {
        // 按照每个arr的start升序排序， 对比每个arr的end，end大于后者的start说明overlap了，对比两者end取较大作为更新end
        if (intervals.length == 1) {
            return intervals;
        }
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] cur = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (cur[1] >= intervals[i][0]) {
                cur[1] = Math.max(cur[1], intervals[i][1]);
            }else{
                list.add(cur);
                cur = intervals[i];
            }
        }
        list.add(cur);
        return list.toArray(new int[list.size()][2]);
    }
}
