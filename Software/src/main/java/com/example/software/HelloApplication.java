package com.example.software;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This Singleton class acts as the center of DocDocGo's UI
 * and provides a view frame reference accessible by all view controllers.
 */
public class HelloApplication extends Application {

    // Singleton Instance.
    private static final HelloApplication instance = new HelloApplication();
    public static HelloApplication getInstance() {
        return instance;
    }

    @Override
    public void start(Stage primaryStage) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void mostrarPagina(ActionEvent event, FXMLLoader fxmlLoader) {
        try {
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void cerrarPagina(ActionEvent event, Button btnEmpezar) {

        try {
            // selecciona la vista a la que pertenece btn1
            Stage stage = (Stage) btnEmpezar.getScene().getWindow();
            // haciendo .hide cierra la ventana con la opción de reabrir la vista
            stage.hide();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
