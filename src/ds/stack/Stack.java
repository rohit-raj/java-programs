package ds.stack;

public class Stack {
    static final int MAX = 1000;
    int top;
    int [] a = new int[MAX];

    boolean isEmpty(){
        return (top < 0);
    }
    Stack(){
        top = -1;
    }

    boolean push(int x){
        if(top > (MAX -1)){
            System.out.println("stack overflow");
            return false;
        } else {
            a[++top] = x;
            System.out.println("Element pushed");
            return true;
        }
    }

    int pop(){
        if(top < 0){
            System.out.println("No element in stack");
            return 0;
        } else {
//            int y = a[top--];
            return a[top--];
        }
    }

    void print(){
        for(int i = 0; i < top+1; i++){
            System.out.println(a[i]);
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        s.push(60);

        s.print();
        System.out.println(s.pop() + " Element popped");

        s.print();
    }
}