package com.example.onepiece.Controller;

import com.example.onepiece.AppMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class HomeControllerAdmin {
    @FXML
    private Button DarkModeButton;
    @FXML
    private Button checkoutButton;
    @FXML
    private Button listButton;
    @FXML
    private Button logoutButton;
    @FXML
    private Button shopButton;

    @FXML
    void ActionOnCheckoutButton(ActionEvent event) throws IOException {
        AppMain m = new AppMain();
        m.changeScene("CheckOut.fxml");
    }

    @FXML
    void ActionOnDarkModeButton(ActionEvent event) {

    }

    @FXML
    void ActionOnListButton(ActionEvent event) throws IOException {
        AppMain m = new AppMain();
        m.changeScene("AdminList.fxml");
    }

    @FXML
    void ActionOnShopButton(ActionEvent event) throws IOException {
        AppMain m = new AppMain();
        m.changeScene("ShoppingCart.fxml");
    }

    @FXML
    void ActionOnLogoutButton(ActionEvent event) throws IOException {
        AppMain m = new AppMain();
        m.changeScene("LoginForm.fxml");
    }

}