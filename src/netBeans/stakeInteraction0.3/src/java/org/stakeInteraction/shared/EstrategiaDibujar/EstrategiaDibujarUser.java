/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.shared.EstrategiaDibujar;


import com.extjs.gxt.ui.client.widget.menu.Menu;
import java.io.Serializable;
import org.stakeInteraction.client.GWTServiceUsage;
import org.stakeInteraction.client.ventanaGrafo.mediador.ContenedorGrafo;
import org.stakeInteraction.shared.Informacion.Informacion;
import org.stakeInteraction.shared.Informacion.Usuario;
import org.stakeInteraction.shared.grafo.Nodo;
import org.stakeInteraction.shared.handler.GrafoNodoUserHanlder;
import org.stakeInteraction.shared.ventanaInfo.VentanaDoc;
import org.stakeInteraction.shared.ventanaInfo.VentanaInfo;
import org.stakeInteraction.shared.ventanaInfo.VentanaUser;
import org.stakeInteraction.shared.widgets.NodoVisual;
/**
 *
 * @author grela
 */
public class EstrategiaDibujarUser implements Serializable,EstrategiaDibujarNodo {

    

    
public EstrategiaDibujarUser()
    {

}
    
    
    @Override
    public NodoVisual crearNodoVisual(Nodo nodo,ContenedorGrafo contenedorGrafo,Menu contextMenu) {
        NodoVisual nodoVisual=new NodoVisual(nodo);
        nodoVisual.setDirImagenAceptado("imagen/user1.gif");
         nodoVisual.setDirImagenNoAceptado("imagen/user1NoAceptado.gif");
         nodoVisual.setDirImagenSeleccionado("imagen/user1Seleccionado.gif");
         nodoVisual.setDirImagenNoAceptadoSeleccionado("imagen/user1NoAceptadoSeleccionado.gif");
         nodoVisual.contraerTexto();
        nodoVisual.dibujar();
        nodoVisual.addMouseDownHandler(new GrafoNodoUserHanlder(contenedorGrafo,contextMenu));
        return nodoVisual;
    }

    @Override
    public VentanaInfo crearVentanaInfo(Informacion info,ContenedorGrafo contenedorGrafo) {
        VentanaUser ventanaUser=new VentanaUser();
        Usuario user=(Usuario)info;
        ventanaUser.setVentanaActualizar(contenedorGrafo);
        GWTServiceUsage.pedirInformacionNodoBaseUsuario(user,ventanaUser);

      
        return ventanaUser;

    }

   

  

}

