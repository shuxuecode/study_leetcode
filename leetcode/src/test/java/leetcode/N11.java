package leetcode;

import org.junit.jupiter.api.Test;

/**
 * @date 2021/11/4
 */
public class N11 {
    // 双指针
    // 执行用时：3 ms, 在所有 Java 提交中击败了92.70% 的用户
    // 内存消耗：51.8 MB, 在所有 Java 提交中击败了57.57% 的用户
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int res = 0;

        while (i < j) {
            // 左侧挡板的高度
            int leftHeight = height[i];
            // 右侧挡板的高度
            int rightHeight = height[j];

            if (leftHeight < rightHeight) {
                // 左侧比较低时，计算面积
                int area = leftHeight * (j - i);
                // 与之前的最大面积比较
                res = Math.max(res, area);
                // 左指针移动
                i++;
            } else {
                // 右侧比较低时
                int area = rightHeight * (j - i);
                // 与之前的最大面积比较
                res = Math.max(res, area);
                // 右指针移动
                j--;
            }
        }

        return res;
    }

    // 双指针 简化版
    public int maxArea2(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while (i < j) {
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]) :
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }

    @Test
    void t() {
        System.out.println(maxArea(new int[]{1, 2, 3, 4}));
        System.out.println(maxArea2(new int[]{1, 2, 3, 4}));
    }
}
