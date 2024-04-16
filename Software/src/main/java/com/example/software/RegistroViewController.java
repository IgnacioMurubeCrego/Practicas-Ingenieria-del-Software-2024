package com.example.software;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RegistroViewController {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtApellidos;

    @FXML
    private TextField txtBirth;

    @FXML
    private TextField txtGenre;

    @FXML
    private TextField txtMail;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserType;

    @FXML
    private TextField txtAdmin;

    @FXML
    private Button btnAcceder;

    @FXML
    private Button btnLogin;

    HelloApplication main = new HelloApplication();
    //Bd baseDatos = new Bd();

    Bd baseDatos = Bd.getInstance();
    FXMLLoader loaderLogin = new FXMLLoader(getClass().getResource("LoginView.fxml"));
    @FXML
    void MostrarViewInicioSesion(ActionEvent event) {
        try {
            main.cerrarPagina(event, btnLogin);
            main.mostrarPagina(event, loaderLogin);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void showHome(ActionEvent event) {
        boolean encontrados = false;

        try {

            baseDatos.guardarUsuario(txtNombre,txtApellidos, txtBirth, txtGenre, txtMail,txtPassword, txtUserType, txtAdmin);
            main.cerrarPagina(event, btnAcceder);
            main.mostrarPagina(event, loaderLogin);


            encontrados = baseDatos.iniciarSesion( txtMail, txtPassword);

            //Una vez a encontrado el usuario accedo a la siguiente vista
            if(encontrados == false) {
                baseDatos.guardarUsuario(txtNombre, txtApellidos, txtBirth, txtGenre, txtMail, txtPassword, txtUserType, txtAdmin);
                main.cerrarPagina(event, btnAcceder);
                main.mostrarPagina(event, loaderLogin);
            }


        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}

