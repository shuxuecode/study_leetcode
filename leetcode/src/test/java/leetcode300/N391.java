package leetcode300;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @date 2021/11/16
 */
public class N391 {

    public boolean isRectangleCover(int[][] rectangles) {
        // 统计每块矩形的面积
        long area = 0;
        // 记录矩形中出现的每个点
        HashSet<Integer> set = new HashSet<>();

        // 定义完美矩形的四个顶点
        int xMin, xMax, yMin, yMax;
        xMin = yMin = Integer.MAX_VALUE;
        xMax = yMax = Integer.MIN_VALUE;

        for (int[] rectangle : rectangles) {
            int x1 = rectangle[0];
            int y1 = rectangle[1];
            int x2 = rectangle[2];
            int y2 = rectangle[3];

            // 计算面积
            area += (long) (x2 - x1) * (y2 - y1);

            if (x1 < xMin || y1 < yMin) {
                // 更新最小的顶点
                xMin = x1;
                yMin = y1;
            }
            if (x2 > xMax || y2 > yMax) {
                // 更新最大的顶点
                xMax = x2;
                yMax = y2;
            }

            setNum(set, x1, y1);
            setNum(set, x1, y2);
            setNum(set, x2, y1);
            setNum(set, x2, y2);
        }

        if (area != (long) (xMax - xMin) * (yMax - yMin)) {
            // 如果面积不相等则直接返回false
            return false;
        }

        if (set.size() != 4) {
            // set里面必须是四个顶点
            return false;
        }

        return set.contains(getNum(xMin, yMin))
                && set.contains(getNum(xMin, yMax))
                && set.contains(getNum(xMax, yMin))
                && set.contains(getNum(xMax, yMax));
    }

    private void setNum(Set<Integer> set, int x, int y) {
        int num = getNum(x, y);
        if (!set.add(num)) {
            // 如果已经存在，则去掉
            set.remove(num);
        }
    }

    private int getNum(int x, int y) {
        return x * 100001 + y;
    }


    @Test
    void t() {

        //int[][] rectangles = {{1, 1, 3, 3}, {3, 1, 4, 2}, {3, 2, 4, 4}, {1, 3, 2, 4}, {2, 3, 3, 4}};

        int[][] rectangles = {{1, 1, 3, 3}, {3, 1, 4, 2}, {1, 3, 2, 4}, {3, 2, 4, 4}};

        boolean bool = isRectangleCover(rectangles);

        System.out.println(bool);

    }

}
