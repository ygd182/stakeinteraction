/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.server.ValidarCambiosGrafo;

import java.util.List;
import java.util.Vector;
import org.stakeInteraction.server.Sesion.SesionAdmin;
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
public class VisitanteValidadorSimple implements VisitanteGrafo  {

SesionAdmin sesion;

   public VisitanteValidadorSimple(SesionAdmin sesion){
       this.sesion=sesion;
   }


   @Override
    public void visitarGrafo(Grafo grafo) {
        Vector<Nodo> allNodos=grafo.getAllNodos();

        Nodo n=null;
        for(int i=0;i<allNodos.size();i++){
            n= allNodos.elementAt(i);
            n.aceptar(this);


      }
    }

    @Override
    public void visitarNodo(Nodo nodo) {

        if(!nodo.isValido()){
            sesion.validarNodo(nodo);
          /*  nodo.setValido(true);
          ManejadorGrafo.editarNodo(nodo);*/

        }

        List<Arco> ady=nodo.getAdyacentes();
                Arco a=null;
               for(int i=0;i<ady.size();i++){
                   a=ady.get(i);
                   a.aceptar(this);

               }
    }

    @Override
    public void visitarArco(Arco arco) {
       if(!arco.isValido()){
           sesion.validarArco(arco);
          /*  arco.setValido(true);
          ManejadorGrafo.editarArco(arco);*/

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

}
