/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.shared.handler;


import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.InlineHTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import org.stakeInteraction.client.pantallaExportar.PantallaExportar;
import org.stakeInteraction.client.ventanaGrafo.VentanaGrafoUser;

/**
 *
 * @author grela
 */
public class PantallaPrincipalUserHandler implements MouseDownHandler,MouseOverHandler {
    private Image imageFondo;
    private InlineHTML iconoAdministrarProy;
    private InlineHTML iconoExportar;
    //private InlineHTML iconoVerProy;
     private InlineHTML iconoSalir;
    public PantallaPrincipalUserHandler(Image imageFodo,InlineHTML iconoAdmin,InlineHTML iconoPrueba, InlineHTML iconoSalir)
    {
        this.imageFondo=imageFodo;
        this.iconoExportar=iconoPrueba;
        this.iconoAdministrarProy=iconoAdmin;
        this.iconoSalir=iconoSalir;
        this.imageFondo.addMouseOverHandler(this);
        this.iconoAdministrarProy.addMouseDownHandler(this);
        this.iconoAdministrarProy.addMouseOverHandler(this);
        this.iconoExportar.addMouseDownHandler(this);
        this.iconoSalir.addMouseDownHandler(this);


    }

    @Override
    public void onMouseDown(MouseDownEvent event) {
         Widget sender=(Widget)event.getSource();
        if(sender==this.iconoAdministrarProy)
        {
            VentanaGrafoUser v=new VentanaGrafoUser();



        }

        else
        if(sender==this.imageFondo)
        {

        }
        else
        if(sender==this.iconoExportar)
        {
        //  GWTServiceUsage.exportarGml();
            PantallaExportar pantallaExportar=new PantallaExportar();
        }
          else
        if(sender==this.iconoSalir)
        {
           Window.Location.reload();
        }

    }

    @Override
    public void onMouseOver(MouseOverEvent event) {
         Widget sender=(Widget)event.getSource();
        if(sender==this.iconoAdministrarProy)
        {
             this.iconoAdministrarProy.setHTML("<img src=" + "imagen/AdminProyecto.png" + " alt=some_text/>" + "<br><u>" + "Administrar <br> Proyecto" + "</b></u>");
           //   DOM.setStyleAttribute(RootPanel.getBodyElement(), "cursor", "pointer");
        }
        else
        if(sender==this.imageFondo)
        {
             this.iconoAdministrarProy.setHTML("<img src=" + "imagen/AdminProyecto.png" + " alt=some_text/>" + "<br>" + "Administrar <br> Proyecto" + "</b>");
             DOM.setStyleAttribute(RootPanel.getBodyElement(), "cursor", "pointer");
        }

    }

}
