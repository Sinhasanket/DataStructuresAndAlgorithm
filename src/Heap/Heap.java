package Heap;

import java.util.ArrayList;

class makeHeap {
    ArrayList<Integer> data = new ArrayList<>();

    public void add(int item){
        data.add(item);
        heapify(data.size()-1);
    }

    private void heapify(int childIndex){
        int parentI = (childIndex-1)/2;
        if (data.get(parentI) > data.get(childIndex)){
            swap(parentI,childIndex);
            heapify(parentI);
        }
    }

    private void swap(int i,int j){
        int ith = data.get(i);
        int jth = data.get(j);
        data.set(i,jth);
        data.set(j,ith);
    }

    public void display(){
        System.out.println(data);
    }

    public int size(){
        return this.data.size();
    }

    public boolean isEmpty(){
        return this.data.size()==0;
    }

    public int remove(){
        swap(0,this.data.size()-1);
        int rm = this.data.remove(this.data.size()-1);
        downheapify(0);
        return rm;
    }

    public void downheapify(int pi){
        int leftChildIndex = 2*pi+1;
        int rightChildIndex = 2*pi+2;

        int mini = pi;

        if (leftChildIndex < this.data.size() && this.data.get(leftChildIndex) < this.data.get(mini)){
            mini = leftChildIndex;
        }

        if(rightChildIndex < this.data.size() && this.data.get(rightChildIndex) < this.data.get(mini)){
            mini = rightChildIndex;
        }

        if (mini != pi){
            swap(pi,mini);
            downheapify(mini);
        }
    }

    public int get(){
        return this.data.get(0);
    }
}

public class Heap{
    public static void main(String[] args){
        makeHeap heap = new makeHeap();
        heap.add(200);
        heap.display();
        heap.add(162);
        heap.display();
        heap.add(128);
        heap.display();
        heap.add(98);
        heap.display();
        heap.add(72);
        heap.display();
        heap.add(50);
        heap.display();

        System.out.println(heap.remove());
        heap.display();

        System.out.println(heap.remove());
        heap.display();
    }
}