package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DocDocGoApplication extends Application {

    protected Scene currentScene;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DocDocGoApplication.class.getResource("login_screen.fxml"));
        currentScene = new Scene(fxmlLoader.load(), 500, 720);
        stage.setTitle("DocDocGo");
        stage.setScene(currentScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}