package leetcode999;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @date 2021/10/26
 */
public class N496 {
    //执行用时：2 ms, 在所有 Java 提交中击败了98.82% 的用户
    //内存消耗：38.7 MB, 在所有 Java 提交中击败了23.24% 的用户
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 存nums2里元素对应的坐标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        int[] res = new int[nums1.length];
        // 默认值为-1
        for (int i = 0; i < res.length; i++) {
            res[i] = -1;
        }

        for (int i = 0; i < nums1.length; i++) {
            // 得到对应的下标
            Integer index = map.get(nums1[i]);
            for (int j = index + 1; j < nums2.length; j++) {
                if (nums1[i] < nums2[j]) {
                    // 只要大于就记录
                    res[i] = nums2[j];
                    break;
                }
            }
        }

        return res;
    }

    @Test
    void t() {

        int[] nums1 = {4, 2, 1};
        int[] nums2 = {1, 2, 3, 4};

        int[] arr = nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(arr));

    }
}
