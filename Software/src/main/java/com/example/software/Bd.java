package com.example.software;

import javafx.scene.control.TextField;

import java.sql.*;

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
    public void guardarUsuario(TextField nombre, TextField apellidos, TextField birth, TextField gender, TextField email, TextField password, TextField Type, TextField admin) {

        int result;
        String sql;

        String nombreAux = nombre.getText();
        String apellidosAux = apellidos.getText();
        String birthAux = birth.getText();
        String genderAux = gender.getText();
        String emailAux = email.getText();
        String passwordAux = password.getText();
        //String TypeAux = Type.getText();
        //String adminAux = admin.getText();

        try {

            // ANTES TENEMOS QUE VERIFICAR SI EL USUARIO EXISTE

            conectar();
            sentenciaSQL = conexion.createStatement();


            // Sentencia para añadir usuarios a la tabla
            sql = "INSERT INTO usuarios (userName, userLastname, userBirth, userGender, userMail, userPassword) VALUES ('" + nombreAux + "', '" + apellidosAux + "', '" + birthAux +"',  '" + genderAux + "','" + emailAux + "', '" + passwordAux + "')";
            result = sentenciaSQL.executeUpdate(sql);

            // Se incrementa el valor de los personajes almacenados en el arrayList
            System.out.println("Usuario añadido");

            desconectar();

        } catch (SQLException ex) {
            System.out.println("ERROR al guardar el usuario");
        }
    }


    public boolean iniciarSesion(TextField email, TextField password) {
        boolean encontrado = false;
        ResultSet result;
        String sql;
        String emailAux = email.getText();
        String passwordAux = password.getText();

        try {
            conectar();

            sentenciaSQL = conexion.createStatement();

            // Sentencia para añadir usuarios a la tabla
            sql = "SELECT userMail, userPassword FROM usuarios where userMail = '" + emailAux + "' and userPassword = '" + passwordAux + "'";
            result = sentenciaSQL.executeQuery(sql);

            // Siempre se ejecuta cada vez que encuentre un dato buscado en la secuencia
            if (result.next()) {
                System.out.println("User found");
                encontrado = true;
            }


           // desconectar();

        } catch (SQLException ex) {
            System.out.println("ERROR al encontrar el usuario");
        }

        return encontrado;
    }

    public int getIdUser(TextField txtUsername, TextField txtPassword) {
        int id = 0;

        ResultSet result;
        String sql;

        String emailAux = txtUsername.getText();
        String passwordAux = txtPassword.getText();

        try {

            conectar();
            sentenciaSQL = conexion.createStatement();

            // Sentencia para añadir usuarios a la tabla
            sql = "SELECT idUsuarios FROM usuarios where userMail = '" + emailAux + "' and userPassword = '" + passwordAux + "'";
            result = sentenciaSQL.executeQuery(sql);

            // Siempre se ejecuta cada vez que encuentre un dato buscado en la secuencia
            if(result.next()) {
                id = result.getInt("idusuarios");
                System.out.println("El id del usuario en el sql es : " + id);
            }

            desconectar();

        } catch (SQLException ex) {
            System.out.println("ERROR al obtener el id del usuario");
        }

        return id;
    }

    public String mostrarNombre (int idUser){

        ResultSet result;
        String sql;
        String nombreAux = "";


        try {

            conectar();
            sentenciaSQL = conexion.createStatement();

            // Sentencia para añadir usuarios a la tabla
            sql = "SELECT userName FROM usuarios where idUsuarios = '" + idUser + "'";
            result = sentenciaSQL.executeQuery(sql);

            // Siempre se ejecuta cada vez que encuentre un dato buscado en la secuencia
            if(result.next()) {
                nombreAux = result.getString("userName");
                System.out.println("El nombre del usuario en el sql es : " + nombreAux);
            }

            desconectar();

        } catch (SQLException ex) {
            System.out.println("ERROR al obtener el id del usuario");
        }
        return nombreAux;
    }
}
