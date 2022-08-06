package CodeOf1408;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author linsvert
 * leetcode 每日一题 【1408.数组中的字符匹配】
 * @url https://leetcode.cn/problems/string-matching-in-an-array/
 * @tag
 */
class Solution {

    /**
     * 暴力解
     * @param words
     * @return
     */
    public List<String> stringMatching2(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Set<String> r = new HashSet<>();
        for (int i = 0;i < words.length - 1;i++) {
            int a = words[i].length();
            for (int j = i + 1;j < words.length;j++) {
                int b = words[j].length();
                if (a == b) {
                    continue;
                }
                if (words[j].contains(words[i])) {
                    r.add(words[i]);
                }
            }
        }
        return new ArrayList<>(r);
    }

    /**
     * 想一下有没有更高效的
     * @param words
     * @return
     */
    public List<String> stringMatching(String[] words) {
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        var r = solution.stringMatching(new String[]{"dyk","rgdykdu","e","fjrgdykduf","nbtuep","mxrgdykdul","hxwang","omxrgdykdula","zhfkwzfbjzvpfeh","bfjrgdykdufl","cupitoye","rbzhfkwzfbjzvpfehrc","empelypoealbb","nvnbtuepar","bzmqfbzssvpj","qfcupitoye","mvvvekjw","qfcupitoyenb","evwttioleugq","mdykb","vfdhehqjenr","qfcupitoyenba","rknmkxrbreftew","dddyk","uykehqi","ldmdykbx","aey","wmbzmqfbzssvpj","qnas","rknmkxrbreftewu","ifyhwhpktbiixb","vaeyxx","ltnfyituk","juykehqiso","kj","ulmxrgdykduldq","kkpnhivvrlptukt","mjuykehqisoma"});

        System.out.println(r);
    }
}
