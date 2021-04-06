package tree;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    TrieNode head = new TrieNode(false);

    /** Initialize your data structure here. */
    public Trie() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = head;
        int len = word.length();
        for(int i =0; i< len; i++) {
            char c = word.charAt(i);
            if( i == len -1 ) {
                node = node.putNext(c, true);
            } else {
                node = node.putNext(c, false);
            }
        }

        //System.out.println(head);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = head;
        int len = word.length();
        for(int i =0; i< len; i++) {
            char c = word.charAt(i);
            if( !node.hasNext(c) ) {
                return false;
            }

            node = node.getNext(c);
        }

        return node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = head;
        int len = prefix.length();
        for(int i =0; i< len; i++) {
            char c = prefix.charAt(i);
            if( !node.hasNext(c) ) {
                return false;
            }

            node = node.getNext(c);
        }

        return true;
    }
}

class TrieNode {
    Map<Character, TrieNode> next = new HashMap<>();
    boolean isEnd;

    public TrieNode(boolean isEnd) {
        this.isEnd = isEnd;
    }

    public boolean hasNext(Character c) {
        return next.containsKey(c);
    }


    public TrieNode getNext(Character c) {
        return next.get(c);
    }

    public TrieNode putNext(Character c, boolean isEnd) {
        //System.out.printf("Putting %c %b\n", c, isEnd);
        if( hasNext(c) ) {
            TrieNode node = next.get(c);
            if(isEnd) {
                node.isEnd = isEnd;
            }
            return node;
        }

        TrieNode node = new TrieNode(isEnd);
        next.put(c, node);
        return node;
    }

    public String toString() {
        String str = "";
        for(Character key: next.keySet()) {
            TrieNode node = next.get(key);
            str += String.valueOf(key);
            if( node.isEnd ) {
                str += ".";
            }
            str += "->" + next.get(key).toString();
        }
        str += "\n";
        return str;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */