/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.shared.EstrategiaDibujar;


import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.InlineHTML;
import com.google.gwt.user.client.ui.RootPanel;
//import org.stakeNet.client.pantallaPrincipal.PantallaPrincipal;
import org.stakeInteraction.client.ventanaGrafo.VentanaGrafoUser;
import org.stakeInteraction.shared.handler.PantallaPrincipalUserHandler;

/**
 *
 * @author grela
 */
public class EstrategiaDibujarPantallaPrincipalUser implements EstrategiaDibujarPantallaPrincipal {
       private RootPanel rootPanel;
    private Image imageFondo;
    private InlineHTML iconoAdministrarProy;
    private InlineHTML iconoExportar;
     private InlineHTML iconoSalir;
    private VentanaGrafoUser ventanaGrafo;
    private PantallaPrincipalUserHandler pantallaPrincipalHandler;
    @Override
    public void dibujarPantalla() {
       //PantallaPrincipal pantallaPrincipal=new PantallaPrincipal();


           DOM.setStyleAttribute(RootPanel.getBodyElement(), "cursor", "pointer");
           this.imageFondo = new Image("imagen/fondo_principal1.jpg");
	   this.imageFondo.setSize("640px", "480px");

           this.iconoSalir=new InlineHTML("<img src="+"imagen/exit.png"+" alt=some_text/>"+"<br>"+"Cerrar Sesion"+"</b>");
           this.iconoExportar=new InlineHTML("<img src="+"imagen/export.png"+" alt=some_text/>"+"<br>"+"Exportar Grafo"+"</b>");
           this.iconoAdministrarProy = new InlineHTML("<img src="+"imagen/AdminProyecto.png"+" alt=some_text/>"+"<br>"+"Administrar <br> Proyecto"+"</b>");





           this.rootPanel = RootPanel.get();
           this.rootPanel.add(imageFondo, 70, 0);
           this.rootPanel.add(iconoExportar,90,220);
           this.rootPanel.add(iconoSalir,90,340);
      	   this.rootPanel.add(iconoAdministrarProy, 90, 100);


           this.pantallaPrincipalHandler=new PantallaPrincipalUserHandler(imageFondo,iconoAdministrarProy,iconoExportar,iconoSalir);
    }


}
