package com.truecaller.prefixmatch;

import com.truecaller.prefixmatch.trie.Trie;
import com.truecaller.prefixmatch.utils.FileResourcesUtils;

import java.util.List;
import java.util.Scanner;

public class TrueCallerLongestPrefixMatch {

    public static void main(String[] args) {
        String fileName = "sample_prefixes.txt";
        FileResourcesUtils fileResourcesUtil = new FileResourcesUtils();
        List<String> prefixList = fileResourcesUtil.getPrefixList(fileName);

        Trie trie = new Trie();

        if(prefixList.isEmpty()){
            System.out.println("==========================================================");
            System.out.println("|| Prefix list is empty, Existing the program.... :( !! ||");
            System.out.println("==========================================================");
            return;
        }

        prefixList.forEach(el -> {
            trie.insert(el);
        });

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a search term : ");
        String searchTerm = input.nextLine();

        String longestPrefix = trie.containsLongestMatchingPrefix(searchTerm.trim());
        if (longestPrefix != null)
            System.out.println("Longest matching prefix : " + longestPrefix);
        else
            System.out.println("No matching prefix was found on the given list for term '" + searchTerm + "'");
    }
}
