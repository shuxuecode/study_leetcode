package leetcode999;

import org.junit.jupiter.api.Test;

/**
 * @date 2021/11/10
 */
public class N495 {

    // 执行用时：2 ms, 在所有 Java 提交中击败了90.57% 的用户
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (duration == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            if ((timeSeries[i] + duration) <= timeSeries[i + 1]) {
                res += duration;
            } else {
                res += (timeSeries[i + 1] - timeSeries[i]);
            }
        }
        return res + duration;
    }

    @Test
    void t() {
        System.out.println(findPoisonedDuration(new int[]{1, 4}, 2));
        System.out.println(findPoisonedDuration(new int[]{1, 2}, 2));
    }
}
