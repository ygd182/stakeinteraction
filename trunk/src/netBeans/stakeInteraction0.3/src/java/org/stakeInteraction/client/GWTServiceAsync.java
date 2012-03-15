/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.client;


import org.stakeInteraction.shared.Informacion.Documento;
import org.stakeInteraction.shared.Informacion.Usuario;
import org.stakeInteraction.shared.CuentaUsuario.CuentaUsuario;
import org.stakeInteraction.shared.grafo.Grafo;
import org.stakeInteraction.shared.grafo.Nodo;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Vector;
import org.stakeInteraction.shared.Informacion.Informacion;
import org.stakeInteraction.shared.grafo.Arco;


/**
 *
 * @author yor
 */
public interface GWTServiceAsync {
   



  //  public void getInformacionNodo(int idNodo, AsyncCallback<Informacion> asyncCallback);


    public void conectar(String nombre, String contraseña, AsyncCallback<CuentaUsuario> asyncCallback);

    public void getInformacionNodo(Documento documento, AsyncCallback<Documento> asyncCallback);

    public void getInformacionNodo(Usuario usuario, AsyncCallback<Usuario> asyncCallback);

    public void pedirGrafo(AsyncCallback<Grafo> asyncCallback);

    public void exportar(AsyncCallback<Void> asyncCallback);





    //--------------------------------------------------------------------------------

    public void guardarNodoUsuario(Nodo nodo,AsyncCallback<java.lang.Integer> asyncCallback);

    public void guardarNodoDocumento(Nodo nodo,AsyncCallback<java.lang.Integer> asyncCallback);

    public void guardarArco(Arco arco,AsyncCallback<java.lang.Integer> asyncCallback);

    

    public void editarNodoUsuario(Nodo nodo,AsyncCallback<Void> asyncCallback);

    public void editarNodoDocumento(Nodo nodo,AsyncCallback<Void> asyncCallback);


    public void eliminarNodoUsuario(Nodo nodo,AsyncCallback<Void> asyncCallback);

    public void eliminarNodoDocumento(Nodo nodo,AsyncCallback<Void> asyncCallback);

    public void eliminarArco(Arco arco,AsyncCallback<Void> asyncCallback);

    public void pedirGrafoFiltrado(int idGrafo,AsyncCallback<Grafo> asyncCallback);

   /* public void eliminarNodoPorUsuario(Nodo nodo, AsyncCallback<Void> asyncCallback);

    public void eliminarArcoPorUsuario(Arco arco, AsyncCallback<Void> asyncCallback);*/

    public void crearSesionAdmin(CuentaUsuario cuenta, AsyncCallback<Void> asyncCallback);

    public void crearSesionUser(CuentaUsuario cuenta, AsyncCallback<Void> asyncCallback);

    public void editarUsuario(Usuario usuario, AsyncCallback<Void> asyncCallback);

    public void editarDocumento(Documento documento, AsyncCallback<Void> asyncCallback);

    public void pedirUsuarios(AsyncCallback<Vector<CuentaUsuario>> asyncCallback);

    public void importar(AsyncCallback<Void> asyncCallback);

    public void validarGrafo(AsyncCallback<Void> asyncCallback);

    public void asignarNodo(Nodo nodo, int idGrafo, AsyncCallback<Void> asyncCallback);

    public void asignarArco(Arco arco, int idGrafo, AsyncCallback<Void> asyncCallback);

    public void validarArco(Arco arco, AsyncCallback<Void> asyncCallback);

    public void validarNodo(Nodo nodo, AsyncCallback<Void> asyncCallback);
}
