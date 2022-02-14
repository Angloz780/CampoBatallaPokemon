module com.example.pokemon {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;

    opens com.example.pokemon to javafx.fxml;
    exports com.example.pokemon;
}