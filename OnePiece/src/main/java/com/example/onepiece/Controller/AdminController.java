package com.example.onepiece.Controller;

import com.example.onepiece.AppMain;
import com.example.onepiece.Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.List;


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
    private TableView<Item> itemTable;
    @FXML private TableColumn<Item, Integer> itemId;
    @FXML private TableColumn<Item, String> itemName;
    @FXML private TableColumn<Item, Integer> priceTesco;
    @FXML private TableColumn<Item, Integer> priceSpar;
    @FXML private TableColumn<Item, Integer> priceAldi;


    @FXML void listButtonPressed() {
        ItemDAO idao = new JpaItemDAO();
        List<Item> itemList = idao.listItems();
        ObservableList<Item> ol = FXCollections.observableArrayList();
        for(int i=0;i<itemList.size();i++){
            ol.add(itemList.get(i));
        }
        itemId.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        itemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        priceTesco.setCellValueFactory(new PropertyValueFactory<>("priceTesco"));
        priceSpar.setCellValueFactory(new PropertyValueFactory<>("priceSpar"));
        priceAldi.setCellValueFactory(new PropertyValueFactory<>("priceAldi"));
        itemTable.setItems(ol);
    }

    Item eggs = new Item("Eggs (Extra Yellow Deep-Sleep) / 10 pcs", 729, 850, 765);

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
