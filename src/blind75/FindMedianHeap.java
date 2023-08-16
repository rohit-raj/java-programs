package blind75;

import java.util.*;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/
 */
public class FindMedianHeap {
    private List<Integer> list; // brute
    private Queue<Integer> smallHeap; // maxHeap
    private Queue<Integer> largeHeap; // minHeap

    public FindMedianHeap() {
        list = new ArrayList<>(); // brute
        smallHeap = new PriorityQueue<>((a,b) -> b-a);
        largeHeap = new PriorityQueue<>((a,b) -> a-b);
    }

    public void addNumBrute(int num) {
        list.add(num); // brute
    }

    public void addNumOptimal(int num) {
        smallHeap.add(num);
        if(smallHeap.size() - largeHeap.size() > 1 || !largeHeap.isEmpty() && smallHeap.peek() > largeHeap.peek()){
            largeHeap.add(smallHeap.poll());
        }
        if(largeHeap.size() - smallHeap.size() > 1){
            smallHeap.add(largeHeap.poll());
        }
    }

    public double findMedianBrute() {
        Collections.sort(list);
        int n = list.size();
        if(n%2 == 0){
            int middle1 = list.get((n/2)-1);
            int middle2 = list.get(n/2);
            return (double) (middle1+middle2)/2;
        } else {
            return (double) list.get(n/2);
        }
    }

    public double findMedianOptimal(){
        if(smallHeap.size() == largeHeap.size()){
            return (double) (smallHeap.peek() + largeHeap.peek())/2;
        } else if(smallHeap.size() > largeHeap.size()){
            return (double) smallHeap.peek();
        } else {
            return (double) largeHeap.peek();
        }
    }

    public static void main(String[] args) {

        FindMedianHeap fmh = new FindMedianHeap();

        fmh.addNumBrute(2);
        fmh.addNumBrute(5);
        fmh.addNumBrute(3);
//        fmh.addNumBrute(1);

        System.out.println("median : "+fmh.findMedianBrute());

        //optimal

        fmh.addNumOptimal(2);
        fmh.addNumOptimal(5);
        fmh.addNumOptimal(3);
//        fmh.addNumOptimal(1);

        System.out.println("median : "+fmh.findMedianOptimal());

    }
}
