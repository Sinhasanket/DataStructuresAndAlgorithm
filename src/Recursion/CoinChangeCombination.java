package Recursion;

public class CoinChangeCombination {
    static int count=0;
    public static void main(String[] args){
        int denom[]={2,3};
        int total = 7;
        CoinChange(denom,total,"",0);
        coinChangewtCoin(denom,0,total,"");
    }

    public static void CoinChange(int denomination[],int amout,String ans,int lastIndex){
        if (amout==0){
            count++;
            System.out.println(count+". "+ans);
            return;
        }
        //if want to print permutation then start from 0 instead of lastindex.
        for (int i=lastIndex;i<denomination.length;i++){
            if (amout >= denomination[i]){
                CoinChange(denomination,amout-denomination[i],ans+denomination[i],i);
            }
        }
    }

    public static void coinChangewtCoin(int denom[],int idx,int amout,String ans){
        //Positive BaseCase
        if (amout==0){
            System.out.println(ans);
            return;
        }
        //Negative BaseCase
        if (idx==denom.length || amout < 0){
            return;
        }
        //Include coin at present idx
        coinChangewtCoin(denom,idx,amout-denom[idx],ans+denom[idx]);
        //Don't include coin at present idx
        coinChangewtCoin(denom,idx+1,amout,ans);
    }
}
