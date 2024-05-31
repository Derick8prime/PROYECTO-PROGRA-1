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
import javafx.stage.Stage;
import javafxsistemalibros.modelo.Login;

/**
 * FXML Controller class
 *
 * @author derick
 */
public class InterfazBibliotecaController implements Initializable {
    
    
    
    @FXML
    private Button btnListadoAlquiler;

    @FXML
    private Button btnRegistrarLibro;

    @FXML
    private Button btnRegistrarUsuario;

    @FXML
    private Button btnCatalogoLibros;

    @FXML
    private Button btnInformeLibros;

    @FXML
    void buttonListadoAlquiler(ActionEvent event) {
        try{
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LibrosAlquilados.fxml"));
                        Parent root = (Parent)fxmlLoader.load();
                
                        Stage stage = new Stage();
                        stage.setTitle("Catalogo Libros");
                        stage.setScene(new Scene(root));
                        stage.show();
                        
                        }catch(IOException e){
                            System.out.println("No se logro Cargar el contenido");
                        }
    }

    @FXML
    void buttonCatalogoLibros(ActionEvent event) {
        try{
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PrestamoLibro.fxml"));
                        Parent root = (Parent)fxmlLoader.load();
                
                        Stage stage = new Stage();
                        stage.setTitle("Catalogo Libros");
                        stage.setScene(new Scene(root));
                        stage.show();
                        }catch(IOException e){
                            System.out.println("No se logro Cargar el contenido");
                        }
    }

    @FXML
    void buttonRegistrarLibro(ActionEvent event) {
        try{
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RegistrarLibro.fxml"));
                        Parent root = (Parent)fxmlLoader.load();
                
                        Stage stage = new Stage();
                        stage.setTitle("Registrar Libro");
                        stage.setScene(new Scene(root));
                        stage.show();
                        }catch(IOException e){
                            System.out.println("No se logro Cargar el contenido");
                        }
    }

    @FXML
    void buttonRegistrarUsuario(ActionEvent event) {
        try{
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RegistrarUsuario.fxml"));
                        Parent root = (Parent)fxmlLoader.load();
                
                        Stage stage = new Stage();
                        stage.setTitle("Registrar Usuario");
                        stage.setUserData(stage);
                        stage.setScene(new Scene(root));
                        stage.show();
                        }catch(IOException e){
                            System.out.println("No se logro Cargar el contenido");
                        }
    }

        
    @FXML
    void buttonInformeLibros(ActionEvent event) {

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize (URL url, ResourceBundle rb) {

        
    }    
    
}
