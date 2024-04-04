package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DocDocGoApplication extends Application {

    public static Scene currentScene;
    public static Stage currentStage;

    @Override
    public void start(Stage stage) throws IOException {
        currentStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(DocDocGoApplication.class.getResource("login_screen.fxml"));
        currentScene = new Scene(fxmlLoader.load(), 500, 720);
        currentStage.setTitle("DocDocGo");
        showScene(currentStage);
    }

    public static void showScene(Stage stage){

        stage.setScene(currentScene);
        stage.show();
    }

    public static void main(String[] args) {launch();}
}