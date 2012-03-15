/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.server.Sesion;

import org.stakeInteraction.server.EscribirArchivo;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.stakeInteraction.server.Base.ManejadorArcosDeUsuario;
import org.stakeInteraction.server.Base.ManejadorCuentaUsuario;
import org.stakeInteraction.server.Base.ManejadorDocumento;
import org.stakeInteraction.server.Base.ManejadorGrafo;
import org.stakeInteraction.server.Base.ManejadorNodo;
import org.stakeInteraction.server.Base.ManejadorNodosDeUsuario;
import org.stakeInteraction.server.Base.ManejadorUsuario;
import org.stakeInteraction.server.ExportarGrafo.ExportadorGrafo;
import org.stakeInteraction.server.ExportarGrafo.VisitanteExportarGML;
import org.stakeInteraction.server.filtro.FiltroArcoGrafoPorUsuario;
import org.stakeInteraction.server.filtro.FiltroNodoGrafoPorUsuario;
import org.stakeInteraction.shared.CuentaUsuario.CuentaUsuario;
import org.stakeInteraction.shared.Informacion.Documento;
import org.stakeInteraction.shared.Informacion.Usuario;
import org.stakeInteraction.shared.grafo.Arco;
import org.stakeInteraction.shared.grafo.Grafo;
import org.stakeInteraction.shared.grafo.Nodo;

/**
 *
 * @author Jorge
 */
public abstract class Sesion {
protected ManejadorGrafo manejadorGrafo;
private CuentaUsuario cuenta;
//private Grafo grafo;

/*public Sesion(){
     manejadorGrafo=new ManejadorGrafo();
     cuenta=null;

}*/

public Sesion(CuentaUsuario cuenta){
     manejadorGrafo=new ManejadorGrafo(cuenta.getGrafo().getId());
     this.cuenta=cuenta;

}

/*
 public CuentaUsuario conectar(String nombre, String contraseña) {

         ManejadorCuentaUsuario m=new ManejadorCuentaUsuario();
      //  CuentaUsuario c=m.getCuentaUsuario(nombre,contraseña);
          cuenta=(CuentaUsuario) m.get("nombre='"+nombre+"' and contraseña='"+contraseña+"'");
     //    System.out.println("cuentaUsuario :"+c.getId()+" "+c.getNombre());
        return cuenta;

    }*/


  
/*
 public Grafo pedirGrafo() {

 


   ManejadorNodo m=new ManejadorNodo();
   Vector<Nodo> nodos=m.cargarListaNodos();
   Grafo grafo= cargarGrafo(nodos);
  grafo.setId(getCuenta().getGrafo().getId());
        getCuenta().setGrafo(grafo);

   return grafo;


    }*/

  public Grafo getGrafoFiltrado(int idGrafo) {

  ManejadorNodosDeUsuario gu=new ManejadorNodosDeUsuario();
         FiltroNodoGrafoPorUsuario fn=new FiltroNodoGrafoPorUsuario(gu.getAll("idGrafo="+idGrafo));
         ManejadorArcosDeUsuario ma= new ManejadorArcosDeUsuario();
         FiltroArcoGrafoPorUsuario fa=new FiltroArcoGrafoPorUsuario(ma.getAll("idGrafo="+idGrafo));//cuenta.getGrafo().getId()));
       //  ManejadorGrafo m=new ManejadorGrafo();
       Grafo grafo=manejadorGrafo.getGrafoFiltrado(fn,fa);

           grafo.setId(getCuenta().getGrafo().getId());
        getCuenta().setGrafo(grafo);

   return grafo;


    }

      private  Grafo cargarGrafo(Vector<Nodo> l){

                Grafo g=new Grafo();
           //     System.out.println("CLIENTE");
                Nodo n=null;
		 for(int i=0;i<l.size();i++){

                   n= l.get(i);


		g.agregarNodo(n);

		 }

                return g;


	}


      public  Grafo getGrafoFiltradoCompleto(int idGrafo) {

  ManejadorNodosDeUsuario gu=new ManejadorNodosDeUsuario();
         FiltroNodoGrafoPorUsuario fn=new FiltroNodoGrafoPorUsuario(gu.getAll("idGrafo="+idGrafo));
         ManejadorArcosDeUsuario ma= new ManejadorArcosDeUsuario();
         FiltroArcoGrafoPorUsuario fa=new FiltroArcoGrafoPorUsuario(ma.getAll("idGrafo="+idGrafo));//cuenta.getGrafo().getId()));
       //  ManejadorGrafo m=new ManejadorGrafo();
       Grafo grafo=manejadorGrafo.getGrafoFiltradoCompleto(fn,fa);

           grafo.setId(getCuenta().getGrafo().getId());
        getCuenta().setGrafo(grafo);

   return grafo;


    }

  /*  public void exportar() {
  
 ExportadorGrafo e=new ExportadorGrafo(this);
 e.exportar();


     /*   Grafo g=this.pedirGrafoFiltradoCompleto(cuenta.getGrafo().getId());
       VisitanteExportarGML vi=new VisitanteExportarGML();
               g.aceptar(vi);

               EscribirArchivo.write("grafoExportar.gml", vi.getLineas());*/
  //  }


  public Usuario getInformacionNodo(Usuario usuario) {
        ManejadorUsuario m=new ManejadorUsuario();
        return (Usuario) m.get(usuario.getId());
    }


    public Documento getInformacionNodo(Documento documento) {
        ManejadorDocumento m=new ManejadorDocumento();
        return (Documento) m.get(documento.getId());
    }


    //----------------------Editar la BD----------------------------------



public abstract int guardarNodoUsuario(Nodo nodo);

public abstract int guardarNodoDocumento(Nodo nodo);

  public abstract void eliminarNodoUsuario(Nodo nodo);


    public abstract void eliminarNodoDocumento(Nodo nodo);

    public abstract int guardarArco(Arco arco);


    public abstract void eliminarArco(Arco arco);



    public void editarNodoUsuario(Nodo nodo) {
       manejadorGrafo.editarNodoUsuario(nodo);
    }


    public void editarNodoDocumento(Nodo nodo) {
      manejadorGrafo.editarNodoDocumento(nodo);
    }



      public void editarUsuario(Usuario usuario) {
       manejadorGrafo.editarUsuario(usuario);
    }


    public void editarDocumento(Documento documento) {
      manejadorGrafo.editarDocumento(documento);
    }

    /**
     * @return the cuenta
     */
    public CuentaUsuario getCuenta() {

        return cuenta;
    }

  

  

    //--------------------Eliminar por usuario solamente--------------------
   /* public void eliminarNodoPorUsuario(Nodo nodo){
          manejadorGrafo.eliminarNodoPorUsuario( cuenta.getGrafo().getId(),nodo);

    }

    public void eliminarArcoPorUsuario(Arco arco){
          manejadorGrafo.eliminarArcoPorUsuario(cuenta.getGrafo().getId(), arco.getId());
    }


     //--------------------para mantener la consistencia entre las tablas de los usuarios y la BD------
  public void eliminarNodoPorTodoUsuario(Nodo nodo){
             manejadorGrafo.eliminarNodoPorTodoUsuario(nodo.getId());
    }
 public void eliminarArcoPorTodoUsuario(Arco arco){
        manejadorGrafo.eliminarArcoPorTodoUsuario(arco.getId());
    }
//-----------------------Agregar Para todo admin----------------------

 public void agregarNodoPorTodoAdmin(Nodo nodo){
     manejadorGrafo.agregarNodoPorTodoAdmin(nodo.getId());

 }

  public void agregarArcoPorTodoAdmin(Arco arco){
     manejadorGrafo.agregarNodoPorTodoAdmin(arco.getId());

 }*/



    /* public int guardarNodoUsuario(Nodo nodo) {

     int id= manejadorGrafo.guardarNodoUsuario(nodo);
     manejadorGrafo.agregarNodoPorUsuario( cuenta.getGrafo().getId(),id);
      return id;
    }


    public int guardarNodoDocumento(Nodo nodo) {

       int id= manejadorGrafo.guardarNodoDocumento(nodo);
      manejadorGrafo.agregarNodoPorUsuario( cuenta.getGrafo().getId(),id);
      return id;
    }*/



    /*  public void eliminarNodoUsuario(Nodo nodo) {
        manejadorGrafo.eliminarNodoUsuario(nodo);

       //       manejadorGrafo.eliminarNodoPorUsuario( cuenta.getGrafo().getId(),nodo.getId());
    }


    public void eliminarNodoDocumento(Nodo nodo) {
       manejadorGrafo.eliminarNodoDocumento(nodo);
      //    manejadorGrafo.eliminarNodoPorUsuario( cuenta.getGrafo().getId(),nodo.getId());
    }


    public int guardarArco(Arco arco) {
     int id= manejadorGrafo.guardarArco(arco);
     manejadorGrafo.agregarArcoPorUsuario(cuenta.getGrafo().getId(), id);
     return id;

    }


    public void eliminarArco(Arco arco) {
       manejadorGrafo.eliminarArco(arco);
       //manejadorGrafo.eliminarArcoPorUsuario(cuenta.getGrafo().getId(), arco.getId());
    }
     */

  /*  public void cerrarSesion(){
        try {
            this.finalize();
        } catch (Throwable ex) {
            Logger.getLogger(Sesion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
}
