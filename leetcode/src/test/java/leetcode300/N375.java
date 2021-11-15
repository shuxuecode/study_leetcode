package leetcode300;

import org.junit.jupiter.api.Test;

/**
 * @date 2021/11/12
 */
public class N375 {

    // todo
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        /*遍历左节点i*/
        for (int i = n - 1; i >= 1; i--) {
            /*遍历右节点j，注意j=i+1*/
            for (int j = i + 1; j <= n; j++) {
                /*定义在i到j中最小值*/
                int minCost = Integer.MAX_VALUE;
                /*遍历k*/
                for (int k = i; k < j; k++) {
                    /*更新最小花费，由于是max所以不用取k==j*/
                    int max = k + Math.max(dp[i][k - 1], dp[k + 1][j]);
                    minCost = Math.min(max, minCost);
                }
                /*记录最小花费*/
                dp[i][j] = minCost;
            }
        }
        /*返回*/
        return dp[1][n];
    }


    @Test
    void t() {
        System.out.println(getMoneyAmount(10));
    }
}
