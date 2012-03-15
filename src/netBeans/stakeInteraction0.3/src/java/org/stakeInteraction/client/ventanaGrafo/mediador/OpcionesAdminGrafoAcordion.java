/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.client.ventanaGrafo.mediador;

import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.TreePanelEvent;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.AccordionLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel;
import com.google.gwt.user.client.Window;


import java.util.Iterator;
import java.util.Vector;
import org.stakeInteraction.client.GWTServiceUsage;


import org.stakeInteraction.shared.CuentaUsuario.CuentaUsuario;
import org.stakeInteraction.shared.EstrategiaDibujar.EstrategiaDibujarDoc;
import org.stakeInteraction.shared.EstrategiaDibujar.EstrategiaDibujarUser;
import org.stakeInteraction.shared.Informacion.Documento;
import org.stakeInteraction.shared.Informacion.Usuario;
import org.stakeInteraction.shared.handler.BotonesVerticalPanelWestHandler;
import org.stakeInteraction.shared.ventanaInfo.VentanaDoc;
import org.stakeInteraction.shared.ventanaInfo.VentanaInfo;
import org.stakeInteraction.shared.ventanaInfo.VentanaUser;

/**
 *
 * @author grela
 */






public class OpcionesAdminGrafoAcordion  extends Util {


  private ContentPanel panel;
  private CuentaUsuario cuentaUserSeleccionado;
  
private final int NOPRESIONADO=0;
    private final int CREARDOC=1;
    private final int CREARUSER=2;
     private final int VALIDARTODO=3;
    private int estadoBotones=NOPRESIONADO;
    private ContenedorGrafo contenedorGrafo;
    private ContentPanel cpGrafoUsers;
    private   ContentPanel cpValidar;

  protected OpcionesAdminGrafoAcordion(ContenedorGrafo contenedorGrafo) {
      this.contenedorGrafo=contenedorGrafo;
      this.cuentaUserSeleccionado=null;

    //super.onRender(parent, index);

   // setLayout(new FlowLayout(10));



    this.panel = new ContentPanel();

    

    panel.setHeading("Opciones");

    panel.setBodyBorder(true);
   

AccordionLayout accordionLayout=new AccordionLayout();

    panel.setLayout(accordionLayout);

  ContentPanel cp = new ContentPanel();

    cp.setAnimCollapse(false);

    cp.setHeading("Administrar Grafo");

    cp.setLayout(new FitLayout());
    Button btnBoton = new com.extjs.gxt.ui.client.widget.button.Button("Crear Documento");
    Button btnBoton_1 = new com.extjs.gxt.ui.client.widget.button.Button("Crear Usuario");
    VerticalPanel vp =new VerticalPanel();
    vp.add(btnBoton);
    vp.add(btnBoton_1);
  //  BotonesVerticalPanelWestHandler botonesVerticalPanelWestHandler=new BotonesVerticalPanelWestHandler(this,btnBoton, btnBoton_1);
    cp.add(vp);

    panel.add(cp);


   this.cpGrafoUsers = new ContentPanel();

    cpGrafoUsers.setAnimCollapse(false);

    cpGrafoUsers.setBodyStyleName("pad-text");

    cpGrafoUsers.setHeading("Grafos de Usuarios");
    panel.add(cpGrafoUsers);


    //----------validar------
     cpValidar = new ContentPanel();

    cpValidar.setAnimCollapse(false);

    cpValidar.setHeading("Validar Grafo");

    cpValidar.setLayout(new FitLayout());
    Button btnBotonValidarTodo = new com.extjs.gxt.ui.client.widget.button.Button("Validar Todo");

    VerticalPanel vpValidar =new VerticalPanel();
    vpValidar.add(btnBotonValidarTodo);
    
    BotonesVerticalPanelWestHandler botonesVerticalPanelWestHandler1=new BotonesVerticalPanelWestHandler(this,btnBoton,btnBoton_1,btnBotonValidarTodo);
    cpValidar.add(vpValidar);

    panel.add(cpValidar);



    //------------------


    panel.setSize(10, 300);
    


  }

  public ContentPanel getContentPanel()
  {
      return this.panel;
  }

  public void seleccionarCuentaUsuario(CuentaUsuario cu)
  {
      this.cuentaUserSeleccionado=cu;
  }
  public CuentaUsuario getCuentaUsuarioSeleccionado()
  {
      return this.cuentaUserSeleccionado;
  }



  private ModelData newItem(String text, String iconStyle,CuentaUsuario cuentaUsuario) {

    ModelData m = new BaseModelData();
    m.set("objeto",cuentaUsuario );

    m.set("name", text);

    m.set("icon", iconStyle);



    return m;

  }

    @Override
    public void manejarRaton() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   public void presionarBotonCrearDocumento()
    {
        this.estadoBotones=CREARDOC;
    }

    public void presionarBotonCrearUsuario()
    {
        this.estadoBotones=CREARUSER;
    }

    public void presionarBotonValidarTodo()
    {
        this.estadoBotones=VALIDARTODO;
    }


    public boolean isBotonesPresionados()
    {
        if(this.estadoBotones==NOPRESIONADO)
        {
            return false;
        }
        return true;
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
              else
                 {
                  if(this.estadoBotones==VALIDARTODO){
                                 this.estadoBotones=NOPRESIONADO;
                                 contenedorGrafo.borrarNodosDePantalla();
                                  GWTServiceUsage.validarGrafo(contenedorGrafo.getGrafo());
                                    return null;


                                      }

        }

        }

        return null;
    }

    public void setUserManejo()
    {
        this.cpGrafoUsers.disable();
        this.cpValidar.disable();
    }
     public void setAdminManejo()
    {
  
        Vector<CuentaUsuario> usuarios=new Vector<CuentaUsuario>();
        GWTServiceUsage.pedirUsuarios( usuarios,this);

    }
     public void seleccionarUsuario()
    {

         /*TreePanel<ModelData> tree=(TreePanel<ModelData>)this.cpGrafoUsers.getItem(0);
         
         Window.alert("aca deberia deseleccionar user->HACER!!!!");*/

     }

     public void cargarUsuarios(Vector<CuentaUsuario> usuarios)
    {
             TreeStore<ModelData> store = new TreeStore<ModelData>();
             TreePanel<ModelData> tree = new TreePanel<ModelData>(store);
             tree.setDisplayProperty("name");
             ModelData m = newItem("Usuarios", null,null);

   
                store.add(m, false);

                for(Iterator<CuentaUsuario> i=usuarios.iterator();i.hasNext();)
                {
                    CuentaUsuario cu=i.next();

                  //  store.add(m,new Html("<span class=text>Enter a search string such as 'dirk'</span>"),false);
                    store.add(m, newItem(cu.getNombre(), "user",cu), false);

                    /*store.add(m, newItem(cu.getContraseña(), "user-girl"),true);

                    /*store.add(m, newItem("Lia", "user-kid"), false);

                    store.add(m, newItem("Alec", "user-kid"), false);

                    store.add(m, newItem("Andrew", "user-kid"), false);*/


                    }
                 tree.setExpanded(m, true);
                tree.addListener(Events.OnClick, new Listener<TreePanelEvent<ModelData>>() {
                        public void handleEvent(TreePanelEvent<ModelData> be) {
                            CuentaUsuario cu=(CuentaUsuario)be.getItem().get("objeto");
                            seleccionarCuentaUsuario(cu);
                    
                            modificado();
                        };
                    });
   
   

                 cpGrafoUsers.add(tree);



     }

}
