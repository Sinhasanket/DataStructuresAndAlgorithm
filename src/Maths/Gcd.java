package Maths;

import java.util.Scanner;

public class Gcd {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
      //  int a = sc.nextInt();
        //int b = sc.nextInt();
//        System.out.println(gcd(a,b));
//        System.out.println(lcm(a,b));

        //Extended Euclidean Algorithm
        //a*x+b*y = gcd(a,b);
        //g=b*x1+a*(y1−⌊b/a⌋*x1)
        //{ x=y1−⌊b/a⌋*x1
        //{ y=x1
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(Exgcd(x,y,0,0));
    }

    public static int gcd(int a,int b){
        return (b==0)?a:gcd(b,a%b);
    }

    public static int lcm(int a,int b){
        return a/gcd(a,b) * b;
    }

    public static int Exgcd(int a,int b,int x,int y){
       if (a==0){
           x=0;
           y=1;
           return b;
       }
       int x1=0,y1=0;
       int d = Exgcd(b%a,a,x1,y1);
       x = y1 - (b/a) * x1;
       y = x1;
       System.out.print(x+" "+y+" ");
       return d;
    }
}
