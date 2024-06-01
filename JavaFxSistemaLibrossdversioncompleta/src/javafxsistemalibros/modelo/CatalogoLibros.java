/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxsistemalibros.modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author deric
 */
public class CatalogoLibros {
        private String isbn;
        private String titulo;
        private String autor;
        private String anioPubl;
        private String editorial;
        private int cantidad;
        private int precio;
        
    public CatalogoLibros(){
    
    };
    public CatalogoLibros(String isbn,String titulo,String autor,String anioPubl,String editorial,int cantidad,int precio){
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPubl = anioPubl;
        this.editorial = editorial;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAnioPubl(String anioPubl) {
        this.anioPubl = anioPubl;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getAnioPubl() {
        return anioPubl;
    }

    public String getEditorial() {
        return editorial;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getPrecio() {
        return precio;
    }
    
    
    public ObservableList<CatalogoLibros> getCatalogoLibros() {
        ObservableList<CatalogoLibros> x = FXCollections.observableArrayList();
        

        
        try{
        Conexion con = new Conexion();
        Connection conexionDB = con.getConnection();
        
        String consulta = "SELECT isbn,titulo,autor,anioPubl,editorial,cantidad,precio FROM registro_Libros";
            Statement statement = conexionDB.createStatement();
            ResultSet sql = statement.executeQuery(consulta);
            while(sql.next()){
                String isbn = sql.getString("isbn");
                String titulo = sql.getString("titulo");
                String autor = sql.getString("autor");
                String anioPubl = sql.getString("anioPubl");
                String editorial = sql.getString("editorial");
                int cantidad = sql.getInt("cantidad");
                int precio = sql.getInt("precio");
                
                CatalogoLibros mostrarLibros = new CatalogoLibros(isbn,titulo,autor,anioPubl,editorial,cantidad,precio);
                x.add(mostrarLibros);
            }
        }catch(Exception ex){
            System.out.println("Consulta no realizada"+ex);
        }
        
        
        return x;
    }
}
