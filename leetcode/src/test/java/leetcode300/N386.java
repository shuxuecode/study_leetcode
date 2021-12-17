package leetcode300;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2021/12/17
 */
public class N386 {


    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();

        dfs(0, 1, n, res);

        return res;
    }

    // todo zsx
    private void dfs(int num, int start, int n, List<Integer> res) {
        if (num > n) {
            return;
        }
        for (int i = start; i < 10; i++) {
            int number = i + num;
            if (number <= n) {
                res.add(number);
                dfs(number * 10, 0, n, res);
            }
        }

    }

    @Test
    void t() {
        System.out.println(lexicalOrder(25));
    }
}
