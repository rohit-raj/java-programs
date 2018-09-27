package ds.linkedlist;

class MiddleElement {
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
     * @return
     */
    void findMiddle() {
        if (head == null){
            System.out.println("No nodes present");
            return;
        }
        Node curr_x_2 = head;
        Node curr_x_1 = head;
        while ((curr_x_2.next != null) && (curr_x_2.next.next != null)) {
            curr_x_2 = curr_x_2.next.next;
            curr_x_1 = curr_x_1.next;
        }
        System.out.println("middle of Linked list = " + curr_x_1.data);
    }

    public static void main(String[] args) {
        MiddleElement middle = new MiddleElement();
        middle.insertNode(1);
        middle.insertNode(2);
        middle.insertNode(3);
        middle.insertNode(4);
        middle.insertNode(5);
        middle.print();
        middle.findMiddle();


    }
}