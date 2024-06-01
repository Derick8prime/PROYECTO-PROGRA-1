/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxsistemalibros;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafxsistemalibros.modelo.LibrosAlquilados;

/**
 * FXML Controller class
 *
 * @author deric
 */
public class LibrosAlquiladosController implements Initializable {

    @FXML private TableView<LibrosAlquilados> tablaAlquilerLibros;
    @FXML private TableColumn<LibrosAlquilados, Integer> colLibro;
    @FXML private TableColumn<LibrosAlquilados, Integer> colCodigo;
    @FXML private TableColumn<LibrosAlquilados, String> colFechaE;
    @FXML private TableColumn<LibrosAlquilados, String> colEstado;
    @FXML private TableColumn<LibrosAlquilados, Integer> colMulta;
    @FXML private TableColumn<LibrosAlquilados, String> colCliente;
    @FXML private TableColumn<LibrosAlquilados, String> colFechaA;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tablaAlquilerLibros.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        this.colCodigo.setCellValueFactory(new PropertyValueFactory <>("idLogin"));
        this.colCliente.setCellValueFactory(new PropertyValueFactory <>("primerN"));
        this.colLibro.setCellValueFactory(new PropertyValueFactory <>("titulo"));
        this.colFechaA.setCellValueFactory(new PropertyValueFactory <>("fechaAlquiler"));
        this.colFechaA.setCellValueFactory(new PropertyValueFactory <>("fechaAlquiler"));
        this.colEstado.setCellValueFactory(new PropertyValueFactory <>("estado"));
        this.colMulta.setCellValueFactory(new PropertyValueFactory <>("multa"));
        
        LibrosAlquilados a = new LibrosAlquilados();
        ObservableList<LibrosAlquilados> contenido = a.getLibrosAlquilados();
        this.tablaAlquilerLibros.setItems(contenido);
    }    
    
}
