/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.shared.ventanaInfo;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.LayoutData;
import org.stakeInteraction.client.ventanaGrafo.mediador.ContenedorGrafo;
import org.stakeInteraction.shared.Informacion.Informacion;
import org.stakeInteraction.shared.handler.BotonActualizarCrearUsuarioHandler;

/**
 *
 * @author grela
 */
public abstract class VentanaInfo {
    protected Window window;
    protected Listener<ButtonEvent> handler;
    protected com.extjs.gxt.ui.client.widget.button.Button BotonGuardar;
    protected ContenedorGrafo contenedorGrafo;
    public VentanaInfo( )
    {
        
        this.window=new Window();
        this.window.setMaximizable(false);
        this.window.setSize(400, 300);
        
        this.window.show();
      

       
    }
    public void agregarContenedorGrafo(ContenedorGrafo contenedorGrafo)
    {
        this.contenedorGrafo=contenedorGrafo;
    }
    public void agregarHandler( Listener<ButtonEvent> handler)
    {
        this.handler=handler;
    }
    /*
    public void agregarEventoBotonGuardar( Listener<ButtonEvent> handler)
    {
        this.handler=handler;

    }*/
    public abstract void cargarVentana(Informacion info);

    /**
     * @return the BotonGuardar
     */
    public com.extjs.gxt.ui.client.widget.button.Button getBotonGuardar() {
        return BotonGuardar;
    }

    public void cerrarVentana()
    {
        this.window.close();
    }

    public abstract void deshabilitarVentana();

}
