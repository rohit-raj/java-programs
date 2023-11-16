package algo.misc;

public class MyCalendar {
    public class Node {
        int start, end;
        Node left, right;
        public Node(int _start, int _end){
            start = _start;
            end = _end;
            left = right = null;
        }
    }

    Node root;
    public MyCalendar() {
        root = null;
    }

    public boolean book(int start, int end) {
        if(root == null){
            root = new Node(start, end);
            return true;
        }

        return insert(root, start, end);
    }

    public boolean insert(Node root, int start, int end){
        if(root.start >= end){
            if(root.left == null){
                root.left = new Node(start, end);
                return true;
            } else {
                return insert(root.left, start, end);
            }
        } else if(root.end <= start){
            if(root.right == null){
                root.right = new Node(start, end);
                return true;
            } else {
                return insert(root.right, start, end);
            }
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10, 20)); // return True
        System.out.println(myCalendar.book(15, 25)); // return False, It can not be booked because time 15 is already booked by another event.
        System.out.println(myCalendar.book(20, 30)); // return True, The event can be booked, as the first event takes every time less than 20, but not including 20.
    }
}
