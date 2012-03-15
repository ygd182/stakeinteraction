/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.shared.handler;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;

import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.event.Listener;
import com.google.gwt.dev.protobuf.Service;
import com.google.gwt.user.client.Window;
import org.stakeInteraction.client.GWTServiceUsage;
import org.stakeInteraction.client.ventanaGrafo.mediador.ContenedorGrafo;
import org.stakeInteraction.shared.ventanaInfo.VentanaInfo;
import org.stakeInteraction.shared.ventanaInfo.VentanaUser;



/**
 *
 * @author grela
 */
public class BotonActualizarCrearUsuarioHandler implements Listener<ButtonEvent>{
     private Button botonGuardar;
     private VentanaUser ventanaUser;
     private ContenedorGrafo contenedorGrafo;

     public BotonActualizarCrearUsuarioHandler(VentanaUser ventanaUser,ContenedorGrafo contenedorGrafo)
    {
         this.ventanaUser=ventanaUser;
         this.botonGuardar=ventanaUser.getBotonGuardar();
         this.botonGuardar.addListener(Events.OnClick, this);
         this.contenedorGrafo=contenedorGrafo;
     }
     

    @Override
    public void handleEvent(ButtonEvent be) {
        if(be.getButton().getText()=="Actualizar")
        {

           this.ventanaUser.copiarCamposAUsuario();
           this.contenedorGrafo.actualizarUser(ventanaUser.getUsuario());
           
           this.ventanaUser.cerrarVentana();
           
        }
        else
            if(be.getButton().getText()=="Crear")
            {
             //   Window.alert("Se ha creado un nodouser");
                ventanaUser.copiarCamposAUsuario();
                contenedorGrafo.nuevoNodoVisualUsuario(ventanaUser.getUsuario());
                this.ventanaUser.cerrarVentana();

            }


        //Window.alert( " clicked");

        //throw new UnsupportedOperationException("Not supported yet.");
    }

}
