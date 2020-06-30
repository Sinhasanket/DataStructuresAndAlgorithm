package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargestNumWithSum {

    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while(t-- >0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int sum = Integer.parseInt(inputLine[1]);
            System.out.println(largestNumber(n, sum));
        }
    }

    static String largestNumber(int n, int sum) {
        if(sum > 9*n){
            return "-1";
        }
        String str = "";
        for(int i=0; i<n; i++){
            int temp = 0;
            if(sum!=0)temp = sum>9?9:sum;
            str += (char)(temp+'0');
            sum -= temp;
        }
        return str;
    }
}



//        Input:
//        3
//        5 12
//        3 29
//        3 26
//
//        Output:
//        93000
//        -1
//        998
