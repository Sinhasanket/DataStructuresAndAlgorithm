package DynamicProgramming;

public class CatalanNumber {
        static int catalanDP(int n) {
            int catalan[] = new int[n + 2];
            catalan[0] = 1;
            catalan[1] = 1;
            for (int i = 2; i <= n; i++) {
                   catalan[i] = 0;
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - j - 1];
            }
        }
            return catalan[n];
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            System.out.print(catalanDP(i) + " ");
        }
    }

//    static long binomialCoeff(int n, int k) {
//        long res = 1;
//
//        // Since C(n, k) = C(n, n-k)
//        if (k > n - k) {
//            k = n - k;
//        }
//
//        // Calculate value of [n*(n-1)*---*(n-k+1)] / [k*(k-1)*---*1]
//        for (int i = 0; i < k; ++i) {
//            res *= (n - i);
//            res /= (i + 1);
//        }
//
//        return res;
//    }
//
//    // A Binomial coefficient based function to find nth catalan
//// number in O(n) time
//    static long catalan(int n) {
//        // Calculate value of 2nCn
//        long c = binomialCoeff(2 * n, n);
//
//        // return 2nCn/(n+1)
//        return c / (n + 1);
//    }
}