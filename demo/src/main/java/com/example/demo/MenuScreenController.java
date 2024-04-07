package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import java.io.IOException;

import static com.example.demo.DocDocGoApplication.currentStage;

public class MenuScreenController {

    public void OnReportsBtnClick(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("reports_screen.fxml"));
            Scene reportsScene = new Scene(fxmlLoader.load(), 500, 720);
            currentStage.close();
            currentStage.setScene(reportsScene);
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void OnEmergencyNumberBtnClick(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("emergencyNum_screen.fxml"));
            Scene EmergencyNumScene = new Scene(fxmlLoader.load(), 500, 720);
            currentStage.close();
            currentStage.setScene(EmergencyNumScene);
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
