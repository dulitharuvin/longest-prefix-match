package com.truecaller.prefixmatch.util;

import java.util.ArrayList;
import java.util.Arrays;

import com.truecaller.prefixmatch.trie.Trie;
import com.truecaller.prefixmatch.utils.FileResourcesUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FileResourcesUtilsUnitTest {

    static FileResourcesUtils fileResourcesUtil;
    static ArrayList<String> preLoadedList;

    @BeforeAll
    public static void init() {
        fileResourcesUtil = new FileResourcesUtils();
        preLoadedList = new ArrayList<String>(
                Arrays.asList("2y3fKTS", "4VdwEEXC8", "AWMa4vvOf", "xyiuoXZV", "KAWeqI",
                        "XfhdW", "8dLfGZU0T", "LgXK8iwln", "oDyiYa", "2y3fKTa"));
    }

    @Test
    public void readsATextFile_AndReturnsAnArrayListType() {
        String fileName = "sample_prefixes_test.txt";
        assertEquals(ArrayList.class, fileResourcesUtil.getPrefixList(fileName).getClass());
    }

    @Test
    public void readsATextFile_AndReturnsAnEmptyArrayListWhenTextFileIsEmpty() {
        String emptyfileName = "sample_prefixes_empty_file_test.txt";
        assertTrue(fileResourcesUtil.getPrefixList(emptyfileName).isEmpty());
    }

    @Test
    public  void readsATextFile_AndReturnsAnArrayListWithStringElements(){
        String fileName = "sample_prefixes_test.txt";
        assertEquals(preLoadedList, fileResourcesUtil.getPrefixList(fileName));
    }

    @Test
    public void trysToReadATextFile_AndReturnsAnEmptyArrayListWhileHandlingTheException(){
        String nonExistFileName = "non_existent_file_test.txt";
        ArrayList<String> emptyArrayList = new ArrayList<>();
        assertEquals(emptyArrayList, fileResourcesUtil.getPrefixList(nonExistFileName));
    }

    @AfterAll
    public static void tearDown() {
        fileResourcesUtil = null;
    }
}
