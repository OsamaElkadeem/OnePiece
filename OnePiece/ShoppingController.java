/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.onepiece;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.IOException;

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
    void ActionOnResetButton(ActionEvent event) {

    }
    @FXML
    void ActionOnCheckoutButton(ActionEvent event) throws IOException {
        AppMain m = new AppMain();
        m.changeScene("Checkout.fxml");

    }
}


