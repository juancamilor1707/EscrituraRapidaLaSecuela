package com.example.escriturarapida;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;
//Inicio Programa
public class App1 extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App1.class.getResource("/com/example/escriturarapida/view/Menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 680);
        stage.setTitle("Miniproyecto #1");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }
}
