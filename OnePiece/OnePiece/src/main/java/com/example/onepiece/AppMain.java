package com.example.onepiece;

<<<<<<< Updated upstream
=======
import com.example.onepiece.Controller.CheckOutController;
import com.example.onepiece.Controller.ShopController;
>>>>>>> Stashed changes
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AppMain extends Application {
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

    public static void main(String[] args) {
<<<<<<< Updated upstream
        launch();
=======
        
        launch();

        ShopController shop = new ShopController();
        CheckOutController check = new CheckOutController();
        check.setCart(shop.getCartItems());

>>>>>>> Stashed changes
    }
}