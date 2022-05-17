package com.example.onepiece.Controller;

import com.example.onepiece.AppMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.ArrayList;


public class CheckOutController extends AppMain{

    @FXML
    private Label aldiTotal;

    @FXML
    private Button homeButton;

    @FXML
    private Button logoutButton;

    @FXML
    private Button removeItem;

    @FXML
    private Label sparTotal;

    @FXML
    private Label tescoTotal;

    
    @FXML
    private ListView<String> checkoutList;

    ArrayList<String> cart = new ArrayList<>();

    ShopController shop = new ShopController();

    public ArrayList<String> getCart() {
        return cart;
    }

    public void setCart(ArrayList<String> cart) {
        this.cart = shop.getCartItems();

    }



    @FXML
    void ActionOnAldiTotal(MouseEvent event) {

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
    void ActionOnRemoveItemButton(ActionEvent event) {

    }

    @FXML
    void ActionOnSparTotal(MouseEvent event) {

    }

    @FXML
    void ActionOnTescoTotal(MouseEvent event) {

    }



    @FXML
    void OnActionCheckoutList(ActionEvent event) {
            checkoutList.getItems().addAll(cart);
    }



    @FXML
    public void ActionOnDarkModeButton(ActionEvent actionEvent) {
    }
}
