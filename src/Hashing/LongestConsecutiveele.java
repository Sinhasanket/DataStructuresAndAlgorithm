package Hashing;

import java.util.HashSet;
import java.util.Scanner;

public class LongestConsecutiveele {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t>0) {
            int n = sc.nextInt();
            int a[] = new int[n];

            for(int i=0; i<n; i++)
                a[i] = sc.nextInt();

            System.out.println(findLongestConseqSubseq(a, n));

            t--;
        }
    }

    static int findLongestConseqSubseq(int a[], int n) {
        // HashSet to store numbers
        HashSet<Integer> hs = new HashSet<Integer>();
        int ans = 0;

        // Adding elements to hash
        for(int i=0; i<n; i++)
            hs.add(a[i]);

        for(int i=0; i<n; i++) {
            if(!hs.contains(a[i]-1)) {
                int j = a[i];
                while(hs.contains(j)) {
                    j++;
                }
                if(ans < j-a[i])
                    ans = j-a[i];
            }
        }
        return ans;
    }
}

//        Input:
//        2
//        7
//        2 6 1 9 4 5 3
//        7
//        1 9 3 10 4 20 2
//
//        Output:
//        6
//        4