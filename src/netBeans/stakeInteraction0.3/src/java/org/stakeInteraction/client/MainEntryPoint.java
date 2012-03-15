/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.stakeInteraction.client;









import com.google.gwt.core.client.EntryPoint;

import com.google.gwt.user.client.ui.InlineHTML;


import com.google.gwt.user.client.ui.RootPanel;
//import org.stakeNet.client.pantallaPrincipal.PantallaPrincipal;





/**
 * Main entry point.
 *
 * @author grela
 */
public class MainEntryPoint implements EntryPoint {
    /** 
     * Creates a new instance of MainEntryPoint
     */
    private InlineHTML nl;
    public MainEntryPoint() {
    }

    /** 
     * The entry point method, called automatically by loading a module
     * that declares an implementing class as an entry-point
     */
    @Override
    public void onModuleLoad() {
      

        Login l=new Login();
      RootPanel.get().add(l);
         // this.onModuleLoad();
    
    
        
      //  PantallaPrincipal pantallaPrincipal=new PantallaPrincipal();
        


        }


    
}
