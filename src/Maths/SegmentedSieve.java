package Maths;

import java.util.ArrayList;

public class SegmentedSieve {

    public static void main(String[] args){

        ArrayList<Integer> li = new ArrayList<>();

        sieve(li);

        for (int i=0;i<li.size();i++){
            System.out.print(li.get(i)+" ");
        }
    }

    public static ArrayList<Integer> sieve(ArrayList<Integer> primes){

        boolean isPrime[]=new boolean[100];
        for (int i=0;i<isPrime.length;i++) isPrime[i]=true;

        for (int i=2;i*i<isPrime.length;i++){
            if (isPrime[i]){
                for (int j=i*i;j<isPrime.length;j+=i){
                    isPrime[j]=false;
                }
            }
        }

        for (int i=2;i<isPrime.length;i+=2){
            if (isPrime[i]) primes.add(i);
        }

        return primes;
    }

}