package leetcode999;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @date 2022/1/18
 */
public class N539 {

    /**
     * done
     */
    public int findMinDifference(List<String> timePoints) {


        int[] arr = new int[timePoints.size() + 1];
        for (int i = 0; i < timePoints.size(); i++) {
            String[] split = timePoints.get(i).split(":");

            int num = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);

            arr[i] = num;
        }

        arr[arr.length - 1] = 24 * 60 * 2;

        Arrays.sort(arr);

        // 将第一个加上 24*60（即一天的分钟数） 后再追加到最后一位，达到时间点循环的效果
        arr[arr.length - 1] = arr[0] + 24 * 60;

        int ans = arr[1] - arr[0];

        for (int i = 2; i < arr.length; i++) {
            int n = arr[i] - arr[i - 1];
            ans = Math.min(ans, n);
        }

        return ans;
    }


    @Test
    void t() {
        List<String> timePoints = new ArrayList<>();
        timePoints.add("00:00");
        timePoints.add("23:59");

        System.out.println(findMinDifference(timePoints));

    }

}
