package CodeOf648;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodeOf648 {

    public String replaceWords(List<String> dictionary, String sentence) {
        //先做成字典
        Map<String, Integer> dictionaryMap = new HashMap<>();
        for (String s : dictionary) {
            dictionaryMap.put(s, 1);
        }
        int n = sentence.length();
        boolean continueTo = false;
        StringBuilder r = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch = sentence.charAt(i);
            if (ch == ' ') {
                continueTo = false;
                //遇到空格插入
                sb.append(" ");
                r.append(sb.toString());
                sb = new StringBuilder();
                continue;
            } else if (continueTo) {
                continue;
            }
            sb.append(ch);
            String t = sb.toString();
            if (dictionaryMap.containsKey(t)) {
                continueTo = true;
            }
        }
        if (sb.length() > 0) {
            r.append(sb);
        }
        return r.toString();
    }

    public static void main(String[] args) {
        CodeOf648 codeOf648 = new CodeOf648();
        List<String> dictionary = new ArrayList<>();
        dictionary.add("a");
        dictionary.add("b");
        dictionary.add("c");
        String sentence = "aadsfasf absbs bbab cadsfafs okcckkckckcck";
        System.out.println(codeOf648.replaceWords(dictionary, sentence));
    }

}
