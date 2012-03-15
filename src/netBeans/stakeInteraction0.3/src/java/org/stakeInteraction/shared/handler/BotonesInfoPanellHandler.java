/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.shared.handler;


import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.button.Button;
import org.stakeInteraction.client.ventanaGrafo.mediador.ContenedorGrafo;
import org.stakeInteraction.client.ventanaGrafo.mediador.PanelDeInformacion;
import org.stakeInteraction.shared.grafo.Nodo;
import org.stakeInteraction.shared.ventanaInfo.VentanaInfo;


/**
 *
 * @author grela
 */
public class BotonesInfoPanellHandler implements Listener<ButtonEvent> {

    //private VentanaPrincipal ventanaPrincipal;
    //private ContenedorGrafo contenedorGrafo;
    private Button botonVerInfo;
    private PanelDeInformacion panelDeInformacion;

    public BotonesInfoPanellHandler(Button botonVerInfo,PanelDeInformacion panelDeInformacion)
    {
      //  this.panelDeInformacion=panelDeInformacion;

        this.botonVerInfo=botonVerInfo;
        this.botonVerInfo.addListener(Events.OnClick, this);
        this.panelDeInformacion=panelDeInformacion;

    }


    @Override
    public void handleEvent(ButtonEvent be) {
        this.panelDeInformacion.presionarBotonVerDetalles(true);
        this.panelDeInformacion.modificado();
    }

}
