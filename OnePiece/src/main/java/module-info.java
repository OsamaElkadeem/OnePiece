module com.example.onepiece {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires com.h2database;
    requires javax.persistence;

    opens com.example.onepiece to javafx.fxml;
    exports com.example.onepiece;
    exports com.example.onepiece.Controller;
    opens com.example.onepiece.Controller to javafx.fxml;
}