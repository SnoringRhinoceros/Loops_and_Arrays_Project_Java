package com.example.generaltemplate;

import javafx.scene.control.TextArea;

import java.io.*;
import java.util.function.Supplier;

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
            Supplier<String> multiplesOfNumRef = () -> oneNumMath.multiplesOfNum(v1, v2);
            runMethod(1, 0, multiplesOfNumRef);
        }
        if (String.valueOf(oneNumMathMethods.charAt(1)).equals("1")) {
            Supplier<String> numIsEvenOrOddRef = () -> oneNumMath.numIsEvenOrOdd(v1);
            runMethod(1, 1, numIsEvenOrOddRef);
        }
        if (String.valueOf(oneNumMathMethods.charAt(2)).equals("1")) {
            Supplier<String> factorialOfNumRef = () -> oneNumMath.factorialOfNum(v1);
            runMethod(1, 2, factorialOfNumRef);
        }
        if (String.valueOf(oneNumMathMethods.charAt(3)).equals("1")) {
            Supplier<String> primeFactorizationOfNumRef = () -> oneNumMath.primeFactorizationOfNum(v1);
            runMethod(1, 3, primeFactorizationOfNumRef);
        }

        if (String.valueOf(twoNumMathMethods.charAt(0)).equals("1")) {
            Supplier<String> getIfAIsDivisibleByBRef = () -> twoNumMath.getIfAIsDivisibleByB(v1, v2);
            runMethod(2, 0, getIfAIsDivisibleByBRef);
        }
        if (String.valueOf(twoNumMathMethods.charAt(1)).equals("1")) {
            Supplier<String> divideRef = () -> twoNumMath.divide(v1, v2, v3);
            runMethod(2, 1, divideRef);
        }
        if (String.valueOf(twoNumMathMethods.charAt(2)).equals("1")) {
            Supplier<String> getGCFRef = () -> twoNumMath.getGCF(v1, v2);
            runMethod(2, 2, getGCFRef);
        }

        if (String.valueOf(cypherMethods.charAt(0)).equals("1")) {
            Supplier<String> encodeCaesarCypherRef = () -> cypher.encodeCaesarCypher(v1, v2);
            runMethod(3, 0, encodeCaesarCypherRef);
        }
        if (String.valueOf(cypherMethods.charAt(1)).equals("1")) {
            Supplier<String> decodeCaesarCypherRef = () -> cypher.decodeCaesarCypher(v1, v2);
            runMethod(3, 1, decodeCaesarCypherRef);
        }
        if (String.valueOf(cypherMethods.charAt(2)).equals("1")) {
            Supplier<String> encodeAtBashCypherRef = () -> cypher.encodeAtBashCypher(v1);
            runMethod(3, 2, encodeAtBashCypherRef);
        }
        if (String.valueOf(cypherMethods.charAt(3)).equals("1")) {
            Supplier<String> decodeAtBashCypherRef = () -> cypher.decodeAtBashCypher(v1);
            runMethod(3, 3, decodeAtBashCypherRef);
        }

        if (String.valueOf(diceSimulatorMethods.charAt(0)).equals("1")) {
            Supplier<String> rollRef = () -> diceSimulator.roll(v1, v2, v3);
            runMethod(4, 0, rollRef);
        }
        if (String.valueOf(diceSimulatorMethods.charAt(1)).equals("1")) {
            Supplier<String> rollRef = () -> diceSimulator.minMaxAndAvg(v1, v2, v3);
            runMethod(4, 1, rollRef);
        }
        if (String.valueOf(diceSimulatorMethods.charAt(2)).equals("1")) {
            Supplier<String> maxRef = () -> diceSimulator.howManyOfEachSum(v1, v2, v3);
            runMethod(4, 2, maxRef);
        }
        if (String.valueOf(diceSimulatorMethods.charAt(3)).equals("1")) {
            Supplier<String> minRef = () -> diceSimulator.weightedRoll(v1, v2, v3, v4);
            runMethod(4, 3, minRef);
        }

        if (String.valueOf(wordArraySearchMethods.charAt(0)).equals("1")) {
            Supplier<String> checkIfWordIsInStringRef = () -> wordArraySearch.checkIfWordIsInString(v1, v2);
            runMethod(5, 0, checkIfWordIsInStringRef);
        }
        if (String.valueOf(wordArraySearchMethods.charAt(1)).equals("1")) {
            Supplier<String> getIndexOfWordInStringRef = () -> wordArraySearch.getIndexOfWordInString(v1, v2);
            runMethod(5, 1, getIndexOfWordInStringRef);
        }
        if (String.valueOf(wordArraySearchMethods.charAt(2)).equals("1")) {
            Supplier<String> getAllWordsThatContainAWordInAStringRef = () -> wordArraySearch.getAllWordsThatContainAWordInAString(v1, v2);
            runMethod(5, 2, getAllWordsThatContainAWordInAStringRef);
        }
    }

    private void runMethod(int moduleNum, int methodNum, Supplier<String> method) throws IOException {
        String correspondingLetter = String.valueOf((char)(methodNum + 1 + 64)).toLowerCase();
        int currentFileNum = 0;
        while (nextInputFileExists(moduleNum, correspondingLetter, currentFileNum)) {
            currentFileNum++;
            setInput(moduleNum, correspondingLetter, currentFileNum);
            showResult(method.get(), getExpectedResult(moduleNum, correspondingLetter, currentFileNum));
        }
    }

    private boolean nextInputFileExists(int moduleNum, String correspondingLetter, int currentFileNum) {
        File nextInputFile = new File("src/main/java/com/example/generaltemplate/Test_Cases/" + moduleNum + "/" + correspondingLetter + "/input" + (currentFileNum+1) + ".txt");
        return (nextInputFile.exists() && !nextInputFile.isDirectory());
    }

    private void setInput(int moduleNum, String correspondingLetter, int currentFileNum) throws IOException {
        BufferedReader bufferReader = new BufferedReader(new FileReader("src/main/java/com/example/generaltemplate/Test_Cases/" + moduleNum + "/" + correspondingLetter + "/input" + currentFileNum + ".txt"));
        setV(bufferReader.readLine());
    }

    private String getExpectedResult(int moduleNum, String correspondingLetter, int currentFileNum) throws IOException {
        BufferedReader bufferReader = new BufferedReader(new FileReader("src/main/java/com/example/generaltemplate/Test_Cases/" + moduleNum + "/" + correspondingLetter + "/output" + currentFileNum + ".txt"));
        return bufferReader.readLine();
    }

    private void setV(String inputs) {
        String[] inputArray = inputs.split(",", 4);
        clearV();
        for (int varInd = 0; varInd < inputArray.length; varInd++) {
            setV(varInd+1, inputArray[varInd]);
        }
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

    private void clearV() {
        setV1(null);
        setV2(null);
        setV3(null);
        setV4(null);
    }

    private void showResult(String result, String expectedResult) {
        // Still going to have error when v's are set but not used
        resultTextArea.appendText("Input:\n");
        if (v1 != null) {
            resultTextArea.appendText(v1);
        }
        if (v2 != null) {
            resultTextArea.appendText("," + v2);
        }
        if (v3 != null) {
            resultTextArea.appendText("," + v3);
        }
        if (v4 != null) {
            resultTextArea.appendText("," + v4);
        }
        resultTextArea.appendText("\n");
        resultTextArea.appendText("Output:\n");
        resultTextArea.appendText(result);
        resultTextArea.appendText("\nExpected Result:\n");
        resultTextArea.appendText(expectedResult);
        resultTextArea.appendText("\n\n");
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
