/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.shared.EstrategiaDibujar;


import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.InlineHTML;
import com.google.gwt.user.client.ui.Widget;
import org.stakeInteraction.shared.Informacion.Documento;



import java.io.Serializable;
import org.stakeInteraction.client.GWTServiceUsage;
import org.stakeInteraction.client.ventanaGrafo.mediador.ContenedorGrafo;
import org.stakeInteraction.shared.Informacion.Informacion;
import org.stakeInteraction.shared.ventanaInfo.VentanaInfo;
import org.stakeInteraction.shared.widgets.NodoVisual;
import org.stakeInteraction.shared.grafo.Nodo;
import org.stakeInteraction.shared.handler.GrafoNodoDocHanlder;
import org.stakeInteraction.shared.ventanaInfo.VentanaDoc;





/**
 *
 * @author grela
 */
public class EstrategiaDibujarDoc implements Serializable, EstrategiaDibujarNodo
{

    


    
    
    public EstrategiaDibujarDoc()
    {
       
        

    }
    
  


    @Override
    public NodoVisual crearNodoVisual(Nodo nodo,ContenedorGrafo contenedorGrafo,Menu contextMenu)
    {
        NodoVisual nodoVisual=new NodoVisual(nodo);
        nodoVisual.setDirImagenAceptado("imagen/doc1.gif");
         nodoVisual.setDirImagenNoAceptado("imagen/doc1NoAceptado.gif");
         nodoVisual.setDirImagenSeleccionado("imagen/doc1Seleccionado.gif");
         nodoVisual.setDirImagenNoAceptadoSeleccionado("imagen/doc1NoAceptadoSeleccionado.gif");
        nodoVisual.contraerTexto();
        nodoVisual.dibujar();
        nodoVisual.addMouseDownHandler(new GrafoNodoDocHanlder(contenedorGrafo,contextMenu));
        //nodoVisual.add
      //  nodoVisual.addMouseOutHandler(nodoMouseOverOutHandler);
        //nodoVisual.addClickHandler(nodoMouseOverOutHandler);
        //nodoVisual.addMouseOverHandler(nodoMouseOverOutHandler);
     //   nodoVisual.addMouseDownHandler(nodoMouseOverOutHandler);


    



        return nodoVisual;

    }

    @Override
    public VentanaInfo crearVentanaInfo(Informacion info,ContenedorGrafo contenedorGrafo) {
        VentanaDoc ventanaDoc=new VentanaDoc();
        ventanaDoc.setVentanaActualizar(contenedorGrafo);
        Documento doc=(Documento)info;
        GWTServiceUsage.pedirInformacionNodoBaseDocumento(doc,ventanaDoc);
        

        return ventanaDoc;
    }
  

}

