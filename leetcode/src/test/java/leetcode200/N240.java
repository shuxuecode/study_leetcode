package leetcode200;

import org.junit.jupiter.api.Test;

/**
 * @date 2021/10/25
 */
public class N240 {

    boolean res = false;
    int targetNum = 0;
    int x = 0;
    int y = 0;


    //todo

    //执行用时：14 ms, 在所有 Java 提交中击败了10.07% 的用户
    //内存消耗：43.9 MB, 在所有 Java 提交中击败了50.34% 的用户
    public boolean searchMatrix(int[][] matrix, int target) {

        targetNum = target;

        x = matrix[0].length;
        y = matrix.length;

        //dfs(matrix, 0, 0);

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                int num = matrix[i][j];
                if (num == target) {
                    return true;
                }
            }
        }

        return res;
    }

    public void dfs(int[][] matrix, int i, int j) {
        if (matrix[i][j] == targetNum) {
            res = true;
            return;
        }

        if (matrix[i][j] < targetNum) {

        }


    }

    @Test
    void t() {
        int[] row1 = {1, 4, 7, 11, 15};
        int[] row2 = {2, 5, 8, 12, 19};
        int[] row3 = {3, 6, 9, 16, 22};
        int[] row4 = {10, 13, 14, 17, 24};
        int[] row5 = {18, 21, 23, 26, 30};

        int[][] matrix = new int[][]{
                row1, row2, row3, row4, row5
        };

        boolean bool = searchMatrix(matrix, 5);

        System.out.println(bool);


        double d = Math.pow(10, 9);
        System.out.println(Double.toString(d));

        System.out.println(Integer.MAX_VALUE);
        System.out.println(String.valueOf(Integer.MAX_VALUE).length());

    }
}
