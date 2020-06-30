package Maths;

public class FastExponentiation {
    static int power(int x, int y, int p) {
        int res = 1;
        x = x % p;
        while (y > 0) {
            if((y & 1)==1)
                res = (res * x) % p;
            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }

    static int powerFun(int x,int n){
        if (n==0)return 1;
        int pnb2 = powerFun(x,n/2);
        if (n%2==1){
            return pnb2*pnb2*x;
        }else {
            return pnb2*pnb2;
        }
    }

    public static void main(String args[]) {
        int x = 2;
        int y = 5;
        int p = 13;
        System.out.println("Power is " + power(x, y, p));

        //find Power in O(logn) time
        System.out.println(powerFun(2,5));
    }
}
