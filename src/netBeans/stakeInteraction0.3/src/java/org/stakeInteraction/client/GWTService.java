/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.client;

import org.stakeInteraction.shared.grafo.Nodo;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.Vector;
import org.stakeInteraction.shared.Informacion.Documento;
import org.stakeInteraction.shared.Informacion.Informacion;
import org.stakeInteraction.shared.Informacion.Usuario;

import org.stakeInteraction.shared.CuentaUsuario.CuentaUsuario;
import org.stakeInteraction.shared.grafo.Arco;
import org.stakeInteraction.shared.grafo.Grafo;


/**
 *
 * @author yor
 */
@RemoteServiceRelativePath("gwtservice")
public interface GWTService extends RemoteService {
   


    public Grafo pedirGrafo();

     public Grafo pedirGrafoFiltrado(int idGrafo);


    public Usuario getInformacionNodo(Usuario usuario);

    public Documento getInformacionNodo(Documento documento);

    public CuentaUsuario conectar(String nombre,String contraseña);

    public void exportar();



    //----EJECUCION COMANDOS-----------------------

    public int guardarNodoUsuario(Nodo nodo);

    public int guardarNodoDocumento(Nodo nodo);



    public void editarNodoUsuario(Nodo nodo);

    public void editarNodoDocumento(Nodo nodo);

    public void editarUsuario(Usuario usuario);

    public void editarDocumento(Documento documento);

    public void eliminarNodoUsuario(Nodo nodo);

    public void eliminarNodoDocumento(Nodo nodo);



    public int guardarArco(Arco arco);

    public void eliminarArco(Arco arco);

    //---------------Eliminar Por usuario solamente------------------
/*
     public void eliminarNodoPorUsuario(Nodo nodo);


    public void eliminarArcoPorUsuario(Arco arco);*/

    //-------------Crear Sesion------------------

    public void crearSesionAdmin(CuentaUsuario cuenta);

    public void crearSesionUser(CuentaUsuario cuenta);


    //-------------------------------------------
    public Vector<CuentaUsuario> pedirUsuarios();

    public void importar();

    public void validarGrafo();



    //----------------------------------------

    public void asignarNodo(Nodo nodo,int idGrafo);

    public void asignarArco(Arco arco,int idGrafo);

    public void validarArco(Arco arco);

    public void validarNodo(Nodo nodo);

}
