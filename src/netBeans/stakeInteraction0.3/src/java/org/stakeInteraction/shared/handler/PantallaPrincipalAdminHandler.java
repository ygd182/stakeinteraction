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
import org.stakeInteraction.client.VentanaImportar.VentanaSubirArchivo;
import org.stakeInteraction.client.pantallaExportar.PantallaExportar;
import org.stakeInteraction.client.ventanaGrafo.VentanaGrafoAdmin;
/**
 *
 * @author grela
 */
public class PantallaPrincipalAdminHandler  implements MouseDownHandler,MouseOverHandler {
  private Image imageFondo;
    private InlineHTML iconoAdministrarProy;
    private InlineHTML iconoExportar;
    private InlineHTML iconoImportar;
      private InlineHTML iconoSalir;

      private int EN_ICONO=0;
      private int EN_FONDO=1;
      private int lugar=EN_FONDO;
    public PantallaPrincipalAdminHandler(Image imageFodo,InlineHTML iconoAdmin,InlineHTML iconoPrueba,InlineHTML iconoImportar,InlineHTML iconoSalir)
    {
        this.imageFondo=imageFodo;
        this.iconoExportar=iconoPrueba;
        this.iconoAdministrarProy=iconoAdmin;
        this.iconoImportar=iconoImportar;
        this.iconoSalir=iconoSalir;

        this.imageFondo.addMouseOverHandler(this);
        this.iconoAdministrarProy.addMouseDownHandler(this);
        this.iconoAdministrarProy.addMouseOverHandler(this);
        this.iconoExportar.addMouseDownHandler(this);

        this.iconoImportar.addMouseDownHandler(this);
        this.iconoSalir.addMouseDownHandler(this);

    }

    @Override
    public void onMouseDown(MouseDownEvent event) {
         Widget sender=(Widget)event.getSource();
        if(sender==this.iconoAdministrarProy)
        {
            VentanaGrafoAdmin v=new VentanaGrafoAdmin();
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
        if(sender==this.iconoImportar)
        {
        //  GWTServiceUsage.exportarGml();
           // PantallaExportar pantallaExportar=new PantallaExportar();
           // GWTServiceUsage.importar();
          //  VentanaGxt v=new VentanaGxt();
            VentanaSubirArchivo s=new VentanaSubirArchivo();
            s.setVisible(true);
        }
           else
        if(sender==this.iconoSalir)
        {
        //  GWTServiceUsage.exportarGml();
           // PantallaExportar pantallaExportar=new PantallaExportar();
           Window.Location.reload();
        }
    }

    @Override
    public void onMouseOver(MouseOverEvent event) {
         Widget sender=(Widget)event.getSource();
        if(sender==this.iconoAdministrarProy)
        {
            if(this.lugar==EN_FONDO)
            {
             this.iconoAdministrarProy.setHTML("<img src=" + "imagen/AdminProyecto.png" + " alt=some_text/>" + "<br><u>" + "Administrar <br> Proyecto" + "</b></u>");
             DOM.setStyleAttribute(RootPanel.getBodyElement(), "cursor", "pointer");
             this.lugar=EN_ICONO;
            }
        }
        else
        if(sender==this.imageFondo)
        {
            if(this.lugar==EN_ICONO)
            {
             this.iconoAdministrarProy.setHTML("<img src=" + "imagen/AdminProyecto.png" + " alt=some_text/>" + "<br>" + "Administrar <br> Proyecto" + "</b>");
             DOM.setStyleAttribute(RootPanel.getBodyElement(), "cursor", "default");
             this.lugar=EN_FONDO;
            }
        }

    }
}
