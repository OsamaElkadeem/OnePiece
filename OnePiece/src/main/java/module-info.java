module com.example.onepiece {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.onepiece to javafx.fxml;
    exports com.example.onepiece;
<<<<<<< Updated upstream
=======
    exports com.example.onepiece.Controller;
    opens com.example.onepiece.Controller to javafx.fxml;

>>>>>>> Stashed changes
}