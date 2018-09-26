public class Queue {
    int front, rear, size;
    int capacity;
    int arr[];

    public Queue(int capacity){
        this.capacity = capacity;
        front = this.size = 0;
        rear = capacity - 1;
        arr = new int[this.capacity];
    }

    boolean isFull(Queue queue){
        return (queue.size == queue.capacity);
    }

    boolean isEmpty(Queue queue){
        return (queue.size == 0);
    }

    void enQueue(int x){
        if(isFull(this)){
            return;
        }
        this.rear = (this.rear + 1)%this.capacity;
        this.arr[this.rear] = x;
        this.size = this.size + 1;
        System.out.println(x + " enqueued to queue");
    }

    int deQueue(){
        if(isEmpty(this))
            return Integer.MIN_VALUE;
        int x = this.arr[this.front];
        this.front = (this.front + 1)%this.capacity;
        this.size = this.size - 1;
        return x;
    }

    void print(){
        for(int i = 0; i < this.size; i++){
            System.out.println(this.arr[i]);
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue(6);
        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(30);
        queue.enQueue(40);
        queue.enQueue(50);
        queue.enQueue(60);

        queue.print();

        System.out.println(queue.deQueue() + " dequeued from queue\n");

        queue.print();
    }
}