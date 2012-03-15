/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.client.ventanaGrafo.mediador;


import com.extjs.gxt.ui.client.core.XTemplate;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.InlineHTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 *
 * @author grela
 */
public class VerticalPanelInfoBorrar extends Util{

    @Override
    public void manejarRaton() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private VerticalPanel verticalPanel;
    public VerticalPanelInfoBorrar()
    {
        this.verticalPanel = new VerticalPanel();
	verticalPanel.setSize("167px", "173px");


   Label a=new Label("hola");
//InlineHTML html = new InlineHTML("hola");
    

    
    this.verticalPanel.add(a);
    }

    public void addLabel(Label l)
    {
        this.verticalPanel.add(l);

    }
    public Widget getVerticalPanel()
    {
        return this.verticalPanel;
    }

   

}
