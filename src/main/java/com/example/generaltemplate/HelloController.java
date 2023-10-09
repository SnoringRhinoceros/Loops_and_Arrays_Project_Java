package com.example.generaltemplate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class HelloController {
    @FXML
    public TextField v1TxtInput, v2TxtInput, v3TxtInput, v4TxtInput;
    @FXML
    private TextArea resultArea;
    private Driver driver;

    @FXML
    public void initialize() {
        resultArea.setEditable(false);
        driver = new Driver(resultArea);
    }

    private void handleAnySingleMethodBtnClick(String oneNumMathMethods, String twoNumMathMethods, String cypherMethods, String diceSimulatorMethods, String wordArraySearchMethods) throws IOException {
        driver.setV1(v1TxtInput.getText());
        driver.setV2(v2TxtInput.getText());
        driver.setV3(v3TxtInput.getText());
        driver.setV4(v4TxtInput.getText());
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
        handleAnySingleMethodBtnClick("0000","111","0000","0000","000");
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
}