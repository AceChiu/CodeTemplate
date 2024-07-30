package Algorithm;

public class Main {
    public static void main(String[] args) {
        // Decimal To Binary
       BinaryAndDecimal binaryAndDecimal = new BinaryAndDecimal();
       System.out.println("10: Binary Number is " + binaryAndDecimal.decimalToBinary1(10));
       System.out.println("99: Binary Number is " + binaryAndDecimal.decimalToBinary1(99));
       System.out.println("10: Binary Number is " + binaryAndDecimal.decimalToBinary2(10));
       System.out.println("99: Binary Number is " + binaryAndDecimal.decimalToBinary2(99));

    }
}