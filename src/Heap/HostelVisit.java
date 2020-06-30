package Heap;

import java.util.ArrayList;
import java.util.*;

class Hep {
        static ArrayList<Long> data = new ArrayList<>();
        public static void main(String args[]) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int k = sc.nextInt();
            while(n-->0){
                int type = sc.nextInt();
                if(type==1){
                    long x = sc.nextLong();
                    long y = sc.nextLong();
                    long calc = (x*x)+(y*y);
                    add(calc,k);
                    //  System.out.println(data);
                }else{
                    // downheapify(0);
                    display();
                }
            }
        }

        public static void display(){
            System.out.println(data.get(0));
        }

        public static void add(long item,int k ){
            if(data.size() < k){
                data.add(item);
                heapify(data.size()-1);
            }else if(data.get(0) > item){
                // System.out.println(data.get(0));
                remove();
                data.add(item);
                heapify(data.size()-1);
            }
        }

        public static void heapify(int idx){
            int parentidx = (idx-1)/2;
            if(data.get(parentidx) < data.get(idx)){
                swap(parentidx,idx);
                heapify(parentidx);
            }
        }

        public static long remove(){
            swap(0,data.size()-1);
            long rm = data.remove(data.size()-1);
            downheapify(0);
            return rm;
        }

        public static void swap(int pi, int ci){
            long pp = data.get(pi);
            long cc = data.get(ci);
            data.set(pi,cc);
            data.set(ci,pp);
        }

        public static void downheapify(int pi){
            int leftChildIndex = 2*pi+1;
            int rightChildIndex = 2*pi+2;

            int max = pi;

            if (leftChildIndex < data.size() && data.get(leftChildIndex) > data.get(max)){
                max = leftChildIndex;
            }

            if(rightChildIndex < data.size() && data.get(rightChildIndex) > data.get(max)){
                max = rightChildIndex;
            }

            if (max != pi){
                swap(pi,max);
                downheapify(max);
            }
        }
}
