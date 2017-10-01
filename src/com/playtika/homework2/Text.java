package com.playtika.homework2;

import java.util.*;

/**
 * Created by jane on 9/30/17.
 */
public class Text {
    private String text;

    public Text(String text) {
        if (text == null || text.trim().isEmpty()  || text.trim().split("[^A-Za-z0-9]+").length == 0) {
            throw new IllegalArgumentException("Text is null, empty or has no words");
        }
        this.text = text;
    }

    String[] splitByWords() {
        return text.toLowerCase().split("[^A-Za-z0-9]+");
    }

    int getLengthInChars() {
        return text.replaceAll("[^A-Za-z0-9]+", "").length();
    }

    Map<String, Integer> getWordFrequencies() {
        Map<String, Integer> wordFrequencies = new HashMap<String, Integer>();
        List<String> wordsList = new ArrayList<String>(Arrays.asList(splitByWords()));
        for (String word : wordsList) {
            if (!wordFrequencies.containsKey(word)) {
                int frequency = Collections.frequency(wordsList, word);
                wordFrequencies.put(word, frequency);
            }
        }
        return wordFrequencies;
    }

    List<String> getTopWords(int N) {
        Set<String> words = new HashSet<String>(Arrays.asList(splitByWords()));
        List<String> wordsList = new ArrayList<String>(words);
        Collections.sort(wordsList);
        List<String> topWords = new ArrayList<String>();
        if (N > wordsList.size()) { N = wordsList.size();}
        for (int i=0; i < N; i++){
            topWords.add(wordsList.get(i));
        }
        return topWords;
    }

}
