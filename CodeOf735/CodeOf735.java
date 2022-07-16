package CodeOf735;


import java.util.Arrays;
import java.util.Stack;

public class CodeOf735 {
    /**
     * 队列
     * @param asteroids
     * @return
     */
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int n : asteroids) {
            if (n < 0) {
                if (stack.isEmpty()) {
                    stack.push(n);
                } else {
                    int p = stack.pop();
                    if (p < 0) {
                        stack.push(p);
                        stack.push(n);
                    } else {
                        if (p > n * -1) {
                            stack.push(p);
                        } else if (p < n * -1) {
                            while (true) {
                                if (stack.isEmpty()) {
                                    stack.push(n);
                                    break;
                                }
                                int lp = stack.pop();
                                if (lp < 0) {
                                    stack.push(lp);
                                    stack.push(n);
                                    break;
                                } else if (lp > n * -1) {
                                    stack.push(lp);
                                    break;
                                } else if (lp == n * -1) {
                                    break;
                                }
                            }
                        }
                    }
                }
            } else {
                stack.push(n);
            }
        }
        int[] r = new int[stack.size()];
        int i = stack.size() - 1;
        while (!stack.isEmpty()) {
            r[i] = stack.pop();
            i --;
        }
        return r;
    }

    public static void main(String[] args) {
        int[] r = {-2,2,1,-2};
        CodeOf735 codeOf735 = new CodeOf735();
        int[] result = codeOf735.asteroidCollision(r);
        System.out.println(Arrays.toString(result));
    }
}
