package algoProblemSolutions.trie;

import java.util.HashMap;

class MapSum {

    class TrieNode {
        char charVal;
        boolean eOW;
        int value;
        HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    }

    TrieNode root = new TrieNode();
    HashMap<String, Integer> storedVals = new HashMap<String, Integer>();

    /** Initialize your data structure here. */
    public MapSum() {
        root.value = 0;
    }

    public void insert(String key, int val) {
        if (!storedVals.containsKey(key)) {
            insertNew(key, val);
        } else {
            updateExisting(key, storedVals.get(key), val);
        }
        storedVals.put(key, val);
    }


    private void updateExisting(String key, int oldVal, int newVal) {
        TrieNode curr = root;
        int i = 0;
        while (i < key.length()) {
            char c = key.charAt(i);
            TrieNode ltr = curr.children.get(c);
            ltr.value -= oldVal;
            ltr.value += newVal;
            curr = ltr;
            i++;
        }
    }

    private void insertNew(String key, int val) {
        TrieNode curr = root;
        int i = 0;
        while (i < key.length()) {
            char c = key.charAt(i);
            TrieNode ltr;
            if (curr.children.get(c) == null) {
                ltr = new TrieNode();
                ltr.charVal = c;
                ltr.value = val;
                curr.children.put(c, ltr);
            } else {
                ltr = curr.children.get(c);
                ltr.value += val;
            }
            curr = ltr;
            i++;
        }
    }

    public int sum(String prefix) {
        TrieNode curr = root;
        int i = 0;
        int val = curr.value;
        while (i < prefix.length()) {
            char c = prefix.charAt(i);
            if (curr.children.get(c) != null) {
                TrieNode child = curr.children.get(c);
                val = child.value;
                curr = child;
            } else {
                val = 0;
                break;
            }
            i++;
        }
        return val;
    }
}
