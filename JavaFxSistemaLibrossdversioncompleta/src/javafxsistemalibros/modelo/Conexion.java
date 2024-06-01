/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxsistemalibros.modelo;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author deric
 */
public class Conexion {
    public Connection database;
    
    public Connection getConnection(){
    String name = "biblotecadb";
    String user = "postgres";
    String pass = "80141670";
    String url = "jdbc:postgresql://localhost:5432/"+ name;
    
    try{
        Class.forName("org.postgresql.Driver");
        database = DriverManager.getConnection(url,user,pass);
    }catch(Exception ex){
        ex.printStackTrace();
    }
    
    
    return database;
    }
}
