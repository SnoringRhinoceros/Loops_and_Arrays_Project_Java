package com.example.generaltemplate;

import java.util.ArrayList;
import java.util.List;

public class Cypher {

    private String encodeCypher(String textToEncode, String howFarToEncode, String type) {
        ArrayList<String> textToEncodeArray = new ArrayList<>(List.of(textToEncode.split("")));
        ArrayList<String> lowercaseAlphabet = new ArrayList<>(List.of("abcdefghijklmnopqrstuvwxyz".split("")));
        StringBuilder result = new StringBuilder();
        for (String character : textToEncodeArray) {
            // make char at different
            // All I'm checking is if the letter is a valid alphabet letter
            if (((int) 'A' <= (int) character.charAt(0) && (int) character.charAt(0) <= (int) 'Z') || (int) 'a' <= (int) character.charAt(0) && (int) character.charAt(0) <= (int) 'z') {
                int translatedCharacter = 0;
                if (type.equals("C")) {
                    translatedCharacter = lowercaseAlphabet.indexOf(character.toLowerCase())+Integer.parseInt(howFarToEncode);
                } else if (type.equals("A")) {
                    translatedCharacter = 26-lowercaseAlphabet.indexOf(character.toLowerCase())-1;
                }
                if (translatedCharacter < 0) {
                    translatedCharacter += translatedCharacter/26 + 26;
                }
                translatedCharacter = translatedCharacter % 26;

                // check capitalization
                if (lowercaseAlphabet.contains(character)) {
                    result.append(lowercaseAlphabet.get(translatedCharacter));
                } else {
                    result.append(lowercaseAlphabet.get(translatedCharacter).toUpperCase());
                }
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    /*
    Precondition:
    User inputs 2 strings:
    First string can be any set of ASCII characters
    Second string is an integer

    returns a new string with all the english alphabet letters in input1 shifted to the right input2 times
     */
    public String encodeCaesarCypher(String textToEncode, String howFarToEncode) {
        return encodeCypher(textToEncode, howFarToEncode, "C");
    }

    /*
    Precondition:
    User inputs 2 strings:
    First string can be any set of ASCII characters
    Second string is an integer or null

    if second input is not null:
    returns a new string with all the english alphabet letters in input1 shifted to the left input2 times
    else if second input is null:
    returns all possible unique outputs given input1 and without knowing input2
     */
    public String decodeCaesarCypher(String textToDecode, String howFarToDecode) {
        if (howFarToDecode == null) {
            return decodeCaesarCypher(textToDecode);
        }
        return encodeCypher(textToDecode, String.valueOf(Integer.parseInt(howFarToDecode)*-1), "C");
    }

    private String decodeCaesarCypher(String textToDecode) {
        StringBuilder allCyphers = new StringBuilder();
        for (int howFarToDecode=0; howFarToDecode<26; howFarToDecode++) {
            if (howFarToDecode != 0) {
                allCyphers.append("\n");
            }
            allCyphers.append(encodeCypher(textToDecode, String.valueOf(howFarToDecode*-1), "C"));
        }
        return allCyphers.toString();
    }

    /*
    Precondition:
    User inputs 1 string that can contain any set of ASCII characters

    returns the at-bash cypher of that string
     */
    public String encodeAtBashCypher(String textToEncode) {
        return encodeCypher(textToEncode, "0","A");
    }

    /*
    Precondition:
    User inputs 1 string that can contain any set of ASCII characters

    returns the decoded at-bash cypher of that string
     */
    public String decodeAtBashCypher(String textToDecode) {
        return encodeCypher(textToDecode, "0", "A");
    }
}
