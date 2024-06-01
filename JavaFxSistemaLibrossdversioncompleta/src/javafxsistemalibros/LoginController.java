/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxsistemalibros;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafxsistemalibros.modelo.Conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * FXML Controller class
 *
 * @author deric
 */
public class LoginController implements Initializable {
        

    
        @FXML
        private Button btnLogin;
        
        @FXML 
        private TextField usuario;
        
        @FXML 
        private PasswordField password;

        @FXML 
        private Label loginMessageLabel;
        @FXML
        void buttonActivated(ActionEvent event) {
            if(usuario.getText().isBlank()== false && password.getText().isBlank()== false ){
                
                validarLogin();
                
            }else{
                loginMessageLabel.setText("Por favor Rellene los Campos");
            }
        }
            
        public void validarLogin(){
            Conexion con = new Conexion();
            Connection conectDB = con.getConnection();
            
            String verifyLogin = "SELECT idLogin,email,contrasena FROM login WHERE email = '"+usuario.getText()+"' AND contrasena = '"+password.getText()+"'";
            
            try{
                Statement statement = conectDB.createStatement();
                ResultSet queryResult = statement.executeQuery(verifyLogin);
                
                    if(queryResult.next()){
                        int idUser = queryResult.getInt("idLogin");
                        try{
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InterfazBiblioteca.fxml"));
                        Parent root = (Parent)fxmlLoader.load();

                        Stage stage = new Stage();
                        stage.setTitle("Interfaz Grafica");
                        stage.setScene(new Scene(root));
                        stage.show();
                        Stage cerrarVentana = (Stage) this.btnLogin.getScene().getWindow();
                        cerrarVentana.close();
                        }catch(IOException e){
                            System.out.println("No se logro Cargar el contenido");
                        }
                    }else{
                        loginMessageLabel.setText("Usuario incorrecto");
                    };
                
            }catch(Exception ex){
                ex.printStackTrace();
            }
        
        }


        @Override
        public void initialize(URL url,ResourceBundle rb){
                  

    }
    
    /**
     * Initializes the controller class.
     */
   
    
}
