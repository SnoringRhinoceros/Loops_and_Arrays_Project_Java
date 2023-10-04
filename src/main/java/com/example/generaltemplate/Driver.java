package com.example.generaltemplate;

import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Driver {
    private TextArea resultTextArea;
    private String v1;
    private String v2;
    private String v3;
    private OneNumMath oneNumMath = new OneNumMath();
    private TwoNumMath twoNumMath = new TwoNumMath();
    private Cypher cypher = new Cypher();
    private DiceSimulator diceSimulator = new DiceSimulator();
    private WordArraySearch wordArraySearch = new WordArraySearch();

    public Driver(TextArea resultTextArea) {
        this.resultTextArea = resultTextArea;
    }

    public void run(String oneNumMathMethods, String twoNumMathMethods, String cypherMethods, String diceSimulatorMethods,String wordArraySearchMethods) {
        if (String.valueOf(oneNumMathMethods.charAt(0)).equals("1")) {
            showResult(oneNumMath.multiplesOfNum(v1));
        }
        if (String.valueOf(oneNumMathMethods.charAt(1)).equals("1")) {
            showResult(oneNumMath.numIsEvenOrOdd(v1));
        }
        if (String.valueOf(oneNumMathMethods.charAt(2)).equals("1")) {
            showResult(oneNumMath.factorialOfNum(v1));
        }
        if (String.valueOf(oneNumMathMethods.charAt(3)).equals("1")) {
            showResult(oneNumMath.primeFactorizationOfNum(v1));
        }

        if (String.valueOf(twoNumMathMethods.charAt(0)).equals("1")) {
            showResult(twoNumMath.getIfAIsDivisibleByB(v1, v2));
        }
        if (String.valueOf(twoNumMathMethods.charAt(1)).equals("1")) {
            showResult(twoNumMath.divideInDecimals(v1, v2));
        }
        if (String.valueOf(twoNumMathMethods.charAt(2)).equals("1")) {
            showResult(twoNumMath.divideInReducedImproperFractions(v1, v2));
        }
        if (String.valueOf(twoNumMathMethods.charAt(3)).equals("1")) {
            showResult(twoNumMath.divideInReducedProperFractions(v1, v2));
        }
        if (String.valueOf(twoNumMathMethods.charAt(4)).equals("1")) {
            showResult(twoNumMath.getGCF(v1, v2));
        }

        if (String.valueOf(cypherMethods.charAt(0)).equals("1")) {
            showResult(cypher.encodeCaesarCypher(v1));
        }
        if (String.valueOf(cypherMethods.charAt(1)).equals("1")) {
            showResult(cypher.decodeCaesarCypher(v1));
        }
        if (String.valueOf(cypherMethods.charAt(2)).equals("1")) {
            showResult(cypher.encodeAtBashCypher(v1));
        }
        if (String.valueOf(cypherMethods.charAt(3)).equals("1")) {
            showResult(cypher.decodeAtBashCypher(v1));
        }

        if (String.valueOf(diceSimulatorMethods.charAt(0)).equals("1")) {
            showResult(diceSimulator.roll(v1));
        }
        if (String.valueOf(diceSimulatorMethods.charAt(1)).equals("1")) {
            showResult(diceSimulator.roll(v1, v2));
        }
        if (String.valueOf(diceSimulatorMethods.charAt(2)).equals("1")) {
            showResult(diceSimulator.max(v1, v2));
        }
        if (String.valueOf(diceSimulatorMethods.charAt(3)).equals("1")) {
            showResult(diceSimulator.min(v1, v2));
        }
        if (String.valueOf(diceSimulatorMethods.charAt(4)).equals("1")) {
            showResult(diceSimulator.average(v1, v2));
        }
        if (String.valueOf(diceSimulatorMethods.charAt(5)).equals("1")) {
            showResult(diceSimulator.totalCombinationsOfSumWithGivenDice(v1, v2));
        }

        if (String.valueOf(wordArraySearchMethods.charAt(0)).equals("1")) {
            showResult(wordArraySearch.checkIfWordIsInString(v1, v2));
        }
        if (String.valueOf(wordArraySearchMethods.charAt(1)).equals("1")) {
            showResult(wordArraySearch.getIndexOfWordInString(v1, v2));
        }
        if (String.valueOf(wordArraySearchMethods.charAt(2)).equals("1")) {
            showResult(wordArraySearch.getAllWordsThatContainAWordInAString(v1, v2));
        }
    }

    private void showResult(String result) {
        resultTextArea.appendText(result);
    }

    public void setV1(String v1) {
        this.v1 = v1;
    }

    public void setV2(String v2) {
        this.v2 = v2;
    }

    public void setV3(String v3) {
        this.v3 = v3;
    }
}
