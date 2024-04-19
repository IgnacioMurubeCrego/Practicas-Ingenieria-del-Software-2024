package com.example.software;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.*;
import java.util.ArrayList;

/**
 * This Singleton class acts as the connection and data checker with DocDocGo's MySQL database.
 *  It provides a database instance accessible by all classes.
 */
public class Bd {
    private static Connection conexion = null;
    private static Statement sentenciaSQL = null;
    private static Bd instance;

    public Bd() {
        super();
    }

    //----------------------------------------------------------------------------------------------------------

    // Conectar a la base de datos

    final void conectar() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/docdocgo", "root", "root");
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        }
    }

    // Método para obtener la instancia única de la clase Bd (patron de diseño Singleton)
    //El patrón Singleton se utiliza para asegurar que una clase tenga solo una instancia y
    // proporciona un punto de acceso global a esa instancia.
    public static Bd getInstance() {
        if (instance == null) {
            instance = new Bd();
        }
        return instance;
    }

    final void desconectar() throws SQLException{
        try {
            sentenciaSQL.close();
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Añadir un usuario nuevo al registrarse
    public void guardarUsuario(TextField nombre, TextField apellidos, TextField birth,
                               TextField gender, TextField email, TextField password) {

        int result;
        String sql;

        String nombreAux = nombre.getText();
        String apellidosAux = apellidos.getText();
        String birthAux = birth.getText();
        String genderAux = gender.getText();
        String emailAux = email.getText();
        String passwordAux = password.getText();

        try {

            // ANTES TENEMOS QUE VERIFICAR SI EL USUARIO EXISTE

            conectar();
            sentenciaSQL = conexion.createStatement();


            // Sentencia para añadir usuarios a la tabla
            sql = "INSERT INTO usuarios (userName, userLastname, userBirth, userGender, " +
                    "userMail, userPassword) VALUES ('" + nombreAux + "', '" + apellidosAux
                    + "', '" + birthAux +"',  '" + genderAux + "','" + emailAux + "', '" + passwordAux + "')";

            result = sentenciaSQL.executeUpdate(sql);

            // Se incrementa el valor de los personajes almacenados en el arrayList
            System.out.println("Usuario añadido");

            desconectar();

        } catch (SQLException ex) {
            System.out.println("ERROR al guardar el usuario");
        }
    }

    public int iniciarSesion(TextField email, TextField password, Label txtError) {

        int encontrado = 0;

        ResultSet result;
        String sql;

        String emailAux = email.getText();
        String passwordAux = password.getText();

        try {

            conectar();

            sentenciaSQL = conexion.createStatement();

            // Sentencia para añadir usuarios a la tabla
            sql = "SELECT userMail, userPassword, idAdmin FROM usuarios where userMail = '" +
                    emailAux + "' and userPassword = '" + passwordAux + "'";
            result = sentenciaSQL.executeQuery(sql);

            // Siempre se ejecuta cada vez que encuentre un dato buscado en la secuencia
            if(result.next()) {

                // Mostramos el id del usuario para comprobar funcionamiento
                System.out.println("Admin? : " + result.getString("idAdmin"));

                //Comprobamos que tipo de user quiere entrar
                if (result.getString("idAdmin") == null) {
                    System.out.println("User found");
                    encontrado = 1;
                } else if (result.getString("idAdmin") == "1") {
                    System.out.println("Doc found");
                    encontrado = 2;
                } else if (result.getString("idAdmin") == "2") {
                    System.out.println("Admin found");
                    encontrado = 3;
                }
                /*
                System.out.println("Admin found");
                encontrado = 1;

                 */
            }

            desconectar();

        } catch (SQLException ex) {
            System.out.println("ERROR at login");
            txtError.setText("User or password incorrect");
        }

        return encontrado;
    }

    public int getIdUser(TextField email, TextField password) {

        int id = 0;

        ResultSet result;
        String sql;

        String emailAux = email.getText();
        String passwordAux = password.getText();

        try {

            conectar();
            sentenciaSQL = conexion.createStatement();

            // Sentencia para añadir usuarios a la tabla
            sql = "SELECT idUsuario FROM usuarios where userMail = '" + emailAux
                    + "' and userPassword = '" + passwordAux + "'";
            result = sentenciaSQL.executeQuery(sql);

            // Siempre se ejecuta cada vez que encuentre un dato buscado en la secuencia
            if(result.next()) {
                id = result.getInt("idUsuario");
                System.out.println("El id del usuario en el sql es : " + id);
            }

            desconectar();

        } catch (SQLException ex) {
            System.out.println("ERROR al obtener el id del usuario");
        }

        return id;
    }

    public void mostrarNombre (int idUser, Label userName){

        ResultSet result;
        String sql;

        try {

            conectar();
            sentenciaSQL = conexion.createStatement();

            // Sentencia para añadir usuarios a la tabla
            sql = "SELECT userName FROM usuarios where idUsuario = '" + idUser + "'";
            result = sentenciaSQL.executeQuery(sql);

            // Siempre se ejecuta cada vez que encuentre un dato buscado en la secuencia
            if(result.next()) {
                userName.setText(result.getString("userName"));
            }

            desconectar();

        } catch (SQLException ex) {
            System.out.println("ERROR al obtener el id del usuario");
        }
    }

    public void mostrarUsuario(int idUser, Label userName, Label userSurname, Label userBirth,
                               Label userGender, Label userMail) {

        ResultSet result;
        String sql;

        try {

            conectar();
            sentenciaSQL = conexion.createStatement();

            // Sentencia para añadir usuarios a la tabla
            sql = "SELECT * FROM usuarios where idUsuario = '" + idUser + "'";
            result = sentenciaSQL.executeQuery(sql);

            // Siempre se ejecuta cada vez que encuentre un dato buscado en la secuencia
            if(result.next()) {

                // Insertamos en cada TextField los datos que sacamos de la BD
                userName.setText(result.getString("userName"));
                userSurname.setText("ID : " + result.getString("idUsuario"));
                userBirth.setText("Birth : " + result.getString("userBirth"));
                userGender.setText("Gender : " + result.getString("userGender"));
                userMail.setText("Mail : " + result.getString("userMail"));
            }

            desconectar();

        } catch (SQLException ex) {
            System.out.println("ERROR al mostrar user");
        }
    }

    public void crearCita(TextField txtNameC, TextField txtIdDocC, TextField txtIdUserC, TextField txtDateC) {

        int result;
        String sql;

        String nombreAux = txtNameC.getText();
        String idDocAux = txtIdDocC.getText();
        String idUserAux = txtIdUserC.getText();
        String dateAux = txtDateC.getText();

        try {

            conectar();
            sentenciaSQL = conexion.createStatement();

            // Sentencia para añadir usuarios a la tabla
            sql = "INSERT INTO citas (citaDescripcion, idDoc, idPaciente, citaFecha) VALUES ('" +
                    nombreAux + "', '" + idDocAux + "', '" + idUserAux + "', '" + dateAux + "')";
            result = sentenciaSQL.executeUpdate(sql);

            // Se incrementa el valor de los personajes almacenados en el arrayList
            System.out.println("Contenido añadido");

            desconectar();

        } catch (SQLException ex) {
            System.out.println("ERROR al guardar un contenido");
            //txtError.setText("ERROR at add a content");
        }
    }

    public ArrayList<Integer> getIdCitas(int idUser) {

        ResultSet result;
        String sql;

        ArrayList<Integer> listIds = new ArrayList<>();
        int idCont = 0;

        try {

            conectar();
            sentenciaSQL = conexion.createStatement();

            // Filtramos por id del usuario
            sql = "SELECT idCitas FROM citas WHERE idPaciente = '" + idUser + "'";
            result = sentenciaSQL.executeQuery(sql);

            // Cada vez que encuentre algo lo añade a un array
            while(result.next()) {

                idCont = result.getInt("idCitas");
                listIds.add(idCont);
            }

            desconectar();

        } catch (SQLException ex) {
            System.out.println("ERROR al guardar los ids pelicula de los contenidos");
        }

        return listIds;
    }

    public void mostrarCita(int idCita, Label txtNameC, Label txtIdDocC, Label txtDateC) {

        ResultSet result;
        String sql;

        try {

            conectar();
            sentenciaSQL = conexion.createStatement();

            // Sentencia para añadir usuarios a la tabla
            sql = "SELECT * FROM citas where idCitas = '" + idCita + "'";
            result = sentenciaSQL.executeQuery(sql);

            // Siempre se ejecuta cada vez que encuentre un dato buscado en la secuencia
            if(result.next()) {

                // Insertamos en cada TextField los datos que sacamos de la BD
                txtNameC.setText(result.getString("citaDescripcion"));
                txtIdDocC.setText("DOC : " + result.getString("idDoc"));
                txtDateC.setText("DATE : " + result.getString("citaFecha"));
            }

            desconectar();

        } catch (SQLException ex) {
            System.out.println("ERROR al mostrar citas");
        }
    }

}
