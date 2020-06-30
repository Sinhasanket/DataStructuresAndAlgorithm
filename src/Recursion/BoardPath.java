package Recursion;

//reach from 0 to 10 in all possible ways
public class BoardPath {
    public static void main(String[] args){
      //  ArrayList<String> ans = boardPath(0,10);
        //System.out.println(ans);
        boardPathV(0,10,"");
    }

//    public static ArrayList<String> boardPath(int curr,int end){
//        if (curr==end){
//            ArrayList<String> base = new ArrayList<>();
//            base.add("\n");
//            return base;
//        }
//        if (curr > end){
//            ArrayList<String> base = new ArrayList<>();
//            return base;
//        }
//        ArrayList<String> myans = new ArrayList<>();
//        for (int dice = 1;dice<=6;dice++){
//            ArrayList<String> recu = boardPath(curr+dice,end);
//            for (String recur : recu){
//                myans.add(dice+recur);
//            }
//        }
//        return myans;
//    }

    public static void boardPathV(int curr,int end,String ans){
        if (curr==end){
            System.out.println(ans);
            return;
        }
        if (curr>end){
            return;
        }

        for (int dice=1;dice<=6;dice++){
            boardPathV(curr+dice,end,ans+dice);
        }
    }
}
