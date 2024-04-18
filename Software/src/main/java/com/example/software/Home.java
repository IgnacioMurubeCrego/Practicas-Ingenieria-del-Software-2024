package com.example.software;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Home extends AppNavegacion {

    @FXML
    private Label txtUserName;

    void mostrarId(int id) {

        txtId.setText(String.valueOf(id));
        idUsuario = Integer.parseInt(txtId.getText());
        System.out.println("el valor recogido es : " + idUsuario);

        // Para mostrar el nombre del user
        baseDatos.mostrarNombre(idUsuario, txtUserName);
    }
}




