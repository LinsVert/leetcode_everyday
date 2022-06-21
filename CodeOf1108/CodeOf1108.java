package CodeOf1108;

/**
 * @author linsvert
 * leetcode 每日一题 【1108.IP地址无效化】
 * @url https://leetcode.cn/problems/defanging-an-ip-address/
 * @tag 简单模拟题
 */
public class CodeOf1108 {
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        int len = address.length();
        int index = 0;
        while(index < len) {
            char c = address.charAt(index);
            if (c == '.') {
                sb.append('[');
            }
            sb.append(c);
            if (c == '.') {
                sb.append(']');
            }
            index ++;
        }
        return sb.toString();
    }
}
