package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.demo.DocDocGoApplication.currentStage;

public class ReportsScreenController {
    public void OnMenuBtnClick(ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main_screen.fxml"));
            Scene mainScene = new Scene(fxmlLoader.load(), 500, 720);
            stage.setScene(mainScene);
            stage.show();
            // Close the current login screen
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
