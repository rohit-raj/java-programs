package blind75;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class DeleteFromLastLinkedList {

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
        Node node = new Node(item);
        if(head == null){
            head = node;
            return;
        }

        Node curr = head;
        Node prev = null;
        while (curr.next != null){
            curr = curr.next;
        }
        curr.next = node;
    }

    int lengthOfList(){
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

    void deleteAtPos(int pos){
        if (pos <= 0){
            System.out.println("incorrect position");
            return;
        }
        if(pos ==1){
            head = head.next;
            return;
        }

        if(head == null){
            System.out.println("No item in list");
            return;
        }


        if(head.next == null){
            head = null;
            return;
        }

        int count = 0;
        Node curr = head;
        Node prev = null;

        while (curr.next != null){
            count++;
            if(count == pos){
                break;
            }
            prev = curr;
            curr = curr.next;
        }

        prev.next =curr.next;
    }

    void deleteAtPosFromLast(int pos){
        int length = lengthOfList();

        int posFromStart = length-pos+1;

        deleteAtPos(posFromStart);
    }

    public static void main(String[] args) {
        DeleteFromLastLinkedList d = new DeleteFromLastLinkedList();

        d.insertAtLast(1);
        d.insertAtLast(2);
        d.insertAtLast(3);
        d.insertAtLast(4);
        d.insertAtLast(5);

        d.printLL();

        System.out.println(d.lengthOfList());
        d.deleteAtPosFromLast(1);
        d.printLL();
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
