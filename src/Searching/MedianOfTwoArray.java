package Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MedianOfTwoArray {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] a){
        FastReader in = new FastReader();
        int t = in.nextInt();
        while(t-->0){
            int n1= in.nextInt();
            int n2 = in.nextInt();
            int arr1[] = new int[n1];
            int arr2[] = new int[n2];
            for(int i=0;i<n1;i++){
                arr1[i] = in.nextInt();
            }
            for(int i=0;i<n2;i++){
                arr2[i] = in.nextInt();
            }
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            System.out.println(findMedianOfArrays(arr1,arr2));
        }

    }

    public static int findMedianOfArrays(int input1[], int input2[]) {
        if (input1.length > input2.length) {
            return findMedianOfArrays(input2, input1);
        }
        int x = input1.length;
        int y = input2.length;

        int low = 0;
        int high = x;
        while (low <= high) {
            int partitionX = (low + high)/2;
            int partitionY = (x + y + 1)/2 - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : input1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : input1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : input2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((x + y) % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }
        return 0;
    }
}

//input
//3
//5 6
//1 2 3 4 5
//3 4 5 6 7 8
//2 3
//1 2
//2 3 4
//4 4
//1 2 3 4
////11 12 13 14

//output
//4