package Maths;

import java.util.Scanner;

public class GoldbachConjucture {
    public static void main (String[] args) {
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
          boolean flag = true;
          for (int i=2;i<=n;i++){
              if (isPrime(i) && isPrime(n-i)){
                  System.out.println(i+" "+(n-i));
                  flag = false;
                  break;
              }
          }
          if (flag) System.out.println("No conjecture");
    }

    public static boolean isPrime(int num){
        if (num==0)return false;
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }

}
