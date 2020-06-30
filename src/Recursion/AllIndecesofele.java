package Recursion;

public class AllIndecesofele {
    static int ans[]=new int[1];
    public static void main(String[] args){
//        two solutions
        int arr[]={3,8,1,8,8,4};
//        allindices(arr,0,8,0);
//        for (int i=0;i<ans.length;i++){
//            System.out.print(ans[i]+" ");
//        }
        int ar[]=allindices(arr,0,8,0);
        for (int i=0;i<ar.length;i++) System.out.print(ar[i]+" ");
    }

//    public static int[] allindices(int arr[],int si,int find,int count){
//        if (si==arr.length)return ans;
//        if (arr[si]==find){
//            int b[] = ans;
//            ans = Arrays.copyOf(b,count+1);
//            ans[count]=si;
//            return allindices(arr,si+1,find,count+1);
//        }else{
//            return allindices(arr,si+1,find,count);
//        }
//    }

    public static int[] allindices(int arr[],int si,int find,int count){
        if (si==arr.length){
            int[] base = new int[count];
            return base;
        }
        int[] indices = null;
        if (arr[si]==find){
            indices = allindices(arr,si+1,find,count+1);
        }else{
            indices = allindices(arr,si+1,find,count);
        }
        if (arr[si]==find){
            indices[count] = si;
        }
        return indices;
    }
}
