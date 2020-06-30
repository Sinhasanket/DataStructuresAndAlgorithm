package Arrays;

public class Kadane {
    public static void main(String[] args){

//        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
      //  int [] a = {-1 ,-2 ,-3 ,-4};
        int [] a = {2, 6, 1 ,9, 4, 5, 3};
        int n = a.length;
        System.out.println("Maximum contiguous sum is " + maxSubArraySum(a ,n));
    }
    static int maxSubArraySum(int a[],int size){

        int max_so_far = a[0], max_ending_here = 0;

        for (int i = 0; i < size; i++) {
            max_ending_here = max_ending_here + a[i];
            if (max_ending_here < 0)
                max_ending_here = 0;

            else if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
        }
        return max_so_far;
    }
}