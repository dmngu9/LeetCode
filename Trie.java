class TrieNode {
    // Initialize your data structure here.
    char character;
    boolean isComplete = false;
    HashMap<Character, TrieNode> children = new HashMap<>();
    
    public TrieNode() {}
    
    public TrieNode(char c) {
        character = c;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word == "")
            return;
        TrieNode cursor = root;
        for (char c : word.toCharArray()) {
            if (cursor.children.containsKey(c)) {
                cursor = cursor.children.get(c);
            } else {
                TrieNode newNode = new TrieNode(c);
                cursor.children.put(c, newNode);
                cursor = newNode;
            }
        }
        cursor.isComplete = true;
        return;
    }
    
    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word == "")
            return false;
        TrieNode cursor = root;
        for (char c : word.toCharArray()) {
            if (cursor.children.containsKey(c)) 
                cursor = cursor.children.get(c);
            else return false;
        }
        if (!cursor.isComplete)
            return false;
        return true;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix == "")
            return false;
        TrieNode cursor = root;
        for (char c : prefix.toCharArray()) {
            if (cursor.children.containsKey(c)) 
                cursor = cursor.children.get(c);
            else return false;
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");