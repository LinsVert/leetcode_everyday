package CodeOf641;

/**
 * @author linsvert
 * leetcode 每日一题 【641.设计循环双端队列】
 * @url https://leetcode.cn/problems/design-circular-deque/
 * @tag 
 */
public class MyCircularDeque {
    int[] queue;
    int head = 0;
    int end = 0;
    int k;
    int cnt = 0;

    public MyCircularDeque(int _k) {
        this.queue = new int[_k];
        k = _k;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        head = (head + k - 1) % k;
        queue[head] = value;
        cnt++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        //原index 进行操作后更新
        queue[end] = value;
        end = (end + 1) % k;
        cnt++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        head = (head + k + 1) % k;
        cnt --;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        end = (end + k - 1) % k;
        cnt --;
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : queue[head];
    }

    public int getRear() {
        return isEmpty() ? -1 : queue[(end + k - 1) % k];
    }

    public boolean isEmpty() {
        return cnt == 0;
    }

    public boolean isFull() {
        return cnt == k;
    }

}
