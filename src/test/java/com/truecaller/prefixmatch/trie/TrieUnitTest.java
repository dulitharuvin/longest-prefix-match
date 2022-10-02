package com.truecaller.prefixmatch.trie;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrieUnitTest {

    @Test
    public void whenEmptyTrie_thenNoElements() {
        Trie trie = new Trie();

        assertTrue(trie.isEmpty());
    }

    @Test
    public void givenATrie_whenAddingElements_thenTrieNotEmpty() {
        Trie trie = createExampleTrie();

        assertFalse(trie.isEmpty());
    }

    private Trie createExampleTrie() {
        Trie trie = new Trie();

        trie.insert("True");
        trie.insert("trueCal");
        trie.insert("caller");
        trie.insert("truecaller");
        trie.insert("Test");
        trie.insert("Sweden");
        trie.insert("8AuSk7J");
        trie.insert("XfhdOK");
        trie.insert("KAWeqD");
        trie.insert("KAWeq7");

        return trie;
    }
}
