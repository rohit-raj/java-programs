package blind75;

public class ReverseLinkedList {

    Node head;

    static class Node {
        int data;
        Node next;

        Node(int item){
            data = item;
            next = null;
        }
    }

    void insertAtLast(int item){
        Node newNode = new Node(item);
        if(head == null){
            head = newNode;
            return;
        } else {
            Node curr = head;
            while (curr.next != null){
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }

    void reverse(){
        if(head.next == null){
            return;
        }

        Node curr = head;
        Node prev = null;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    void reverseUsing2Pointers(){
        if(head == null){
            return;
        }
        if(head.next == null){
            return;
        }

        Node curr = head;
        Node next = null;

        while(curr.next != null){
            next = curr.next;
            curr.next = next.next;
            next.next = head;
            head = next;
        }
    }

    public static void main(String[] args) {
        ReverseLinkedList r = new ReverseLinkedList();
        r.insertAtLast(5);
        r.insertAtLast(6);
        r.insertAtLast(7);
        r.insertAtLast(8);
        r.printLL();

        r.reverse();
        r.printLL();
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
