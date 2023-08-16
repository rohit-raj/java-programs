package ds.linkedlist;

/**
 * Created by rohit on 02/09/20.
 * https://leetcode.com/problems/linked-list-cycle/
 * https://leetcode.com/problems/linked-list-cycle-ii/
 */
public class Cycle {
    Node head;

    static class Node {
        int data;
        Node next;
        Node(int item) {
            data = item;
            next = null;
        }
    }

    void insertAtLast(int data){
        Node item = new Node(data);
        if(head == null){
            head = item;
            return;
        }
        Node curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = item;
    }

    boolean findCycle () {
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    void createCycle(int a, int b){
        int countA = 0, countB =0;

        Node ptrA = head;
        Node ptrB = head;

        while (countA != a || countB != b){
            if (countA != a){
                countA++;
                ptrA = ptrA.next;

            }
            if(countB != b){
                countB++;
                ptrB = ptrB.next;
            }
        }
        ptrB.next=ptrA;
    }

    Node detectCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                fast = head;
                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        Cycle cycle = new Cycle();

        cycle.insertAtLast(1);
        cycle.insertAtLast(2);
        cycle.insertAtLast(3);
//        cycle.insertAtLast(4);
        cycle.printLL();

//        cycle.createCycle(1,2);
        System.out.println(cycle.findCycle());


    }

    void printLL(){
        Node curr = head;
        while (curr != null){
            System.out.print(curr.data);
            System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

}
