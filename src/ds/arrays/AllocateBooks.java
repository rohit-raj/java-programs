package ds.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * https://www.youtube.com/watch?v=Z0hwjftStI4&list=PLgUwDviBIf0pMFMWuuvDNMAkoQFi-h0ZF&index=19
 *
 * https://www.codingninjas.com/studio/problems/allocate-books_1090540
 */
public class AllocateBooks {

    static int allocation(ArrayList<Integer> books, int pages){
        int allocatedStudent = 1;
        int pagesStudent = 0;

        for(int i=0;i<books.size();i++){
            if(pagesStudent + books.get(i) <= pages){
                pagesStudent += books.get(i);
            } else {
                allocatedStudent++;
                pagesStudent = books.get(i);
            }
        }
        return allocatedStudent;
    }

    static int findPagesBrute(ArrayList<Integer> books, int students){
        if(students > books.size()){
            return -1;
        }
        int low = Integer.MAX_VALUE;
        int high = 0;
        for(int pages : books){
            low = Math.min(low, pages);
            high += pages;
        }

        for (int pages=low;pages<high;pages++){
            int allocatedStudent = allocation(books, pages);
            if(allocatedStudent == students){
                return pages;
            }
        }
        return -1;
    }

    static int findPagesOptimal(ArrayList<Integer> books, int students){
        if(students > books.size()){
            return -1;
        }

        Collections.sort(books);
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int pages : books){
            low = Math.max(low, pages);
            high += pages;
        }

        while (low<=high){
            int mid = low+(high-low)/2;

            int allocatedStudent = allocation(books, mid);
            if(allocatedStudent <= students){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        ArrayList<Integer> books = new ArrayList<>(Arrays.asList(1,17,14,9,15,9,14));

        int students = 7;


        System.out.println("findPagesBrute : "+findPagesBrute(books, students));
        System.out.println("findPagesOptimal : "+findPagesOptimal(books, students));

    }

}
