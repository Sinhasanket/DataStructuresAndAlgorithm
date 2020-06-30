package Heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxMinHeap {
    public static void main (String[] args) {
        // DECLARING MAX HEAP
        Queue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());

        max_heap.add(10);
        max_heap.add(30);
        max_heap.add(20);
        max_heap.add(5);
        max_heap.add(1);

        System.out.print("Element at top of Max Heap at" + " every step:\n");
        while(!max_heap.isEmpty()) {
            System.out.print(max_heap.peek()+" ");
            max_heap.poll();
        }

        // DECLARING MIN HEAP
        Queue<Integer> min_heap = new PriorityQueue<>();

        min_heap.add(10);
        min_heap.add(30);
        min_heap.add(20);
        min_heap.add(5);
        min_heap.add(1);

        System.out.print("\n\nElement at top of Min Heap "+ "at every step:\n");
        while(!min_heap.isEmpty()) {
            System.out.print(min_heap.peek()+" ");
            min_heap.poll();
        }
    }
}