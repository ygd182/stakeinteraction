/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.client;

import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.widget.MessageBox;

/**
 *
 * @author Jorge
 */
public  class PantallaMensaje {
    public static void mostrarDialogo(String texto,Listener<MessageBoxEvent> l){
               MessageBox.alert("Mensaje", texto, l);
}

}
