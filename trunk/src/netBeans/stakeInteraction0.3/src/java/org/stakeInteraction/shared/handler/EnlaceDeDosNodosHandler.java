/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.shared.handler;


import com.orange.links.client.event.TieLinkEvent;
import com.orange.links.client.event.TieLinkHandler;
import com.google.gwt.user.client.Window;
import org.stakeInteraction.client.GWTServiceUsage;
import org.stakeInteraction.client.ventanaGrafo.mediador.ContenedorGrafo;
import org.stakeInteraction.shared.grafo.Arco;
import org.stakeInteraction.shared.grafo.Nodo;
import org.stakeInteraction.shared.widgets.NodoVisual;


/**
 *
 * @author grela
 */
public class EnlaceDeDosNodosHandler implements TieLinkHandler{

    private ContenedorGrafo contenedorGrafo;
    public EnlaceDeDosNodosHandler(ContenedorGrafo contenedorGrafo)
    {
        this.contenedorGrafo=contenedorGrafo;
    }
    @Override
    public void onTieLink(TieLinkEvent event) {
        NodoVisual nodoVOrigen=((NodoVisual)event.getStartWidget());
        NodoVisual nodoVFin=((NodoVisual)event.getEndWidget());
        Nodo nodoFin=nodoVFin.getNodo();
      //  Nodo nodoFinCopia=new Nodo(NodoFin.getInformacion(),NodoFin.getId(), true);
        Arco arco=new Arco(nodoFin,-1, nodoVOrigen.getNodo().getId(),true);
        this.contenedorGrafo.nuevoArco(arco);
//        new Arco(nodoFin.getNodo(),-1,nodoFin.getId(),true);
  //      GWTServiceUsage.guardarArco(null)*/

       // Window.alert("unidos evento captado");
    }
    /*
    controller.addTieLinkHandler(new TieLinkHandler() {
                        @Override
                        public void onTieLink(TieLinkEvent event) {
                                // Do fun stuff
                        }
                });
*/
}
