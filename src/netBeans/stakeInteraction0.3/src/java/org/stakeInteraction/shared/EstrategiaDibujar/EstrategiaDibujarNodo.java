/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.shared.EstrategiaDibujar;

import com.extjs.gxt.ui.client.widget.menu.Menu;
import org.stakeInteraction.client.ventanaGrafo.mediador.ContenedorGrafo;
import org.stakeInteraction.shared.Informacion.Informacion;
import org.stakeInteraction.shared.grafo.Nodo;
import org.stakeInteraction.shared.ventanaInfo.VentanaInfo;
import org.stakeInteraction.shared.widgets.NodoVisual;






/**
 *
 * @author grela
 */
/*patron factory pagina 99 del libro Gamma*/
public interface   EstrategiaDibujarNodo {



    public abstract NodoVisual crearNodoVisual(Nodo nodo,ContenedorGrafo contenedorGrafo,Menu contextMenu);
    public abstract VentanaInfo crearVentanaInfo(Informacion info,ContenedorGrafo contenedorGrafo);

    //public abstract NodoVisual obtenerNodo();
   

}
