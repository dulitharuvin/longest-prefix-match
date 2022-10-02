package com.truecaller.prefixmatch.trie;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            current = current.getChildren().computeIfAbsent(ch, key -> new TrieNode());
        }
        current.setEndOfWord(true);
    }

    public String containsPrefix(String prefix) {
        TrieNode current = root;
        StringBuilder prefixToBuild = new StringBuilder();

        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            TrieNode node = current.getChildren().get(ch);
            if (node == null) {
                if (current.isEndOfWord())
                    return prefixToBuild.toString();
                else return null;
            }
            current = node;
            prefixToBuild.append(ch);
        }
        return current.isEndOfWord() ? prefixToBuild.toString() : null;
    }

    public boolean isEmpty() {
        return root.getChildren().isEmpty();
    }
}
