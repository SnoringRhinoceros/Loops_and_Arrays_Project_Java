package com.example.generaltemplate;

import java.util.ArrayList;
import java.util.List;

public class Cypher {

    private String encodeCypher(String textToEncode, String howFarToEncode, String type) {
        ArrayList<String> textToEncodeArray = new ArrayList<>(List.of(textToEncode.split("")));
        ArrayList<String> lowercaseAlphabet = new ArrayList<>(List.of("abcdefghijklmnopqrstuvwxyz".split("")));
        ArrayList<String> resultArray = new ArrayList<>();
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
                resultArray.add(lowercaseAlphabet.get(translatedCharacter));
            } else {
                resultArray.add(character);
            }
        }

        // fix capitalization
        String resultString = "";
        for (int letterInd=0; letterInd<resultArray.size(); letterInd++) {
            if (lowercaseAlphabet.contains(textToEncodeArray.get(letterInd))) {
                resultString += resultArray.get(letterInd);
            } else {
                resultString += resultArray.get(letterInd).toUpperCase();
            }
        }
        return resultString;
    }

    public String encodeCaesarCypher(String textToEncode, String howFarToEncode) {
        return encodeCypher(textToEncode, howFarToEncode, "C");
    }

    public String decodeCaesarCypher(String textToDecode, String howFarToDecode) {
        return "";
    }

    public String encodeAtBashCypher(String textToEncode) {
        return encodeCypher(textToEncode, "0","A");
    }

    public String decodeAtBashCypher(String textToDecode, String howFarToDecode) {
        return "";
    }
}
