package Recursion;

import java.util.ArrayList;

public class SubsequeneceOfString {
    public static void main(String[] args){
        String str = "123";   //no. of subsequence will be always 2^n, where n is length of string
//       ArrayList<String> sub =findSub(str);
//        for (int i=0;i<sub.size();i++){
//            System.out.print(sub.get(i)+" ");
//        }

//        ArrayList<String> subAscii =findSubwithAscii(str);
//        for (int i=0;i<subAscii.size();i++){
//            System.out.print(subAscii.get(i)+" ");
//        }
        findSubVoid(str,0,"");
      //  findSubAscii(str,"");
    }

    public static ArrayList<String> findSubwithAscii(String str){
        if (str.length()==0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        char current = str.charAt(0);
        String rest = str.substring(1);
        ArrayList<String> myReS = new ArrayList<>();
        ArrayList<String> recRes = findSub(rest);
        for (int i=0;i<recRes.size();i++){
            myReS.add(recRes.get(i));
            myReS.add(current+recRes.get(i));
            myReS.add(((int)current)+recRes.get(i));
        }
        return myReS;
    }

    //with using arraylist

    public static ArrayList<String> findSub(String str){
         if (str.length()==0){
             ArrayList<String> base = new ArrayList<>();
             base.add("");
             return base;
         }
         char current = str.charAt(0);
         String rest = str.substring(1);
         ArrayList<String> myReS = new ArrayList<>();
         ArrayList<String> recRes = findSub(rest);
         for (int i=0;i<recRes.size();i++){
             myReS.add(recRes.get(i));
             myReS.add(current+recRes.get(i));
        }
        return myReS;
    }


//    one of the solution without returning arraylist

    public static void findSubVoid(String str,int index,String curr){
        if (index==str.length()){
            System.out.println(curr);
            return;
        }
        findSubVoid(str,index+1,curr);
        findSubVoid(str,index+1,curr+str.charAt(index));
    }
//    another way
    public static void findSubAscii(String str,String curr){
        if (str.length()==0){
            System.out.println(curr);
            return;
        }
       // int ch =(int) str.charAt(0);
        char chr = str.charAt(0);
        String rest = str.substring(1);
        findSubAscii(rest,curr);
        findSubAscii(rest,curr+chr);
    }
}
