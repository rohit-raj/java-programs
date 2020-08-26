package ds.linkedlist;

class SinglyLinkedList {
    Node head;

    static class Node{
        int data;
        Node next;
        Node(int item){
            data = item;
            next = null;
        }
    }

    void insertAtStart(int item){
        Node n = new Node(item);
        n.next = head;
        head = n;
    }

    void insertAtLast(int item){
        Node n = new Node(item);
        if(head == null){
            head = n;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = n;
    }

    void insertAtPosition(int item, int pos){
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

    void print(){
        Node n = head;
        while (n != null){
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    void deleteFirstNode(){
        head = head.next;
    }

    void deleteLastNode(){
        Node curr = head;
        Node prev = curr;
        while (curr != null){
            if(curr.next == null){
                curr = null;
                prev.next = null;
                return;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
    }

    void deleteAtPosition(int pos){
        if(pos <= 0){
            System.out.println("Cannot delete : index less than 1");
            return;
        }
        if(pos == 1){
            head = head.next;
            return;
        }
        int count = 0;
        Node curr = head;
        Node prev = curr;
        while (curr != null){
            count++;
            if(pos == count){
                prev.next = curr.next;
                return;
            } else{
                prev = curr;
                curr = curr.next;
            }
        }
        if(pos > count){
            System.out.println("Cannot delete: index is greater than the list length");
        }
    }

    void deleteByValue(int value) {
        boolean headElement = true;
        Node curr = head;
        Node prev = curr;

        while(curr != null) {
            if(curr.data == value) {
                if(headElement) {
                    head = head.next;
                    curr = head;
                    prev = curr;
                } else {
                    prev.next = curr.next;
                    curr = curr.next;
                    headElement = false;
                }
            } else {
                prev = curr;
                curr = curr.next;
                headElement = false;
            }
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        linkedList.head.next = second;
        second.next = third;

        linkedList.print();
        linkedList.insertAtStart(0);
        linkedList.print();
        linkedList.insertAtLast(4);
        linkedList.print();
        linkedList.insertAtPosition(5, 1);
        linkedList.print();
        linkedList.deleteFirstNode();
        linkedList.print();
        linkedList.deleteLastNode();
        linkedList.print();
        linkedList.deleteAtPosition(1);
        linkedList.print();
        linkedList.insertAtLast(2);
        linkedList.insertAtLast(2);
        linkedList.insertAtLast(4);
        linkedList.insertAtLast(4);
        linkedList.print();
        linkedList.deleteByValue(4);
        linkedList.print();
    }
}