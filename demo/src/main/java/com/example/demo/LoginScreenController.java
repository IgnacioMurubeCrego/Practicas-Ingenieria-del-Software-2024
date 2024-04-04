package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.demo.DocDocGoApplication.currentScene;
import static com.example.demo.DocDocGoApplication.currentStage;

public class LoginScreenController {

    @FXML
    private TextField usernameTxtf, passwordTxtf;

    @FXML
    protected void onRegisterBtnClick(){

    }

    @FXML
    protected void onLoginBtnClick(){
        // Retrieve the username and password from the TextFields
        String username = usernameTxtf.getText();
        String password = passwordTxtf.getText();

        // Perform authentication (replace this with your authentication logic)
        boolean isAuthenticated = false;
        if("user".equals(username) & "12345".equals(password)){ isAuthenticated = true;}

        if (isAuthenticated) {
            // If authentication succeeds, transition to the main screen
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
        } else {
            // If authentication fails, display an error message (replace this with your error handling)
            System.out.println("Invalid username or password");
        }
    }

    // Sample authentication method (replace this with your actual authentication logic)
    private boolean authenticate(String username, String password) {
        // For demonstration purposes, authenticate any non-empty username and password
        return !username.isEmpty() && !password.isEmpty();
    }


    @FXML
    protected void onLoginProBtnClick(){

    }

    @FXML
    protected void onLoginAdminBtnClick(){

    }

}
