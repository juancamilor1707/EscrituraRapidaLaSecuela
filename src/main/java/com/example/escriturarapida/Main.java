package com.example.escriturarapida;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;
public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/example/escriturarapida/view/Menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 655, 576);
        stage.setTitle("Miniproyecto #1");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }
}
