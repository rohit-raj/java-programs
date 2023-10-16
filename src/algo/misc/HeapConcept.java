package algo.misc;

import java.util.*;

/**
 * Heap
 * Min Heap : Small number : high priority
 * Max Heap : Large number : high priority
 *
 * default priority queue is min heap
 */
public class HeapConcept {
    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;
    Queue<Integer> heap;
    Map<Integer, Integer> map;

    public HeapConcept(){
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        map = new HashMap<>();
    }

    public void insert(int[] nums){
        for (int num : nums){
            minHeap.offer(num);
            maxHeap.offer(num);
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        heap = new PriorityQueue<>(
                (a,b)->map.get(a)-map.get(b)
        );

        heap.addAll(map.keySet());

    }

    public void printMinHeap(){
        System.out.println("Min heap : ");
        while (minHeap.size()>0){
            System.out.println(minHeap.poll());
        }
    }

    public void printMaxHeap(){
        System.out.println("Max heap : ");
        while (maxHeap.size()>0){
            System.out.println(maxHeap.poll());
        }
    }

    public void print(){
        System.out.println("Min heap\tMax heap");
        while (maxHeap.size()>0){
            System.out.println(minHeap.poll()+"\t\t\t"+maxHeap.poll());
        }
    }

    public void printHeap(){
        System.out.println("\nheap : ");
        System.out.println("map : "+ map);
        while (heap.size()>0){
            System.out.println(heap.poll());
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,2,2,3};

        HeapConcept heap = new HeapConcept();

        heap.insert(nums);
//        heap.printMinHeap();
//        System.out.println();
//        heap.printMaxHeap();
        heap.print();
        heap.printHeap();
    }
}
