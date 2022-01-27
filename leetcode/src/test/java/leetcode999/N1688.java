package leetcode999;

import org.junit.jupiter.api.Test;

/**
 * @date 2022/1/25
 */
public class N1688 {

    //执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
    //内存消耗：38.4 MB, 在所有 Java 提交中击败了5.01% 的用户
    public int numberOfMatches(int n) {
        int ans = 0;

        // 是否有多余的一支队伍
        boolean flag = false;
        while (n > 1) {

            if (flag) {
                // 如果有多余的一支队伍
                n += 1;
            }

            flag = n % 2 != 0;

            n /= 2;

            ans += n;
        }
        if (flag) {
            ans++;
        }

        return ans;
    }

    // 解法： n-1 todo

    @Test
    void t() {
        System.out.println(numberOfMatches(2));
        System.out.println(numberOfMatches(3));
        System.out.println(numberOfMatches(7));
        System.out.println(numberOfMatches(14));
    }
}
