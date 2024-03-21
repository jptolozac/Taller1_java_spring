package com.login.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.login.modelo.Usuario;

//servidor que elimina la informacion y cierra la sesion
@WebServlet(name = "eliminar", value = "/eliminar")
public class ServletEliminar extends HttpServlet{
    List<Usuario> usuarios;
    static Usuario sesionActual;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Usuario> usuarios = ServletRegistro.getUsuarios();
        usuarios.clear();
        //usuarios.remove(0)  si se desea remove un es especifico
        if(usuarios == null) {
            resp.getWriter().println("su usuario no ha sido eliminado");
            for(Usuario usuario : usuarios){
                resp.getWriter().println("usuario"+ usuario.getNombre());    
            }
        }
        else{                      
            req.getSession().removeAttribute("sesionIniciada");
            /* HttpSession sesion =  req.getSession()
            sesion.invalidate(); */
            resp.getWriter().println("usuario elimidado correctamente" + ServletLogin.getSesionActual());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("En eliminar post");
    }
    
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //lectura de usuarios desde los servlets de registro y login
        usuarios = ServletRegistro.getUsuarios();
        Usuario usuarioActual = ServletLogin.getSesionActual();

        //verifica si el usuario es nulo, en caso de que no, lo elimina y muestra mensaje de éxito, en caso de que sí muestra mensaje de error
        PrintWriter out = resp.getWriter();
        if(usuarioActual != null){
            for(Usuario usu : usuarios){
                if(usu.equals(usuarioActual)){
                    usuarios.remove(usu);
                }
                System.out.println(usu.getUsuario());
            }
            for(Usuario usu : usuarios){
                out.println(usu.getUsuario());
            }
            ServletLogin.setSesionActual(null);
            out.println("Usuario eliminado con éxito");
        }else{
            resp.setStatus(401);
            out.println("No se ha logueado en el sistema");
        }
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        usuarios = null;
    }
    
}
