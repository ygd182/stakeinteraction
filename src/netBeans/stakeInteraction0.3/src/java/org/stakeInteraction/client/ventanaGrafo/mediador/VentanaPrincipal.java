/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.client.ventanaGrafo.mediador;

import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.WindowEvent;
import com.extjs.gxt.ui.client.event.WindowListener;
import com.extjs.gxt.ui.client.widget.Window;

import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import com.google.gwt.widgetideas.client.event.ClickEvent;
import com.google.gwt.widgetideas.client.event.ClickHandler;
import org.stakeInteraction.shared.handler.VentanaGrafoHandler;

/**
 *
 * @author grela
 */
public class VentanaPrincipal extends Util{
 private Window window;

    @Override
    public void manejarRaton() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public VentanaPrincipal()
    {
             this.window=new Window();
             window.setSize("800px", "535px");
          //   window.setMaximizable(true);
             window.setResizable(true);
            
        VentanaGrafoHandler a=new VentanaGrafoHandler(this);
     
             window.addListener(Events.Resize, a);
             window.addListener(Events.Move,a);
             

             
         
    }
    public void agregarPanel(Widget panel)
    {
        this.window.add(panel);

    }
    public void mostrar()
    {
        this.window.show();
    }
    public void redibujar()
    {
        this.window.layout(true);
        this.window.repaint();

    }
    public String getWight()
    {
        int a=this.window.getWidth();
        return String.valueOf(a);
    }
    public String getHeight()
    {
        int a=this.window.getHeight()-40;
        return String.valueOf(a);
    }

    public Window getWindow()
    {
        return this.window;
    }
}
