package leetcode999;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @date 2021/11/29
 */
public class N930 {

    //todo
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> mm = new HashMap<>();
        int prefix = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            mm.put(prefix, mm.getOrDefault(prefix, 0) + 1);
            prefix += nums[i];
            res += mm.getOrDefault(prefix - goal, 0);
        }
        return res;
    }

    @Test
    void t() {
        System.out.println(numSubarraysWithSum(new int[]{1, 2}, 3));
    }
}
