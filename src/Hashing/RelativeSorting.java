package Hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class RelativeSorting {

    public static void main (String[] args) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- >0) {
            int m = sc.nextInt();
            int n = sc.nextInt();

            int A[] = new int[m];
            int B[] = new int[n];

            for(int i = 0; i< m; i++)
                A[i] = sc.nextInt();

            for(int i = 0; i < m; i++) {
                int key = A[i];

                if(mp.containsKey(key) == true) {
                    int freq = mp.get(key);
                    freq++;
                    mp.put(key, freq);
                }
                else mp.put(key, 1);
            }

            StringBuffer sb = new StringBuffer();

            for(int i = 0; i < n; i++)
                B[i] = sc.nextInt();

            for(int i = 0; i < n; i++) {
                if(mp.containsKey(B[i]) == true) {
                    int freq = mp.get(B[i]);
                    while(freq != 0) {
                        sb.append(B[i] + " ");
                        freq--;
                    }
                    if(freq == 0)
                        mp.remove(B[i]);
                }
            }

            ArrayList<Integer> list = new ArrayList<>();

            for(int i = 0; i < m ;i++) {
                if(mp.containsKey(A[i]) == true)
                    list.add(A[i]);
            }
            Collections.sort(list);

            for(Integer val: list)
                sb.append(val + " ");

            System.out.println(sb);
            mp.clear();
        }
    }
}


//        Input:
//        1
//        11 4
//        2 1 2 5 7 1 9 3 6 8 8
//        2 1 8 3
//
//        Output:
//        2 2 1 1 8 8 3 5 6 7 9