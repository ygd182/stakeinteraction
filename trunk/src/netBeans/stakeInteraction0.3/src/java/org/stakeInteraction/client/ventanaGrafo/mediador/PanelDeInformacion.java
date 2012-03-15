/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.client.ventanaGrafo.mediador;

import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import org.stakeInteraction.shared.Informacion.Informacion;
import org.stakeInteraction.shared.handler.BotonesInfoPanellHandler;

/**
 *
 * @author grela
 */
public class PanelDeInformacion extends Util {
    private com.extjs.gxt.ui.client.widget.VerticalPanel verticalPanel;
    private Button buttonVerDetalles;
    private Button buttonVerActividad;
    private BotonesInfoPanellHandler botonesVentanaPrincipalHandler;
    private boolean  botonPresionado=false;
    @Override
    public void manejarRaton() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public void inicializarPanelDeInfo()
    {
         this.verticalPanel = new com.extjs.gxt.ui.client.widget.VerticalPanel();
         //this.verticalPanel.setWidth(60);
         this.verticalPanel.setBorders(true);

         this.verticalPanel.setScrollMode(Scroll.AUTOX);
         this.verticalPanel.setAutoWidth(true);


      
         this.buttonVerDetalles=new Button("Ver Detalles");
         this.buttonVerActividad=new Button("Ver Actividad");

         this.botonesVentanaPrincipalHandler=new BotonesInfoPanellHandler(buttonVerDetalles,this);

   }

    public void presionarBotonVerDetalles(boolean press)
    {
        this.botonPresionado=press;
    }
    public boolean isBotonVerDetallesPress()
    {
        return this.botonPresionado;
    }
    public void addLabelInfo(String info)
    {
             Text txtInfo = new Text(info);
		verticalPanel.add(txtInfo);

                verticalPanel.layout(true);
                /*Text txtInfo_1 = new Text("Info2");
		verticalPanel.add(txtInfo_1);*/
    }

    public void mostrarTitulo()
    {
         this.verticalPanel.removeAll();
        StringBuffer sb = new StringBuffer();
        sb.append("<div class=text style='line-height: 1.5em'>");
        sb.append("<b>Presiones en los </b>" );
        sb.append("<b>nodos para ver detalles</b>");
        

     //XTemplate template = XTemplate.create(sb.toString());
     HTML html = new HTML(sb.toString());
    html.setWidth("125px");
    verticalPanel.add(html);
    }

    public void mostrarInfo(Informacion info)
    {   this.verticalPanel.removeAll();
        StringBuffer sb = new StringBuffer();
        sb.append("<div class=text style='line-height: 1.5em'>");
        sb.append("<b>Nombre:</b>" +info.getNombre()+"<br>");
        sb.append("<b>Link:</b>"+info.getLink()+"<br>");
        /*sb.append("<b>Last:</b> {last}<br>");
        sb.append("<b>Change:</b> {[new Number(values.change).toFixed(2)]}<br>");
        sb.append("<b>Updated:</b> {date:date(\"MM/dd/y\")}<br>");*/
        sb.append("<a href=");
        sb.append(info.getLink()+" target=_blank");
        sb.append(">"+info.getLink()+"</a>");
        sb.append("</div>");

     //XTemplate template = XTemplate.create(sb.toString());
     HTML html = new HTML(sb.toString());
    html.setWidth("125px");
    verticalPanel.add(html);
    this.verticalPanel.add(this.buttonVerDetalles);
    }

    public  VerticalPanel obtenerPanelDeInfo()
      {
        return this.verticalPanel;

    }


}
