package com.example.generaltemplate;

import java.util.ArrayList;
import java.util.List;

public class Cypher {

    private String encodeCypher(String textToEncode, String howFarToEncode, String type) {
        ArrayList<String> textToEncodeArray = new ArrayList<>(List.of(textToEncode.split("")));
        ArrayList<String> lowercaseAlphabet = new ArrayList<>(List.of("abcdefghijklmnopqrstuvwxyz".split("")));
        StringBuilder result = new StringBuilder();
        for (String character : textToEncodeArray) {
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

    public String encodeCaesarCypher(String textToEncode, String howFarToEncode) {
        return encodeCypher(textToEncode, howFarToEncode, "C");
    }

    public String decodeCaesarCypher(String textToDecode, String howFarToDecode) {
        return encodeCypher(textToDecode, String.valueOf(Integer.parseInt(howFarToDecode)*-1), "C");
    }

    public String encodeAtBashCypher(String textToEncode) {
        return encodeCypher(textToEncode, "0","A");
    }

    public String decodeAtBashCypher(String textToDecode) {
        return encodeCypher(textToDecode, "0", "A");
    }
}
