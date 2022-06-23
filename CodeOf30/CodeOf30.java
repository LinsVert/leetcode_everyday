package CodeOf30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author linsvert
 * leetcode 每日一题 【30.串联所有单词的子串】
 * @url https://leetcode.cn/problems/substring-with-concatenation-of-all-words/
 * @tag 哈希表 滑动窗口
 */
public class CodeOf30 {
    /**
     * 方法1 遍历所有的[i, n - m * k] 区间 m * k 长度的word
     *
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> r = new ArrayList<>();
        int n = s.length();
        int m = words.length;
        int k = words[0].length();
        //统计words频次 用来后续比较
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : words) {
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }
        //只需要到n - m * k 后续截取出来的长度不够了
        for (int i = 0; i <= n - m * k; i++) {
            //当前截取长度内s的word hash
            Map<String, Integer> subMap = new HashMap<>();
            //j 只找到 i + (m - 1) * k
            for (int j = i; j <= i + (m - 1) * k; j += k) {
                String sub = s.substring(j, j + k);
                if (!wordsMap.containsKey(sub)) {
                    break;
                }
                subMap.put(sub, subMap.getOrDefault(sub, 0) + 1);
                //最后判断 是否相等
                if (j == i + (m - 1) * k && subMap.equals(wordsMap)) {
                    r.add(i);
                }
            }
        }
        return r;
    }

    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> r = new ArrayList<>();
        int n = s.length();
        int m = words.length;
        int k = words[0].length();
        //统计words频次 用来后续比较
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : words) {
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }
        //因为每次 i自增遍历后 遇到 k * i => 等于 i 时已经遍历过了 所以最后 i 只要走 k次就好了
        //不过相对的 j的长度需要放宽 让窗口能够走到n的边界
        for (int i = 0; i < k; i++) {
            Map<String, Integer> subMap = new HashMap<>();
            for (int j = i; j <= n - k; j += k) {
                String sub = s.substring(j, j + k);
                subMap.put(sub, subMap.getOrDefault(sub, 0) + 1);
                //寻找零界点 => 当 j 到了 i + (m - 1) * k 这个位置时 说明已经到了 m  * k 窗口到最后一个节点 这个时候允许判断
                //如果 j >= i + m * k 要移除 第一个节点
                if (j >= i + m * k) {
                    String firstSub = s.substring(j - m * k, j - (m - 1) * k);
                    // < = 1时 直接移除
                    if (subMap.get(firstSub) == 1) {
                        subMap.remove(firstSub);
                    } else {
                        subMap.put(firstSub, subMap.get(firstSub) - 1);
                    }
                    if (!subMap.getOrDefault(firstSub, 0).equals(wordsMap.getOrDefault(firstSub, 0))) {
                        continue;
                    }
                }
                //如果 j 到了窗口零界点 开始判断是否相等
                if (j >= i + (m - 1) * k && subMap.get(sub).equals(wordsMap.getOrDefault(sub, 0)) && subMap.equals(wordsMap)) {
                    r.add(j - (m - 1) * k);
                }
            }
        }
        return r;
    }
}
