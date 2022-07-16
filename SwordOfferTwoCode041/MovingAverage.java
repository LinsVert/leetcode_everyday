package SwordOfferTwoCode041;


import java.util.*;

/**
 * 队列
 */
public class MovingAverage {
    int size;
    int[] record = new int[10001];
    int sum;
    int i;
    int j;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        record[i] = val;
        i++;
        sum += val;
        //超过长度了
        if (i - j > size) {
            sum -= record[j];
            j++;
        }
        return sum * 1.0 / (i - j);
    }

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println(movingAverage.next(1));
        System.out.println(movingAverage.next(10));
        System.out.println(movingAverage.next(3));
        System.out.println(movingAverage.next(5));
    }

}
