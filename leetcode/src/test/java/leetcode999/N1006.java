package leetcode999;

import org.junit.jupiter.api.Test;

public class N1006 {

    public int clumsy(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 6;
        } else if (n == 4) {
            return 7;
        }

        if (n % 4 == 0) {
            return n + 1;
        } else if (n % 4 <= 2) {
            return n + 2;
        } else {
            return n - 1;
        }

    }

    @Test void t(){
        System.out.println(clumsy(8));
        System.out.println(clumsy(99));
    }
}