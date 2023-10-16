package ds.linkedlist;

public class DeleteDuplicate {
    public static Node deleteDuplicate(Node head){
        if(head == null) return null;
        Node curr = head;
        Node next = null;
        while (curr.next!=null){
            next = curr.next;
            if(next.val == curr.val){
                curr.next = next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        Node head = sll.createListFromItems(new int[]{1,2,3,3,4,5,5});
        sll.print(head);
        System.out.println("===========================");

        Node root2 = deleteDuplicate(head);
        sll.print(root2);
    }
}
