package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.demo.DocDocGoApplication.currentStage;

public class MainScreenController {

    public void OnReportsBtnClick(ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("reports_screen.fxml"));
            Scene mainScene = new Scene(fxmlLoader.load(), 500, 720);
            stage.setScene(mainScene);
            stage.show();
            // Close the current login screen
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void OnEmergencyNumberBtnClick(ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("emergencyNum_screen.fxml"));
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
