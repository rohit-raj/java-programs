package blind75;

import java.util.HashSet;
import java.util.Set;

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
                Node temp = head;
                while(slow != temp) {
                    slow = slow.next;
                    temp = temp.next;
                }
                return slow;
            }
        }
        return null;
    }

    void createCycleFromLast(int toPosition){
        Node curr = head;
        int count = 0;
        Node cyclePosition = null;
        while(curr.next != null){
            count++;
            if(count == toPosition){
                cyclePosition = curr;
            }
            curr = curr.next;
        }
        curr.next = cyclePosition;
//        System.out.println("cyclePosition : "+ cyclePosition.data);
//        System.out.println("curr : "+ curr.data);
    }



    public static void main(String[] args) {
        Cycle cycle = new Cycle();

        cycle.insertAtLast(1);
        cycle.insertAtLast(2);
        cycle.insertAtLast(3);
        cycle.insertAtLast(4);
        cycle.insertAtLast(5);
//        cycle.insertAtLast(4);
        cycle.printLL();

//        cycle.createCycle(1,2);
        System.out.println(cycle.findCycle());

        cycle.createCycleFromLast(3);
        System.out.println(cycle.findCycle());
        System.out.println("cycle at : "+cycle.detectCycle(cycle.head).data);
        System.out.println("length of cycle : "+cycle.lengthOfLoop2(cycle.head));

    }

    int lengthOfLoop(Node head){
        Node pos = null;
        Node slow = head;
        Node fast = head;
        Node temp = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast){
                pos = slow;
                while (temp != slow){
                    temp = temp.next;
                    slow = slow.next;
                }
                break;
            }
        }
        if(pos == null) return -1;

        temp = temp.next;
        int count=1;
        while (temp != slow){
            temp = temp.next;
            count++;
        }
        return count;
    }

    int lengthOfLoop2(Node head){
        Set<Node> set = new HashSet<>();
        Node curr = head;
        while (curr != null && !set.contains(curr)){
            curr = curr.next;
        }

        System.out.println("curr. : "+ curr.data);
        return 0;
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
