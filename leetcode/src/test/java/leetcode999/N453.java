package leetcode999;

import org.junit.jupiter.api.Test;

/**
 * @date 2021/10/20
 */
public class N453 {

    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }

        int res = 0;
        for (int num : nums) {
            res += num - min;
        }

        return res;
    }


    @Test void t(){
        System.out.println(minMoves(new int[]{1,2,3}));
        System.out.println(minMoves(new int[]{1,1,1}));
    }
}
