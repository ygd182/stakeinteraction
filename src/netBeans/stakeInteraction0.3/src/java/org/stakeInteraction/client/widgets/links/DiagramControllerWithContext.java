/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.client.widgets.links;

import com.orange.links.client.DiagramController;



import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.google.gwt.user.client.ui.InlineHTML;
import com.google.gwt.user.client.ui.Widget;

import com.orange.links.client.connection.Connection;
import com.orange.links.client.connection.StraightArrowConnection;

import com.orange.links.client.menu.ContextMenu;
import com.orange.links.client.menu.HasContextMenu;
import com.orange.links.client.shapes.DecorationShape;
import com.orange.links.client.shapes.FunctionShape;
import com.orange.links.client.shapes.Point;
import com.orange.links.client.shapes.Shape;
import com.orange.links.client.utils.MovablePoint;
import java.util.HashMap;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;

import org.stakeInteraction.client.GWTService;
import org.stakeInteraction.client.GWTServiceUsage;
import org.stakeInteraction.client.ventanaGrafo.mediador.ContenedorGrafo;
import org.stakeInteraction.shared.grafo.Arco;
import org.stakeInteraction.shared.handler.ContexMenuArcoHandler;

import org.stakeInteraction.shared.widgets.NodoVisual;
/**
 *
 * @author grela
 */
public class DiagramControllerWithContext extends DiagramController{
     private ContenedorGrafo contenedorGrafo;
     private Menu contextMenu;
     private Map<Integer,Connection> conexionesMap;
     private ContexMenuArcoHandler contexMenuArcoHandler;
    //private boolean menuAdmin;
    public DiagramControllerWithContext(int canvasWith,int canvasHeith,ContenedorGrafo contenedorGrafo)
    {
        super(canvasWith,canvasHeith);
        this.contenedorGrafo=contenedorGrafo;
        this.conexionesMap=new HashMap<Integer,Connection>();

      //  this.menuAdmin=false;
        

    }


    public Connection drawStraightArrowConnection(Widget startWidget, Widget endWidget,Arco arco)
    {
        Connection con=super.drawStraightArrowConnection(startWidget, endWidget);




        this.conexionesMap.put(arco.getId(), con);
        return con;


    }

    public Connection getConection(int arcoId)
    {
        return this.conexionesMap.get(arcoId);
    }

    public void setContextMenu(Menu contextMenu)
    {
        this.contextMenu=contextMenu;
        this.contexMenuArcoHandler=new ContexMenuArcoHandler(null, contextMenu, contenedorGrafo);
    }

   private NodoVisual buscarNodoVisualEnMap(FunctionShape shape)
    {
                for(Iterator<Map.Entry<Widget,FunctionShape>> i=this.widgetShapeMap.entrySet().iterator();i.hasNext();)
                {
                    Map.Entry<Widget,FunctionShape> entry=i.next();
                    if(shape==entry.getValue())
                    {
                      //  Window.alert("lo encontcro");
                        return (NodoVisual)entry.getKey();

                    }

                }
                return null;

   }
    @Override
   protected void showContextualMenu() {
		final Connection c = getConnectionNearMouse();
                FunctionShape shapeOrigen=(FunctionShape) c.getStartShape();
                FunctionShape shapeFin=(FunctionShape) c.getEndShape();
                NodoVisual nodoOrigen = buscarNodoVisualEnMap(shapeOrigen);
                NodoVisual nodoFin = buscarNodoVisualEnMap(shapeFin);
     
                final Arco arco=nodoOrigen.getNodo().estaConectadoA(nodoFin.getNodo());
                MenuItem menuItem=(MenuItem)this.contextMenu.getItemByItemId("ASIGNAR_ARCO");
                if(menuItem!=null){
                  if((!nodoOrigen.isMarcado())|| (!nodoFin.isMarcado()))
                      menuItem.disable();
                  else
                  {
                    if(arco.isMarcado()||(c.getDecoration()!=null))//esto es para que no pueda asignar arcos no habilitados
                    {
                      menuItem.disable();
                    }
                    else
                    {
                        menuItem.enable();
                    }
                    }
                 }
                   MenuItem menuItemVal=(MenuItem)this.contextMenu.getItemByItemId("VALIDAR_ARCO");
                   if(menuItemVal!=null)
                   {
                       if(arco.isValido())
                           menuItemVal.disable();
                       else
                           menuItemVal.enable();
                   }

             /*   Menu contextMenu = new Menu();
                contextMenu.setWidth(140);
                MenuItem eliminar = new MenuItem();
                eliminar.setText("Eliminar Arco");
                contextMenu.add(eliminar);
                ContexMenuArcoUserHandler contexMenuArcoHandler=new ContexMenuArcoUserHandler(arco, contextMenu, contenedorGrafo);
*/
                this.contexMenuArcoHandler.setArco(arco);
                contextMenu.show(this.getView());
                contextMenu.setPosition(mouseOffsetPoint.getLeft()+5, mouseOffsetPoint.getTop()+5);

          
    }

              


    @Override
	protected void showMenu(final HasContextMenu c) {
		showMenu(c, mouseOffsetPoint.getLeft(), mouseOffsetPoint.getTop());
	}

    @Override
	protected void showMenu(final HasContextMenu c, int left, int top) {
		ContextMenu menu = c.getContextMenu();
		if (menu != null) {
			menu.setPopupPosition(left, top);
			menu.show();
                        //Window.alert("hoal");
		}
	}
    public void borrarDecoraciones()
    {
        for(Iterator<Integer> i=this.conexionesMap.keySet().iterator();i.hasNext(); )
        {
            Connection con=this.conexionesMap.get(i.next());
            this.removeDecoration(con);
        }
       /* for(Iterator<Integer> i=this.conexionesMap.keySet().iterator();i.hasNext(); )
        {
             Connection con=this.conexionesMap.get(i.next());
            
           InlineHTML decoration=new InlineHTML();
           decoration.setHTML("<img src="+"imagen/alertaArco1.gif"+" alt=some_text/>");
           addDecoration(decoration, con);
        }*/

    }



}
