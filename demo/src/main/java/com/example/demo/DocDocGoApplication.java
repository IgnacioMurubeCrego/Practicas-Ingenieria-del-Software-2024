package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DocDocGoApplication extends Application {

    public static Stage currentStage;

    @Override
    public void start(Stage stage) throws IOException {
        currentStage = new Stage();
        StageController controller = new StageController();
        controller.loadStage("login_screen.fxml");
    }

    public static void main(String[] args) {launch();}
}