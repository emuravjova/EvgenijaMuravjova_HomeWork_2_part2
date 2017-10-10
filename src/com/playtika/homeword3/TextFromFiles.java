package com.playtika.homeword3;

import com.playtika.homework2.Text;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.Map;

/**
 * Created by jane on 10/3/17.
 */
public class TextFromFiles {

    public static void main(String[] args) {

        Path myDir = Paths.get("test");

        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(myDir)) {

            for (Path filePath : dirStream) {

                BasicFileAttributes attr = Files.readAttributes(filePath, BasicFileAttributes.class);
                System.out.println(String.valueOf(filePath));
                System.out.println("creationTime = " + attr.creationTime());
                System.out.println("size         = " + attr.size());
                StringBuilder linesFromFile = new StringBuilder();
                try {
                    List<String> lines = Files.readAllLines(filePath);
                    for(String line: lines){
                        linesFromFile.append(line).append(" ");
                    }
                }
                catch (IOException e) {e.printStackTrace();}
                String text = linesFromFile.toString();
                Map<String,Integer> wordFrequencies = new Text(text).getWordFrequencies();
                int aggregatedFrequency = 0;
                for (int frequency : wordFrequencies.values()) {
                    aggregatedFrequency = aggregatedFrequency + frequency;
                }
                System.out.println("Aggregated word frequency is: " + aggregatedFrequency);
            }

        }
        catch (IOException e) {e.printStackTrace();}

    }

}



