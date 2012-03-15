/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.server;


import org.stakeInteraction.shared.Informacion.Documento;
import org.stakeInteraction.shared.Informacion.Usuario;
import org.stakeInteraction.shared.CuentaUsuario.CuentaUsuario;
import org.stakeInteraction.shared.grafo.Arco;





import org.stakeInteraction.shared.grafo.Nodo;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.util.Vector;


import org.stakeInteraction.client.GWTService;
import org.stakeInteraction.server.ExportarGrafo.ExportadorGrafo;
import org.stakeInteraction.server.ExportarGrafo.ExportadorGrafoGML;
import org.stakeInteraction.server.Importar.ImportadorGrafo;
import org.stakeInteraction.server.Importar.ImportadorGrafoGML;
import org.stakeInteraction.server.Sesion.Conexion;
import org.stakeInteraction.server.Sesion.Sesion;
import org.stakeInteraction.server.Sesion.SesionAdmin;
import org.stakeInteraction.server.Sesion.SesionUser;
import org.stakeInteraction.server.ValidarCambiosGrafo.ValidadorGrafo;
import org.stakeInteraction.server.ValidarCambiosGrafo.ValidadorGrafoSimple;
import org.stakeInteraction.shared.grafo.Grafo;



/**
 *
 * @author yor
 */
public class GWTServidor extends RemoteServiceServlet implements GWTService {

private Sesion sesion;
private ExportadorGrafo exportador;
private ImportadorGrafo importador;
private ValidadorGrafo validadorGrafo;


  

  

  

    @Override
    public CuentaUsuario conectar(String nombre, String contraseña) {
     Conexion c=new Conexion();
    return c.conectar(nombre, contraseña);

      /*  sesion=new Sesion();
      
        return sesion.conectar(nombre, contraseña);*/

    }

      @Override
    public void crearSesionAdmin(CuentaUsuario cuenta) {
       sesion=new SesionAdmin(cuenta);
    }

    @Override
    public void crearSesionUser(CuentaUsuario cuenta) {
       sesion=new SesionUser(cuenta);
    }



    //--------------------------------------------------------------------
    
    @Override
    public Usuario getInformacionNodo(Usuario usuario) {
        Usuario u= sesion.getInformacionNodo(usuario);
        return u;
    }

    @Override
    public Documento getInformacionNodo(Documento documento) {
      Documento d=sesion.getInformacionNodo(documento);
        return d;
    }

    @Override
    public Grafo pedirGrafo() {

     Grafo g= sesion.getGrafoFiltrado(this.sesion.getCuenta().getGrafo().getId()); // sesion.pedirGrafo();
  
   return g;


    }

     @Override
    public Grafo pedirGrafoFiltrado(int idGrafo) {
       return sesion.getGrafoFiltrado(idGrafo);
    }

    @Override
    public void exportar() {
       //  sesion.exportar();
         exportador=new ExportadorGrafoGML(sesion);
        exportador.exportar();
   //return null;
    }




    //----------------------Editar la BD--------------------------------------------------




    @Override
    public int guardarNodoUsuario(Nodo nodo) {
      int id= sesion.guardarNodoUsuario(nodo);
      return id;
    }

    @Override
    public int guardarNodoDocumento(Nodo nodo) {
         int id= sesion.guardarNodoDocumento(nodo);
      return id;
    }

    @Override
    public void editarNodoUsuario(Nodo nodo) {
        sesion.editarNodoUsuario(nodo);
    }

    @Override
    public void editarNodoDocumento(Nodo nodo) {
       sesion.editarNodoDocumento(nodo);
    }

    @Override
    public void eliminarNodoUsuario(Nodo nodo) {
       sesion.eliminarNodoUsuario(nodo);
    }

    @Override
    public void eliminarNodoDocumento(Nodo nodo) {
      sesion.eliminarNodoDocumento(nodo);
    }

    @Override
    public int guardarArco(Arco arco) {
      int id= sesion.guardarArco(arco);
      return id;
    }

    @Override
    public void eliminarArco(Arco arco) {
        sesion.eliminarArco(arco);
    }

   /* @Override
    public void eliminarNodoPorUsuario(Nodo nodo) {
       sesion.eliminarNodoPorUsuario(nodo);
    }

    @Override
    public void eliminarArcoPorUsuario(Arco arco) {
       sesion.eliminarArcoPorUsuario(arco);
    }*/

  

    @Override
    public void editarUsuario(Usuario usuario) {
        sesion.editarUsuario(usuario);
    }

    @Override
    public void editarDocumento(Documento documento) {
       sesion.editarDocumento(documento);
    }

    @Override
    public Vector<CuentaUsuario> pedirUsuarios() {
      return ((SesionAdmin)sesion).getUsuarios();
    }

    @Override
    public void importar() {
        importador =new ImportadorGrafoGML((SesionAdmin) sesion);
        importador.importar();
     // ((SesionAdmin)sesion).importar();
    }

    @Override
    public void validarGrafo() {
      //  ((SesionAdmin)sesion).validarGrafo();
          validadorGrafo =new ValidadorGrafoSimple(((SesionAdmin)sesion));
        validadorGrafo.validarGrafo();
    }

    @Override
    public void asignarNodo(Nodo nodo, int idGrafo) {
       ((SesionAdmin)sesion).asignarNodo(nodo, idGrafo);
    }

    @Override
    public void asignarArco(Arco arco, int idGrafo) {
       ((SesionAdmin)sesion).asignarArco(arco, idGrafo);
    }

    @Override
    public void validarArco(Arco arco) {
       ((SesionAdmin)sesion).validarArco(arco);
    }

    @Override
    public void validarNodo(Nodo nodo) {
       ((SesionAdmin)sesion).validarNodo(nodo);
    }

   

}
