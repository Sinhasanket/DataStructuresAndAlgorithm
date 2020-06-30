package Hashing;

import java.util.HashSet;
import java.util.Scanner;

public class ConsSequence {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-->0) {
            int n = sc.nextInt();
            int a[] = new int[n];

            for(int i=0; i<n; i++)
                a[i] = sc.nextInt();
            System.out.println(findLongestConseqSubseq(a, n));
        }
}

    static int findLongestConseqSubseq(int arr[], int n) {
        int ans = 0;
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hs.add(arr[i]);
        }
        for (int i = 0; i < n; i++) {

            if (!hs.contains(arr[i] - 1)) {
                int j = arr[i];
                while (hs.contains(j)) {
                    j++;
                    if (ans < j - arr[i])
                        ans = j - arr[i];
                }
            }
        }
        return ans;
    }
}