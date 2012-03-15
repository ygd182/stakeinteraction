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
import java.io.Serializable;
import org.stakeInteraction.client.ventanaGrafo.mediador.ContenedorGrafo;
import org.stakeInteraction.shared.grafo.Nodo;
import org.stakeInteraction.shared.widgets.NodoVisual;

/**
 *
 * @author grela
 */
public class GrafoNodoDocHanlder implements MouseDownHandler,Serializable {

    private ContenedorGrafo contenedorGrafo;
    private Menu contextMenu;
    public GrafoNodoDocHanlder(ContenedorGrafo contenedorGrafo,Menu contextMenu)
    {
        this.contenedorGrafo=contenedorGrafo;
        this.contextMenu=contextMenu;
        
    }
    @Override
    public void onMouseDown(MouseDownEvent event) {
         NodoVisual nodoVisual=(NodoVisual)event.getSource();
         Nodo nodo=nodoVisual.getNodo();

         if(event.getNativeButton()==NativeEvent.BUTTON_RIGHT)
         {
         /*   Menu contextMenu = new Menu();
             contextMenu.setWidth(140);

          MenuItem eliminar = new MenuItem();
          eliminar.setText("Eliminar Nodo");


//insert.setIcon(ICONS.add());
          contextMenu.add(eliminar);*/
          ContexMenuNodoDocHandler contextMenuNodoHandler=new ContexMenuNodoDocHandler(contextMenu,contenedorGrafo,nodo);



//contextMenu.isVisible(true);
           contextMenu.show(nodoVisual);
         }
    }
}
