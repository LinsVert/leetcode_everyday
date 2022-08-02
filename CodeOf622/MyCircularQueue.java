package CodeOf622;

public class MyCircularQueue {
     static class Node {
        int val;
        Node next;

        Node(int val){
            this.val = val;
        }
    }
    Node front;
    Node rear;
    int max;
    int now;

    public MyCircularQueue(int k) {
        this.max = k;
    }

    public boolean enQueue(int value) {
        if (now + 1 > max) {
            return false;
        }
        Node t = new Node(value);
        if (now == 0) {
            t.next = t;
            front = t;
        } else {
            rear.next = t;
            t.next = front;
        }
        rear = t;
        now ++;
        return true;
    }

    public boolean deQueue() {
        if (now == 0) {
            return false;
        }
        front = front.next;
        rear.next = front;
        if (now == 1) {
            front = null;
            rear = null;
        }
        now --;
        return true;
    }

    public int Front() {
        if (front == null) {
            return  -1;
        }
        return front.val;
    }

    public int Rear() {
        if (rear == null) {
            return -1;
        }
        return rear.val;
    }

    public boolean isEmpty() {
        return now == 0;
    }

    public boolean isFull() {
        return now == max;
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(6);
        System.out.println(myCircularQueue.enQueue(6));
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.Front());
        System.out.println(myCircularQueue.isEmpty());
    }
}
