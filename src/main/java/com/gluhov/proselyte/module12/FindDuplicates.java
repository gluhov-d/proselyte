package com.gluhov.proselyte.module12;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicates {
    public static void main(String[] args) {
        System.out.println(hasDuplicates(new int[] {4,5,6,6,8}));
    }

    private static boolean hasDuplicates(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int val: arr) {
            if (!set.add(val)) return true;
        }
        return false;
    }
}
