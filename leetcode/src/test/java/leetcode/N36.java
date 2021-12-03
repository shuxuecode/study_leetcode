package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * todo
 *
 * @date 2021/9/17
 */
public class N36 {

    // 执行用时：2 ms, 在所有 Java 提交中击败了61.41% 的用户
    // 内存消耗：38.6 MB, 在所有 Java 提交中击败了22.81% 的用户
    public boolean isValidSudoku(char[][] board) {
        // 记录每行出现的每个数字的次数
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        // 每个九宫格中出现数字的频次
        int[][] squared = new int[9][9];

        for (int i = 0; i < board.length; i++) {
            char[] row = board[i];
            for (int j = 0; j < row.length; j++) {

                if (row[j] != '.') {

                    int num = row[j] - '0' - 1;

                    rows[i][num]++;

                    columns[j][num]++;

                    squared[getIndex(i, j)][num]++;

                    if (rows[i][num] > 1 || columns[j][num] > 1 || squared[getIndex(i, j)][num] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private int getIndex(int i, int j) {
        i = i / 3;
        j = j / 3;

        if (i == 0) {
            return j;
        } else if (i == 1) {
            //0 1 2
            //3 4 5
            return j + 3;
        } else if (i == 2) {
            //0 1 2
            //6 7 8
            return j + 6;
        }

        return -1;
    }

    private void print() {
        //for (int i = 0; i < rows.length; i++) {
        //    System.out.println("rows " + (i + 1) + " = " + Arrays.toString(rows[i]));
        //}
        //
        //for (int i = 0; i < columns.length; i++) {
        //    System.out.println("columns " + (i + 1) + " = " + Arrays.toString(columns[i]));
        //}
        //
        //for (int i = 0; i < squared.length; i++) {
        //    System.out.println("squared " + (i + 1) + " = " + Arrays.toString(squared[i]));
        //}
    }


    // 仅仅优化了缓存
    //执行用时：1 ms, 在所有 Java 提交中击败了100.00% 的用户
    //内存消耗：38.6 MB, 在所有 Java 提交中击败了16.37% 的用户
    public boolean isValidSudoku2(char[][] board) {
        // 记录每行出现的每个数字的次数
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        // 每个九宫格中出现数字的频次
        int[][] squared = new int[9][9];

        for (int i = 0; i < board.length; i++) {
            char[] row = board[i];
            for (int j = 0; j < row.length; j++) {

                if (row[j] != '.') {
                    int num = row[j] - '0' - 1;

                    if (rows[i][num] > 0) {
                        return false;
                    }
                    rows[i][num]++;


                    if (columns[j][num] > 0) {
                        return false;
                    }
                    columns[j][num]++;

                    int index = getIndex(i, j);
                    if (squared[index][num] > 0) {
                        return false;
                    }
                    squared[index][num]++;
                }
            }
        }
        return true;
    }

    @Test
    void t() {
        char[] a = new char[]{'8', '3', '.', '.', '7', '.', '.', '.', '.'};
        char[] b = new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'};
        char[] c = new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'};

        char[] d = new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'};
        char[] e = new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'};
        char[] f = new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'};

        char[] h = new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'};
        char[] i = new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'};
        char[] j = new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'};

        char[][] board = new char[][]{a, b, c, d, e, f, h, i, j};

        System.out.println(isValidSudoku(board));


    }
}
