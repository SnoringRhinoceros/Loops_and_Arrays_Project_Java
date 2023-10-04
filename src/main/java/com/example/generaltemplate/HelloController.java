package com.example.generaltemplate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    public TextField v1TxtInput, v2TxtInput, v3TxtInput;
    @FXML
    private Button testEverythingBtn;
    @FXML
    private TextArea resultArea;
    private final Driver driver = new Driver();

    @FXML
    public void initialize() {
        resultArea.setEditable(false);
    }

    private void handleAnySingleMethodBtnClick() {
        driver.setV1(v1TxtInput.getText());
        driver.setV2(v2TxtInput.getText());
        driver.setV3(v3TxtInput.getText());
    }
    @FXML
    public void handleTestEverythingBtnClick(ActionEvent event) {
        // Driver.run()
        System.out.println((txtInput.getText()));
    }

}