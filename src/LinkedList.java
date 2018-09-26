class LinkedList {
    Node head;

    static class Node{
        int data;
        Node next;
        Node(int item){
            data = item;
            next = null;
        }
    }

    void print(){
        Node n = head;
        while (n != null){
            System.out.println(n.data + " ");
            n = n.next;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        linkedList.head.next = second;
        second.next = third;

        linkedList.print();
    }
}