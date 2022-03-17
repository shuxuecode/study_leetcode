package leetcode999;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @date 2022/3/17
 */
public class N720 {
    public String longestWord(String[] words) {
        String ans = "";
        Set<String> set = new HashSet<>();
        for (String s : words) set.add(s);
        for (String s : set) {
            int n = s.length(), m = ans.length();
            if (n < m) continue;
            if (n == m && s.compareTo(ans) > 0) continue;
            boolean ok = true;
            for (int i = 1; i <= n && ok; i++) {
                String sub = s.substring(0, i);
                if (!set.contains(sub)) ok = false;
            }
            if (ok) ans = s;
        }
        return ans;
        // todo

    }

    @Test
    void t() {
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};

        System.out.println(longestWord(words));
    }
}
