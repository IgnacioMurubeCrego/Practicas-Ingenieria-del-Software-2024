package com.example.software;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Home {

    @FXML
    private Label welcomeUserLabel, txtId;

    @FXML
    private Button btnCalendar;


    int idUsuario = 0;

    //Bd baseDatos = new Bd();
    Bd baseDatos = Bd.getInstance();
    public void mostrarId(int idUser) {
        txtId.setText(String.valueOf(idUser));
        idUsuario = Integer.parseInt(txtId.getText());
        System.out.println("El id recogido es: "+ idUsuario);
        String nombreAux = baseDatos.mostrarNombre(idUsuario);
        welcomeUserLabel.setText("Bienvenido, "+nombreAux);
    }






    HelloApplication main = new HelloApplication();







}




