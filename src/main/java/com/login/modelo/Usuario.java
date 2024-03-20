package com.login.modelo;

public class Usuario {
    String identificacion;
    String nombre;
    String codigo;
    String usuario;
    String password;
    public Usuario(String identificacion, String nombre, String codigo, String usuario, String password) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.codigo = codigo;
        this.usuario = usuario;
        this.password = password;
    }
    public Usuario() {
        identificacion = "";
        nombre = "";
        codigo = "";
        usuario = "";
        password = "";
    }
    public String getIdentificacion() {
        return identificacion;
    }
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
