/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.shared.handler;

import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.MenuEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import org.stakeInteraction.client.ventanaGrafo.mediador.ContenedorGrafo;
import org.stakeInteraction.shared.grafo.Nodo;

/**
 *
 * @author grela
 */
public abstract class ContexMenuNodoHandler extends SelectionListener<MenuEvent>{

     protected Menu contexMenu;
    protected ContenedorGrafo contenedorGrafo;
    protected Nodo nodo;
   public ContexMenuNodoHandler(Menu contextMenu,ContenedorGrafo contenedorGrafo,Nodo nodo)
    {
       this.nodo=nodo;
       this.contexMenu=contextMenu;
       this.contenedorGrafo=contenedorGrafo;

       int coun= this.contexMenu.getItemCount();
       MenuItem eliminarNodo=(MenuItem)this.contexMenu.getItemByItemId("ELIMINAR_NODO");
       eliminarNodo.removeAllListeners();
       eliminarNodo.addSelectionListener(this);
       MenuItem asignarNodo=(MenuItem)this.contexMenu.getItemByItemId("ASIGNAR_NODO");
       configurarContextMenuAsignar(asignarNodo);
       MenuItem validarNodo=(MenuItem)this.contexMenu.getItemByItemId("VALIDAR_NODO");
       configurarContextMenuValidar(validarNodo);
    }
    public void configurarContextMenuAsignar(MenuItem asignarNodo)
    {
         if(asignarNodo!=null)
       {
           asignarNodo.removeAllListeners();
           asignarNodo.addSelectionListener(this);
           if(nodo.getNodoVisual().isMarcado()||(!nodo.isValido()))//esto es para no asignar nodos invalidos
           {
               asignarNodo.disable();
           }
           else
           {
               if(contenedorGrafo.getGrafoIdSeleccionado()==-1)
               {
                   asignarNodo.disable();
               }
               else
               {
                  asignarNodo.enable();
               }
           }
       }
    }
     public void configurarContextMenuValidar(MenuItem validarNodo)
    {
         if(validarNodo!=null)
       {
           validarNodo.removeAllListeners();
           validarNodo.addSelectionListener(this);
           if(nodo.isValido())
           {
               validarNodo.disable();
           }
           else
           {
         /*      if(contenedorGrafo.getGrafoIdSeleccionado()==-1)
               {
                   validarNodo.disable();
               }
               else
               {*/
                  validarNodo.enable();
               //}
           }
       }
    }


}
