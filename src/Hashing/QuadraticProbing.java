package Hashing;

import java.util.Scanner;

public class QuadraticProbing {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- >0) {
            int hash_size = sc.nextInt();
            int array_size = sc.nextInt();

            int arr[] = new int[array_size];

            for(int i = 0; i < array_size; i++)
                arr[i] = sc.nextInt();

            int hash_table[] = new int[hash_size];

            for(int i = 0; i < hash_size; i++)
                hash_table[i] = -1;

            quadraticProbing(hash_table, hash_size, arr, array_size);

            for(int i = 0; i <hash_size; i++)
                System.out.print(hash_table[i] + " ");

            System.out.println();
        }
    }

    static void quadraticProbing(int hash_table[], int hash_size, int arr[], int n) {
        int temp = 0, k = 0;
        for (int i = 0; i < n; i++) {
            temp = arr[i] % hash_size;
            if (hash_table[temp] == -1) {
                hash_table[temp] = arr[i];
            } else {
                k = arr[i];
                for (int j = 1; j < hash_size; j++) {
                    temp = (k + (j * j)) % hash_size;
                    if (hash_table[temp] == -1) {
                        hash_table[temp] = arr[i];
                        break;
                    }
                }
            }
        }
    }
}


//        Input:
//        1
//        11
//        4
//        21 10 32 43
//        Output:
//        10 -1 -1 32 -1 -1 -1 -1 43 -1 21