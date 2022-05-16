package com.example.onepiece;


import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.h2.tools.Server;
import com.example.onepiece.Model.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class AppMain extends Application {

    public static void main(String[] args) throws SQLException {
        startDatabase();


        launch();

        /*try (ItemDAO iDAO = new JpaItemDAO()) {
            handleData(iDAO);
        } catch (Exception e) {
            e.printStackTrace();
        } */

        ItemDAO iDAO = new JpaItemDAO();
        Item eggs = new Item("Eggs (Extra Yellow Deep-Sleep) / 10 pcs", 729, 850, 765);
        iDAO.saveItem(eggs);
        List<Item> i = iDAO.listItems();
    }

    private static void startDatabase() throws SQLException {
        new Server().runTool("-tcp", "-web", "-ifNotExists");
    }

    public static void handleData(ItemDAO iDAO){
        Item a = new Item();
        a.setName("Eggs (Extra Yellow Deep-Sleep) / 10 pcs");
        a.setPriceTesco(729);
        a.setPriceSpar(850);
        a.setPriceAldi(765);
        iDAO.saveItem(a);


        Category dairy = new Category();
        dairy.setName("Dairy");
        dairy.getItems().add(a);
        iDAO.saveCategory(dairy);
    }

    private static Stage stg;

    @Override
    public void start(Stage stage) throws IOException {
        stg = stage;
        stage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(AppMain.class.getResource("LoginForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        stage.setTitle("One Piece!");
        stage.setScene(scene);
        stage.show();
    }

    public void changeScene(String fxml) throws IOException{
        Parent pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));
        stg.getScene().setRoot(pane);
    }

}

