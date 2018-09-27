package algo;

class MultipleOfThree {
    static int mulOf3(int n) {
        int even_count = 0;
        int odd_count = 0;

        if (n < 0) n = -n;
        if (n == 0) return 1;
        if (n == 1) return 0;

        while (n != 0) {
            if ((n & 1) != 0) {
                odd_count++;
            }
            n = n >> 1;
            if ((n & 1) != 0) {
                even_count++;
            }
            n = n >> 1;
        }
        return mulOf3(Math.abs(odd_count - even_count));
    }

    public static void main(String[] args) {
        int a = 3;
        if (mulOf3(a) == 0) {
            System.out.println("Not a mutiple of 3");
        } else {
            System.out.printf("Yes a mutiple of 3");
        }
    }
}