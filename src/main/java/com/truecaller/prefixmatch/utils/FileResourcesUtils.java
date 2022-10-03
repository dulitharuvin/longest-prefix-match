package com.truecaller.prefixmatch.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class FileResourcesUtils {

    public ArrayList<String> getPrefixList(String fileName) {

        ArrayList<String> listOfPrefixes = new ArrayList<>();
        try {
            InputStream fileInputStream = this.getFileFromResourceAsStream(fileName);

            InputStreamReader streamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(streamReader);
            String line;
            while ((line = reader.readLine()) != null) {
                listOfPrefixes.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        return listOfPrefixes;
    }

    private InputStream getFileFromResourceAsStream(String fileName) {

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new IllegalArgumentException("File not found! " + fileName);
        } else {
            return inputStream;
        }
    }

}
