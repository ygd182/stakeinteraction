package org.stakeInteraction.client.ventanaGrafo.mediador;


import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;

import com.orange.links.client.DiagramController;
import org.stakeInteraction.client.GWTServiceUsage;
import org.stakeInteraction.shared.CuentaUsuario.CuentaUsuario;
import org.stakeInteraction.shared.grafo.Grafo;
import org.stakeInteraction.shared.grafo.Nodo;
import org.stakeInteraction.shared.handler.GrafoNodoHandler;
import org.stakeInteraction.shared.ventanaInfo.VentanaInfo;





public class DirectorDialogoGrafo extends DirectorDialogo{

	
     
       private ContenedorGrafo contenedorGrafo;
       private ContentPanelPrincipal contentPanelPrincipal;
       private PanelDeInformacion panelDeInformacion;
       private VentanaPrincipal ventanaPrincipal;
       private OpcionesAdminGrafoAcordion opcionesAdminGrafoAcordion;
       private boolean habilitarActualizar;
       

   


      

	
	public DirectorDialogoGrafo(ContenedorGrafo contenedorGrafo)
	{
            this.contenedorGrafo=contenedorGrafo;
            this.contenedorGrafo.agregarDirector(this);

        }
	@Override
	public void crearUtiles() {
          
         
             this.contentPanelPrincipal=new ContentPanelPrincipal(this.contenedorGrafo);
             this.contentPanelPrincipal.agregarDirector(this);
          
             this.panelDeInformacion=new PanelDeInformacion();
             this.panelDeInformacion.agregarDirector(this);
             GrafoNodoHandler grafoNodoHandler=new GrafoNodoHandler(this.contenedorGrafo,this.panelDeInformacion);
             this.contenedorGrafo.agregarGrafoNodoHandler(grafoNodoHandler);

             this.ventanaPrincipal=new VentanaPrincipal();
             this.ventanaPrincipal.agregarDirector(this);

            
             this.contenedorGrafo.agregarContentPanel((ContentPanel)contentPanelPrincipal.getPanelPrincipal());
             this.contenedorGrafo.agregarVentana(ventanaPrincipal);

             this.opcionesAdminGrafoAcordion=new OpcionesAdminGrafoAcordion(this.contenedorGrafo);
             this.opcionesAdminGrafoAcordion.agregarDirector(this);

             this.contentPanelPrincipal.addOpcionAcordionGrafoIzquierda(this.opcionesAdminGrafoAcordion);
             

             /***new Ventana****/

             /***opciones administrador***********/

        
              
		
	}
        public void agregarControlDeUsuarios()
        {
            this.opcionesAdminGrafoAcordion.setUserManejo();
             Menu contextMenuArco = new Menu();
                contextMenuArco.setWidth(140);
                MenuItem eliminarArco = new MenuItem();
                eliminarArco.setText("Eliminar Arco");
                 eliminarArco.setId("ELIMINAR_ARCO");
                contextMenuArco.add(eliminarArco);
                
            this.contenedorGrafo.agregarCotextMenuArco(contextMenuArco);

          Menu contextMenuNodo = new Menu();
            contextMenuNodo.setWidth(140);
            MenuItem eliminarNodo = new MenuItem();
            eliminarNodo.setText("Eliminar Nodo");
            eliminarNodo.setId("ELIMINAR_NODO");
            contextMenuNodo.add(eliminarNodo);
            this.contenedorGrafo.agregarContextMenuNodo(contextMenuNodo);
            this.habilitarActualizar=false;
         }
          public void agregarControlDeAdmin()
          {
                this.opcionesAdminGrafoAcordion.setAdminManejo();
                 Menu contextMenuArco = new Menu();
                contextMenuArco.setWidth(140);
                MenuItem eliminarArco = new MenuItem();
                eliminarArco.setText("Eliminar Arco");
                eliminarArco.setId("ELIMINAR_ARCO");
                contextMenuArco.add(eliminarArco);
                 MenuItem asignarArco = new MenuItem();
                asignarArco.setText("Asignar Arco");
                asignarArco.setId("ASIGNAR_ARCO");
                contextMenuArco.add(asignarArco);
                MenuItem validarArco = new MenuItem();
                validarArco.setText("Validar Arco");
                validarArco.setId("VALIDAR_ARCO");
                contextMenuArco.add(validarArco);
                this.contenedorGrafo.agregarCotextMenuArco(contextMenuArco);

            Menu contextMenuNodo = new Menu();
            contextMenuNodo.setWidth(140);
            MenuItem eliminarNodo = new MenuItem();
            eliminarNodo.setText("Eliminar Nodo");
            eliminarNodo.setId("ELIMINAR_NODO");
            contextMenuNodo.add(eliminarNodo);
            MenuItem asignarNodo=new MenuItem();
            asignarNodo.setText("Asignar Nodo");
            asignarNodo.setId("ASIGNAR_NODO");
            contextMenuNodo.add(asignarNodo);
            MenuItem validarNodo=new MenuItem();
            validarNodo.setText("Validar Nodo");
            validarNodo.setId("VALIDAR_NODO");
            contextMenuNodo.add(validarNodo);
            this.contenedorGrafo.agregarContextMenuNodo(contextMenuNodo);
            this.habilitarActualizar=true;

        }


	@Override
	public void mostrarDialogo() {

               contenedorGrafo.inicializarContenedorGrafo();
                             

                DiagramController controller=contenedorGrafo.getControllerGrafo();

                contentPanelPrincipal.addControllerGrafo(controller.getViewAsScrollPanel());
                
                

                contentPanelPrincipal.MostrarPanelPrincipal();

              /**ventana addGrafoAdminPanel****/
            //    window.add(contentPanelPrincipal.getPanelPrincipal());
                this.ventanaPrincipal.agregarPanel(contentPanelPrincipal.getPanelPrincipal());
             /**mostrarVentana*****/
              
                this.panelDeInformacion.inicializarPanelDeInfo();
                //this.panelDeInformacion.addLabelInfo("Presiones en los nodos\npara ver detalles");
                this.panelDeInformacion.mostrarTitulo();
                contentPanelPrincipal.addVerticalPanelDerecha(this.panelDeInformacion.obtenerPanelDeInfo());
                this.contenedorGrafo.agregarPanelDeInfo(panelDeInformacion);

               //window.show();
                this.ventanaPrincipal.mostrar();
           


                      
	}

	@Override
	public void utilModificado(Util u) {
            if(u==this.panelDeInformacion)
            {
                Nodo nodo=this.contenedorGrafo.getNodoSeleccionado();
                if(nodo!=null)
                {
                    if(this.panelDeInformacion.isBotonVerDetallesPress())
                    {

                            VentanaInfo ventanaInfo=nodo.getInformacion().getEstrategiaDibujarNodo().crearVentanaInfo(nodo.getInformacion(),this.contenedorGrafo);
                            if(this.habilitarActualizar==false)
                            {
                                if(nodo.isValido())
                                {
                                   ventanaInfo.deshabilitarVentana();
                                }
                            }
                            this.panelDeInformacion.presionarBotonVerDetalles(false);
                           
                    }
                    else
                    {

                       this.panelDeInformacion.mostrarInfo(nodo.getInformacion());
                       this.ventanaPrincipal.redibujar();
                 
                     }
                }else
                {
                    this.panelDeInformacion.mostrarTitulo();
                     this.ventanaPrincipal.redibujar();
                }
            }
            else
                if(u==this.ventanaPrincipal)
                {
                     this.contentPanelPrincipal.redibujar();
                     this.contenedorGrafo.repintar();
                     this.ventanaPrincipal.redibujar();
                     DiagramController controller=contenedorGrafo.getControllerGrafo();
                     controller.update();
                     int a=controller.getViewAsScrollPanel().getScrollPosition()+1;
                     controller.getViewAsScrollPanel().setScrollPosition(a);
                     this.contentPanelPrincipal.setTamanio(this.ventanaPrincipal.getWight(),this.ventanaPrincipal.getHeight());
                     int b=controller.getViewAsScrollPanel().getVerticalScrollPosition();
                     controller.getViewAsScrollPanel().setVerticalScrollPosition(b+1);
                     int c=controller.getViewAsScrollPanel().getHorizontalScrollPosition();
                     controller.getViewAsScrollPanel().setHorizontalScrollPosition(c+1);

                     controller.getViewAsScrollPanel().setScrollPosition(a);


                }
                else
                       if(u==this.opcionesAdminGrafoAcordion)
                        {
                            if(this.opcionesAdminGrafoAcordion.isBotonesPresionados())
                            {
                               VentanaInfo ventanaInfo=this.opcionesAdminGrafoAcordion.getVentanaSegunEstado();
                           // ventanaInfo.agregarContenedorGrafo(contenedorGrafo);
                            }
                            else
                            {
                                CuentaUsuario cu=this.opcionesAdminGrafoAcordion.getCuentaUsuarioSeleccionado();
                                if(cu!=null)
                                {
                                    GWTServiceUsage.pedirGrafoFiltrado(cu.getGrafo().getId(), contenedorGrafo);
                                }
                                else
                                {
                                    contenedorGrafo.marcarGrafo(new Grafo());
                                }
                            }
                        }
                        else
                            if(u==this.contenedorGrafo)
                            {
                           /*     if(this.habilitarActualizar)
                                  this.opcionesAdminGrafoAcordion.seleccionarUsuario();*/
                                /*this.contenedorGrafo.borrarNodosDePantalla();
                                this.contenedorGrafo.dibujarGrafo();*/
                               // CuentaUsuario cu=this.opcionesAdminGrafoAcordion.getCuentaUsuarioSeleccionado();


                            }
		
	}
	
	

}
