package com.example.generaltemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordArraySearch {

    /*
    Precondition:
    User inputs 2 strings:
    First string can be any legal string
    Second string can be any legal string without spaces

    returns if the second string can be found in the first string as its own word (surrounded by spaces)
     */
    public String checkIfWordIsInString(String text, String wordToFind) {
        ArrayList<String> wordsArray= new ArrayList<>(List.of(text.split(" ")));
        for (String word: wordsArray) {
            if (word.equals(wordToFind)) {
                return "true";
            }
        }
        return "false";
    }

    public String getIndexOfWordInString(String text, String wordToFind) {
        ArrayList<String> wordsArray = new ArrayList<>(List.of(text.split(" ")));
        for (int wordInd=0; wordInd<wordsArray.size(); wordInd++) {
            if (wordsArray.get(wordInd).equals(wordToFind)) {
                return String.valueOf(getSumOfPriorWordLengths(wordsArray, wordInd)-1);
            }
        }
        return "none";
    }

    private int getSumOfPriorWordLengths(ArrayList<String> wordsArray, int endInd) {
        int sum = 0;
        for (int wordInd=0; wordInd<endInd; wordInd++) {
            // +1 is for the spaces
            sum += wordsArray.get(wordInd).length() + 1;
        }
        // no space at the end
        sum += 1;
        return sum;
    }

    public String getAllWordsThatContainAPhraseInAString(String text, String phraseToFind) {
        ArrayList<String> wordsArray = new ArrayList<>(List.of(text.split(" ")));
        ArrayList<String> result = new ArrayList<>();
        for (String word: wordsArray) {
            String wordContainingPhrase = wordWithPhrase(phraseToFind, word);
            if (!wordContainingPhrase.equals("")) {
                result.add(wordContainingPhrase);
            }
        }
        if (result.toString().equals("[]")) {
            return "none";
        }
        return result.toString();
    }

    private String wordWithPhrase(String phrase, String word) {
        ArrayList<String> letterArray = new ArrayList<>(List.of(word.split("")));
        for (int pointer1 = 0; pointer1 < letterArray.size(); pointer1++) {
            for (int pointer2 = pointer1+1; pointer2 < letterArray.size()+1; pointer2++) {
                if (word.substring(pointer1, pointer2).equals(phrase)) {
                    return word;
                }
            }
        }
        return "";
    }
}
