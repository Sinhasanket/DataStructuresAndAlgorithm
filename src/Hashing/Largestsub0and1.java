package Hashing;

import java.util.HashMap;
import java.util.Map;

public class Largestsub0and1 {

    static int countSubarrWithEqualZeroAndOne(int[] arr, int n) {
        Map<Integer, Integer> myMap = new HashMap<>();
        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0)
                arr[i] = -1;

            sum += arr[i];
            if (sum == 0)
                count++;

            if (myMap.containsKey(sum))
                count += myMap.get(sum);

            if (!myMap.containsKey(sum))
                myMap.put(sum, 1);
            else
                myMap.put(sum, myMap.get(sum) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        int arr[] = { 1, 0, 0, 1, 0, 1, 1 };
        int n = arr.length;
        System.out.println("Count = " +
                countSubarrWithEqualZeroAndOne(arr, n));

    }

}