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
    private TextField txtInput;
    @FXML
    private Button testEverythingBtn;
    @FXML
    private TextArea resultArea;

    @FXML
    public void initialize() {
        resultArea.setEditable(false);
    }
    @FXML
    public void handleTestEverythingBtnClick(ActionEvent event) {
        System.out.println((txtInput.getText()));
    }

}