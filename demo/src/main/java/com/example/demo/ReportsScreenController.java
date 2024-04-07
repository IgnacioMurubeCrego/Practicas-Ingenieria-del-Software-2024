package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import java.io.IOException;

import static com.example.demo.DocDocGoApplication.currentStage;

public class ReportsScreenController {
    public void OnMenuBtnClick(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu_screen.fxml"));
            Scene mainScene = new Scene(fxmlLoader.load(), 500, 720);
            currentStage.close();
            currentStage.setScene(mainScene);
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
