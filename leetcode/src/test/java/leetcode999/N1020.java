package leetcode999;

import org.junit.jupiter.api.Test;


/**
 * @date 2022/2/12
 */
public class N1020 {
    int[][] arr;
    int x;
    int y;

    public int numEnclaves(int[][] grid) {
        arr = grid;
        x = arr[0].length;
        y = arr.length;


        // 先从边界遍历，把所有从边界出发能到达的1全部置为0
        for (int i = 0; i < y; i++) {
            dfs(i, 0);
            dfs(i, x - 1);
        }

        for (int i = 0; i < x; i++) {
            dfs(0, i);
            dfs(y - 1, i);
        }

        int ans = 0;
        // 遍历剩下的1就是无法到达边界的
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (arr[i][j] == 1) {
                    ans++;
                }
            }
        }

        return ans;
    }


    public void dfs(int i, int j) {
        //if (i < 0 || i >= x || j < 0 || j >= y) {
        //    return;
        //}
        // 注意这里比较的坐标
        if (i < 0 || j < 0 || i >= y || j >= x) {
            return;
        }
        if (arr[i][j] == 1) {
            arr[i][j] = 0;
            dfs(i - 1, j);
            dfs(i + 1, j);
            dfs(i, j - 1);
            dfs(i, j + 1);
        }
    }


    @Test
    void t() {
        int[] a = {0, 0, 0, 0};
        int[] b = {1, 0, 1, 0};
        int[] c = {0, 1, 1, 0};
        int[] d = {0, 0, 0, 0};

        int[][] arr = {a, b, c, d};

        System.out.println(numEnclaves(arr));

    }

    @Test
    void t2() {
        int[] a = {0, 1, 1, 0};
        int[] b = {1, 0, 1, 0};
        int[] c = {0, 0, 1, 0};
        int[] d = {0, 0, 0, 0};

        int[][] arr = {a, b, c, d};

        System.out.println(numEnclaves(arr));

    }

    @Test
    void t3() {
        int[] a = {0, 1, 1, 0, 0};

        int[][] arr = {a};

        System.out.println(numEnclaves(arr));

    }

}
