package com.example.onepiece;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ShoppingController {
    @FXML
    private Button homeButton;
    @FXML
    private Button logoutButton;
    @FXML
    private Button searchButton;
    @FXML
    private Button addItemButton;
    @FXML
    private Button ResetButton;
    @FXML
    private Button CheckoutButton;

    public ShoppingController() {
    }

    @FXML
    void ActionOnHomeButton(ActionEvent event) throws IOException {
        AppMain m = new AppMain();
        m.changeScene("HomePage.fxml");
    }

    @FXML
    void ActionOnLogoutButton(ActionEvent event) throws IOException {
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
    void ActionOnResetButton(ActionEvent event) {
    }

    @FXML
    void ActionOnCheckoutButton(ActionEvent event) throws IOException {
        AppMain m = new AppMain();
        m.changeScene("Checkout.fxml");
    }
}
