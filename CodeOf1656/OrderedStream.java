package CodeOf1656;

import java.util.ArrayList;
import java.util.List;

/**
 * @author linsvert
 * leetcode 每日一题 【1656.设计有序流】
 * @url https://leetcode.cn/problems/design-an-ordered-stream/
 * @tag
 */
public class OrderedStream {
    String[] stream;
    int ptr = 1;
    public OrderedStream(int n) {
        this.stream = new String[n + 1];
    }

    public List<String> insert(int idKey, String value) {
        stream[idKey] = value;
        return find(idKey);
    }

    public List<String> find(int id) {
        List<String> r = new ArrayList<>();
        if (id == ptr) {
            for (int i = ptr;i < stream.length;i++) {
                if (stream[i] != null) {
                    r.add(stream[i]);
                } else {
                    this.ptr = i;
                    break;
                }
            }
        }
        return r;
    }


    public static void main(String[] args) {
        OrderedStream orderedStream = new OrderedStream(5);
        System.out.println(orderedStream.insert(3, "12345"));
        System.out.println(orderedStream.insert(2, "12345"));
        System.out.println(orderedStream.insert(1, "12345"));
        System.out.println(orderedStream.insert(5, "12345"));
        System.out.println(orderedStream.insert(4, "12345"));
    }
}
