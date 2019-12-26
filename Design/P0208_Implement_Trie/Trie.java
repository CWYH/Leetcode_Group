/**
 * 208. Implement Trie -- Medium
 * 
 * Microsoft
 */

class Trie {

    public class TrieNode {
        char c;
        boolean end;
        HashMap<Character, TrieNode> nextMap;
        TrieNode() {
            c = ' ';
            end = false;
            nextMap = new HashMap<>();
        }

        TrieNode(char cc) {
            c = cc;
            end = false;
            nextMap = new HashMap<>();
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode(' ');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0) return;

        TrieNode x = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!x.nextMap.containsKey(c)) {
                x.nextMap.put(c, new TrieNode(c));
            }
            x = x.nextMap.get(c);
        }
        x.end = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;

        TrieNode x = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!x.nextMap.containsKey(c)) return false;
            x = x.nextMap.get(c);
        }
        return x.end;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) return false;

        TrieNode x = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!x.nextMap.containsKey(c)) return false;
            x = x.nextMap.get(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */