package Arrays;

class MaxCircularSubArSum {

    static int maxCircularSum (int a[]) {
        int n = a.length;

        int max_kadane = kadane(a);
        int max_wrap  =  0;
        for (int i = 0; i < n; i++) {
            max_wrap += a[i];
            a[i] = -a[i];
        }
        max_wrap = max_wrap + kadane(a);
        if(max_wrap==0 || max_kadane==0){
            return -1;
        }
        else
            return (max_wrap > max_kadane)? max_wrap: max_kadane;
    }

    static int kadane (int a[]) {
        int n = a.length;
        int max_so_far = a[0], max_ending_here = 0;
        for (int i = 0; i < n; i++) {
            max_ending_here = max_ending_here + a[i];
            if (max_ending_here < 0)
                max_ending_here = 0;
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
        }
        return max_so_far;
    }

    public static void main (String[] args)
    {
//        int a[] =  {11, 10, -20, 5, -3, -5, 8, -13, 10};
        int a[]={240, 71, -136, 88};
        System.out.println("Maximum circular sum is " +
                maxCircularSum(a));
    }
}