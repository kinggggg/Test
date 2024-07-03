package com.zeek.algorithm;

/**
 * 差分数组
 * leetcode 370
 * leetcode 1109
 *
 *
 * @author liweibo04 <liweibo04@58.com>
 * Created on 2024/7/3 09:20
 */
public class ChaFenShuZu370 {

    int[] diff;

    ChaFenShuZu370(int[] arr) {
        diff = new int[arr.length];
        diff[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            diff[i] = arr[i] - arr[i - 1];
        }
    }

    public void increment(int i, int j, int value) {
        diff[i] += value;
        if (j + 1 < diff.length) {
            diff[j+1] -= value;
        }
    }

    public int[] sum() {
        int[] arr = new int[diff.length];
        arr[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            arr[i] = arr[i-1] + diff[i];
        }
        return arr;
    }
}
