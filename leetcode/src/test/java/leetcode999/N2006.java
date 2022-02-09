package leetcode999;

import org.junit.jupiter.api.Test;

/**
 * @date 2022/2/9
 */
public class N2006 {

    public int countKDifference(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    ans++;
                }
            }
        }
        return ans;
    }


    @Test
    void t() {
        System.out.println(countKDifference(new int[]{1, 2, 2, 1}, 1));
        System.out.println(countKDifference(new int[]{1, 3}, 3));
        System.out.println(countKDifference(new int[]{3, 2, 1, 5, 4}, 2));
    }
}
