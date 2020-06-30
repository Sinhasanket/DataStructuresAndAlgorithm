package Recursion;

import java.util.ArrayList;
//find ways to reach from (0,0) to (2,2) in a maze
public class MazePath {
    public static void main(String[] args){
        System.out.println(getMzePath(0,0,2,2));
        printmazepathV(0,0,2,2,"");
    }

    public static ArrayList<String> getMzePath(int currRow,int currCol,int endRow,int endCol){
        if (currRow==endRow && currCol==endCol){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        if (currRow > endRow || currCol > endCol){
            ArrayList<String> base = new ArrayList<>();
            return base;
        }

        ArrayList<String> myAns = new ArrayList<>();
        ArrayList<String> rowH = getMzePath(currRow,currCol+1,endRow,endCol);
        for (String rh : rowH){
            myAns.add("H"+rh);
        }
        //for diagonal
        ArrayList<String> diagonal = getMzePath(currRow+1,currCol+1,endRow,endCol);
        for (String dg : diagonal){
            myAns.add("D"+dg);
        }

        ArrayList<String> colV = getMzePath(currRow+1,currCol,endRow,endCol);
        for (String cv : colV){
            myAns.add("V"+cv);
        }
        return myAns;
    }

    public static  void printmazepathV(int cr,int cu,int er,int ec,String ans){
        if (cr==er && cu==ec){
            System.out.println(ans);
            return;
        }
        if (cr>er || cu > ec)return;

        printmazepathV(cr,cu+1,er,ec,ans+"H");
        //for diagonal
        printmazepathV(cr+1,cu+1,er,ec,ans+"D");
        printmazepathV(cr+1,cu,er,ec,ans+"V");
    }
}
