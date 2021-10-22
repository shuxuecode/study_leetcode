package leetcode200;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @date 2021/10/22
 */
public class N229 {


    // 性能不好，  摩尔投票 todo
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        // 先计算n/3
        int num = nums.length / 3;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer j = map.getOrDefault(nums[i], 0);
            map.put(nums[i], j + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > num) {
                res.add(entry.getKey());
            }
        }

        return res;
    }


    @Test
    void t() {

        List<Integer> list = majorityElement(new int[]{1, 1, 1, 3, 3, 2, 2, 2});

        System.out.println(list);

    }

}
