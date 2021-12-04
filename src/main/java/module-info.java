module javafxprojects.cryptoapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.net.http;
    requires com.google.gson;

    opens javafxprojects.cryptoapp to javafx.fxml;
    exports javafxprojects.cryptoapp;
}