package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSum {

    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static void main (String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- >0) {
            String str[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            ArrayList<Integer> list = new ArrayList<>();
            str = br.readLine().trim().split(" ");
            for(int i = 0; i <n ;i++)
                list.add(Integer.parseInt(str[i]));
            str = br.readLine().trim().split(" ");
            int sum = Integer.parseInt(str[0]);

            res = combinationSum(list, sum);
            if (res.size() == 0) {
                System.out.print("Empty");
            }

            for (int i = 0; i < res.size(); i++) {
                if (res.size() > 0) {
                    System.out.print("(");
                    List<Integer> ij = res.get(i);
                    for (int j = 0; j < ij.size(); j++) {

                        System.out.print(ij.get(j));
                        if(j < ij.size()-1)
                            System.out.print(" ");
                    }
                    System.out.print(")");
                }
            }
            System.out.println();
            res.clear();
        }
    }

    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> list, int sum) {
        Collections.sort(list);
        ArrayList<Integer> r = new ArrayList<>();
        ArrayList<Integer> C = new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int i,j;

        for(i=0;i<list.size();i++){
            j=i+1;
            while(j<list.size()&&list.get(i) == list.get(j)){
                j++;
            }
            C.add(list.get(i));
            i=j-1;
        }
        findNumbers(C, sum, res, r, 0);
        return res;
    }

    static void findNumbers(ArrayList<Integer> ar, int sum, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> r, int i) {
        if (sum < 0 || i >= ar.size())
            return;

        if (sum == 0) {
            res.add(new ArrayList<Integer>(r));
            return;
        }

        r.add(ar.get(i));

        findNumbers(ar, sum-ar.get(i), res, r, i);

        r.remove(r.size()-1);

        findNumbers(ar, sum, res, r, i+1);

    }
}

//        Input:
//        3
//        4
//        7 2 6 5
//        16
//        11
//        6 5 7 1 8 2 9 9 7 7 9
//        6
//        4
//        2 4 6 8
//        8
//
//        Output:
//        (2 2 2 2 2 2 2 2)(2 2 2 2 2 6)(2 2 2 5 5)(2 2 5 7)(2 2 6 6)(2 7 7)(5 5 6)
//        (1 1 1 1 1 1)(1 1 1 1 2)(1 1 2 2)(1 5)(2 2 2)(6)
//        (2, 2, 2, 2)(2, 2, 4)(2, 6)(4, 4)(8)