/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.client.ventanaGrafo.mediador;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.widget.ContentPanel;

import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.google.gwt.user.client.ui.Widget;
import org.stakeInteraction.shared.EstrategiaDibujar.EstrategiaDibujarDoc;
import org.stakeInteraction.shared.EstrategiaDibujar.EstrategiaDibujarUser;
import org.stakeInteraction.shared.Informacion.Documento;
import org.stakeInteraction.shared.Informacion.Usuario;
import org.stakeInteraction.shared.ventanaInfo.VentanaDoc;
import org.stakeInteraction.shared.ventanaInfo.VentanaInfo;
import org.stakeInteraction.shared.ventanaInfo.VentanaUser;






/**
 *
 * @author grela
 */
public class ContentPanelPrincipal extends Util{

    /*private final int NOPRESIONADO=0;
    private final int CREARDOC=1;
    private final int CREARUSER=2;
    private int estadoBotones=NOPRESIONADO;*/

    private ContentPanel cntntpnlStakeadmin;
    private BorderLayout borderLayout;
    private ContenedorGrafo contenedorGrafo;
    private float anchoPanelWest;


    @Override
    public void manejarRaton() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ContentPanelPrincipal(ContenedorGrafo contenedorGrafo)
    {
        this.contenedorGrafo=contenedorGrafo;
         cntntpnlStakeadmin = new ContentPanel();
       // cntntpnlStakeadmin = new Window();
		cntntpnlStakeadmin.setHeading("GrafoAdmin");
               this.borderLayout=new BorderLayout();
		cntntpnlStakeadmin.setLayout(this.borderLayout);

	
		/*com.extjs.gxt.ui.client.widget.VerticalPanel verticalPanel_1 = new com.extjs.gxt.ui.client.widget.VerticalPanel();

                verticalPanel_1.setBorders(true);
		com.extjs.gxt.ui.client.widget.button.Button btnBoton = new com.extjs.gxt.ui.client.widget.button.Button("Crear Documento");
		verticalPanel_1.add(btnBoton);
		btnBoton.setWidth("100px");

		com.extjs.gxt.ui.client.widget.button.Button btnBoton_1 = new com.extjs.gxt.ui.client.widget.button.Button("Crear Usuario");
		verticalPanel_1.add(btnBoton_1);
		btnBoton_1.setWidth("100px");

                BotonesVerticalPanelWestHandler botonesVerticalPanelWestHandler=new BotonesVerticalPanelWestHandler(this,btnBoton, btnBoton_1);

             
    

           
		cntntpnlStakeadmin.add(verticalPanel_1, new BorderLayoutData(LayoutRegion.WEST, 160.0f));

*/
        
             
             
            
               
    }
    public void MostrarPanelPrincipal() {
           

          


		 cntntpnlStakeadmin.setSize("800px", "500px");

              
               
         

    }
    public void addControllerGrafo(Widget grafo)
    {
        /*Text txtGrafo = new Text("Grafo");
		cntntpnlStakeadmin.add(txtGrafo, new BorderLayoutData(LayoutRegion.CENTER));*/
            
          
       this.cntntpnlStakeadmin.add(grafo,new BorderLayoutData(LayoutRegion.CENTER));

    }


    public void addVerticalPanelDerecha(Widget verticalPanel)
    {
        		cntntpnlStakeadmin.add(verticalPanel, new BorderLayoutData(LayoutRegion.EAST, 140.0f));

    }
    public void addOpcionAcordionGrafoIzquierda(OpcionesAdminGrafoAcordion opcionesAdminGrafoAcordion)
    {

        this.cntntpnlStakeadmin.add(opcionesAdminGrafoAcordion.getContentPanel(),new BorderLayoutData(LayoutRegion.WEST,160.0f));
    }

    public Widget getPanelPrincipal()
    {
        return this.cntntpnlStakeadmin;
    }

    public void redibujar()
    {
        this.cntntpnlStakeadmin.repaint();
        this.cntntpnlStakeadmin.layout(true);
        this.borderLayout.layout();
        


    }
    public void setTamanio(String wight,String height)
    {
         cntntpnlStakeadmin.setSize(wight, height);
    }

  /*  public void presionarBotonCrearDocumento()
    {
        this.estadoBotones=CREARDOC;
    }

    public void presionarBotonCrearUsuario()
    {
        this.estadoBotones=CREARUSER;
    }

    public VentanaInfo getVentanaSegunEstado()
    {
        if(this.estadoBotones==CREARDOC)
        {
            this.estadoBotones=NOPRESIONADO;
            VentanaDoc ventanaDoc=new VentanaDoc();
            ventanaDoc.setVentanaCrear(contenedorGrafo);
            ventanaDoc.cargarVentana(new Documento(-1,"","","",new EstrategiaDibujarDoc()));
            

            return ventanaDoc;
        }
        else
        {
            if(this.estadoBotones==CREARUSER)
            {
                this.estadoBotones=NOPRESIONADO;
                VentanaUser ventanaUser=new VentanaUser();
                 ventanaUser.setVentanaCrear(contenedorGrafo);
                ventanaUser.cargarVentana(new Usuario(-1,"", "",new EstrategiaDibujarUser(),"","","",""));
               

                return ventanaUser;
            }

        }
        return null;
    }*/
   

}
