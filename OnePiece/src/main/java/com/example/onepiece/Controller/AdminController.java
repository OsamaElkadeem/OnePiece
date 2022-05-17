package com.example.onepiece.Controller;

import com.example.onepiece.AppMain;
import com.example.onepiece.ConnectDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AdminController implements Initializable{

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
    private TextField itemName;
    @FXML
    private ListView<String> itemList;
    @FXML
    private TextField itemID;
    @FXML
    private TextField priceTesco;
    @FXML
    private TextField priceAldi;
    @FXML
    private TextField priceSpar;
    @FXML 
    private ChoiceBox<String> itemCategory;
    
    private String[] categories = {"Fruits", "Vegetables", "Meat", "Drinks"};
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        itemCategory.getItems().addAll(categories);
    }
    
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
                query = String.format("SELECT items.item_id, items.name as item_name, category, price, shops.name as shop_name FROM items JOIN prices ON items.item_id = prices.item_id JOIN shops ON prices.shop_id = shops.shop_id WHERE items.name = '%s';", searchName);
            }
            else{
                query =  "SELECT items.item_id, items.name as item_name, category, price, shops.name as shop_name FROM items JOIN prices ON items.item_id = prices.item_id JOIN shops ON prices.shop_id = shops.shop_id";
            }
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("item_id");
                String item = rs.getString("item_name");
                String category = rs.getString("category");
                float price = rs.getInt("price");
                String shop = rs.getString("shop_name");
                System.out.println("id: " + id + "\tname: " + item +"\tcategory: " + category + "\tprice: " + price + "\tshop: " + shop);
                items.add("id: " + id + "\tname: " + item +"\tcategory: " + category + "\tprice: " + price + "\tshop: " + shop);
            }
            itemList.getItems().addAll(items);
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void ActionOnAddItemButton(ActionEvent event) {
          String item = itemName.getText();
          String category = itemCategory.getValue();
          int tescoPrice = parseInt(priceTesco.getText());
          int sparPrice = parseInt(priceSpar.getText());
          int aldiPrice = parseInt(priceAldi.getText());
          
          try{
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String queryItems = String.format("INSERT INTO items(name, category) VALUES('%s', '%s')", item, category);
            stmt.executeUpdate(queryItems);
            c.commit();
            System.out.println("done");
            String queryGetId = String.format("SELECT item_id FROM items WHERE name = '%s'", item);
            rs = stmt.executeQuery(queryGetId);
            rs.next();
            int itemId = rs.getInt("item_id");
            System.out.println(itemId);
            String queryPrices = String.format("INSERT INTO prices(item_id, shop_id, price) VALUES(%d, 1, %d), (%d, 2, %d), (%d, 3, %d)", itemId, tescoPrice, itemId, sparPrice, itemId, aldiPrice);
            stmt.executeUpdate(queryPrices);
            c.commit();
          } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void ActionOnRemoveItemButton(ActionEvent event) {
        int deleteId = parseInt(itemID.getText());
        try {
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String queryPrices = String.format("DELETE FROM prices WHERE item_id = %d", deleteId);
            stmt.executeUpdate(queryPrices);
            c.commit();
            String queryItems = String.format("DELETE FROM items WHERE item_id = %d", deleteId); 
            stmt.executeUpdate(queryItems);
            c.commit();
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
