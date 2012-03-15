/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.shared.handler;



import com.extjs.gxt.ui.client.widget.menu.Menu;

import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.user.client.Window;

import java.io.Serializable;
import org.stakeInteraction.client.ventanaGrafo.mediador.ContenedorGrafo;
import org.stakeInteraction.client.ventanaGrafo.mediador.PanelDeInformacion;
import org.stakeInteraction.client.ventanaGrafo.mediador.VerticalPanelInfoBorrar;
import org.stakeInteraction.shared.grafo.Nodo;
import org.stakeInteraction.shared.widgets.NodoVisual;

/**
 *
 * @author grela
 */
public class GrafoNodoHandler implements MouseDownHandler,Serializable {

    ContenedorGrafo contenedorGrafo;

    PanelDeInformacion panelDeInformacion;



    public GrafoNodoHandler(ContenedorGrafo contenedorGrafo,PanelDeInformacion panelDeInformacion)
    {
        this.contenedorGrafo=contenedorGrafo;
        this.panelDeInformacion=panelDeInformacion;



        
    }

    @Override
    public void onMouseDown(MouseDownEvent event) {
         NodoVisual nodoVisual=(NodoVisual)event.getSource();
         Nodo nodo=nodoVisual.getNodo();
         this.contenedorGrafo.setNodoSeleccionado(nodo);
         this.panelDeInformacion.modificado();
    }
   



}
