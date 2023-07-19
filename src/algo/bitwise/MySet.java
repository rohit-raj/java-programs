package algo.bitwise;

import java.util.Random;

/**
 * Design set data structure using bit
 * https://youtu.be/ZwU6wSkepBI?t=6187
 *
 * complexity : O(1)
 */
public class MySet {
    private static int x=0;

    static void add(int num){
        x = x | (1<< num); // concept of set ith bit
    }

    static void remove(int num){
        x = x & ~(1<<num); // concept of clear ith bit
    }

    static void print(){
        for(int bit=0;bit<32;bit++){
            if((x &(1<<bit)) !=0){
                System.out.println(bit);
            }
        }
    }

    public static void main(String[] args) {
        add(1);
        add(5);
        add(3);
        add(4);
        add(5);
        remove(3);
        print();
    }
}
