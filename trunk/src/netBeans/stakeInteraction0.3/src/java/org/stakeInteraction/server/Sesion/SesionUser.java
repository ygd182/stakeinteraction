/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.server.Sesion;

import org.stakeInteraction.shared.CuentaUsuario.CuentaUsuario;
import org.stakeInteraction.shared.grafo.Arco;
import org.stakeInteraction.shared.grafo.Nodo;

/**
 *
 * @author Jorge
 */
public class SesionUser extends Sesion {

    
    public  SesionUser(CuentaUsuario cuenta){
        super(cuenta);
    }
    @Override
    public int guardarNodoUsuario(Nodo nodo) {
       
        nodo.setValido(false);
       //   System.out.println("valido user"+nodo.isValido());

     int id= manejadorGrafo.guardarNodoUsuario(nodo);
     manejadorGrafo.agregarNodoPorUsuario( id);
     manejadorGrafo.agregarNodoPorTodoAdmin(id);
      return id;
    }


    @Override
    public int guardarNodoDocumento(Nodo nodo) {
       nodo.setValido(false);
     //  System.out.println("valido user"+nodo.isValido());
       int id= manejadorGrafo.guardarNodoDocumento(nodo);
      manejadorGrafo.agregarNodoPorUsuario( id);
      manejadorGrafo.agregarNodoPorTodoAdmin(id);
      return id;
    }


  /*  @Override
    public void editarNodoUsuario(Nodo nodo) {
       manejadorGrafo.editarNodoUsuario(nodo);
    }


    @Override
    public void editarNodoDocumento(Nodo nodo) {
      manejadorGrafo.eliminarNodoDocumento(nodo);
    }*/


    @Override
    public void eliminarNodoUsuario(Nodo nodo) {

        manejadorGrafo.eliminarNodoPorUsuario( nodo);
         System.out.println("valido user"+nodo.isValido());
        if(!nodo.isValido()){
              manejadorGrafo.eliminarNodoUsuario(nodo);
                manejadorGrafo.eliminarNodoPorTodoUsuario( nodo);
        }
    }


    @Override
    public void eliminarNodoDocumento(Nodo nodo) {

          manejadorGrafo.eliminarNodoPorUsuario( nodo);
          System.out.println("valido doc"+nodo.isValido());
          if(!nodo.isValido()){
              manejadorGrafo.eliminarNodoDocumento(nodo);
                manejadorGrafo.eliminarNodoPorTodoUsuario( nodo);
        }
    }


    @Override
    public int guardarArco(Arco arco) {
        arco.setValido(false);
     int id= manejadorGrafo.guardarArco(arco);
     manejadorGrafo.agregarArcoPorUsuario( id);
     manejadorGrafo.agregarArcoPorTodoAdmin(id);
     return id;

    }


    @Override
    public void eliminarArco(Arco arco) {

       manejadorGrafo.eliminarArcoPorUsuario( arco.getId());
       if(!arco.isValido()){
           manejadorGrafo.eliminarArco(arco);
             manejadorGrafo.eliminarArcoPorTodoUsuario(arco.getId());
        }
    }

}
