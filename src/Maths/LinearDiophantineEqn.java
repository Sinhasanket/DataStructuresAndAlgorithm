package Maths;
//a*x+b*y=c
public class LinearDiophantineEqn {
    static int gcd(int a, int b) {
        return (a % b == 0) ? Math.abs(b) : gcd(b,a%b);
    }

    static boolean isPossible(int a, int b, int c) {
        return (c % gcd(a, b) == 0);
    }

    public static void main (String[] args) {
        int a = 3, b = 6, c = 7;
        if(isPossible(a, b, c))
            System.out.println( "Possible" );
        else
            System.out.println( "Not Possible");

        a = 3; b = 6; c = 8;
        if(isPossible(a, b, c))
            System.out.println( "Possible") ;
        else
            System.out.println( "Not Possible");

        a = 2; b = 5; c = 1;
        if(isPossible(a, b, c))
            System.out.println( "Possible" );
        else
            System.out.println( "Not Possible");
    }
}
