package com.example.onepiece.Controller;

import com.example.onepiece.AppMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
<<<<<<< Updated upstream
import javafx.scene.input.KeyCode;
=======
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
            case ENTER:
                checkLogin();
                break;

        }
    }


=======
            case ENTER: checkLogin(); break;
        }
    }

>>>>>>> Stashed changes
    private void checkLogin() throws IOException {
        AppMain m = new AppMain();
        if ((username.getText().equals("admin") && password.getText().equals("admin"))){
            m.changeScene ("HomePageAdmin.fxml");
        }
        else if ((username.getText().equals("osama.elkadeem@gmail.com") && password.getText().equals("elkadeem12"))){
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
