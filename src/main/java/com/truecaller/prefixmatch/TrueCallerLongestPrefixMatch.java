package com.truecaller.prefixmatch;

import com.truecaller.prefixmatch.utils.FileResourcesUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TrueCallerLongestPrefixMatch {

    public static void main(String[] args) {
        String fileName = "sample_prefixes.txt";
        FileResourcesUtils fileResourcesUtil = new FileResourcesUtils();
        List<String> list = fileResourcesUtil.getPrefixList(fileName);

    }
}
