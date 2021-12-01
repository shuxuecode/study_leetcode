package leetcode999;

import org.junit.jupiter.api.Test;

/**
 * @date 2021/12/1
 */
public class N1446 {

    public int maxPower(String s) {
        int ans = 1;

        char[] charArray = s.toCharArray();

        char c = charArray[0];
        int count = 1;

        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] == c) {
                count++;

                ans = Math.max(ans, count);
            } else {
                c = charArray[i];
                count = 1;
            }
        }

        return ans;
    }

    @Test
    void t() {
        System.out.println(maxPower("leetcode"));
        System.out.println(maxPower("abbcccddddeeeeedcba"));
        System.out.println(maxPower("triplepillooooow"));
        System.out.println(maxPower("hooraaaaaaaaaaay"));
        System.out.println(maxPower("tourist"));
    }
}
