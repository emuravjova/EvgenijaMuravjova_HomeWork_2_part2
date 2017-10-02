package com.playtika.homework2;

import java.util.*;

/**
 * Created by jane on 9/30/17.
 */
public class Text {
    private final String text;

    public Text(String text) {
        if (text == null ) {
            throw new IllegalArgumentException("Text should not be null");
        }
        this.text = text;
    }

    private String[] splitByWords() {
        if (text.trim().isEmpty() || text.trim().split("[^A-Za-z0-9]+").length == 0){
            return new String[]{};
        }
        return text.trim().toLowerCase().split("[^A-Za-z0-9]+");
    }

    public int getLengthInChars() {
        return text.replaceAll("[^A-Za-z0-9]+", "").length();
    }

    public Map<String, Integer> getWordFrequencies() {
        Map<String, Integer> wordFrequencies = new HashMap<String, Integer>();
        for (String word : Arrays.asList(splitByWords())) {
            if (wordFrequencies.containsKey(word)) {
                wordFrequencies.put(word, wordFrequencies.get(word)+1);
            }
            else {
                wordFrequencies.put(word, 1);
            }
        }
        return wordFrequencies;
    }

    public List<String> getTopWords(int n) {
        if (n <= 0){throw new IllegalArgumentException("Incorrect parameter");}
        TreeSet<String> sortedWords = new TreeSet<String>(Arrays.asList(splitByWords()));
        List<String> listOfsortedWords = new ArrayList<String>(sortedWords);
        return listOfsortedWords.subList(0,Math.min(n,listOfsortedWords.size()));
    }

}
