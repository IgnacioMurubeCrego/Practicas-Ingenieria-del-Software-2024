package com.example.software;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Perfil extends AppNavegacion {
    @FXML
    private Label txtName, txtBirth, txtMail, txtGender, txtSurname;

    void mostrarId(int id) {

        txtId.setText(String.valueOf(id));
        idUsuario = Integer.parseInt(txtId.getText());
        System.out.println("el valor recogido es : " + idUsuario);
        baseDatos.mostrarUsuario(idUsuario, txtName, txtSurname, txtBirth, txtGender, txtMail);
    }





}
