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
    private TextField usernameTxtf, passwordTxtf, confirmPasswordTxtf;

    /**
     * @param path
     * Will be used to load each screen of DocDocGo on the app panel visible by the user
     * by modifying the currentStage variable of the DocDocApplication class instance.
     */
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

    /**
     * @return boolean variable checking for the registered user in MySQL database.
     */
    // Sample authentication method (replace this with your actual authentication logic)
    private boolean authenticateUser() {

        // Retrieve the username and password from the TextFields
        String username = usernameTxtf.getText();
        String password = passwordTxtf.getText();

        // For demonstration purposes, authenticate any non-empty username and password
        return !username.isEmpty() && !password.isEmpty();
    }


    // Pending to be implemented with database connection.
    /**
     * Will be responsible to process new users registrations in MySQL database
     * checking for duplicates.
     */
    private void registerUser() {

        // Retrieve the username and password from the TextFields
        String username = usernameTxtf.getText();
        String password = passwordTxtf.getText();
        String confirmPassword = confirmPasswordTxtf.getText();

        if(!(username.isEmpty()) & !(password.isEmpty()) & password.equals(confirmPassword)){
            // Add new user to database:

        }

    }

    /**
     * @param actionEvent
     * onBtnClick function will act as the main event handler in the StageController class
     *     sorting the actions that will be performed depending on the button clicked by the user.
     */
    public void onBtnClick(ActionEvent actionEvent) {
        String id = ((Node) actionEvent.getSource()).getId();
        switch (id) {
            case "loginBtn", "loginProBtn", "loginAdminBtn" -> {
                if (authenticateUser())
                    loadStage("menu_screen.fxml");
            }
            case "registerBtn" -> loadStage("register_screen.fxml");
            case "registerNewUserBtn" -> {
                try {
                    registerUser();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                loadStage("login_screen.fxml");
            }
            case "reportsBtn" -> loadStage("reports_screen.fxml");
            case "profileBtn" -> loadStage("profile_screen.fxml");
            case "emergencyNumBtn" -> loadStage("emergencyNum_screen.fxml");
            case "configBtn" -> loadStage("config_screen.fxml");
            case "menuBtn" -> loadStage("menu_screen.fxml");
            case "logOutBtn" -> loadStage("login_screen.fxml");
        }
    }


}
