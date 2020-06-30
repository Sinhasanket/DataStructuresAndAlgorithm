package Heap;

import java.util.ArrayList;

public class makeHeapgeneric<T extends Comparable<T>> {
    ArrayList<T> data = new ArrayList<>();

    public void add(T item){
        data.add(item);
        heapify(data.size()-1);
    }

    private void heapify(int childIndex){
        int parentI = (childIndex-1)/2;
        if ((isLarger(data.get(childIndex), data.get(parentI))) > 0 ){
            swap(parentI,childIndex);
            heapify(parentI);
        }
    }

    private void swap(int i,int j){
        T ith = data.get(i);
        T jth = data.get(j);
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

    public T remove(){
        swap(0,this.data.size()-1);
        T rm = this.data.remove(this.data.size()-1);
        downheapify(0);
        return rm;
    }

    public void downheapify(int pi){
        int leftChildIndex = 2*pi+1;
        int rightChildIndex = 2*pi+2;

        int mini = pi;

        if (leftChildIndex < this.data.size() && (isLarger(data.get(leftChildIndex),data.get(mini))) > 0){
            mini = leftChildIndex;
        }

        if(rightChildIndex < this.data.size() && (isLarger(data.get(rightChildIndex),data.get(mini))) > 0){
            mini = rightChildIndex;
        }

        if (mini != pi){
            swap(pi,mini);
            downheapify(mini);
        }
    }

    public T get(){
        return this.data.get(0);
    }

    public int isLarger(T t,T o){
        return t.compareTo(o);
    }
}
