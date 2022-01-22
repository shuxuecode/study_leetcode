package leetcode999;

import org.junit.jupiter.api.Test;

public class N1332 {

    // todo
    public int removePalindromeSub(String s) {
        int n = s.length();
        int i = 0, j = n - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return 2;
            i++; j--;
        }
        return 1;
    }

    @Test void t(){
        System.out.println(removePalindromeSub("ababa"));
    }
}
