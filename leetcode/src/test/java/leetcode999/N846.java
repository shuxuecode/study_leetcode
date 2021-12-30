package leetcode999;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @date 2021/12/30
 * todo
 */
public class N846 {

    /**
     * 先对原数组升序排序，然后进行双指针嵌套遍历，外层遍历找顺子起点，内层遍历找顺子后续元素，
     * 被找到的元素置为-1即寻找其他顺子元素时直接略过，若无法找到完整顺子则返回false
     */
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] < 0) continue;

            int count = 0;
            for (int j = i + 1; j < hand.length && count != groupSize - 1; j++) {
                if (hand[j] - hand[i] == count + 1) {
                    count++;
                    hand[j] = -1;
                }
            }
            if (count != groupSize - 1) {
                return false;
            }
        }
        return true;
    }

    @Test
    void t() {
        System.out.println(isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
        System.out.println(isNStraightHand(new int[]{1, 2, 3, 4, 5}, 4));
    }

}
