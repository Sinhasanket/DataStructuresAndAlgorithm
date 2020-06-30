package Hashing;

import java.util.Scanner;

public class LinearProbing {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int hash_size = sc.nextInt();
            int array_size = sc.nextInt();

            int arr[] = new int[array_size];
            for (int i = 0; i < array_size; i++)
                arr[i] = sc.nextInt();

            int hash_table[] = new int[hash_size];
            for (int i = 0; i < hash_size; i++)
                hash_table[i] = -1;

            linearProbing(hash_table, hash_size, arr, array_size);

            for (int i = 0; i < hash_size; i++)
                System.out.print(hash_table[i] + " ");

            System.out.println();

        }
    }
    static void linearProbing(int hash_table[], int hash_size, int arr[], int n) {
        int temp=0;
        for(int i=0;i<n;i++){
            temp=arr[i]%hash_size;
            if(hash_table[temp]==-1){
                hash_table[temp]=arr[i];
            }else{
                for(int j=0;j<hash_size;j++){
                    int k = (temp+j)%hash_size;
                    if(hash_table[k]==-1){
                        hash_table[k]=arr[i];
                        break;
                    }
                }
            }
        }
    }
}

//        Input:
//        2
//        10
//        4
//        4 14  24 44
//        10
//        4
//        9 99 999 9999
//        Output:
//        -1 -1 -1 -1 4 14 24 44 -1 -1
//        99 999 9999 -1 -1 -1 -1 -1 -1 9