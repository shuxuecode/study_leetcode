package leetcode999;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2022/2/10
 */
public class N1447 {


    public List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 1) {
            return ans;
        }

        // 分子
        for (int i = 1; i < n; i++) {
            // 分母
            for (int j = i + 1; j <= n; j++) {
                if (gcd(i, j) == 1) {
                    ans.add(i + "/" + j);
                }
            }
        }
        return ans;
    }

    // 分子分母的最大公约数
    public int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

    @Test
    void t() {
        List<String> list = simplifiedFractions(5);
        list.stream().forEach(System.out::println);
    }

}
