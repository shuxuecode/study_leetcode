package leetcode999;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

/**
 * @date 2021/12/24
 */
public class N1705 {

    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int n = apples.length, time = 0, ans = 0;
        while (time < n || !q.isEmpty()) {
            if (time < n && apples[time] > 0) q.add(new int[]{time + days[time] - 1, apples[time]});
            while (!q.isEmpty() && q.peek()[0] < time) q.poll();
            if (!q.isEmpty()) {
                int[] cur = q.poll();
                if (--cur[1] > 0 && cur[0] > time) q.add(cur);
                ans++;
            }
            time++;
        }
        return ans;
    }

    @Test
    void t() {

        int[] apples = {1,2,3};
        int[] days = {1,2,3};

        System.out.println(eatenApples(apples, days));
    }
}
