package com.example.onepiece;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.IOException;




public class AdminController {

    @FXML
    private Button homeButton;
    @FXML
    private Button logoutButton;
    @FXML
    private Button searchButton;
    @FXML
    private Button addItemButton;
    @FXML
    private Button removeItemButton;

    @FXML
    void ActionOnHomeButton(ActionEvent event) throws IOException {
        AppMain m = new AppMain();
        m.changeScene("HomePage.fxml");
    }
    @FXML
    void ActionOnLogoutButton(ActionEvent event) throws IOException{
        AppMain m = new AppMain();
        m.changeScene("LoginForm.fxml");

    }
    @FXML
    void ActionOnSearchButton(ActionEvent event) {

    }
    @FXML
    void ActionOnAddItemButton(ActionEvent event) {

    }
    @FXML
    void ActionOnRemoveItemButton(ActionEvent event) {

    }
}
