package SwordOfferTwoCode029;

/**
 * @author linsvert
 * leetcode 每日一题 【剑指 Offer II 029.排序的循环链表】
 * @url https://leetcode.cn/problems/4ueAj6/
 * @tag 模拟题
 */
public class CodeOf029 {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            head = new Node(insertVal);
            head.next = head;
            return head;
        }
        Node temp = head;
        Node insert = new Node(insertVal);
        while (true) {
            if (insertVal >= temp.val && insertVal <= temp.next.val || temp.val > temp.next.val && (insertVal < temp.next.val || insertVal > temp.val) || head == temp.next) {
                Node next = temp.next;
                temp.next = insert;
                temp.next.next = next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }
}

class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
