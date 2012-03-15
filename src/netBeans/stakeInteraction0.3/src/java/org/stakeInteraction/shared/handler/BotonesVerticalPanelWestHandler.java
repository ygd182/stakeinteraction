/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.shared.handler;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;

import com.extjs.gxt.ui.client.widget.button.Button;
import com.google.gwt.user.client.Window;
import org.stakeInteraction.client.ventanaGrafo.mediador.ContentPanelPrincipal;
import org.stakeInteraction.client.ventanaGrafo.mediador.OpcionesAdminGrafoAcordion;
/**
 *
 * @author grela
 */
public class BotonesVerticalPanelWestHandler implements Listener<ButtonEvent> {

    private Button botonCrearDocumento;
    private Button botonCrearUsuario;
    private Button botonValidarTodo;
    //private ContentPanelPrincipal contentPanelPrincipal;
    private OpcionesAdminGrafoAcordion opcionesAdminGrafoAcordion;
    public BotonesVerticalPanelWestHandler(OpcionesAdminGrafoAcordion opcionesAdminGrafoAcordion,Button botonCrearDocumento,Button botonCrearUsuario,Button botonValidarTodo)
    {
        this.botonCrearDocumento=botonCrearDocumento;
        this.botonCrearUsuario=botonCrearUsuario;
        this.botonValidarTodo=botonValidarTodo;
        this.botonCrearDocumento.addListener(Events.OnClick, this);
        this.botonCrearUsuario.addListener(Events.OnClick, this);
        this.botonValidarTodo.addListener(Events.OnClick, this);
        //this.contentPanelPrincipal=contentPanelPrincipal;
        this.opcionesAdminGrafoAcordion=opcionesAdminGrafoAcordion;
    }

    @Override
    public void handleEvent(ButtonEvent be) {
        if(be.getButton()==botonCrearDocumento)
        {
      //    Window.alert( "botonCrearDoc ");
          this.opcionesAdminGrafoAcordion.presionarBotonCrearDocumento();
          this.opcionesAdminGrafoAcordion.modificado();
        }
        else
        {
            if(be.getButton()==botonCrearUsuario)
            {

              this.opcionesAdminGrafoAcordion.presionarBotonCrearUsuario();
              this.opcionesAdminGrafoAcordion.modificado();
            }
             else{
                if(be.getButton()==botonValidarTodo){
                    this.opcionesAdminGrafoAcordion.presionarBotonValidarTodo();
                     this.opcionesAdminGrafoAcordion.modificado();
                }
             }
        }

    }

}
