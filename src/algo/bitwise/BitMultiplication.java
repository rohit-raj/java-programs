package algo.bitwise;

class BitMultiplication {
    int mul(int a, int b) {
        if (b == 1) {
            return a;
        }

        int nextPowerOfTwoForYourNumber = 1;
        int numberOfBits = 0;

        while (nextPowerOfTwoForYourNumber < b) {
            nextPowerOfTwoForYourNumber = nextPowerOfTwoForYourNumber << 1;
            numberOfBits++;
        }
        return (a << numberOfBits) - (mul(a, (nextPowerOfTwoForYourNumber - b)));
    }

    public static void main(String[] args) {
        BitMultiplication bit = new BitMultiplication();
        int a = 2;
        int b = 5;
        System.out.printf("multiple of " + a + " * " + b + " = " + bit.mul(a, b));
    }
}