package edu.northeastern.qian.algorithm_array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _1762_BuildingsWithAnOceanView {
    // https://leetcode.com/problems/buildings-with-an-ocean-view/
    public int[] findBuildings(int[] heights) {
        int maxHeight = -1;
        List<Integer> list = new ArrayList<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            if (maxHeight < heights[i]) {
                list.add(i);
                maxHeight = heights[i];
            }
        }
        Collections.reverse(list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
