package ds.linkedlist;

class Reverse {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int item) {
            data = item;
            next = null;
        }
    }

    void insertNode(int item) {
        Node n = new Node(item);
        if (head == null) {
            head = n;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = n;
    }

    void print() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    /**
     * find middle element of a linked list by 2 pointers,
     * one that iterates 2 nodes
     * second that iterates one node
     *
     * @return
     */
    void reverseList() {
        if (head == null) {
            System.out.println("No nodes present");
            return;
        }
        Node next, prev = null;
        Node curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        Reverse reverse = new Reverse();
        reverse.insertNode(1);
        reverse.insertNode(2);
        reverse.insertNode(3);
        reverse.insertNode(4);
        reverse.insertNode(5);
        reverse.print();

        reverse.reverseList();
        reverse.print();


    }
}