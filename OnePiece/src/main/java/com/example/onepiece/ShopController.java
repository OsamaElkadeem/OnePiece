/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.onepiece;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ShopController{

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
    private Button CheckOutButton;
    @FXML
    private TextField itemName;
    @FXML
    private ListView<String> itemList;

    Connection c = ConnectDatabase.connect();
    ResultSet rs;
    Statement stmt;
    
    public ArrayList<String> selectedItems = new ArrayList<>();
    
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
        try {
            String searchName = itemName.getText();
            String query;
            stmt = c.createStatement();
            ArrayList<String> items = new ArrayList<>();
            itemList.getItems().clear();
            if (!searchName.equals("")) {
                query = String.format("SELECT items.item_id, items.name as item_name, category, price, shops.name as shop_name FROM items JOIN prices ON items.item_id = prices.item_id JOIN shops ON prices.shop_id = shops.shop_id WHERE items.name = '%s';", searchName);
            } else {
                query = "SELECT items.item_id, items.name as item_name, category, price, shops.name as shop_name FROM items JOIN prices ON items.item_id = prices.item_id JOIN shops ON prices.shop_id = shops.shop_id";
            }
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("item_id");
                String item = rs.getString("item_name");
                String category = rs.getString("category");
                float price = rs.getInt("price");
                String shop = rs.getString("shop_name");
                System.out.println("id: " + id + "\tname: " + item + "\tcategory: " + category + "\tprice: " + price + "\tshop: " + shop);
                items.add("id: " + id + "\tname: " + item + "\tcategory: " + category + "\tprice: " + price + "\tshop: " + shop);
            }
            itemList.getItems().addAll(items);
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void ActionOnAddItemButton(ActionEvent event) {
        String selectedItem = itemList.getSelectionModel().getSelectedItem();
        selectedItems.add(selectedItem);
        System.out.println(selectedItem);
    }

    @FXML
    void ActionOnRemoveItemButton(ActionEvent event) {
        String selectedItem = itemList.getSelectionModel().getSelectedItem();
        selectedItems.remove(selectedItem);
    }

    @FXML
    void ActionOnCheckOutButton(ActionEvent event) throws IOException {
        AppMain m = new AppMain();
        m.changeScene("CheckOut.fxml");

    }
}
