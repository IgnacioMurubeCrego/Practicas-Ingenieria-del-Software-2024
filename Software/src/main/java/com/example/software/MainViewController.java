package com.example.software;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;



public class MainViewController {
    @FXML
    private Button btnMostrarInicioSesion, btnMostrarRegistro;
    @FXML
    private TextField txtMostrar;




    //Esto sive para añadir el link a las vistas
    HelloApplication main = new HelloApplication();


    //Dirección de las diferentes vistas que se podrán usar
    FXMLLoader loaderLogin = new FXMLLoader(getClass().getResource("LoginView.fxml"));
    FXMLLoader loaderRegistro = new FXMLLoader(getClass().getResource("RegistroView.fxml"));



    @FXML
    void MostrarViewInicioSesion(ActionEvent event) {
        try {
            //creamos objeto del Main para poder llamar al metodo start2 /
            main.cerrarPagina(event, btnMostrarInicioSesion);
            main.mostrarPagina(event, loaderLogin);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void MostrarViewRegistro(ActionEvent event) {
        try {
            // creamos objeto del Main para poder llamar al metodo start2 */
            main.cerrarPagina(event, btnMostrarRegistro);
            main.mostrarPagina(event, loaderRegistro);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }


}