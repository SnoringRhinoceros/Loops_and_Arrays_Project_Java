package com.example.generaltemplate;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.HashMap;
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
    private HashMap<String, TextField> methodTextFields;

    public Driver(TextArea resultTextArea, HashMap<String, TextField> methodTextFields) {
        this.resultTextArea = resultTextArea;
        this.methodTextFields = methodTextFields;
    }

    private void setInputs(int moduleNum, int methodNum, int howMany) {
        clearV();
        for (int inputNum = 1; inputNum <= howMany; inputNum++) {
            StringBuilder textFieldToGrabFromName = new StringBuilder();
            textFieldToGrabFromName.append("v").append(inputNum).append("TxtInput").append(moduleNum);
            textFieldToGrabFromName.append("1".repeat(Math.max(0, methodNum)));
            System.out.println(textFieldToGrabFromName);
            setV(inputNum, methodTextFields.get(textFieldToGrabFromName.toString()).getText());
        }
    }

    public void run(boolean runTestInputs, String oneNumMathMethods, String twoNumMathMethods, String cypherMethods, String diceSimulatorMethods, String wordArraySearchMethods) throws IOException {
        if (String.valueOf(oneNumMathMethods.charAt(0)).equals("1")) {
            Supplier<String> multiplesOfNumRef = () -> oneNumMath.multiplesOfNum(v1, v2);
            runMethod(runTestInputs,1, 0, multiplesOfNumRef, 2);
        }
        if (String.valueOf(oneNumMathMethods.charAt(1)).equals("1")) {
            Supplier<String> numIsEvenOrOddRef = () -> oneNumMath.numIsEvenOrOdd(v1);
            runMethod(runTestInputs,1, 1, numIsEvenOrOddRef, 1);
        }
        if (String.valueOf(oneNumMathMethods.charAt(2)).equals("1")) {
            Supplier<String> factorialOfNumRef = () -> oneNumMath.factorialOfNum(v1);
            runMethod(runTestInputs,1, 2, factorialOfNumRef, 1);
        }
        if (String.valueOf(oneNumMathMethods.charAt(3)).equals("1")) {
            Supplier<String> primeFactorizationOfNumRef = () -> oneNumMath.primeFactorizationOfNum(v1);
            runMethod(runTestInputs,1, 3, primeFactorizationOfNumRef,1);
        }

        if (String.valueOf(twoNumMathMethods.charAt(0)).equals("1")) {
            Supplier<String> getIfAIsDivisibleByBRef = () -> twoNumMath.getIfAIsDivisibleByB(v1, v2);
            runMethod(runTestInputs,2, 0, getIfAIsDivisibleByBRef, 2);
        }
        if (String.valueOf(twoNumMathMethods.charAt(1)).equals("1")) {
            Supplier<String> divideRef = () -> twoNumMath.divide(v1, v2, v3);
            runMethod(runTestInputs,2, 1, divideRef, 3);
        }
        if (String.valueOf(twoNumMathMethods.charAt(2)).equals("1")) {
            Supplier<String> getGCFRef = () -> twoNumMath.getGCF(v1, v2);
            runMethod(runTestInputs,2, 2, getGCFRef, 2);
        }

        if (String.valueOf(cypherMethods.charAt(0)).equals("1")) {
            Supplier<String> encodeCaesarCypherRef = () -> cypher.encodeCaesarCypher(v1, v2);
            runMethod(runTestInputs,3, 0, encodeCaesarCypherRef, 2);
        }
        if (String.valueOf(cypherMethods.charAt(1)).equals("1")) {
            Supplier<String> decodeCaesarCypherRef = () -> cypher.decodeCaesarCypher(v1, v2);
            runMethod(runTestInputs,3, 1, decodeCaesarCypherRef, 2);
        }
        if (String.valueOf(cypherMethods.charAt(2)).equals("1")) {
            Supplier<String> encodeAtBashCypherRef = () -> cypher.encodeAtBashCypher(v1);
            runMethod(runTestInputs,3, 2, encodeAtBashCypherRef, 1);
        }
        if (String.valueOf(cypherMethods.charAt(3)).equals("1")) {
            Supplier<String> decodeAtBashCypherRef = () -> cypher.decodeAtBashCypher(v1);
            runMethod(runTestInputs,3, 3, decodeAtBashCypherRef, 1);
        }

        if (String.valueOf(diceSimulatorMethods.charAt(0)).equals("1")) {
            Supplier<String> rollRef = () -> diceSimulator.roll(v1, v2, v3);
            runMethod(runTestInputs,4, 0, rollRef,3);
        }
        if (String.valueOf(diceSimulatorMethods.charAt(1)).equals("1")) {
            Supplier<String> rollRef = () -> diceSimulator.minMaxAndAvg(v1, v2, v3);
            runMethod(runTestInputs,4, 1, rollRef, 3);
        }
        if (String.valueOf(diceSimulatorMethods.charAt(2)).equals("1")) {
            Supplier<String> maxRef = () -> diceSimulator.howManyOfEachSum(v1, v2, v3);
            runMethod(runTestInputs,4, 2, maxRef, 3);
        }
        if (String.valueOf(diceSimulatorMethods.charAt(3)).equals("1")) {
            Supplier<String> minRef = () -> diceSimulator.weightedRoll(v1, v2, v3, v4);
            runMethod(runTestInputs,4, 3, minRef, 4);
        }

        if (String.valueOf(wordArraySearchMethods.charAt(0)).equals("1")) {
            Supplier<String> checkIfWordIsInStringRef = () -> wordArraySearch.checkIfWordIsInString(v1, v2);
            runMethod(runTestInputs,5, 0, checkIfWordIsInStringRef, 2);
        }
        if (String.valueOf(wordArraySearchMethods.charAt(1)).equals("1")) {
            Supplier<String> getIndexOfWordInStringRef = () -> wordArraySearch.getIndexOfWordInString(v1, v2);
            runMethod(runTestInputs,5, 1, getIndexOfWordInStringRef, 2);
        }
        if (String.valueOf(wordArraySearchMethods.charAt(2)).equals("1")) {
            Supplier<String> getAllWordsThatContainAPhraseInAStringRef = () -> wordArraySearch.getAllWordsThatContainAPhraseInAString(v1, v2);
            runMethod(runTestInputs,5, 2, getAllWordsThatContainAPhraseInAStringRef, 2);
        }
    }

    private void runMethod(boolean runTestInputs, int moduleNum, int methodNum, Supplier<String> method, int paramNum) throws IOException {
        if (runTestInputs) {
            String correspondingLetter = String.valueOf((char)(methodNum + 1 + 64)).toLowerCase();
            int currentFileNum = 0;
            while (nextInputFileExists(moduleNum, correspondingLetter, currentFileNum)) {
                currentFileNum++;
                setInput(moduleNum, correspondingLetter, currentFileNum);
                showResult(method.get(), getExpectedResult(moduleNum, correspondingLetter, currentFileNum));
            }
        } else {
            setInputs(moduleNum, methodNum, paramNum);
            showResult(method.get());
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
        showInputAndOutput(result);
        resultTextArea.appendText("\nExpected Result:\n");
        resultTextArea.appendText(expectedResult);
        resultTextArea.appendText("\n\n");
    }

    private void showResult(String result) {
        showInputAndOutput(result);
    }

    private void showInputAndOutput(String result) {
        resultTextArea.appendText("\n\nInput:\n");
        if (v1 != null && !v1.equals("")) {
            resultTextArea.appendText(v1);
        }
        if (v2 != null && !v2.equals("")) {
            resultTextArea.appendText("," + v2);
        }
        if (v3 != null && !v3.equals("")) {
            resultTextArea.appendText("," + v3);
        }
        if (v4 != null && !v4.equals("")) {
            resultTextArea.appendText("," + v4);
        }
        resultTextArea.appendText("\n");
        resultTextArea.appendText("Output:\n");
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
