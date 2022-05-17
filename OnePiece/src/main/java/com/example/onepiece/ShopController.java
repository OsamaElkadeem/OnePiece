/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.onepiece.Controller;


import com.example.onepiece.AppMain;
import com.example.onepiece.ConnectDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
public class ShopController {
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
            
            if(!searchName.equals("")){ 
                query = String.format("SELECT * FROM items WHERE name = '%s';", searchName);
            }
            else{
                query =  "SELECT * FROM items;";
            }
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("item_id");
                String name = rs.getString("name");
                String category = rs.getString("category");
                items.add("id: " + id + " name: " + name +" category: " + category);
            }
            itemList.getItems().addAll(items);
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void ActionOnAddItemButton(ActionEvent event) {
       /* String searchName = itemName.getText();
        String query =  "SELECT * FROM items;";
        stmt = c.createStatement();
            ArrayList<String> items = new ArrayList<>();
            itemList.getItems().clear();*/
    }

    @FXML
    void ActionOnRemoveItemButton(ActionEvent event) {

    }
    @FXML
    void ActionOnCheckOutButton(ActionEvent event) throws IOException {
        AppMain m = new AppMain();
        m.changeScene("CheckOut.fxml");

    }

}
