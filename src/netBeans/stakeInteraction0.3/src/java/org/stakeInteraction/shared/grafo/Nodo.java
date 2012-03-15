package org.stakeInteraction.shared.grafo;



import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.google.gwt.user.client.ui.Widget;
import java.io.Serializable;
import java.util.*;
import org.stakeInteraction.client.ventanaGrafo.mediador.ContenedorGrafo;
import org.stakeInteraction.shared.VisitanteGrafo.ElementoVisitado;
import org.stakeInteraction.shared.VisitanteGrafo.VisitanteGrafo;
import org.stakeInteraction.shared.widgets.NodoVisual;


import org.stakeInteraction.shared.Informacion.Informacion;

public class Nodo implements Serializable,ElementoVisitado {
	//private Vector<Nodo> _adyacentes;
	//private String _color; 
	//private String nombre;
	

	private List adyacentes;

	private int id;
        private NodoVisual nodoVisual;

        private Informacion informacion;
        private boolean valido;

	public Nodo(Informacion informacion,boolean valido)
	{
		adyacentes=new Vector<Arco>();
		//this._color="BLANCO";
		//this.nombre=nombre;
                this.informacion=informacion;
                this.valido=valido;
                this.id=-1;
	
	}

        public Nodo(int id,Informacion informacion,boolean valido)
	{
		adyacentes=new Vector<Arco>();
		//this._color="BLANCO";
		//this.nombre=nombre;
                this.informacion=informacion;
                this.valido=valido;
                this.id=id;

	}

        public Nodo(Informacion informacion)
	{
		adyacentes=new Vector<Arco>();
		//this._color="BLANCO";
		//this.nombre=nombre;
                this.informacion=informacion;
                this.id=-1;
	
	}
	
	public Nodo()
	{
		adyacentes=new Vector<Arco>();
                id=-1;
		
	
	}
	/*
	public Nodo(int id,String nombre,List adyacentes)
	{
		this.adyacentes=adyacentes;
		//this._color="BLANCO";
		this.nombre=nombre;
	
	}*/
	public List<Arco> getAdyacentes()
	{
		
		return this.adyacentes;
	
	
	}
	public void agregarAdyacente(Arco arco)
	{
		this.adyacentes.add(arco);
	
	}
	
	public void eliminarAdyacente(Arco arco)
	{
		if(this.adyacentes.remove(arco))
		{
			System.out.print("se ha eliminado el arco que llevaba al nodo: "+arco.getNodo().getId());
		
		}
	
	}

	public void imprimir()
	{
		System.out.print(" "+this.id+" ");
	}
	
	public String toString()
	{
		return this.id+" ";

	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void setAdyacentes(List adyacentes) {
		this.adyacentes = adyacentes;
	}

	
	/*public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
*/
    /**
     * @return the documento
     */
    public Informacion getInformacion() {
        return this.informacion;
    }

    /**
     * @param documento the documento to set
     */
    public void setInformacion(Informacion informacion) {
        this.informacion = informacion;
    }

    public void dibujarNodo(ContenedorGrafo contenedorGrafo,Menu ContextMenu)
    {
        this.nodoVisual=this.informacion.getEstrategiaDibujarNodo().crearNodoVisual(this,contenedorGrafo,ContextMenu);
        

    }
    public void borrarNodoVisual()
    {
        this.nodoVisual=null;
    }

    /**
     * @return the nodoVisual
     */
    public NodoVisual getNodoVisual() {
        return nodoVisual;
    }

    @Override
    public void aceptar(VisitanteGrafo v) {
       v.visitarNodo(this);
    }

    /**
     * @return the valido
     */
    public boolean isValido() {
        return valido;
    }

    /**
     * @param valido the valido to set
     */
    public void setValido(boolean valido) {
        this.valido = valido;
    }
public Arco estaConectadoA(Nodo nodo)
    {

    for(Iterator<Arco> i=adyacentes.iterator();i.hasNext();)
    {
        Arco a=i.next();
        if(nodo==a.GetNodo())
        {
            return a;
        }
        
    }
    return null;
 }


public void eliminarAdyacente(int id){
       List<Arco> ady=null;
             Arco a=null;
             ady=this.getAdyacentes();  //esto es lo de los adyacentes
                     for(int j=0;j<ady.size();j++){
                        a=ady.get(j);
                       if(a.getId()==id){
                           ady.remove(j);
                           j=ady.size()+1;
                       }

}
    }
 
        
}
