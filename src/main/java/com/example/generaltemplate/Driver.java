package com.example.generaltemplate;

import javafx.scene.control.TextArea;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Driver {
    private TextArea resultTextArea;
    private String v1;
    private String v2;
    private String v3;
    private String v4;
    private OneNumMath oneNumMath = new OneNumMath();
    private TwoNumMath twoNumMath = new TwoNumMath();
    private Cypher cypher = new Cypher();
    private DiceSimulator diceSimulator = new DiceSimulator();
    private WordArraySearch wordArraySearch = new WordArraySearch();

    public Driver(TextArea resultTextArea) {
        this.resultTextArea = resultTextArea;
    }

    public void run(String oneNumMathMethods, String twoNumMathMethods, String cypherMethods, String diceSimulatorMethods,String wordArraySearchMethods) throws IOException {
        if (String.valueOf(oneNumMathMethods.charAt(0)).equals("1")) {
            setInputs(1, 0);
            showResult(oneNumMath.multiplesOfNum(v1, v2));
        }
        if (String.valueOf(oneNumMathMethods.charAt(1)).equals("1")) {
            setInputs(1, 1);
            showResult(oneNumMath.numIsEvenOrOdd(v1));
        }
        if (String.valueOf(oneNumMathMethods.charAt(2)).equals("1")) {
            setInputs(1, 2);
            showResult(oneNumMath.factorialOfNum(v1));
        }
        if (String.valueOf(oneNumMathMethods.charAt(3)).equals("1")) {
            setInputs(1, 3);
            showResult(oneNumMath.primeFactorizationOfNum(v1));
        }

        if (String.valueOf(twoNumMathMethods.charAt(0)).equals("1")) {
            setInputs(2, 0);
            showResult(twoNumMath.getIfAIsDivisibleByB(v1, v2));
        }
        if (String.valueOf(twoNumMathMethods.charAt(1)).equals("1")) {
            setInputs(2, 1);
            showResult(twoNumMath.divideInDecimals(v1, v2));
        }
        if (String.valueOf(twoNumMathMethods.charAt(2)).equals("1")) {
            setInputs(2, 2);
            showResult(twoNumMath.divideInReducedImproperFractions(v1, v2));
        }
        if (String.valueOf(twoNumMathMethods.charAt(3)).equals("1")) {
            setInputs(2, 3);
            showResult(twoNumMath.divideInReducedProperFractions(v1, v2));
        }
        if (String.valueOf(twoNumMathMethods.charAt(4)).equals("1")) {
            setInputs(2, 4);
            showResult(twoNumMath.getGCF(v1, v2));
        }

        if (String.valueOf(cypherMethods.charAt(0)).equals("1")) {
            setInputs(3, 0);
            showResult(cypher.encodeCaesarCypher(v1));
        }
        if (String.valueOf(cypherMethods.charAt(1)).equals("1")) {
            setInputs(3, 1);
            showResult(cypher.decodeCaesarCypher(v1));
        }
        if (String.valueOf(cypherMethods.charAt(2)).equals("1")) {
            setInputs(3, 2);
            showResult(cypher.encodeAtBashCypher(v1));
        }
        if (String.valueOf(cypherMethods.charAt(3)).equals("1")) {
            setInputs(3, 3);
            showResult(cypher.decodeAtBashCypher(v1));
        }

        if (String.valueOf(diceSimulatorMethods.charAt(0)).equals("1")) {
            setInputs(4, 0);
            showResult(diceSimulator.roll(v1));
        }
        if (String.valueOf(diceSimulatorMethods.charAt(1)).equals("1")) {
            setInputs(4, 1);
            showResult(diceSimulator.roll(v1, v2));
        }
        if (String.valueOf(diceSimulatorMethods.charAt(2)).equals("1")) {
            setInputs(4, 2);
            showResult(diceSimulator.max(v1, v2));
        }
        if (String.valueOf(diceSimulatorMethods.charAt(3)).equals("1")) {
            setInputs(4, 3);
            showResult(diceSimulator.min(v1, v2));
        }
        if (String.valueOf(diceSimulatorMethods.charAt(4)).equals("1")) {
            setInputs(4, 4);
            showResult(diceSimulator.average(v1, v2));
        }
        if (String.valueOf(diceSimulatorMethods.charAt(5)).equals("1")) {
            setInputs(4, 5);
            showResult(diceSimulator.totalCombinationsOfSumWithGivenDice(v1, v2));
        }

        if (String.valueOf(wordArraySearchMethods.charAt(0)).equals("1")) {
            setInputs(5, 0);
            showResult(wordArraySearch.checkIfWordIsInString(v1, v2));
        }
        if (String.valueOf(wordArraySearchMethods.charAt(1)).equals("1")) {
            setInputs(5, 1);
            showResult(wordArraySearch.getIndexOfWordInString(v1, v2));
        }
        if (String.valueOf(wordArraySearchMethods.charAt(2)).equals("1")) {
            setInputs(5, 2);
            showResult(wordArraySearch.getAllWordsThatContainAWordInAString(v1, v2));
        }
    }

    private void setInputs(int moduleNum, int methodNum) throws IOException {
        String correspondingLetter = String.valueOf((char)(methodNum + 1 + 64)).toLowerCase();
        boolean thereAreMoreInputFiles = true;
        int currentFileNum = 1;
        while (thereAreMoreInputFiles) {
            BufferedReader bufferReader = new BufferedReader(new FileReader("src/main/java/com/example/generaltemplate/Test_Cases/" + moduleNum + "/" + correspondingLetter + "/input" + currentFileNum + ".txt"));
            setV(currentFileNum, bufferReader.readLine());
            currentFileNum++;
            File tempFile = new File("./" + moduleNum + "/ " + correspondingLetter + "input" + currentFileNum + ".txt");
            if (!(tempFile.exists() && !tempFile.isDirectory())) {
                thereAreMoreInputFiles = false;
            }
        }
    }

    private void setV(String inputs, String whatToSetTo) {
        String[] inputArray = inputs.split(",", 4);
        

    }

    private void setV(int num, String whatToSetTo) {
        if (num == 1) {
            setV1(whatToSetTo);
        } else if (num==2) {
            setV2(whatToSetTo);
        } else if (num == 3) {
            setV3(whatToSetTo);
        } else if (num == 4) {
            setV4(whatToSetTo);
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

    public void setV4(String v4) {
        this.v4 = v4;
    }
}
