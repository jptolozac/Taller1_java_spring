package com.login.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.login.modelo.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "inicioSesion", value = "/inicioSesion")
public class ServletLogin extends HttpServlet{
    List<Usuario> usuarios;
    static Usuario sesionActual;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Usuario> usuarios = ServletRegistro.getUsuarios();
        PrintWriter out = resp.getWriter();
        Boolean sesionEncontrada = false;
        for(Usuario usuario : usuarios){
            String usuarioReq = req.getParameter("usuario");
            String passwordReq = req.getParameter("password");
            
            if(usuarioReq.equalsIgnoreCase(usuario.getUsuario()) && passwordReq.equals(usuario.getPassword())){
                req.getSession().setAttribute("sesionIniciada", usuario);
                sesionActual = usuario;
                sesionEncontrada = true;
                resp.getWriter().println("Sesion iniciada con éxito");
            }
        }
        if(!sesionEncontrada)
            out.println("No se encontró el usuario");
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        usuarios = new ArrayList<>();
        sesionActual = null;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public static Usuario getSesionActual() {
        return sesionActual;
    }

    public static void setSesionActual(Usuario sesionActual) {
        ServletLogin.sesionActual = sesionActual;
    }
    
}