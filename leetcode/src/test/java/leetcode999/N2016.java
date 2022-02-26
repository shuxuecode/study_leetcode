package leetcode999;

import org.junit.jupiter.api.Test;

public class N2016 {
    public int maximumDifference(int[] nums) {
        int ans = -1;

        int length = nums.length;

        int min = 0;
        int max = 1;

        for (int i = 1; i < length - 1; i++) {

            if (min < max && nums[i] < nums[min]) {
                min = i;
            }
 // todo xue
            if (min < max && nums[i] < nums[min]) {
                min = i;
            }


            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i + 1]);
        }
        if (max > min) {
            return max - min;
        }
        return ans;
    }

    @Test
    void t() {
        System.out.println(maximumDifference(new int[]{7, 1, 5, 4}));
        System.out.println(maximumDifference(new int[]{9, 4, 3, 2}));
        System.out.println(maximumDifference(new int[]{1, 5, 2, 10}));
    }
}
