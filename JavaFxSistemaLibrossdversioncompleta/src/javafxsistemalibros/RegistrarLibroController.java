/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxsistemalibros;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafxsistemalibros.modelo.Conexion;

import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * FXML Controller class
 *
 * @author deric
 */
public class RegistrarLibroController implements Initializable {

        @FXML
        private TextField editorial;

        @FXML
        private TextField precio;

        @FXML
        private Button btnRegistrarLibro;

        @FXML
        private TextField isbn;

        @FXML
        private TextField titulo;

        @FXML
        private TextField cantidad;

        @FXML
        private TextField autor;

        @FXML
        private TextField anioP;

        @FXML
        void buttonRegistrarLibro(ActionEvent event) {
            registrarLibro();
    }
        private void registrarLibro() {
        Conexion con = new Conexion();
        Connection conexionDB = con.getConnection();
        
        Date f = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("YYYY/MM/dd");
        String fecha = formatoFecha.format(f);
        
        String regLibro = "INSERT INTO registro_libros(fecha,isbn,titulo,autor,anioPubl,editorial,cantidad,precio,fkidLogin)VALUES('"+fecha+"','"+isbn.getText()+"','"+titulo.getText()+"','"+autor.getText()+"','"+anioP.getText()+"','"+editorial.getText()+"','"+cantidad.getText()+"','"+precio.getText()+"',1)";
        
        try{
            Statement statement = conexionDB.createStatement();
            statement.executeUpdate(regLibro);
            System.out.println("Registrado con Exito");
        }catch(Exception ex){
            System.out.println("Libro no registrado"+ex);
            
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    
}
