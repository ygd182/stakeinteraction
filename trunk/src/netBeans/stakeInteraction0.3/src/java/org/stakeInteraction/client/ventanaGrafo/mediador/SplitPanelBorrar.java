/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.client.ventanaGrafo.mediador;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.orange.links.client.DiagramController;

import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 *
 * @author grela
 */
public class SplitPanelBorrar {
     private SplitLayoutPanel splitPanel;
     private DockPanel dockPanel;

      public Widget  onInitialize( DiagramController controller) {
    // Create a Dock Panel
     splitPanel = new SplitLayoutPanel();
    splitPanel.ensureDebugId("cwSplitLayoutPanel");
    splitPanel.getElement().getStyle()
        .setProperty("border", "3px solid #e7e7e7");
    splitPanel.setSize("900px", "800px");

    // Add text all around.
   // splitPanel.addNorth(new Label("norte"), 50);
   // splitPanel.addSouth(new Label("sur"), 50);
       TextBox txtbxTitulo = new TextBox();
               txtbxTitulo.setText("titulo");
               splitPanel.addNorth(txtbxTitulo, 100.0);
    TextBox txtbxInfoGrafo = new TextBox();
		txtbxInfoGrafo.setText("info 9grafo");
		splitPanel.addEast(txtbxInfoGrafo, 150.0);
                 TextBox txtbxAcciones = new TextBox();
               txtbxAcciones.setText("botones con acciones");
               splitPanel.addWest(txtbxAcciones, 150.0);
 //   splitPanel.addWest(new Label("oeste"), 100);


 //   splitPanel.addSouth(new Label("sur"), 50);

    // Add scrollable text to the center.
    //String centerText = "aca va el grafo";
              /* Button btnGrafo = new Button("grafo");
               btnGrafo.setSize("5","5");
		splitPanel.add(btnGrafo);*/
		//nameField.selectAll();

   // Label centerLabel = new Label(centerText);
 //   ScrollPanel centerScrollable = new ScrollPanel();
  //  splitPanel.add(centerScrollable);
    splitPanel.add(controller.getViewAsScrollPanel());
    
    splitPanel.forceLayout();
 //   controller.getViewAsScrollPanel().clear();

    /*
     * SplitLayoutPanel splitLayoutPanel = new SplitLayoutPanel();
		rootPanel.add(splitLayoutPanel, 10, 127);
		splitLayoutPanel.setSize("439px", "294px");

		TextBox txtbxTitulo = new TextBox();
		txtbxTitulo.setText("titulo");
		splitLayoutPanel.addNorth(txtbxTitulo, 100.0);

		TextBox txtbxInfoGrafo = new TextBox();
		txtbxInfoGrafo.setText("info grafo");
		splitLayoutPanel.addEast(txtbxInfoGrafo, 100.0);

		Button btnGrafo = new Button("grafo");
		splitLayoutPanel.add(btnGrafo);
		nameField.selectAll();
    */
    // Return the content
    return splitPanel;
    }
      public DockPanel onInitialize1(DiagramController controller)
    {
          dockPanel = new DockPanel();
          dockPanel.setBorderWidth(5);
    dockPanel.setSize("900px", "600px");
 // dockPanel.setWidth("100%");
           TextBox txtbxTitulo = new TextBox();
               txtbxTitulo.setText("titulo");
               dockPanel.add(txtbxTitulo,DockPanel.NORTH);
    //TextBox txtbxInfoGrafo = new TextBox();
		//txtbxInfoGrafo.setText("info 9grafo");
		//dockPanel.add(txtbxInfoGrafo,DockPanel.EAST);
                 TextBox txtbxAcciones = new TextBox();
               txtbxAcciones.setText("botones con acciones");
               dockPanel.add(txtbxAcciones,DockPanel.WEST);
                 dockPanel.add(controller.getViewAsScrollPanel(),DockPanel.CENTER);


                   RootPanel.get().addHandler(new ResizeHandler() {
  public void onResize(final ResizeEvent event) {

//un evento para activar el resize, pero lo desactive
  }

}, ResizeEvent.getType() );


    //p.forceLayout();
/*p.addNorth(new HTML("header"), 2);
p.addSouth(new HTML("footer"), 2);
p.addWest(new HTML("navigation"), 10);
p.add(new HTML(content));*/
    return dockPanel;
      }

 public void addGrafoWidgate()
 {

        /*LabelWithMenu hasMenu = new LabelWithMenu("Context Menu");
        splitPanel
                controller.addWidget(hasMenu,200,115);*/
    //splitPanel.add;

 }

 public void addInformacion(VerticalPanelInfoBorrar vpi)
 {
     this.dockPanel.add(vpi.getVerticalPanel(),DockPanel.EAST);

 }

}
