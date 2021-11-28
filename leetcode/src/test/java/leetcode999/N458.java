package leetcode999;

import org.junit.jupiter.api.Test;

/**
 * @date 2021/11/26
 */
public class N458 {

    // todo
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        if (buckets == 1) {
            return 0;
        }
        int loopNum = minutesToTest / minutesToDie + 1;
        int ans = 0;
        while (Math.pow(loopNum, ans) < buckets) {
            ans++;
        }
        return ans;
    }


    @Test
    void t() {
        System.out.println(poorPigs(1, 1, 1));
        System.out.println(poorPigs(1000, 15, 60));
        System.out.println(poorPigs(4, 15, 15));
        System.out.println(poorPigs(4, 15, 30));
    }
}
