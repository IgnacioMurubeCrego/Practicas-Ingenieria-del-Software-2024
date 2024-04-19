package com.example.software;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

public class MainViewController {

    @FXML
    private Button btnShowL, btnShowR; // Buttons which will appear in as 'SIGN UP' and 'LOGIN'

    // Main view Singleton instance.
    HelloApplication main = HelloApplication.getInstance();

    // FXML loaders of both views accesible from application initial view.
    private final FXMLLoader loaderLogin = new FXMLLoader(getClass().getResource("LoginView.fxml"));
    private final FXMLLoader loaderRegistro = new FXMLLoader(getClass().getResource("RegistroView.fxml"));

    /**
     * @param event Changes main view to user 'LOGIN' view.
     */
    @FXML
    void showViewLogin(ActionEvent event) {
        try {
            main.cerrarPagina(event, btnShowL);
            main.mostrarPagina(event, loaderLogin);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param event Changes main view to new user 'REGISTER' view.
     */
    @FXML
    void showViewRegistro(ActionEvent event) {
        try {
            main.cerrarPagina(event, btnShowR);
            main.mostrarPagina(event, loaderRegistro);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}