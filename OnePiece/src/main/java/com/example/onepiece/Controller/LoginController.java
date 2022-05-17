<<<<<<<< HEAD:OnePiece/OnePiece/src/main/java/com/example/onepiece/LoginController.java
<<<<<<< Updated upstream
package com.example.onepiece;

=======
package com.example.onepiece.Controller;

import com.example.onepiece.AppMain;
>>>>>>> Stashed changes
========
package com.example.onepiece.Controller;

import com.example.onepiece.AppMain;
>>>>>>>> Database:OnePiece/src/main/java/com/example/onepiece/Controller/LoginController.java
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
<<<<<<<< HEAD:OnePiece/OnePiece/src/main/java/com/example/onepiece/LoginController.java
<<<<<<< Updated upstream
=======
import javafx.scene.input.KeyEvent;
>>>>>>> Stashed changes
========
import javafx.scene.input.KeyEvent;
>>>>>>>> Database:OnePiece/src/main/java/com/example/onepiece/Controller/LoginController.java

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

<<<<<<<< HEAD:OnePiece/OnePiece/src/main/java/com/example/onepiece/LoginController.java
<<<<<<< Updated upstream
    private void checkLogin() throws IOException {
        AppMain m = new AppMain();
        if ((username.getText().toString().equals("Admin") && password.getText().toString().equals("12345")) ||
            (username.getText().toString().equals("User") && password.getText().toString().equals("1234"))){
=======
    @FXML
    void keyPressed(KeyEvent event) throws IOException {
        switch (event.getCode()) {
            case ENTER: checkLogin(); break;
        }
    }

    private void checkLogin() throws IOException {
        AppMain m = new AppMain();
========
    @FXML
    void keyPressed(KeyEvent event) throws IOException {
        switch (event.getCode()) {
            case ENTER: checkLogin(); break;
        }
    }

    private void checkLogin() throws IOException {
        AppMain m = new AppMain();
>>>>>>>> Database:OnePiece/src/main/java/com/example/onepiece/Controller/LoginController.java
        if ((username.getText().equals("admin") && password.getText().equals("admin"))){
            m.changeScene ("HomePageAdmin.fxml");
        }
        else if ((username.getText().equals("osama.elkadeem@gmail.com") && password.getText().equals("elkadeem12"))){
<<<<<<<< HEAD:OnePiece/OnePiece/src/main/java/com/example/onepiece/LoginController.java
>>>>>>> Stashed changes
========
>>>>>>>> Database:OnePiece/src/main/java/com/example/onepiece/Controller/LoginController.java
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
