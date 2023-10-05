package com.example.generaltemplate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class HelloController {
    @FXML
    public TextField v1TxtInput, v2TxtInput, v3TxtInput, v4TxtInput;
    @FXML
    private Button testEverythingBtn;
    @FXML
    private TextArea resultArea;
    private final Driver driver = new Driver(resultArea);

    @FXML
    public void initialize() {
        resultArea.setEditable(false);
    }

    private void handleAnySingleMethodBtnClick() {
        driver.setV1(v1TxtInput.getText());
        driver.setV2(v2TxtInput.getText());
        driver.setV3(v3TxtInput.getText());
        driver.setV4(v4TxtInput.getText());
    }
    @FXML
    public void handleTestEverythingBtnClick(ActionEvent event) throws IOException {
        driver.run("100000","000000","000000","000000","000000");
    }
}