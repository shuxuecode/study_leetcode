package leetcode200;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @date 2022/1/19
 */
public class N219 {

    //执行用时：18 ms, 在所有 Java 提交中击败了90.50% 的用户
    //内存消耗：47.4 MB, 在所有 Java 提交中击败了71.29% 的用户
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];

            if (map.containsKey(value)) {
                Integer j = map.get(value);
                if (Math.abs(j - i) <= k) {
                    return true;
                }
                map.put(value, i);
            } else {
                map.put(value, i);
            }
        }

        return false;
    }

    @Test
    void t() {

        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));

    }
}

