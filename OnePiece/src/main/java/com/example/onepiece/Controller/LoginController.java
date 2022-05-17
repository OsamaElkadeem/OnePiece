package com.example.onepiece.Controller;

import com.example.onepiece.AppMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.IOException;

public class LoginController {

    @FXML
    private Label label;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    void ActionOnLoginButton(ActionEvent event) throws IOException {
        checkLogin();
    }

    @FXML
    void keyPressed(KeyEvent event) throws IOException {
        switch (event.getCode()) {
            case ENTER:
                checkLogin();
                break;

        }
    }


    private void checkLogin() throws IOException {
        AppMain m = new AppMain();
        if ((username.getText().toString().equals("Admin") && password.getText().toString().equals("12345")) ||
            (username.getText().toString().equals("User") && password.getText().toString().equals("1234"))){
           m.changeScene ("HomePage.fxml");
        }
        else if (username.getText().isEmpty() && password.getText().isEmpty()){
            label.setText("Please Enter Your Data");
        }
        else {
            label.setText("Wrong Username Or Password");
        }
    }

}
