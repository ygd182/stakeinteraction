/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.shared.handler;

import com.extjs.gxt.ui.client.event.MenuEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;

import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.google.gwt.user.client.Window;
import org.stakeInteraction.client.GWTServiceUsage;
import org.stakeInteraction.client.ventanaGrafo.mediador.ContenedorGrafo;
import org.stakeInteraction.shared.grafo.Nodo;

/**
 *
 * @author grela
 */
public class ContexMenuNodoUserHandler extends ContexMenuNodoHandler {

    
    /*  private Menu contexMenu;
    private ContenedorGrafo contenedorGrafo;
    private Nodo nodo;
*/
    public ContexMenuNodoUserHandler(Menu contextMenu,ContenedorGrafo contenedorGrafo,Nodo nodo) {
        super(contextMenu, contenedorGrafo, nodo);
        /* this.nodo=nodo;
       this.contexMenu=contextMenu;
       this.contenedorGrafo=contenedorGrafo;

       int coun= this.contexMenu.getItemCount();
       MenuItem eliminarNodo= (MenuItem)this.contexMenu.getItemByItemId("ELIMINAR_NODO");
       eliminarNodo.removeAllListeners();
       eliminarNodo.addSelectionListener(this);

       MenuItem asignarNodo=(MenuItem)this.contexMenu.getItemByItemId("ASIGNAR_NODO");
       if(asignarNodo!=null)
       {
           asignarNodo.removeAllListeners();
           asignarNodo.addSelectionListener(this);
       }*/
    }



    @Override
    public void componentSelected(MenuEvent ce) {
      if(ce.getItem()==(MenuItem)this.contexMenu.getItemByItemId("ELIMINAR_NODO"))
      {
         this.contenedorGrafo.eliminarUser(nodo);
      }
      else
      {
          if(ce.getItem()==this.contexMenu.getItemByItemId("ASIGNAR_NODO"))
            {
                this.contenedorGrafo.asignarNodo(nodo);


            }
          else
            if(ce.getItem()==this.contexMenu.getItemByItemId("VALIDAR_NODO"))
            {
              this.contenedorGrafo.validarNodo(nodo);
            }
      }

    }

}
