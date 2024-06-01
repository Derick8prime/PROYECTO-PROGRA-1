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


public class LibrosAlquilados {
    private int idLogin;
    private int idUser;
    private String primerN;
    private String segundoN;
    private String primerA;
    private int fkidLogin;
    private int idRegLibro;
    private String titulo;
    private String fechaAlquiler;
    private String estado;
    private int multa;

    public LibrosAlquilados(){};
    
    public LibrosAlquilados(int idLogin,int idUser, String primerN, String segundoN,String primerA,int fkidLogin,int idRegLibro,String titulo,String fechaAlquiler,String estado,int multa){
        this.idLogin = idLogin;
        this.idUser = idUser;
        this.primerN = primerN;
        this.segundoN = segundoN;
        this.primerA = primerA;
        this.fkidLogin = fkidLogin;
        this.idRegLibro = idRegLibro;
        this.titulo = titulo;
        this.fechaAlquiler = fechaAlquiler;
        this.estado = estado;
        this.multa = multa;
        
    };
    
    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getPrimerN() {
        return primerN;
    }

    public void setPrimerN(String primerN) {
        this.primerN = primerN;
    }

    public String getSegundoN() {
        return segundoN;
    }

    public void setSegundoN(String segundoN) {
        this.segundoN = segundoN;
    }

    public String getPrimerA() {
        return primerA;
    }

    public void setPrimerA(String primerA) {
        this.primerA = primerA;
    }

    public int getFkidLogin() {
        return fkidLogin;
    }

    public void setFkidLogin(int fkidLogin) {
        this.fkidLogin = fkidLogin;
    }

    public int getIdRegLibro() {
        return idRegLibro;
    }

    public void setIdRegLibro(int idRegLibro) {
        this.idRegLibro = idRegLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(String fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getMulta() {
        return multa;
    }

    public void setMulta(int multa) {
        this.multa = multa;
    }
    

    public ObservableList<LibrosAlquilados> getLibrosAlquilados() {
        ObservableList<LibrosAlquilados> alq = FXCollections.observableArrayList();
        
        try{
        Conexion con = new Conexion();
        Connection conexionDB = con.getConnection();

        String consulta = "SELECT l.idLogin,u.idUser, u.primerN,u.segundoN,u.primerA,r.fkidLogin,r.idRegLibro,r.titulo,al.idAlquilerLibro,al.fkidRegLibro,al.fechaAlquiler,al.estado,mu.cantidad,mu.fkidAlquilerLibro FROM alquiler_libro as al join registro_libros as r on al.fkidRegLibro = r.idRegLibro join login as l on r.fkidLogin = l.idLogin join registro_usuario as u on l.fkidUser = u.idUser left join multa as mu on al.idAlquilerLibro = mu.fkidAlquilerLibro";
            Statement statement = conexionDB.createStatement();
            ResultSet sql = statement.executeQuery(consulta);
            while(sql.next()){
                int idLogin = sql.getInt("idLogin");
                int idUser = sql.getInt("idUser");
                String primerN = sql.getString("primerN");
                String segundoN = sql.getString("segundoN");
                String primerA = sql.getString("primerA");
                int fkidLogin = sql.getInt("fkidLogin");
                int idRegLibro = sql.getInt("fkidRegLibro");
                String titulo = sql.getString("titulo");
                String fechaAlquiler = sql.getString("fechaAlquiler");
                String estado = sql.getString("estado");
                int multa = sql.getInt("cantidad");
                
                LibrosAlquilados alquiler = new LibrosAlquilados(idLogin,idUser,primerN,segundoN,primerA,fkidLogin,idRegLibro,titulo,fechaAlquiler,estado,multa);
                alq.add(alquiler);
            }
        }catch(Exception ex){
            System.out.println("Consulta no realizada"+ex);
        }
        
        
        return alq;
    }
    
}


