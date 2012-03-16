/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.client;



import com.google.gwt.user.client.Window;

import com.google.gwt.user.client.rpc.AsyncCallback;



import java.util.Vector;
import org.stakeInteraction.client.ventanaGrafo.mediador.ContenedorGrafo;
import org.stakeInteraction.client.ventanaGrafo.mediador.OpcionesAdminGrafoAcordion;
import org.stakeInteraction.shared.CuentaUsuario.CuentaUsuario;
import org.stakeInteraction.shared.Informacion.Documento;
import org.stakeInteraction.shared.Informacion.Usuario;
import org.stakeInteraction.shared.grafo.Arco;


import org.stakeInteraction.shared.grafo.Grafo;
import org.stakeInteraction.shared.grafo.Nodo;
import org.stakeInteraction.shared.ventanaInfo.VentanaDoc;
import org.stakeInteraction.shared.ventanaInfo.VentanaUser;


/**
 * Example class using the GWTService service.
 *
 * @author yor
 */
public class GWTServiceUsage  {
  



static public void pedirGrafoBase(final Grafo grafo){

       final AsyncCallback<Grafo> callback = new AsyncCallback<Grafo>() {
            @Override
            public void onSuccess(Grafo result) {


                grafo.clonar(result);
               // cargarGrafo(result,grafo);
                //notificarGrafoCambios();
                grafo.notificar();

                // crearGrafoAuxiliar();

               
            }

            @Override
            public void onFailure(Throwable caught) {
                PantallaMensaje.mostrarDialogo("Error.No se pudo obtener el grafo",null);
              
            }
        };

       
        //Service.getService().myMethod(" ",callback);
        Service.getService().pedirGrafo(callback);


       

    }



public static void pedirInformacionNodoBaseDocumento(Documento doc,final VentanaDoc ventana){
            final AsyncCallback<Documento> callback = new AsyncCallback<Documento>() {

            @Override
            public void onFailure(Throwable caught) {
                 PantallaMensaje.mostrarDialogo("Error.No se pudo obtener la infroamcion del documento",null);

            }

            @Override
            public void onSuccess(Documento result) {
                ventana.cargarVentana(result);
            }
        };

  Service.getService().getInformacionNodo(doc,callback);
  /*  public void getInformacionNodo(Usuario usuario, AsyncCallback<Usuario> asyncCallback);*/


    }

public static void pedirInformacionNodoBaseUsuario(Usuario user,final VentanaUser ventana){
            final AsyncCallback<Usuario> callback = new AsyncCallback<Usuario>() {

            @Override
            public void onFailure(Throwable caught) {
                 PantallaMensaje.mostrarDialogo("Error.No se pudo obtener la infroamcion del usuario",null);

            }

            @Override
            public void onSuccess(Usuario result) {
                ventana.cargarVentana(result);
            }
        };

  Service.getService().getInformacionNodo(user,callback);
  /*  public void getInformacionNodo(Usuario usuario, AsyncCallback<Usuario> asyncCallback);*/


    }


public static void exportarGml(){
     final AsyncCallback<Void> asyncCallback=new AsyncCallback<Void>() {

            @Override
            public void onFailure(Throwable caught) {
                 PantallaMensaje.mostrarDialogo("Error.No se pudo exportar",null);
            }

            @Override
            public void onSuccess(Void result) {
                 com.google.gwt.user.client.Window.open("DownloadAttachmentServlet","DownloadFile","");

            }
        };
     Service.getService().exportar(asyncCallback);


    }


public static void crearSesionAdmin(CuentaUsuario cuenta){
     final AsyncCallback<Void> asyncCallback=new AsyncCallback<Void>() {

            @Override
            public void onFailure(Throwable caught) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void onSuccess(Void result) {
              //  throw new UnsupportedOperationException("Not supported yet.");
            }
        };
     Service.getService().crearSesionAdmin(cuenta,asyncCallback);


    }


public static void crearSesionUser(CuentaUsuario cuenta){
     final AsyncCallback<Void> asyncCallback=new AsyncCallback<Void>() {

            @Override
            public void onFailure(Throwable caught) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void onSuccess(Void result) {
             //   throw new UnsupportedOperationException("Not supported yet.");
            }
        };
     Service.getService().crearSesionUser(cuenta,asyncCallback);


    }


public static void guardarNodoUsuario(Nodo nodo,final Grafo grafo){
     final AsyncCallback<Integer> asyncCallback=new AsyncCallback<Integer>() {

            @Override
            public void onFailure(Throwable caught) {
                 PantallaMensaje.mostrarDialogo("Error.No se pudo guardar el Usuario",null);
            }

            @Override
            public void onSuccess(Integer id) {
                 pedirGrafoBase(grafo);
               // throw new UnsupportedOperationException("Not supported yet.");
            }
        };
     Service.getService().guardarNodoUsuario(nodo,asyncCallback);


    }


public static void guardarNodoDocumento(Nodo nodo,final Grafo grafo){
     final AsyncCallback<Integer> asyncCallback=new AsyncCallback<Integer>() {

            @Override
            public void onFailure(Throwable caught) {
                 PantallaMensaje.mostrarDialogo("Error.No se pudo guardar el Documento",null);
            }

            @Override
            public void onSuccess(Integer id) {
                pedirGrafoBase(grafo);
              //  throw new UnsupportedOperationException("Not supported yet.");
            }
        };
     Service.getService().guardarNodoDocumento(nodo,asyncCallback);


    }


public static void guardarArco(Arco arco,final Grafo grafo){
     final AsyncCallback<Integer> asyncCallback=new AsyncCallback<Integer>() {

            @Override
            public void onFailure(Throwable caught) {
               // Window.alert("no se pudo guardar el arco");
                  PantallaMensaje.mostrarDialogo("Error.No se pudo guardar el arco",null);
            }

            @Override
            public void onSuccess(Integer id) {
                pedirGrafoBase(grafo);
              //  throw new UnsupportedOperationException("Not supported yet.");
            }
        };
     Service.getService().guardarArco(arco,asyncCallback);


    }


public static void editarNodoUsuario(Nodo nodo){
     final AsyncCallback<Void> asyncCallback=new AsyncCallback<Void>() {

            @Override
            public void onFailure(Throwable caught) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void onSuccess(Void result) {
               // throw new UnsupportedOperationException("Not supported yet.");
            }
        };
     Service.getService().editarNodoUsuario(nodo,asyncCallback);


    }

public static void editarNodoDocumento(Nodo nodo){
     final AsyncCallback<Void> asyncCallback=new AsyncCallback<Void>() {

            @Override
            public void onFailure(Throwable caught) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void onSuccess(Void result) {
               // throw new UnsupportedOperationException("Not supported yet.");
            }
        };
     Service.getService().editarNodoDocumento(nodo,asyncCallback);


    }


public static void editarUsuario(Usuario usuario,final Grafo grafo){
     final AsyncCallback<Void> asyncCallback=new AsyncCallback<Void>() {

            @Override
            public void onFailure(Throwable caught) {
                  PantallaMensaje.mostrarDialogo("Error editando el usuario",null);
            }

            @Override
            public void onSuccess(Void result) {
               pedirGrafoBase(grafo);
            }
        };
     Service.getService().editarUsuario(usuario,asyncCallback);


    }

public static void editarDocumento(Documento documento,final Grafo grafo){
     final AsyncCallback<Void> asyncCallback=new AsyncCallback<Void>() {

            @Override
            public void onFailure(Throwable caught) {
               PantallaMensaje.mostrarDialogo("Error editando el documento",null);
            }

            @Override
            public void onSuccess(Void result) {
               pedirGrafoBase(grafo);
            }
        };
     Service.getService().editarDocumento(documento,asyncCallback);


    }
     
public static void eliminarNodoUsuario(Nodo nodo,final Grafo grafo){
     final AsyncCallback<Void> asyncCallback=new AsyncCallback<Void>() {

            @Override
            public void onFailure(Throwable caught) {
                 // Window.alert("no se pudo eliminar el user");
                 PantallaMensaje.mostrarDialogo("Error eliminando el Usuario",null);
            }

            @Override
            public void onSuccess(Void result) {
                pedirGrafoBase(grafo);
               // throw new UnsupportedOperationException("Not supported yet.");
            }
        };
     Service.getService().eliminarNodoUsuario(nodo,asyncCallback);


    }


public static void eliminarNodoDocumento(Nodo nodo,final Grafo grafo){
     final AsyncCallback<Void> asyncCallback=new AsyncCallback<Void>() {

            @Override
            public void onFailure(Throwable caught) {
             //  Window.alert("no se pudo eliminar el doc");
                 PantallaMensaje.mostrarDialogo("Error eliminando el documento",null);
            }

            @Override
            public void onSuccess(Void result) {
                pedirGrafoBase(grafo);
               // throw new UnsupportedOperationException("Not supported yet.");
            }
        };
     Service.getService().eliminarNodoDocumento(nodo,asyncCallback);


    }
   

public static void eliminarArco(Arco arco,final Grafo grafo){
     final AsyncCallback<Void> asyncCallback=new AsyncCallback<Void>() {

            @Override
            public void onFailure(Throwable caught) {
                 PantallaMensaje.mostrarDialogo("Error eliminando el arco",null);
            }

            @Override
            public void onSuccess(Void result) {
               pedirGrafoBase(grafo);
            }
        };
     Service.getService().eliminarArco(arco,asyncCallback);


    }


static public void pedirUsuarios(final Vector<CuentaUsuario> usuarios,final OpcionesAdminGrafoAcordion opcionesAdminGrafoAcordion){

       final AsyncCallback<Vector<CuentaUsuario>> callback = new AsyncCallback<Vector<CuentaUsuario>>() {
            @Override
            public void onSuccess(Vector<CuentaUsuario> result) {
                usuarios.addAll(result);
                opcionesAdminGrafoAcordion.cargarUsuarios(usuarios);





            }

            @Override
            public void onFailure(Throwable caught) {
               PantallaMensaje.mostrarDialogo("Error obteniendo los usuarios",null);

            }
        };

 Service.getService().pedirUsuarios(callback);
}
static public void pedirGrafoFiltrado(final int idGrafo,final ContenedorGrafo contenedorGrafo)
    {
    final AsyncCallback<Grafo> Callback=new AsyncCallback<Grafo>() {


            @Override
            public void onFailure(Throwable caught) {
                Window.alert("No se pudo obtener el Grafo");
            }

            @Override
            public void onSuccess(Grafo result) {
                result.setId(idGrafo);
                contenedorGrafo.marcarGrafo(result);
            }
        };
        Service.getService().pedirGrafoFiltrado(idGrafo, Callback);

    }


static public void importar(){

      //  Window.open("http://localhost:8080/stakeNet0.2.4/SubirArchivo.html","Subir Archivo", null);

      /*  Dialog                  d=new Dialog();
        d.setHTML("<HTML><HEAD><TITLE></TITLE></HEAD><BODY><center><form method=\"POST\" enctype='multipart/form-data' action=\"http://localhost:8080/stakeNet0.2.4/UploadFichero\">"+
"Por favor, seleccione el trayecto del fichero a cargar"+"<br><input type=\"file\" name=\"fichero\">"+
"<input type=\"submit\"></form> </center></BODY></HTML>");

         d.setVisible(true);
          RootPanel.get().add(d);*/
     /*  com.extjs.gxt.ui.client.widget.Window w=new com.extjs.gxt.ui.client.widget.Window();
        FileUpload f=new FileUpload();
       f.setVisible(true);
       w.add(f);
       w.setVisible(true);*/

       final AsyncCallback<Void> callback = new AsyncCallback<Void>() {
            @Override
            public void onSuccess(Void result) {
             // Window.alert("Grafo importado correctamente");
                 PantallaMensaje.mostrarDialogo("Grafo importado correctamente",null);
            }

            @Override
            public void onFailure(Throwable caught) {
                PantallaMensaje.mostrarDialogo("Error importando el grafo",null);

            }
        };

 Service.getService().importar(callback);

}


 public static void validarGrafo(final Grafo grafo){
       final AsyncCallback<Void> callback = new AsyncCallback<Void>() {
            @Override
            public void onSuccess(Void result) {
             // Window.alert("Grafo importado correctamente");
                 PantallaMensaje.mostrarDialogo("Grafo validado correctamente",null);
                     pedirGrafoBase(grafo);
            }

            @Override
            public void onFailure(Throwable caught) {
                PantallaMensaje.mostrarDialogo("Error validando el grafo",null);

            }
        };
         Service.getService().validarGrafo( callback);
 }



    //----------------------------------------

    public static void asignarNodo(Nodo nodo,final int idGrafo,final Grafo grafo,final ContenedorGrafo contenedorGrafo){
          final AsyncCallback<Void> callback = new AsyncCallback<Void>() {
            @Override
            public void onSuccess(Void result) {
             // Window.alert("Grafo importado correctamente");
                // PantallaMensaje.mostrarDialogo("Grafo importado correctamente");
           //     pedirGrafoBase(grafo);
                pedirGrafoFiltrado(idGrafo,contenedorGrafo);
            }

            @Override
            public void onFailure(Throwable caught) {
                PantallaMensaje.mostrarDialogo("Error.No se pudo asignar el Nodo",null);

            }
        };
        Nodo nodoCopia=new Nodo(nodo.getId(),nodo.getInformacion(),nodo.isValido());
         Service.getService().asignarNodo(nodoCopia, idGrafo, callback);
    }

    public static void asignarArco(Arco arco,final int idGrafo, final Grafo grafo,final ContenedorGrafo contenedorGrafo){
          final AsyncCallback<Void> callback = new AsyncCallback<Void>() {
            @Override
            public void onSuccess(Void result) {
             // Window.alert("Grafo importado correctamente");
               //  PantallaMensaje.mostrarDialogo("Grafo importado correctamente");
               //  pedirGrafoBase(grafo);
                pedirGrafoFiltrado(idGrafo,contenedorGrafo);
            }

            @Override
            public void onFailure(Throwable caught) {
                PantallaMensaje.mostrarDialogo("Error.No se pudo asignar el arco",null);

            }
        };
        Nodo nodoCopia=new Nodo(arco.GetNodo().getId(),arco.GetNodo().getInformacion(), arco.GetNodo().isValido());
        Arco arcoCopia=new Arco(nodoCopia,arco.getId(),arco.getIdNodoOrigen(),arco.isValido());
        Service.getService().asignarArco(arcoCopia, idGrafo, callback);
    }

    public static void validarArco(Arco arco,final Grafo grafo){
        final AsyncCallback<Void> callback = new AsyncCallback<Void>() {
            @Override
            public void onSuccess(Void result) {
             // Window.alert("Grafo importado correctamente");
               //  PantallaMensaje.mostrarDialogo("Grafo importado correctamente");
                       pedirGrafoBase(grafo);
            }

            @Override
            public void onFailure(Throwable caught) {
                PantallaMensaje.mostrarDialogo("Error.No se pudo validar el arco",null);

            }
        };
        Nodo nodoCopia=new Nodo(arco.GetNodo().getId(),arco.GetNodo().getInformacion(), arco.GetNodo().isValido());
        Arco arcoCopia=new Arco(nodoCopia,arco.getId(),arco.getIdNodoOrigen(),arco.isValido());
         Service.getService().validarArco(arcoCopia, callback);
    }

    public static void validarNodo(Nodo nodo,final Grafo grafo){
          final AsyncCallback<Void> callback = new AsyncCallback<Void>() {
            @Override
            public void onSuccess(Void result) {
             // Window.alert("Grafo importado correctamente");
              //   PantallaMensaje.mostrarDialogo("Grafo importado correctamente");
                pedirGrafoBase(grafo);
            }

            @Override
            public void onFailure(Throwable caught) {
                PantallaMensaje.mostrarDialogo("Error.No se pudo validar el nodo",null);

            }
        };
            Nodo nodoCopia=new Nodo(nodo.getId(),nodo.getInformacion(),nodo.isValido());
         Service.getService().validarNodo(nodoCopia, callback);
    }

}
