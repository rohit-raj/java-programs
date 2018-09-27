package ds.linkedlist;

class Length {
    Node head;

    static class Node{
        int data;
        Node next;
        Node(int item){
            data = item;
            next = null;
        }
    }

    void insertNode(int item){
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

    void print(){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    int calculateLength(){
        Node curr = head;
        int count = 0;
        while(curr != null){
            count++;
            curr = curr.next;
        }
        return count;
    }

    public static void main(String[] args) {
        Length length = new Length();
        length.insertNode(1);
        length.insertNode(2);
        length.insertNode(3);
        length.insertNode(4);
        length.insertNode(5);
        length.print();

        System.out.println("length of Linked list = " +length.calculateLength());
    }
}