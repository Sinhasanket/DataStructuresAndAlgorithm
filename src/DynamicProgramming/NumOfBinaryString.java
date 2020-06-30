package DynamicProgramming;

public class NumOfBinaryString {
    public static void main(String[] args){
        int n = 4;
        System.out.println(solve(n));
    }

    public static int solve(int n){
        int ones[]=new int[n];
        int zeros[]=new int[n];
        ones[0] = 1;
        zeros[0] = 1;
        for (int i=1;i<n;i++){
            zeros[i] = zeros[i-1] + ones[i-1];
            ones[i] = zeros[i-1];
        }
        return zeros[n-1] + ones[n-1];
    }
}
