package com.login.servlet;

import java.io.IOException;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "listar", value = "/listar")
public class ServletListar extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("En listar");
        resp.getWriter().println("Identificacion: " + ServletLogin.getSesionActual().getIdentificacion());
        resp.getWriter().println("Codigo: " + ServletLogin.getSesionActual().getCodigo());
        resp.getWriter().println("Usuario: " + ServletLogin.getSesionActual().getUsuario());
        resp.getWriter().println("Nombre: " + ServletLogin.getSesionActual().getNombre());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        // TODO Auto-generated method stub
        super.init();
    }
    
}
