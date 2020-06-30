package Arrays;

import java.util.HashMap;

public class LongestSubarrayDivByk {
    static int longSubarrWthSumDivByK(int arr[],int n, int k) {
        HashMap<Integer, Integer> um= new HashMap<Integer, Integer>();

        int mod_arr[]= new int[n];
        int max = 0;
        int curr_sum = 0;

        for (int i = 0; i < n; i++) {
            curr_sum += arr[i];
            mod_arr[i] = ((curr_sum % k) + k) % k;
        }

        for (int i = 0; i < n; i++) {
            if (mod_arr[i] == 0)
                max = i + 1;
            else if (!um.containsKey(mod_arr[i]))
                um.put(mod_arr[i] , i);
            else
                if (max < (i - um.get(mod_arr[i])))
                    max = i - um.get(mod_arr[i]);
        }
        return max;
    }

    public static void main (String[] args) {
        int arr[] = {2, 7, 6, 1, 4, 5};
        int n = arr.length;
        int k = 3;
        System.out.println("Length = "+
                longSubarrWthSumDivByK(arr, n, k));
    }
}
