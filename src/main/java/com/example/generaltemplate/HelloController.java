package com.example.generaltemplate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.util.HashMap;

public class HelloController {
    @FXML
    public TextField v1TxtInput1, v2TxtInput1;
    @FXML
    public TextField v1TxtInput11, v1TxtInput111, v1TxtInput1111;
    @FXML
    public TextField v1TxtInput2, v2TxtInput2, v1TxtInput21, v2TxtInput21, v3TxtInput21, v1TxtInput211, v2TxtInput211;
    @FXML
    public TextField v1TxtInput3, v2TxtInput3, v1TxtInput31, v2TxtInput31, v1TxtInput311, v1TxtInput3111;
    @FXML
    public TextField v1TxtInput4, v2TxtInput4, v3TxtInput4;
    @FXML
    public TextField v1TxtInput41, v2TxtInput41, v3TxtInput41;
    @FXML
    public TextField v1TxtInput411, v2TxtInput411, v3TxtInput411;
    @FXML
    public TextField v1TxtInput4111, v2TxtInput4111, v3TxtInput4111, v4TxtInput4111;
    @FXML
    public TextField v1TxtInput5, v2TxtInput5, v1TxtInput51, v2TxtInput51, v1TxtInput511, v2TxtInput511;
    @FXML
    private TextArea resultArea, getAllWordsThatContainAPhraseInAStringResultArea;
    private Driver driver;
    private final HashMap<String, TextField> methodTextFields = new HashMap<>();

    @FXML
    public void initialize() {
        driver = new Driver(resultArea, methodTextFields);
        methodTextFields.put("v1TxtInput1", v1TxtInput1);
        methodTextFields.put("v2TxtInput1", v2TxtInput1);
        methodTextFields.put("v1TxtInput11", v1TxtInput11);
        methodTextFields.put("v1TxtInput111", v1TxtInput111);
        methodTextFields.put("v1TxtInput1111", v1TxtInput1111);
        methodTextFields.put("v1TxtInput2", v1TxtInput2);
        methodTextFields.put("v2TxtInput2", v2TxtInput2);
        methodTextFields.put("v1TxtInput21", v1TxtInput21);
        methodTextFields.put("v2TxtInput21", v2TxtInput21);
        methodTextFields.put("v1TxtInput211", v1TxtInput211);
        methodTextFields.put("v2TxtInput211", v2TxtInput211);
        methodTextFields.put("v1TxtInput3", v1TxtInput3);
        methodTextFields.put("v2TxtInput3", v2TxtInput3);
        methodTextFields.put("v1TxtInput31", v1TxtInput31);
        methodTextFields.put("v2TxtInput31", v2TxtInput31);
        methodTextFields.put("v1TxtInput311", v1TxtInput311);
        methodTextFields.put("v1TxtInput3111", v1TxtInput3111);
        methodTextFields.put("v1TxtInput4", v1TxtInput4);
        methodTextFields.put("v2TxtInput4", v2TxtInput4);
        methodTextFields.put("v3TxtInput4", v3TxtInput4);
        methodTextFields.put("v3TxtInput21", v3TxtInput21);
        methodTextFields.put("v1TxtInput41", v1TxtInput41);
        methodTextFields.put("v2TxtInput41", v2TxtInput41);
        methodTextFields.put("v3TxtInput41", v3TxtInput41);
        methodTextFields.put("v1TxtInput411", v1TxtInput411);
        methodTextFields.put("v2TxtInput411", v2TxtInput411);
        methodTextFields.put("v3TxtInput411", v3TxtInput411);
        methodTextFields.put("v1TxtInput4111", v1TxtInput4111);
        methodTextFields.put("v2TxtInput4111", v2TxtInput4111);
        methodTextFields.put("v3TxtInput4111", v3TxtInput4111);
        methodTextFields.put("v4TxtInput4111", v4TxtInput4111);
        methodTextFields.put("v1TxtInput5", v1TxtInput5);
        methodTextFields.put("v2TxtInput5", v2TxtInput5);
        methodTextFields.put("v1TxtInput51", v1TxtInput51);
        methodTextFields.put("v2TxtInput51", v2TxtInput51);
        methodTextFields.put("v1TxtInput511", v1TxtInput511);
        methodTextFields.put("v2TxtInput511", v2TxtInput511);
    }

    private void handleAnySingleMethodBtnClick(String oneNumMathMethods, String twoNumMathMethods, String cypherMethods, String diceSimulatorMethods, String wordArraySearchMethods) throws IOException {
        driver.run(false, oneNumMathMethods, twoNumMathMethods, cypherMethods, diceSimulatorMethods, wordArraySearchMethods);
    }


    @FXML
    public void onTestEverythingBtnClick(ActionEvent event) throws IOException {
        driver.run(true,"1111","111","1111","1111","111");
    }


    public void handleTestAllOneNumMathClick(ActionEvent actionEvent) throws IOException {
        driver.run(true,"1111","000","0000","0000","000");
    }
    public void onMultiplesOfNumClick(ActionEvent actionEvent) throws IOException {
        handleAnySingleMethodBtnClick("1000","000","0000","0000","000");
    }
    public void onNumIsEvenOrOddClick(ActionEvent actionEvent) throws IOException {
        handleAnySingleMethodBtnClick("0100","000","0000","0000","000");
    }
    public void onFactorialOfNumClick(ActionEvent actionEvent) throws IOException {
        handleAnySingleMethodBtnClick("0010","000","0000","0000","000");
    }
    public void onPrimeFactorizationOfNumClick(ActionEvent actionEvent) throws IOException {
        handleAnySingleMethodBtnClick("0001","000","0000","0000","000");
    }


    public void handleTestAllTwoNumMathClick(ActionEvent actionEvent) throws IOException {
        driver.run(true,"0000","111","0000","0000","000");
    }
    public void onGetIfAIsDivisibleByBClick(ActionEvent actionEvent) throws IOException {
        handleAnySingleMethodBtnClick("0000","100","0000","0000","000");
    }
    public void onDivideClick(ActionEvent actionEvent) throws IOException {
        handleAnySingleMethodBtnClick("0000","010","0000","0000","000");
    }
    public void onGetGCFClick(ActionEvent actionEvent) throws IOException {
        handleAnySingleMethodBtnClick("0000","001","0000","0000","000");
    }


    public void handleTestAllCypherClick(ActionEvent actionEvent) throws IOException {
        driver.run(true,"0000","000","1111","0000","000");
    }
    public void onEncodeCaesarCypherClick(ActionEvent actionEvent) throws IOException {
        handleAnySingleMethodBtnClick("0000","000","1000","0000","000");
    }
    public void onDecodeCaesarCypherClick(ActionEvent actionEvent) throws IOException {
        handleAnySingleMethodBtnClick("0000","000","0100","0000","000");
    }
    public void onEncodeAtBashCypherClick(ActionEvent actionEvent) throws IOException {
        handleAnySingleMethodBtnClick("0000","000","0010","0000","000");
    }
    public void onDecodeAtBashCypherClick(ActionEvent actionEvent) throws IOException {
        handleAnySingleMethodBtnClick("0000","000","0001","0000","000");
    }


    public void handleTestAllDiceSimulatorClick(ActionEvent actionEvent) throws IOException {
        driver.run(true,"0000","000","0000","1111","000");
    }
    public void onRollClick(ActionEvent actionEvent) throws IOException {
        handleAnySingleMethodBtnClick("0000","000","0000","1000","000");
    }
    public void onMinMaxAndAvgClick(ActionEvent actionEvent) throws IOException {
        handleAnySingleMethodBtnClick("0000","000","0000","0100","000");
    }
    public void onHowManyOfEachSumClick(ActionEvent actionEvent) throws IOException {
        handleAnySingleMethodBtnClick("0000","000","0000","0010","000");
    }
    public void onWeightedRollClick(ActionEvent actionEvent) throws IOException {
        handleAnySingleMethodBtnClick("0000","000","0000","0001","000");
    }


    public void handleTestAllWordArraySearchClick(ActionEvent actionEvent) throws IOException {
        driver.run(true,"0000","000","0000","0000","111");
    }
    public void onCheckIfWordIsInStringClick(ActionEvent actionEvent) throws IOException {
        handleAnySingleMethodBtnClick("0000","000","0000","0000","100");
    }
    public void onGetIndexOfWordInStringClick(ActionEvent actionEvent) throws IOException {
        handleAnySingleMethodBtnClick("0000","000","0000","0000","010");
    }
    public void onGetAllWordsThatContainAPhraseInAStringClick(ActionEvent actionEvent) throws IOException {
        handleAnySingleMethodBtnClick("0000","000","0000","0000","001");
    }

    public void handleOnGetAllWordsThatContainAPhraseInAStringTextFieldChanged(KeyEvent inputMethodEvent) {
        WordArraySearch wordArraySearch = new WordArraySearch();
        if (v1TxtInput511.getText() != null && !v1TxtInput511.getText().equals("") && !v2TxtInput511.getText().equals("") && v2TxtInput511.getText() != null) {
            String methodResult = wordArraySearch.getAllWordsThatContainAPhraseInAString(v1TxtInput511.getText(), v2TxtInput511.getText());
            getAllWordsThatContainAPhraseInAStringResultArea.setText(methodResult);
        } else {
            getAllWordsThatContainAPhraseInAStringResultArea.setText("");
        }
    }
}