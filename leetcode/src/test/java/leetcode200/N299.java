package leetcode200;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @date 2021/11/8
 * todo 还有一种解法，是统计0-9在每个字符串出现的词频，然后统计得到奶牛
 */
public class N299 {
    // 可以通过，但性能不行
    // 执行用时：187 ms, 在所有 Java 提交中击败了5.06% 的用户
    public String getHint(String secret, String guess) {
        // 记录数字和位置都对的坐标
        Set<Integer> Bulls = new HashSet<>();
        // 记录数字对但位置不对的坐标（guess的坐标）
        Set<Integer> Cows = new HashSet<>();

        int length = secret.length();

        for (int i = 0; i < length; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                Bulls.add(i);
            }
        }

        // 循环secret
        for (int i = 0; i < length; i++) {
            if (Bulls.contains(i)) {
                // 跳过已经bulls的坐标
                continue;
            }
            char c = secret.charAt(i);

            for (int j = 0; j < length; j++) {
                if (Bulls.contains(j) || Cows.contains(j)) {
                    // 跳过已经bulls的坐标，和已经放到Cows里的坐标
                    continue;
                }
                if (c == guess.charAt(j)) {
                    Cows.add(j);
                    // 这里一定要跳出，避免重复数字时重复计数
                    break;
                }
            }
        }
        return Bulls.size() + "A" + Cows.size() + "B";
    }


    @Test
    void t() {
        //System.out.println(getHint("1234", "4213"));
        System.out.println(getHint("1123", "0111"));
    }
}
