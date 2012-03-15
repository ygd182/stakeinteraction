/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.server.filtro;

import java.util.Vector;
import org.stakeInteraction.shared.grafo.Nodo;

/**
 *
 * @author Jorge
 */
public class FiltroNodoGrafoPorUsuario implements FiltroNodo {
     private Vector<Object> nodos;
    
    public FiltroNodoGrafoPorUsuario(Vector<Object> nodos){
       this.nodos=nodos;
       /*  System.out.println("nodos de grafo");
         for(int j=0;j<nodos.size();j++){
            System.out.println(nodos.get(j));

         }*/
    }





    @Override
    public boolean filtrar(Nodo nodo) {
       if(nodos.contains(nodo.getId()))
           return true;
       else
           return false;
    }

   /* private boolean contiene(int id){
        int aux=-1;
           for(int j=0;j<nodos.size();j++){
               aux=(Integer)nodos.get(j);
                if(aux==id)
                    return true;
           }
           return false;
    }*/
   
}


