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
import org.stakeInteraction.shared.ventanaInfo.VentanaDoc;
import org.stakeInteraction.shared.ventanaInfo.VentanaInfo;

/**
 *
 * @author grela
 */
public class BotonActualizaroCrearDocumentoHandler  implements Listener<ButtonEvent>{
      private Button botonGuardar;
     private VentanaDoc ventanaDoc;
     private ContenedorGrafo contenedorGrafo;

     public BotonActualizaroCrearDocumentoHandler(VentanaDoc ventanaDoc,ContenedorGrafo contenedorGrafo)
    {
         this.ventanaDoc=ventanaDoc;
         this.botonGuardar=ventanaDoc.getBotonGuardar();
         this.botonGuardar.addListener(Events.OnClick, this);
         this.contenedorGrafo=contenedorGrafo;
     }


    @Override
    public void handleEvent(ButtonEvent be) {
          if(be.getButton().getText()=="Actualizar")
          {
           this.ventanaDoc.copiarCamposADocumento();
           this.contenedorGrafo.actualizarDoc(this.ventanaDoc.getDocumento());
           
           this.ventanaDoc.cerrarVentana();
      
          }
            else
            if(be.getButton().getText()=="Crear")
            {
               // Window.alert("Se ha creado un nododoc");
                this.ventanaDoc.copiarCamposADocumento();
                this.contenedorGrafo.nuevoNodoVisualDocumento(this.ventanaDoc.getDocumento());
                this.ventanaDoc.cerrarVentana();

            }



        

        //throw new UnsupportedOperationException("Not supported yet.");
    }

}
