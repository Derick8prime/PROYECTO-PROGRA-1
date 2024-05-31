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
import javafx.collections.ObservableList;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafxsistemalibros.modelo.CatalogoLibros;


/**
 * FXML Controller class
 *
 * @author deric
 */
public class PrestamoLibroController implements Initializable {
    
    @FXML private TableView<CatalogoLibros> tablaLibros;   
    @FXML private TableColumn<CatalogoLibros, String> editorial;
    @FXML private TableColumn<CatalogoLibros, Integer> precio;
    @FXML private TableColumn<CatalogoLibros, String> isbn;
    @FXML private TableColumn<CatalogoLibros, String> titulo;
    @FXML private TableColumn<CatalogoLibros, Integer> cantidad;
    @FXML private TableColumn<CatalogoLibros, String> anioPubl;
    @FXML private TableColumn<CatalogoLibros, String> autor;
    
    
    @FXML private Button btnPrestamo;
    @FXML private Button btnBuscador;
    @FXML private TextField textBuscador;
    
    @FXML
    void buttonBuscar(ActionEvent event) {
        visualizarDatosTabla();
        System.out.println("Rellenando Tabla");
    }
    @FXML
    void buttonRealizarPrestamo(ActionEvent event) {
        visualizarDatosTabla();
        System.out.println("Rellenando Tabla");
        
    }
    void visualizarDatosTabla(){
        
    };

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tablaLibros.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        this.isbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        this.titulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        this.autor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        this.anioPubl.setCellValueFactory(new PropertyValueFactory<>("anioPubl"));
        this.editorial.setCellValueFactory(new PropertyValueFactory<>("editorial"));
        this.cantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        this.precio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        
        CatalogoLibros s = new CatalogoLibros();
        ObservableList<CatalogoLibros> contenido = s.getCatalogoLibros();
        this.tablaLibros.setItems(contenido);
        
    }    
    
}
