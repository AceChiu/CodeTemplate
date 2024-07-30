package Algorithm;

import java.lang.Math;

public class BinaryAndDecimal {
//    Solution 2
    public int decimalToBinary1(int n) {
        int ordinalNum = 0;
        int binary = 0;
        int remainder = 0;
        while (n != 0) {
            remainder = n % 2;
            n = n / 2;
            binary += remainder * Math.pow(10, ordinalNum);
            ordinalNum++;
        }
        return binary;
    }

//    Solution 2
    public String decimalToBinary2(int n) {
        String str = "";
        while (n != 0) {
            str = n % 2 + str;
            n = n / 2;
        }
        return str;
    }
}
