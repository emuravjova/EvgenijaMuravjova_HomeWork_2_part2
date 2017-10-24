package com.playtika.files;

import com.playtika.text.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Created by jane on 10/3/17.
 */
public class TextFromFiles {

    private static final Logger LOG = LogManager.getLogger(TextFromFiles.class);

    public static void main(String[] args) {

        Path myDir = Paths.get("src/main/resources/testFiles");

        if (Files.exists(myDir)&&(Files.isDirectory(myDir))) {
            try {
                Map<String, Long> aggregatedFrequency = Files.walk(myDir)
                        .filter(Files::isRegularFile)
                        .flatMap(TextFromFiles::getWordsFromFile)
                        .map(TextFromFiles::getWordFrequencies)
                        .flatMap(m -> m.entrySet().stream())
                        .collect(groupingBy(Map.Entry::getKey, counting()));
                LOG.info("Aggregated word frequency is: {}", aggregatedFrequency);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else LOG.warn("Directory does not exist");
    }

    private static Map<String, Long> getWordFrequencies(String line) {
        return new Text(line).getWordFrequencies();
    }

    private static Stream <String> getWordsFromFile (Path filePath){
        try {
            BasicFileAttributes attr = Files.readAttributes(filePath, BasicFileAttributes.class);
            LOG.info("File is located here: {}, creationTime = {}, size = {}", String.valueOf(filePath), attr.creationTime(), attr.size());
            return Files.lines(filePath);
        } catch (IOException e) {
            LOG.warn("some problem with file occurs, skip it");
                return Stream.of("");
            }
    }
}


