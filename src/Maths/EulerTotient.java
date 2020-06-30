package Maths;

public class EulerTotient {
    static int phi(int n) {
        int result = n;
        for (int p = 2; p * p <= n; ++p) {

            if (n % p == 0) {
                while (n % p == 0)
                    n /= p;
                result -= result / p;
            }
        }

        if (n > 1)
            result -= result / n;
        return result;
    }

    public static void main (String[] args) {
        int n;
        for (n = 1; n <= 10; n++)
            System.out.println("phi(" + n +
                    ") = " + phi(n));
    }
}
