package com.truecaller.prefixmatch.trie;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrieUnitTest {

    static Trie testTrie;

    @BeforeAll
    public static void init() {
        testTrie = createExampleTrie();
    }

    @Test
    public void whenEmptyTrie_thenNoPrefixes() {
        Trie trie = new Trie();

        assertTrue(trie.isEmpty());
    }

    @Test
    public void givenATrie_whenAddingPrefixes_thenTrieNotEmpty() {
        Trie trie = createExampleTrie();

        assertFalse(trie.isEmpty());
    }

    @Test
    public void givenATrie_whenAddingPrefixes_thenTrieReturns_LongestMatchingPrefix() {
        assertEquals("true", testTrie.containsLongestMatchingPrefix("truecaller"));
        assertEquals("Swe", testTrie.containsLongestMatchingPrefix("Sweden"));
        assertEquals("KAWeq7", testTrie.containsLongestMatchingPrefix("KAWeq7TestString"));
    }

    @Test
    public void givenATrie_whenAddingPrefixes_thenTrieReturns_NullWhenNoMatchingPrefixIsFound() {
        assertEquals(null, testTrie.containsLongestMatchingPrefix("falseCaller"));
        assertEquals(null, testTrie.containsLongestMatchingPrefix("Norway"));
        assertEquals(null, testTrie.containsLongestMatchingPrefix("BcdAWeq7TestString"));
    }

    @Test
    public void givenATrie_whenAddingPrefixes_thenTrieReturns_NullWhenSearchTermIsShorterThanAnyMatchingPrefix() {

        assertEquals(null, testTrie.containsLongestMatchingPrefix("t"));
        assertEquals(null, testTrie.containsLongestMatchingPrefix("Sw"));
        assertEquals(null, testTrie.containsLongestMatchingPrefix("KAWeq"));
    }

    private static Trie createExampleTrie() {
        Trie trie = new Trie();

        trie.insert("true");
        trie.insert("tru");
        trie.insert("tr");
        trie.insert("trueCal");
        trie.insert("caller");
        trie.insert("Test");
        trie.insert("Swe");
        trie.insert("8AuSk7J");
        trie.insert("XfhdOK");
        trie.insert("KAWeqD");
        trie.insert("KAWeq7");

        return trie;
    }

    @AfterAll
    public static void tearDown() {
        testTrie = null;
    }
}
