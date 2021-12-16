package leetcode200;

import org.junit.jupiter.api.Test;

/**
 * @date 2021/12/16
 */
public class N231 {


    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    @Test
    void t() {
        System.out.println(isPowerOfTwo(2));
        System.out.println(isPowerOfTwo(3));
        System.out.println(isPowerOfTwo(4));
        System.out.println(isPowerOfTwo(8));
    }
}
