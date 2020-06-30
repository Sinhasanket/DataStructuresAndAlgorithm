package Maths;

import java.util.HashSet;

public class GrundyNumber {
    static int calculateMex(HashSet<Integer> Set) {
        int Mex = 0;

        while (Set.contains(Mex)) {
            Mex++;
        }
        return (Mex);
    }

    // A function to Compute Grundy
    // Number of 'n' Only this function
    // varies according to the game
    static int calculateGrundy(int n)
    {
        if (n == 0) {
            return (0);
        }
        if (n == 1) {
            return (1);
        }
        if (n == 2) {
            return (2);
        }
        if (n == 3) {
            return (3);
        }

        HashSet<Integer> Set = new HashSet<Integer>();

        for (int i = 1; i <= 3; i++) {
            Set.add(calculateGrundy(n - i));
        }
        return (calculateMex(Set));
    }


    public static void main(String[] args) {
        int n = 10;
        System.out.printf("%d", calculateGrundy(n));
    }

}
