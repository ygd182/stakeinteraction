/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.server.Sesion;

import org.stakeInteraction.server.EscribirArchivo;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.stakeInteraction.server.Base.ManejadorCuentaUsuario;
import org.stakeInteraction.server.Base.ManejadorGrafo;
import org.stakeInteraction.server.Importar.ImportadorGrafo;
import org.stakeInteraction.server.Importar.ImportarGML;
import org.stakeInteraction.server.ValidarCambiosGrafo.ValidadorGrafo;
import org.stakeInteraction.server.ValidarCambiosGrafo.VisitanteValidadorSimple;
import org.stakeInteraction.shared.CuentaUsuario.CuentaUsuario;
import org.stakeInteraction.shared.grafo.Arco;
import org.stakeInteraction.shared.grafo.Grafo;
import org.stakeInteraction.shared.grafo.Nodo;

/**
 *
 * @author Jorge
 */
public class SesionAdmin extends Sesion{

    public  SesionAdmin(CuentaUsuario cuenta){
        super(cuenta);
    }
    @Override
    public int guardarNodoUsuario(Nodo nodo) {
       nodo.setValido(true);
  
     int id= manejadorGrafo.guardarNodoUsuario(nodo);
     manejadorGrafo.agregarNodoPorUsuario(id);
      return id;
    }


    @Override
    public int guardarNodoDocumento(Nodo nodo) {
       nodo.setValido(true);
           
       int id= manejadorGrafo.guardarNodoDocumento(nodo);
      manejadorGrafo.agregarNodoPorUsuario( id);
      return id;
    }


   /* @Override
    public void editarNodoUsuario(Nodo nodo) {
       manejadorGrafo.editarNodoUsuario(nodo);
    }


    @Override
    public void editarNodoDocumento(Nodo nodo) {
      manejadorGrafo.eliminarNodoDocumento(nodo);
    }*/


    @Override
    public void eliminarNodoUsuario(Nodo nodo) {
        manejadorGrafo.eliminarNodoUsuario(nodo);

       //       manejadorGrafo.eliminarNodoPorUsuario( cuenta.getGrafo().getId(),nodo.getId());
          manejadorGrafo.eliminarNodoPorTodoUsuario( nodo);
    }


    @Override
    public void eliminarNodoDocumento(Nodo nodo) {
       manejadorGrafo.eliminarNodoDocumento(nodo);
      //    manejadorGrafo.eliminarNodoPorUsuario( cuenta.getGrafo().getId(),nodo.getId());
       manejadorGrafo.eliminarNodoPorTodoUsuario( nodo);
    }


    @Override
    public int guardarArco(Arco arco) {
     arco.setValido(true);
     int id= manejadorGrafo.guardarArco(arco);
     manejadorGrafo.agregarArcoPorUsuario( id);
     return id;

    }


    @Override
    public void eliminarArco(Arco arco) {
       manejadorGrafo.eliminarArco(arco);
       //manejadorGrafo.eliminarArcoPorUsuario(cuenta.getGrafo().getId(), arco.getId());
      manejadorGrafo.eliminarArcoPorTodoUsuario(arco.getId());
    }


    public Vector<CuentaUsuario> getUsuarios(){
        ManejadorCuentaUsuario m=new ManejadorCuentaUsuario();
        Vector<CuentaUsuario> cuentas= new Vector<CuentaUsuario>();
        Vector<Object> c=m.getAll(" tipo='user'");
        for(int i=0;i<c.size();i++){
            cuentas.add((CuentaUsuario) c.get(i));
            System.out.println(cuentas.get(i).getNombre());
        }
        return cuentas ;
    }


    public void eliminarGrafo(){
         manejadorGrafo.eliminarGrafos(); //vacio la base
    }

   /* public void importar(){
    //   EscribirArchivo.write("grafo.gml",  this.exportar());

        ImportadorGrafo i=new ImportadorGrafo(this);
        i.importar();
*/

     /*   manejadorGrafo.eliminarGrafos(); //vacio la base

      
         ImportarGML l=new ImportarGML();
         l.importar();//esto arranca y carga todo
        //-----------------------------------------
        Collection<Nodo> nodosDoc=l.getNodosDoc();
        Iterator it=nodosDoc.iterator();
        Nodo nodoDoc=null;

       // for(int i=0;i<nodosDoc.size();i++){
        while(it.hasNext()){
            nodoDoc=(Nodo) it.next();

            this.guardarNodoDocumento(nodoDoc);
        }

        //---------------------------------------

      Collection<Nodo> nodosUser=l.getNodosUser();
       it=nodosUser.iterator();
              Nodo nodoUser=null;
       while(it.hasNext()){
            nodoUser=(Nodo) it.next();

            this.guardarNodoUsuario(nodoUser);
        }

           //-------------------------------
              Vector<Arco> arcos=l.getArcos();
              Arco arco=null;
         for(int i=0;i<arcos.size();i++){
           arco=arcos.elementAt(i);

            this.guardarArco(arco);
        }*/

//    }

  //  public void validarGrafo(/*VisitanteValidadorSimple v*/){ //o le puedo pasar el grafo
        /*Grafo g=manejadorGrafo.getGrafoCompleto();

        VisitanteValidadorSimple v=new VisitanteValidadorSimple(this);
        g.aceptar(v);*/
       /* ValidadorGrafo v=new ValidadorGrafo(this);
        v.validarGrafo();
        
    }*/


    public void validarNodo(Nodo nodo){
       if(!nodo.isValido()){
            nodo.setValido(true);
          manejadorGrafo.editarNodo(nodo);

        }
    }

    public void validarArco(Arco arco){
           if(!arco.isValido()){
            arco.setValido(true);
          manejadorGrafo.editarArco(arco);

        }
    }


    public void asignarNodo(Nodo nodo,int idGrafo){
        ManejadorGrafo m=new ManejadorGrafo(idGrafo);
        m.agregarNodoPorUsuario(nodo.getId());
    }

    public void asignarArco(Arco arco,int idGrafo){
        ManejadorGrafo m=new ManejadorGrafo(idGrafo);
        m.agregarArcoPorUsuario(arco.getId());
    }

}
