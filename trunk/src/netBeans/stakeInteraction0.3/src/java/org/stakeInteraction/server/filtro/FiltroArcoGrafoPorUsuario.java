/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.server.filtro;

import java.util.Vector;
import org.stakeInteraction.shared.grafo.Arco;

/**
 *
 * @author Jorge
 */
public class FiltroArcoGrafoPorUsuario implements FiltroArco {

      private Vector<Object> arcos;

    public FiltroArcoGrafoPorUsuario(Vector<Object> arcos){
       this.arcos=arcos;
       /*  System.out.println("nodos de grafo");
         for(int j=0;j<nodos.size();j++){
            System.out.println(nodos.get(j));

         }*/
    }





    @Override
    public boolean filtrar(Arco arco) {
       if(arcos.contains(arco.getId()))
           return true;
       else
           return false;
    }

}
