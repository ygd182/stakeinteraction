/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.shared.handler;

import com.extjs.gxt.ui.client.event.MenuEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;

import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.event.logical.shared.AttachEvent.Handler;
import com.google.gwt.user.client.Window;
import com.orange.links.client.connection.Connection;
import org.stakeInteraction.client.ventanaGrafo.mediador.ContenedorGrafo;
import org.stakeInteraction.shared.grafo.Arco;
import org.stakeInteraction.shared.grafo.Nodo;



/**
 *
 * @author grela
 */
public class ContexMenuArcoHandler extends SelectionListener<MenuEvent> {

    private Arco arco;
    private Menu contextMenu;
    private ContenedorGrafo contenedorGrafo;
    public ContexMenuArcoHandler(Arco arco,Menu contextMenu,ContenedorGrafo contenedorGrafo)
    {
        this.arco=arco;
        this.contextMenu=contextMenu;
        this.contenedorGrafo=contenedorGrafo;
        int coun= this.contextMenu.getItemCount();
        MenuItem eliminar=(MenuItem)this.contextMenu.getItemByItemId("ELIMINAR_ARCO");
        MenuItem asignarArco=(MenuItem)this.contextMenu.getItemByItemId("ASIGNAR_ARCO");
        MenuItem validarArco=(MenuItem)this.contextMenu.getItemByItemId("VALIDAR_ARCO");
          
       eliminar.addSelectionListener(this);
       if(asignarArco!=null)
         asignarArco.addSelectionListener(this);
         if(validarArco!=null)
         validarArco.addSelectionListener(this);
    }
 
 public void setArco(Arco arco)
    {
     this.arco=arco;
 }

    @Override
    public void componentSelected(MenuEvent ce) {

        if(ce.getItem()==this.contextMenu.getItemByItemId("ELIMINAR_ARCO"))
        {
            
           this.contenedorGrafo.eliminarArco(arco);

        }
        else
        {
            if(ce.getItem()==this.contextMenu.getItemByItemId("ASIGNAR_ARCO"))
            {
                

               contenedorGrafo.asignarArco(arco);
            }
            else
            {
                  if(ce.getItem()==this.contextMenu.getItemByItemId("VALIDAR_ARCO"))
                        {


                           contenedorGrafo.validarArco(arco);
                        }
            }
        }

    }

   

}
