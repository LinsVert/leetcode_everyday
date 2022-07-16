package CodeOf745;

import java.util.*;

class WordFilter {

    Map<String, List<Integer>> recordL;
    Map<String, List<Integer>> recordR;

    public WordFilter(String[] words) {
        recordL = new HashMap<>();
        recordR = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < word.length(); j++) {
                sb.append(word.charAt(j));
                String s = sb.toString();
                recordL.computeIfAbsent(s, key -> new ArrayList<>());
                recordL.get(s).add(i);
            }
            sb = new StringBuilder();
            for (int j = word.length() - 1; j >= 0; j--) {
                sb.append(word.charAt(j));
                String s = sb.toString();
                recordR.computeIfAbsent(s, key -> new ArrayList<>());
                recordR.get(s).add(i);
            }

        }
    }


    public int f(String pref, String suff) {
        String suffNew = new StringBuilder(suff).reverse().toString();
        if (recordL.containsKey(pref) && recordR.containsKey(suffNew)) {
            List<Integer> l = recordL.get(pref);
            List<Integer> r = recordR.get(suffNew);
            int i = l.size() - 1;
            int j = r.size() - 1;
            while (i >=0 && j >=0 && !l.get(i).equals(r.get(j))) {
                if (l.get(i) > r.get(j)) {
                    i --;
                } else if (l.get(i) < r.get(j)) {
                    j--;
                }
            }
            if (l.get(i).equals(r.get(j))) {
                return l.get(i);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] words = {"cccccccc"};
        WordFilter wordFilter = new WordFilter(words);
        System.out.println(wordFilter.f("cc", "c"));
        System.out.println(wordFilter.recordL);
        System.out.println(wordFilter.recordR);

    }
}