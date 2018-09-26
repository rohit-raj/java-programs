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
        Node curr = head;
        while(curr != null){
            if(curr.next == null){
                curr.next = new Node(item);
                return;
            } else
                curr = curr.next;
        }

    }

    void insertAtPosition(int item, int pos){
        Node curr = head;
        int count = 1;
        while (curr != null){
            count++;
            if(pos == count){
                Node n = new Node(item);
                n.next = curr.next;
                curr.next = n;
                return;
            } else {
                curr = curr.next;
            }
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

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        linkedList.head.next = second;
        second.next = third;

        linkedList.insertAtStart(0);
        linkedList.print();
        linkedList.insertAtLast(4);
        linkedList.print();
        linkedList.insertAtPosition(5, 3);
        linkedList.print();
    }
}