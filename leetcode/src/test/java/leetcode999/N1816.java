package leetcode999;

import org.junit.jupiter.api.Test;

/**
 * @date 2021/12/6
 */
public class N1816 {

    public String truncateSentence(String s, int k) {
        String[] split = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < k; i++) {
            ans.append(split[i]);
            ans.append(" ");
        }
        return ans.substring(0, ans.length() - 1);
    }

    @Test
    void t() {
        System.out.println(truncateSentence("Hello how are you Contestant", 4));
        System.out.println(truncateSentence("What is the solution to this problem", 4));
        System.out.println(truncateSentence("chopper is not a tanuki", 5));
    }
}
