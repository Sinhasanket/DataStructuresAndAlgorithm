package Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortByFreq {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        while(n != 0) {
            int size = Integer.parseInt(sc.readLine());
            int arr[] = new int[size];
            String[] temp = sc.readLine().trim().split("\\s+");

            for(int i = 0; i < size; i++)
                arr[i] = Integer.parseInt(temp[i]);

            sortByFreq(arr, size);
            System.out.println();
            n--;
        }
    }

    static void sortByFreq(int arr[], int n) {

        HashMap<Integer,Integer> h=new HashMap<>();

        for(Integer k:arr ){
            if(h.containsKey(k))
                h.put(k,h.get(k)+1);
            else
                h.put(k,1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> p=new PriorityQueue<>((t1, t2)->{
            if(t1.getValue()==t2.getValue())
                return t1.getKey()-t2.getKey();
            else
                return t2.getValue()-t1.getValue();
        });

        p.addAll(h.entrySet());

        StringBuffer b=new StringBuffer("");
        while(!p.isEmpty()){
            String str[]=p.poll().toString().split("=");
            int k=Integer.parseInt(str[0]);
            int f=Integer.parseInt(str[1]);
            while(f-- >0)
                b.append(k+" ");
        }
        System.out.print(b);
    }
}

//        Input:
//        2
//        5
//        5 5 4 6 4
//        5
//        9 9 9 2 5
//
//        Output:
//        4 4 5 5 6
//        9 9 9 2 5