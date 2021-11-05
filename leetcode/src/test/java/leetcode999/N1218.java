package leetcode999;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @date 2021/11/5
 */
public class N1218 {

    // 超时
    public int longestSubsequence2(int[] arr, int difference) {
        int max = 1;

        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            int num = arr[i];
            int j = i + 1;
            int next = num + difference;

            while (j < arr.length) {
                if (arr[j] == next) {
                    count++;
                    next += difference;
                }
                j++;
            }
            max = Math.max(max, count);
            //
            if (max >= (arr.length - i)) {
                break;
            }
        }

        return max;
    }

    // todo
    public int longestSubsequence(int[] arr, int difference) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int v : arr) {
            map.put(v, map.getOrDefault(v - difference, 0) + 1);
            res = Math.max(res, map.get(v));
        }
        return res;
    }

        @Test
    void t() {
        System.out.println(longestSubsequence(new int[]{1, 2, 3, 4}, 1));
        System.out.println(longestSubsequence(new int[]{1, 3, 5, 7}, 1));
        System.out.println(longestSubsequence(new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1}, -2));
    }



}
