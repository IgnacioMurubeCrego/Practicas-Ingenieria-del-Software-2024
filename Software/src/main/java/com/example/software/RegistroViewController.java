package com.example.software;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistroViewController {

    @FXML
    private Button btnMostrarViewLogin2, btnMostrarViewPrincipal;

    @FXML
    private TextField titNombre, titUsername, titDate, titGender, titMail, titPassword;

    int idUser = 0;

    // Clase para hacer uso de la base de datos
    Bd baseDatos = Bd.getInstance();
    HelloApplication main = HelloApplication.getInstance();

    //Dirección de las diferentes vistas que se podrán usar
    FXMLLoader loaderLogin = new FXMLLoader(getClass().getResource("LoginView.fxml"));
    FXMLLoader loaderPrincipal = new FXMLLoader(getClass().getResource("HomeView.fxml"));


    @FXML
    void showViewLogin2(ActionEvent event) {

        try {
            // creamos objeto del Main para poder llamar al metodo start2
            main.cerrarPagina(event, btnMostrarViewLogin2);
            main.mostrarPagina(event, loaderLogin);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void showViewPrincipal(ActionEvent event) {

        try {

            // Inserto el nombre del usuario cuando se empieza la partida
            if (!titNombre.getText().isEmpty() && !titUsername.getText().isEmpty() && !titDate.getText().isEmpty() && !titGender.getText().isEmpty() && !titMail.getText().isEmpty() && !titPassword.getText().isEmpty()) {

                baseDatos.guardarUsuario(titNombre, titUsername, titDate, titGender, titMail, titPassword);
                idUser = baseDatos.getIdUser(titMail, titPassword);
                // Creamos un objeto de la clase HelloApplication para llamar al método cerrarPagina y mostrarPrincipalViewUser
                main.cerrarPagina(event, btnMostrarViewPrincipal);
                mostrarPrincipalViewUser(event, loaderPrincipal, idUser);

            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void mostrarPrincipalViewUser(ActionEvent event, FXMLLoader fxmlLoader, int idUser) {

        try {

            Parent root1 = (Parent) fxmlLoader.load();
            // Para pasar datos entre ventanas
            Home pview = fxmlLoader.getController();
            //idUser = pview.mostrarId(idUser);
            pview.mostrarId(idUser);

            System.out.println("Usuario en vista login : " + idUser);

            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}