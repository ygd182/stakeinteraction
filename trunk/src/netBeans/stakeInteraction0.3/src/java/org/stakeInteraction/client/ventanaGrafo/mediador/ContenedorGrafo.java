/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.client.ventanaGrafo.mediador;

import com.allen_sauer.gwt.dnd.client.PickupDragController;
import com.extjs.gxt.ui.client.widget.ContentPanel;

import com.extjs.gxt.ui.client.widget.menu.Menu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.InlineHTML;
import com.google.gwt.user.client.ui.Widget;
import com.orange.links.client.DiagramController;
import com.orange.links.client.connection.Connection;
import java.util.Iterator;
import java.util.List;
import org.stakeInteraction.client.GWTServiceUsage;
import org.stakeInteraction.client.widgets.links.DiagramControllerWithContext;
import org.stakeInteraction.shared.CuentaUsuario.CuentaUsuario;

import org.stakeInteraction.shared.Informacion.Documento;
import org.stakeInteraction.shared.handler.GrafoNodoHandler;

import org.stakeInteraction.shared.Informacion.Usuario;

import org.stakeInteraction.shared.grafo.Arco;
import org.stakeInteraction.shared.grafo.Grafo;
import org.stakeInteraction.shared.grafo.Nodo;
import org.stakeInteraction.shared.handler.EnlaceDeDosNodosHandler;
import org.stakeInteraction.shared.observador.Observador;
import org.stakeInteraction.shared.observador.Sujeto;
import org.stakeInteraction.shared.widgets.NodoVisual;

/**
 *
 * @author grela
 */
public class ContenedorGrafo  extends Util implements Observador{

    	
	private DiagramControllerWithContext controller;
        private Grafo grafo;
        private Image imagenDeEspera;
        private GrafoNodoHandler nodoMouseDownHandler;
        private Nodo nodoSeleccionado;
        private VentanaPrincipal ventanaPrincipal;
        private Menu contextMenuNodo ;
        private ContentPanel contentPanel;
        private CuentaUsuario cuentaUsuarioSeleccionado;
        private int grafoIdSeleccionado;
       
    public ContenedorGrafo(Grafo grafo)
    {
               
                this.grafo=grafo;
                 this.imagenDeEspera=new Image("imagen/cargando.gif");
                 //this.nodoMouseDownHandler=new GrafoNodoHandler(this);
                 this.nodoSeleccionado=null;

                 controller = new DiagramControllerWithContext(700,600,this);
                 this.cuentaUsuarioSeleccionado=null;
                 this.grafoIdSeleccionado=-1;

     }

    public void agregarVentana(VentanaPrincipal ventanaPrincipal)
    {
        this.ventanaPrincipal=ventanaPrincipal;
    }
    private PanelDeInformacion panelDeInformacion;
    public void agregarPanelDeInfo(PanelDeInformacion panelDeInformacion)
    {
        this.panelDeInformacion=panelDeInformacion;
    }

    public void agregarGrafoNodoHandler(GrafoNodoHandler grafoNodoHandler)
    {
        this.nodoMouseDownHandler=grafoNodoHandler;
    }
    public void agregarCotextMenuArco(Menu contextMenu)
    {
        this.controller.setContextMenu(contextMenu);
    }
    public void agregarContextMenuNodo(Menu contextMenu)
    {
        this.contextMenuNodo=contextMenu;
    }

    public void agregarContentPanel(ContentPanel contentPanel)
    {

        this.contentPanel=contentPanel;
    }
    @Override
    public void manejarRaton() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void inicializarContenedorGrafo()
    {
        
        
             controller.showGrid(true);
              Widget widgetPanel = controller.getView();
              widgetPanel.getElement().getStyle().setMargin(0, Unit.PX);
              widgetPanel.getElement().getStyle().setProperty("border", "0px");

             controller.setFrameSize(620, 400);
              
              controller.addWidget(this.imagenDeEspera,controller.getCanvasWidth()/2,controller.getCanvasHeight()/2);


               this.controller.addTieLinkHandler(new EnlaceDeDosNodosHandler(this));
   
    }


    public DiagramController getControllerGrafo(){
        return this.controller;
    }

   public void borrarNodosDePantalla()
    {

       controller.addWidget(this.imagenDeEspera,controller.getCanvasWidth()/2,controller.getCanvasHeight()/2);
         for(Iterator<Nodo> i=grafo.getAllNodos().iterator();i.hasNext();)
         {
             NodoVisual nv=((Nodo)i.next()).getNodoVisual();
             nv.getNodo().borrarNodoVisual();
             if(nv!=null)
             {
               this.controller.deleteWidget(nv);
             }
         }
        // this.controller.update();

    }
    public void dibujarGrafo()
    {
        
        /*dibuja el grafo*/
// borrarNodos();
     // inicializarContenedorGrafo();
      
        generarCirculoDeNodos();
        unirCajas();
        imagenDeEspera.removeFromParent();
        this.panelDeInformacion.modificado();
        if(grafoIdSeleccionado!=-1)
            GWTServiceUsage.pedirGrafoFiltrado(grafoIdSeleccionado, this);
        //modificado();
        /*****************/

    }
    public  void generarCirculoDeNodos()
    {
           PickupDragController dragController = new PickupDragController(controller.getView(), true);
	   controller.registerDragController(dragController);

	   double altoMargen=controller.getCanvasHeight();
           double anchoMargen=controller.getCanvasWidth();
	   double radio;
	   int tamanioCaja=70;
   	   radio=(grafo.getCantDeNodos()*tamanioCaja)/(Math.PI*2)+10;
           GWT.log("Radio: "+radio);
           GWT.log(grafo.getCantDeNodos()+"");
   	   double angulo=0;
   	   double X=0;
   	   double Y=0;
   	   X=radio*Math.cos(angulo);
   	   Y=radio*Math.sin(angulo);
   	   double diffAngulo=(2*Math.PI)/grafo.getCantDeNodos();

           Nodo nodo=null;
           NodoVisual widget=null;
           for(Iterator<Nodo> i=grafo.getAllNodos().iterator();i.hasNext(); )
    	        {
                X=radio*Math.cos(angulo);
                Y=radio*Math.sin(angulo);
                nodo=i.next();
                if(this.nodoSeleccionado!=null)
                {
                    if(this.nodoSeleccionado.getId()==nodo.getId())
                    {
                        this.nodoSeleccionado=nodo;
                    }
                }

                nodo.dibujarNodo(this,this.contextMenuNodo);

                 widget=nodo.getNodoVisual();
                 dragController.makeDraggable(widget);
                 /***evento de los nodos****/
                 widget.addMouseDownHandler(nodoMouseDownHandler);
                 /***fin evento de los nodos***/

                 controller.addWidget(widget,(int)(X+anchoMargen/2) , (int)(Y+altoMargen/2));
   		 angulo=angulo+diffAngulo;

           }


    }
    public void unirCajas()
	{
          

          Nodo nodoOrigen=null;
           Widget nodoOrigenVisual=null;
	    List<Arco> adyacentes=null;
            Nodo nodoAdy=null;
	    Widget nodoVisualAdy=null;
        for(Iterator<Nodo> i=grafo.getAllNodos().iterator();i.hasNext(); )
    	    {

	   	 	 nodoOrigen=i.next();
                       nodoOrigenVisual=nodoOrigen.getNodoVisual();
	   	 	  adyacentes=nodoOrigen.getAdyacentes();
	   	 	 for(Iterator<Arco> j=adyacentes.iterator();j.hasNext(); )
	   	 	 {
                                  Arco arco=j.next();
	   	 		  nodoAdy=arco.getNodo();
	   	 		  nodoVisualAdy=nodoAdy.getNodoVisual();
	   	 		//GWT.log("se une "+nodoOrigen.toString()+" con" +nodoAdy.toString());
                                 System.out.print("se une "+nodoOrigen.toString()+" con" +nodoAdy.toString());
                                 Connection con = controller.drawStraightArrowConnection(nodoOrigenVisual,nodoVisualAdy,arco);

                                 if(!arco.isValido())
                                 {
                                     InlineHTML decoration=new InlineHTML();
                                     decoration.setHTML("<img src="+"imagen/alertaArco1.gif"+" alt=some_text/>");
                                     //Label decorationLabel = new Label("Mickey");
                                     controller.addDecoration(decoration, con);

                                 }

                        

	   	 	 }


            }


	}

    @Override
    public void actualizar(Sujeto elSujetoQueCambio) {
        if(elSujetoQueCambio==this.grafo)
          this.dibujarGrafo();
    }
    public void setNodoSeleccionado(Nodo nodo)
    {
        this.nodoSeleccionado=nodo;

    }

    public Nodo getNodoSeleccionado()
    {
        return this.nodoSeleccionado;
    }

    public void repintar()
    {
        this.controller.update();
    }

    public void nuevoNodoVisualDocumento(Documento documento)
    {
        Nodo nodo=new Nodo(documento);
        borrarNodosDePantalla();
        GWTServiceUsage.guardarNodoDocumento(nodo,this.grafo);

    }
    public void nuevoNodoVisualUsuario(Usuario usuario)
    {
        Nodo nodo=new Nodo(usuario);
        borrarNodosDePantalla();
       GWTServiceUsage.guardarNodoUsuario(nodo,this.grafo);
     


    }

    public void nuevoArco(Arco arco)
    {
       
        borrarNodosDePantalla();
  
        GWTServiceUsage.guardarArco(arco,this.grafo);
    }

    public void eliminarUser(Nodo nodo)
    {
       
        borrarNodosDePantalla();
          GWTServiceUsage.eliminarNodoUsuario(nodo,this.grafo);
    }
    public void eliminarDoc(Nodo nodo)
    {
        
        borrarNodosDePantalla();
  
        GWTServiceUsage.eliminarNodoDocumento(nodo,this.grafo);
    }

    public void actualizarUser(Usuario user)
    {
          borrarNodosDePantalla();
        GWTServiceUsage.editarUsuario(user,this.grafo);

    }
    public void actualizarDoc(Documento doc)
    {
          borrarNodosDePantalla();
        GWTServiceUsage.editarDocumento(doc,this.grafo);

    }

    public void eliminarArco(Arco arco)
    {
        borrarNodosDePantalla();
        GWTServiceUsage.eliminarArco(arco,this.grafo);
    }
    public void marcarGrafo(Grafo grafoUser)
    {
    //    Window.alert("grafo"+grafoUser.getId());
       // if(grafoUser!=null)
          this.grafoIdSeleccionado=grafoUser.getId();

        this.controller.borrarDecoraciones();
        
        boolean modificado=false;
        for(Iterator j=this.grafo.getAllNodos().iterator();j.hasNext();)
        {
             Nodo nj=(Nodo)j.next();
            for(Iterator i=grafoUser.getAllNodos().iterator();i.hasNext();)
            {
                 Nodo ni=(Nodo)i.next();
                if(ni.getId()==nj.getId())
                {
                    nj.getNodoVisual().dibujarMarcado();
                    modificado=true;
                    marcarArcos(nj, ni);
                }


            }
            if(!modificado){
                nj.getNodoVisual().dibujar();
                marcarArcosRestantes(nj);
                

            }
             modificado=false;


        }


    }
public void marcarArcosRestantes(Nodo nodoActual)
    {
           boolean modificado=false;
           for(Iterator<Arco> i=nodoActual.getAdyacentes().iterator();i.hasNext();)
           {
               Arco arcoI=i.next();
               Connection con=this.controller.getConection(arcoI.getId());
               if(!arcoI.isValido())
               {
                     InlineHTML decoration=new InlineHTML();
                         decoration.setHTML("<img src="+"imagen/alertaArco1.gif"+" alt=some_text/>");
                         //Label decorationLabel = new Label("Mickey");
                         controller.addDecoration(decoration, con);
               }
        }

}

       public void marcarArcos(Nodo nodoActual,Nodo nodoComp)
        {
           boolean modificado=false;
           for(Iterator<Arco> i=nodoActual.getAdyacentes().iterator();i.hasNext();)
           {
               Arco arcoI=i.next();
                Connection con=this.controller.getConection(arcoI.getId());
               
               for(Iterator<Arco> j=nodoComp.getAdyacentes().iterator();j.hasNext();)
               {
                   Arco arcoJ=j.next();
                   
                   if(arcoI.getId()==arcoJ.getId())
                   {
                     //  con.removeDecoration();
                       
                       


                         InlineHTML decoration=new InlineHTML();
                         arcoI.setMarcado(true);
                         if(!arcoI.isValido())
                           decoration.setHTML("<img src="+"imagen/alertaArco1Seleccionado.gif"+" alt=some_text/>");
                         else
                             decoration.setHTML("<img src="+"imagen/alertaArco1SeleccionadoValido.gif"+" alt=some_text/>");

                         //Label decorationLabel = new Label("Mickey");
                         controller.addDecoration(decoration, con);
                         modificado=true;
                   }
               }
               if(!modificado)
                {
                   if(!arcoI.isValido())
                   {
                       //con.removeDecoration();
                   //    this.controller.deleteWidget(con.getDecoration().getWidget());
                        InlineHTML decoration=new InlineHTML();
                         decoration.setHTML("<img src="+"imagen/alertaArco1.gif"+" alt=some_text/>");
                         //Label decorationLabel = new Label("Mickey");
                         controller.addDecoration(decoration, con);
                         arcoI.setMarcado(false);
                    }
                   else
                   {
                    /*   InlineHTML decoration=new InlineHTML();
                         decoration.setHTML("<img src="+"imagen/alertaArco.gif"+" alt=some_text/>");
                         //Label decorationLabel = new Label("Mickey");
                         controller.addDecoration(decoration, con);*/
                       //con.removeDecoration();
                    //   this.controller.deleteWidget(con.getDecoration().getWidget());
                                                arcoI.setMarcado(false);

                   }

                }
                 modificado=false;




           }

        }

    public void asignarArco(Arco arco)
    {
        if(this.getGrafoIdSeleccionado()!=-1)
            GWTServiceUsage.asignarArco(arco, getGrafoIdSeleccionado(), null,this);
        else
            Window.alert("no esta un usuario seleccionado");

    }
    public void asignarNodo(Nodo nodo)
    {
        if(this.getGrafoIdSeleccionado()!=-1)
          GWTServiceUsage.asignarNodo(nodo, getGrafoIdSeleccionado(), null,this);
        else
            Window.alert("no esta un usuario seleccionado");

    }
    public void validarNodo(Nodo nodo)
    {
     //    if(this.getGrafoIdSeleccionado()!=-1)
        borrarNodosDePantalla();
             GWTServiceUsage.validarNodo(nodo, grafo);
         /*    else
            Window.alert("no esta un usuario seleccionado");*/

    }
    public void validarArco(Arco arco)
    {
        borrarNodosDePantalla();
     //    if(this.getGrafoIdSeleccionado()!=-1)
             GWTServiceUsage.validarArco(arco, grafo);
         /*    else
            Window.alert("no esta un usuario seleccionado");*/

    }

    /**
     * @return the grafoIdSeleccionado
     */
    public int getGrafoIdSeleccionado() {
        return grafoIdSeleccionado;
    }


///-------------------------
public Grafo getGrafo(){
    return grafo;
}

    

}
