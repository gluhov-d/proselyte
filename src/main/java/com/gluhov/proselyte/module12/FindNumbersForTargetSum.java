package com.gluhov.proselyte.module12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindNumbersForTargetSum {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 8, 15, 17};
        int target = 23;
        List<int[]> res = getNumbersIndexesForTargetSum(arr, target);
        res.forEach(p -> System.out.println(p[0] + " " + p[1]));
    }

    private static List<int[]> getNumbersIndexesForTargetSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        List<int[]> pairs = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int secondNumber = target - arr[i];
            if (!map.containsKey(secondNumber))
                map.put(arr[i], i);
            else
                pairs.add(new int[]{map.get(secondNumber), i});
        }
        return pairs;
    }
}