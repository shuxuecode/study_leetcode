package leetcode300;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @date 2021/11/19
 */
public class N397 {

    int ans = 0;

    // 这种方式不对
    public int integerReplacement2(int n) {
        dfs(n);
        return ans;
    }

    private void dfs(int n) {
        if (n == 1) {
            return;
        }
        ans++;
        if (n % 2 == 0) {
            dfs(n / 2);
        } else {
            if ((n - 1) % 2 == 0) {
                dfs(n - 1);
            } else {
                dfs(n + 1);
            }
        }
    }


    // todo
    public int integerReplacement(int _n) {
        long n = _n;
        int ans = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n >>= 1;
            } else {
                if (n != 3 && ((n >> 1) & 1) == 1) n++;
                else n--;
            }
            ans++;
        }
        return ans;
    }

    @Test
    void t() {
        int num = integerReplacement(1111111);
        System.out.println(num);
        Assertions.assertEquals(26, num, "与预期不符");
    }


}
