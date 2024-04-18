package com.example.software;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class AppNavegacion {

    int idUsuario = 0;

    @FXML
    public TextField txtId;

    Bd baseDatos = Bd.getInstance();
    HelloApplication main = HelloApplication.getInstance();

    //------------------------------------------------------------------------
    // PARA LAS BIBLIOTECAS

    // Recoge el id del usuario que inicia sesión en todas las vistas
    @FXML
    private Button btnPedirCita, btnPerfil, btnVerCitas;
    public Button[] listButtonMenu = new Button[3];

    FXMLLoader loaderNewCita = new FXMLLoader(getClass().getResource("PedirCita.fxml"));
    FXMLLoader loaderPerfil = new FXMLLoader(getClass().getResource("Perfil.fxml"));
    FXMLLoader loaderVerCitas = new FXMLLoader(getClass().getResource("ConsultarCita.fxml"));
    public FXMLLoader[] listFxmlMenu = new FXMLLoader[3];

    private void addArrayMenu() {

        // Botones del menu
        listButtonMenu[0] = btnPedirCita; listButtonMenu[1] = btnPerfil; listButtonMenu[2] = btnVerCitas;
        // Vistas del menu
        listFxmlMenu[0] = loaderNewCita; listFxmlMenu[1] = loaderPerfil; listFxmlMenu[2] = loaderVerCitas;
    }

    @FXML
    void showViewMenu(ActionEvent event) {

        // Cargamos los Arrays
        addArrayMenu();

        try {

            // Recorremos la lista de botones del array
            for (int i = 0; i < listButtonMenu.length; i++) {

                // Comprobamos caul es el botón que se ha presionado
                if (event.getSource() == listButtonMenu[i]) {

                    // Cerramos la vista actual para mostrar la siguiente
                    main.cerrarPagina(event, listButtonMenu[i]);
                    Parent root1 = listFxmlMenu[i].load();

                    // Dependiendo del botón que sea se cargará su controlador para acceder al método de pasar ID
                    if (listButtonMenu[i] == btnPedirCita) {
                        PedirCita pview = loaderNewCita.getController();
                        pview.mostrarId(idUsuario);
                    } else if (listButtonMenu[i] == btnPerfil) {
                        Perfil pview = loaderPerfil.getController();
                        pview.mostrarId(idUsuario);
                    } else if (listButtonMenu[i] == btnVerCitas) {
                        ConsultarCita pview = loaderVerCitas.getController();
                        pview.mostrarId(idUsuario);
                    }

                    Stage stage = new Stage();
                    stage.setScene(new Scene(root1));
                    stage.show();
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}