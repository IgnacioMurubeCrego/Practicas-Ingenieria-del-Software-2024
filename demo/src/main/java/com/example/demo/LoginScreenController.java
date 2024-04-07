package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.io.IOException;

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
        isAuthenticated = authenticate(username,password);

        if (isAuthenticated) {
            // If authentication succeeds, transition to the main screen
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu_screen.fxml"));
                Scene mainScene = new Scene(fxmlLoader.load(), 500, 720);
                currentStage.close();
                currentStage.setScene(mainScene);
                currentStage.show();
                // Close the current login screen

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
