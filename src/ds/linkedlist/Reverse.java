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
     * reverse the linked list 3 iterators,
     * Initialize three pointers prev as NULL, curr as head and next as NULL
     * Iterate trough the linked list. In loop, do following.
     * *** Before changing next of current,
     * *** store next node
     * *** next = curr->next
     *
     * *** Now change next of current
     * *** This is where actual reversing happens
     * *** curr->next = prev
     *
     * *** Move prev and curr one step forward
     * *** prev = curr
     * *** curr = next
     *
     * *** finally point the head to prev
     * @return null
     */
    void reverseListIteratively() {
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

    /**
     * 1) Divide the list in two parts - first node and rest of the linked list.
     * 2) Call reverse for the rest of the linked list.
     * 3) Link rest to first.
     * 4) Fix head pointer
     * @param curr
     * @param prev
     */

    void reverseListRecursively(Node curr, Node prev){
        if(curr.next == null){
            head = curr;
            curr.next = prev;
            return;
        }

        Node next = curr.next;
        curr.next = prev;

        reverseListRecursively(next, curr);
    }

    void reverseListCaller(){
        if (head == null) {
            System.out.println("No nodes present");
            return;
        }
        Node prev = null;
        Node curr = head;

        reverseListRecursively(curr, prev);
    }

    void reverseUsing2Pointers(){
        if (head == null) {
            System.out.println("No nodes present");
            return;
        }

        Node curr = head;
        Node next = null;

        while(curr.next != null){
            next= curr.next;
            curr.next = next.next;
            next.next = head;
            head = next;
        }
    }
    public static void main(String[] args) {
        Reverse reverse = new Reverse();
        reverse.insertNode(1);
        reverse.insertNode(2);
        reverse.insertNode(3);
        reverse.insertNode(4);
        reverse.insertNode(5);
        System.out.print("Original List : ");
        reverse.print();

        reverse.reverseListIteratively();
        reverse.print();

        reverse.reverseListCaller();
        reverse.print();

        reverse.reverseUsing2Pointers();
        reverse.print();

    }
}