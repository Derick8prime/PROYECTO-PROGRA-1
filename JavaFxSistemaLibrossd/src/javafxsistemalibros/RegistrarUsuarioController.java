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

/**
 * FXML Controller class
 *
 * @author deric
 */
public class RegistrarUsuarioController implements Initializable {

    @FXML
    private TextField Email;

    @FXML
    private Button btnRegistrarUsuario;

    @FXML
    private TextField Pass;

    @FXML
    private TextField SegundoA;

    @FXML
    private TextField Telefono;

    @FXML
    private TextField Cui;

    @FXML
    private TextField Direccion;

    @FXML
    private TextField SegundoN;

    @FXML
    private TextField PrimerA;

    @FXML
    private TextField PrimerN;

    @FXML
    void buttonRegistrarUsuario(ActionEvent event) {
        registraUsuario();
    }
    private void registraUsuario() {
        Conexion con = new Conexion();
        Connection conexionDb = con.getConnection();
        
        String registro = "INSERT INTO registro_usuario(primern,segundon,primera,segundoa,direccion,telefono,cui,fkidRegistro)VALUES('"+PrimerN.getText()+"','"+SegundoA.getText()+"','"+PrimerA.getText()+"','"+SegundoN.getText()+"','"+Direccion.getText()+"','"+Telefono.getText()+"','"+Cui.getText()+"',1)"; 
        
        try{
            Statement statement = conexionDb.createStatement();
            statement.executeUpdate(registro);
            System.out.println("Registro Completado");
        }catch(Exception ex){
            System.out.println("registo no realizado");
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    
}
