/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.shared.handler;


import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.user.client.Window;
import com.orange.links.client.connection.Connection;
import org.stakeInteraction.shared.grafo.Arco;

/**
 *
 * @author grela
 */
public class GrafoArcoHandler implements MouseDownHandler {

    //private Connection con;
   
    public GrafoArcoHandler()
    {
        //this.con=con;
    }
    
    @Override
    public void onMouseDown(MouseDownEvent event) {
        Connection con=(Connection)event.getSource();
        Window.alert("Apreto rl botonderecho");

    }

}
