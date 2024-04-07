package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.io.IOException;

import static com.example.demo.DocDocGoApplication.currentStage;

public class StageController {

    @FXML
    private TextField usernameTxtf, passwordTxtf;

    protected void loadStage(String path){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path));
            Scene mainScene = new Scene(fxmlLoader.load(), 500, 720);
            currentStage.close();
            currentStage.setScene(mainScene);
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Sample authentication method (replace this with your actual authentication logic)
    private boolean authenticateUser() {

        // Retrieve the username and password from the TextFields
        String username = usernameTxtf.getText();
        String password = passwordTxtf.getText();

        // For demonstration purposes, authenticate any non-empty username and password
        return !username.isEmpty() && !password.isEmpty();
    }



    public void onBtnClick(ActionEvent actionEvent) {
        String id = ((Node) actionEvent.getSource()).getId();
        switch (id) {
            case "loginBtn":
                if (authenticateUser());
                    loadStage("menu_screen.fxml");
                break;

            case "reportsBtn":
                loadStage("reports_screen.fxml");
                break;
            case "profileBtn":
                loadStage("profile_screen.fxml");
                break;
            case "emergencyNumBtn":
                loadStage("emergencyNum_screen.fxml");
                break;
            case "configBtn":
                loadStage("config_screen.fxml");
                break;
            case "menuBtn":
                loadStage("menu_screen.fxml");
                break;
            case "logOutBtn":
                loadStage("login_screen.fxml");
                break;

        }
    }
}
