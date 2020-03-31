import java.util.HashMap;
import java.util.List;

/**
 * 244. Shortest Word Distance II -- Medium
 */

class WordDistance {
    private HashMap<String, List<Integer>> h = new HashMap<>();

    public WordDistance(String[] words) {
        for (int i = 0; i < words.length; i++) {
            List<Integer> val = h.getOrDefault(words[i], new ArrayList<>());
            val.add(i);
            h.put(words[i], val);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> l1 = h.get(word1);
        List<Integer> l2 = h.get(word2);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < l1.size(); i++) {
            for (int j = 0; j < l2.size(); j++) {
                res = Math.min(res, Math.abs(l1.get(i) - l2.get(j)));
            }
        }
        return res;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */