/**
 * 211. Add and Search Word - Data structure design -- Medium
 */

class WordDictionary {

    private class Node {
        public char c;
        public boolean end = false;
        public Node[] next = new Node[26];
        Node(char c) {
            this.c = c;
        }
    }

    private Node root = new Node('#');

    /** Initialize your data structure here. */
    public WordDictionary() {
    
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node x = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (x.next[c - 'a'] == null) {
                x.next[c - 'a'] = new Node(c);
            }
            x = x.next[c - 'a'];
        }
        x.end = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(root, word);
    }

    private boolean search(Node root, String word) {
        if (root == null) return false;
        Node x = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c != '.') {
                x = x.next[c - 'a'];
                if (x == null) return false;
            } else {
                for (int j = 0; j < 26; j++) {
                    if (x.next[j] != null && search(x.next[j], word.substring(i + 1))) return true;
                }
                return false;
            }
        }
        return x.end;
    }

    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");
        System.out.println(obj.search("pad"));
        System.out.println(obj.search("bad"));
        System.out.println(obj.search(".ad"));
        System.out.println(obj.search("b.."));
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */