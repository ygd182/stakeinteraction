/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.server.FiltradorGrafo;

import java.util.List;
import java.util.Vector;
import org.stakeInteraction.server.filtro.FiltroArco;
import org.stakeInteraction.server.filtro.FiltroNodo;
import org.stakeInteraction.shared.VisitanteGrafo.VisitanteGrafo;
import org.stakeInteraction.shared.Informacion.Documento;
import org.stakeInteraction.shared.Informacion.Usuario;
import org.stakeInteraction.shared.grafo.Arco;
import org.stakeInteraction.shared.grafo.Grafo;
import org.stakeInteraction.shared.grafo.Nodo;

/**
 *
 * @author Jorge
 */
public class VisitanteFiltradorGrafo implements VisitanteGrafo{

  private  Grafo grafoAux;
  private Nodo nodoAux;
  FiltroNodo fn;
  FiltroArco fa;
  int adyCount;


    public VisitanteFiltradorGrafo(FiltroNodo fn, FiltroArco fa){

        this.fa=fa;
        this.fn=fn;
        adyCount=0;
      
    }

     /*  public Grafo getGrafoFiltrado(FiltroNodo fn, FiltroArco fa){
        ManejadorNodo m=new ManejadorNodo();
        Vector<Nodo> nodos=m.cargarListaNodos();
        Grafo g=new Grafo();
           //     System.out.println("CLIENTE");
                Nodo n=null;
                Arco a=null;
                List<Arco> ady=null;
       for(int i=0;i<nodos.size();i++){

                   n= nodos.get(i);

              if(fn.comparar(n.getId())){


                   ady=n.getAdyacentes();  //esto es lo de los adyacentes

                    for(int j=0;j<ady.size();j++){
                        a=ady.get(j);

                        if(!(fa.comparar(a.getId()))){ //filtro los arcos
                            ady.remove(j);
                            j--;

                        }
                     }
                   g.agregarNodo(n);
                    }
        }


        grafo.clonar(g);
        return g;
    }*/


    @Override
    public void visitarGrafo(Grafo grafo) {

         grafoAux=new Grafo(grafo.getId());
         Vector<Nodo> nodos=grafo.getAllNodos();
           Nodo n=null;
               

       for(int i=0;i<nodos.size();i++){

                   n= nodos.get(i);
                   n.aceptar(this);
                
        }


    }

    @Override
    public void visitarNodo(Nodo nodo) {
       
         if(fn.filtrar(nodo)){


             // nodoAux=new Nodo(nodo.getId(),nodo.getInformacion(),nodo.isValido());
             nodoAux=nodo;
             List<Arco> ady=null;
             Arco a=null;
             ady=nodo.getAdyacentes();  //esto es lo de los adyacentes
                     for( adyCount=0;adyCount<ady.size();adyCount++){
                        a=ady.get(adyCount);
                        a.aceptar(this);


             }
                grafoAux.agregarNodo(nodoAux);
        }

    }

    @Override
    public void visitarArco(Arco arco) {
        
          if(!(fa.filtrar(arco))){ //filtro los arcos
                          nodoAux.eliminarAdyacente(arco.getId());
                          adyCount--;

                            System.out.println(arco.getId());

    }
    }

    @Override
    public void visitarUsuario(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void visitarDocumento(Documento documento) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    public Grafo getGrafo(){
        return  grafoAux;
    }

}
