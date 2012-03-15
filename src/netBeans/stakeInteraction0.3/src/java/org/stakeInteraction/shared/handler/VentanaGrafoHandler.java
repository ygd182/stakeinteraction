/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.shared.handler;

import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.WindowEvent;
import com.google.gwt.user.client.ui.Widget;
import org.stakeInteraction.client.ventanaGrafo.mediador.VentanaPrincipal;







/**
 *
 * @author grela
 */
public class VentanaGrafoHandler implements  Listener<WindowEvent>
{
    private VentanaPrincipal ventanaPrincipal;
    public VentanaGrafoHandler(VentanaPrincipal ventanaPrincipal)
    {
        this.ventanaPrincipal=ventanaPrincipal;
    }

    @Override
public void handleEvent(WindowEvent we) {

         System.out.println( "Resize event: " + we );
            System.out.println( "   Size in event: " + we.getWidth() + "x" + we.getHeight() );
            System.out.println( "   Size of window: " + we.getWindow().getSize() );
            this.ventanaPrincipal.modificado();



    }


}
