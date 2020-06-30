package Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Given an array of names (consisting of lowercase characters) of candidates in an election.
//A candidate name in array represents a vote casted to the candidate. Print the name of candidate that received Max votes.
//If there is tie, print lexicographically smaller name.

public class WinnerOfElection {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0) {
            int n = sc.nextInt();
            String arr[] = new String[n];

            for(int i = 0; i < n; i++)
                arr[i] = sc.next();
            winner(arr, n);

            System.out.println();
        }
    }

    static void winner(String arr[], int n) {
        // map to store count of frequency of each name
        HashMap<String, Integer> mp = new HashMap<>();

        // storing the frequency of names in the map
        for(int i = 0; i < n; i++) {
            String key = arr[i];
            if(mp.containsKey(key) == true) {
                int freq = mp.get(key);
                freq++;
                mp.put(key, freq);
            }else {
                mp.put(key, 1);
            }
        }

        // Traverse through map to find the candidate
        // with maximum votes.
        int maxx = 0;
        String answer = "";
        for (Map.Entry<String,Integer> entry : mp.entrySet()) {
            String key  = entry.getKey();
            Integer val = entry.getValue();
            if (val > maxx) {
                maxx = val;
                answer = key;
            }

            // If there is a tie, pick lexicographically
            // smaller.
            else if (val == maxx &&
                    answer.compareTo(key) > 0)
                answer = key;
        }

        System.out.print(answer +" " + maxx);
    }
}

//        Input:
//        2
//        13
//        john johnny jackie johnny john jackie jamie jamie john johnny jamie johnny john
//        3
//        andy blake clark
//
//        Output:
//        john 4
//        andy 1