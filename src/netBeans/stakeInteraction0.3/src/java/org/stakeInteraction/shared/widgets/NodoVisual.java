/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.shared.widgets;



import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.google.gwt.user.client.ui.InlineHTML;

import org.stakeInteraction.shared.grafo.Nodo;
import java.io.Serializable;



/**
 *
 * @author grela
 */
public class NodoVisual  extends InlineHTML implements Serializable{

    private Nodo nodo;

    private String dirImagenAceptado;
    private String dirImagenNoAceptado;
    private String dirImagenSeleccionado;
    private String dirImagenNoAceptadoSeleccionado;

    private String texto;
    private  boolean marcado=false;
    
    public NodoVisual()
    {
        
    }
    public NodoVisual(Nodo nodo)
    {
        this.nodo=nodo;
      //  texto=nodo.getNombre();
          texto=nodo.getInformacion().getNombre();


    }
    public Nodo getNodo()
    {
        return this.nodo;
    }
    
    public void dibujar()
    {
      this.marcado=false;
       if(nodo.isValido())
        setHTML("<b>"+this.texto+"</b><br><img src="+this.getDirImagenAceptado()+" alt=some_text/>");
       else
         setHTML("<b>"+this.texto+"</b><br><img src="+this.getDirImagenNoAceptado()+" alt=some_text/>");
    }

     public void dibujarMarcado()
    {

        this.marcado=true;
       if(nodo.isValido())
        setHTML("<b>"+this.texto+"</b><br><img src="+this.getDirImagenSeleccionado()+" alt=some_text/>");
       else
         setHTML("<b>"+this.texto+"</b><br><img src="+this.getDirImagenNoAceptadoSeleccionado()+" alt=some_text/>");
    }

   
    public void contraerTexto()
    {
        if(texto.length()>5)
        {
            texto=nodo.getInformacion().getNombre().substring(0,5)+"..";

        }
        else
            texto=nodo.getInformacion().getNombre();
    }
    public void expandirTexto()
    {
        texto=nodo.getInformacion().getNombre();
    }

    /**
     * @return the dirImagenAceptado
     */
    public String getDirImagenAceptado() {
        return dirImagenAceptado;
    }

    /**
     * @param dirImagenAceptado the dirImagenAceptado to set
     */
    public void setDirImagenAceptado(String dirImagenAceptado) {
        this.dirImagenAceptado = dirImagenAceptado;
    }

    /**
     * @return the dirImagenNoAceptado
     */
    public String getDirImagenNoAceptado() {
        return dirImagenNoAceptado;
    }

    /**
     * @param dirImagenNoAceptado the dirImagenNoAceptado to set
     */
    public void setDirImagenNoAceptado(String dirImagenNoAceptado) {
        this.dirImagenNoAceptado = dirImagenNoAceptado;
    }

    /**
     * @return the dirImagenSeleccionado
     */
    public String getDirImagenSeleccionado() {
        return dirImagenSeleccionado;
    }

    /**
     * @param dirImagenSeleccionado the dirImagenSeleccionado to set
     */
    public void setDirImagenSeleccionado(String dirImagenSeleccionado) {
        this.dirImagenSeleccionado = dirImagenSeleccionado;
    }

    /**
     * @return the dirImagenNoAceptadoSeleccionado
     */
    public String getDirImagenNoAceptadoSeleccionado() {
        return dirImagenNoAceptadoSeleccionado;
    }

    /**
     * @param dirImagenNoAceptadoSeleccionado the dirImagenNoAceptadoSeleccionado to set
     */
    public void setDirImagenNoAceptadoSeleccionado(String dirImagenNoAceptadoSeleccionado) {
        this.dirImagenNoAceptadoSeleccionado = dirImagenNoAceptadoSeleccionado;
    }

    /**
     * @return the marcado
     */
    public boolean isMarcado() {
        return marcado;
    }



   

 



   

}
