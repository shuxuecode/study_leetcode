package leetcode999;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @date 2021/10/10
 */
public class N441 {

    public int arrangeCoins(int n) {
        int i = 1;
        while (n >= i) {
            System.out.print("n = " + n + "  i = " + i);
            n = n - i;
            System.out.print(" n =  " + n);
            i++;
            System.out.println();
        }
        System.out.println();
        return i - 1;
    }


    @Test
    void t() {
        Assertions.assertEquals(arrangeCoins(1), 1, "");
        Assertions.assertEquals(arrangeCoins(2), 1, "");
        Assertions.assertEquals(arrangeCoins(3), 2, "");
        Assertions.assertEquals(arrangeCoins(5), 2, "");
        Assertions.assertEquals(arrangeCoins(8), 3, "");
    }
}
