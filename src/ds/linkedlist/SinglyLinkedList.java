package ds.linkedlist;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SinglyLinkedList {

    public Node insertAtStart(Node head, int item){
        Node n = new Node(item);
        if(head == null) {
            head = n;
            return head;
        }
        n.next = head;
        head = n;
        return head;
    }

    public Node insertAtLast(Node head, int item){
        Node n = new Node(item);
        if(head == null){
            head = n;
            return head;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = n;
        return head;
    }

    public void insertAtPosition(Node head, int item, int pos){
        if(pos <=0){
            System.out.println("Incorrect position");
            return;
        }
        Node n = new Node(item);
        if(pos == 1){
            n.next = head;
            head = n;
            return;
        }
        Node curr = head;
        int count = 1;
        while (curr != null){
            count++;
            if(pos == count){
                n.next = curr.next;
                curr.next = n;
                return;
            } else {
                curr = curr.next;
            }
        }
        if (pos > count) {
            System.out.println("Cannot insert: index is greater than the list length");
        }
    }

    public void print(Node head){
        Node n = head;
        while (n != null){
            System.out.print(n.data + " => ");
            n = n.next;
        }
        System.out.println("Null");
    }

    public boolean search(Node head, int key){
        if(head == null) return false;

        Node curr = head;
        while (curr.next != null){
            if(curr.data == key){
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public Node createRandomList() {
        Random random = new Random();
        int lLSize = random.nextInt(10);
        Node head = null;
        for(int j = 0; j < lLSize; j++) {
            int x = random.nextInt(10);
            head = insertAtStart(head, x);
        }
        return head;
    }

    public Node createListFromItems(int[] items){
        Node head = null;
        for(int item : items) {
            head = insertAtLast(head, item);
        }
        return head;
    }

    public Node duplicateList(Node head){
        Node curr = head;
        Node dup = null;
        while (curr != null){
            dup = insertAtLast(dup, curr.data);
            curr = curr.next;
        }
        return dup;
    }

    public int getLength(Node head){
        if(head == null){
            return 0;
        }
        if(head.next == null){
            return 1;
        }

        Node curr = head;
        int count = 0;
        while (curr != null){
            count++;
            curr = curr.next;
        }

        return count;
    }

    public Node getMid(Node head){
        if (head == null){
            System.out.println("No nodes present");
            return head;
        }
        Node fast = head;
        Node slow = head;
        while ((fast.next != null) && (fast.next.next != null)) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public void printByHead(Node n) {
        while (n != null){
            System.out.print(n.data + " => ");
            n = n.next;
        }
        System.out.println("Null");
    }

    public Node removeDuplicateBrute(Node head){
        if(head == null || head.next == null) return head;

        Node curr = head;
        Set<Integer> set = new HashSet<>();
        while (curr != null){
            set.add(curr.data);
            curr = curr.next;
        }

        Node dummy = new Node(0);
        Node temp = dummy;
        for (int item : set){
            temp.next = new Node(item);
            temp = temp.next;
        }
        return dummy.next;
    }

    public Node removeDuplicateOptimal(Node head){
        if(head == null || head.next == null) return head;

        Node curr = head;

        while (curr != null  && curr.next != null){
            if(curr.data != curr.next.data){
                curr = curr.next;
            } else {
                curr.next = curr.next.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        Node head = new Node(1);
//        Node second = new Node(2);
//        Node third = new Node(3);
//
//        sll.head.next = second;
//        second.next = third;

//        sll.print();
//        sll.insertAtStart(0);
//        sll.print();
//        sll.insertAtLast(4);
//        sll.print();
//        sll.insertAtPosition(5, 1);
//        sll.print();
//        sll.deleteFirstNodexxx();
//        sll.print();
//        sll.deleteLastNodexxx();
//        sll.print();
//        sll.deleteAtPosition(1);
//        sll.print();
//        sll.insertAtLast(2);
//        sll.insertAtLast(2);
        sll.insertAtLast(head, 1);
        sll.insertAtLast(head, 2);
        sll.insertAtLast(head, 3);
        sll.insertAtLast(head, 3);
        sll.print(head);
//        sll.deleteByValue(4);
//        sll.print();
//        System.out.println("item found : "+ sll.search(head, 2));

        System.out.println("res :: ");
//        Node res = sll.removeDuplicateBrute(head);
        Node res = sll.duplicateList(head);
        sll.printByHead(res);
    }
}