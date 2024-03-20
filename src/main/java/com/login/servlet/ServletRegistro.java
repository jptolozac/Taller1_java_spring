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

@WebServlet(name = "registro", value = "/registro")
public class ServletRegistro extends HttpServlet{
    static List<Usuario> usuarios;

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet de registro iniciado");
        usuarios = new ArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("Buenas");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Usuario usuario = new Usuario();
        PrintWriter out = resp.getWriter();

        //verifica los datos y si son validos, se asignan y se responde
        if(req.getParameter("identificacion") == null ||
            req.getParameter("nombre") == null ||
            req.getParameter("codigo") == null ||
            req.getParameter("usuario") == null ||
            req.getParameter("password") == null
        ){
            out.println("Error: Datos ingresados incorrectos");
            resp.setStatus(400);
        }else{
            Boolean creado = false;
            for(Usuario usu : usuarios){
                if(usu.getIdentificacion().equals(req.getParameter("identificacion"))){
                    creado = true;
                    out.println("Usuario no disponible");
                    resp.setStatus(406);
                }
            }
            if (!creado) {
                usuario.setIdentificacion(req.getParameter("identificacion"));
                usuario.setNombre(req.getParameter("nombre"));
                usuario.setCodigo(req.getParameter("codigo"));
                usuario.setUsuario(req.getParameter("usuario"));
                usuario.setPassword(req.getParameter("password"));

                usuarios.add(usuario);
                out.println("Respuesta: Usuario creado con éxito");
            }
        }
    }

    @Override
    public void destroy() {
        System.out.println("Servlet de registro Terminado");
    }

    public static List<Usuario> getUsuarios() {
        return usuarios;
    }

    public static void setUsuarios(List<Usuario> usu) {
        usuarios = usu;
    }
}
