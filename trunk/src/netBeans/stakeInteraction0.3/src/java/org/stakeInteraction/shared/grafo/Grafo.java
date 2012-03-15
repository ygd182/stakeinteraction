package org.stakeInteraction.shared.grafo;


import java.io.Serializable;
import java.util.*;
import org.stakeInteraction.shared.VisitanteGrafo.ElementoVisitado;
import org.stakeInteraction.shared.VisitanteGrafo.VisitanteGrafo;
import org.stakeInteraction.shared.observador.Sujeto;
public class Grafo extends Sujeto implements Serializable,ElementoVisitado{

	private Vector<Nodo> _nodos;
	//private Hashtable<Nodo,String> _colores; 
	//private Hashtable<Nodo,Nodo> _camino;
	private HashMap<Nodo,String> _colores; 
	private HashMap<Nodo,Nodo> _camino;
        private int id=-1;

	public Grafo()
	{
		this._nodos=new Vector<Nodo>();
		this._colores=new HashMap<Nodo,String>();
		this._camino=new HashMap<Nodo,Nodo>();
	
	}

        public Grafo(int id)
	{
		this._nodos=new Vector<Nodo>();
		this._colores=new HashMap<Nodo,String>();
		this._camino=new HashMap<Nodo,Nodo>();
                this.id=id;

	}
	public void agregarNodo(Nodo n)
	{
		_nodos.add(n);
	
	}
	
	public  void recorrerDFS()
	{
		for(Iterator<Nodo> i=_nodos.iterator();i.hasNext();)
		{
		  Nodo currentN=i.next(); 
		  _colores.put(currentN,"BLANCO");
		  //camino.put(currentN,null );
		  //i.next().setColor("BLANCO");
		  _camino.clear();
		  
		}
		
		for(Iterator<Nodo> i=_nodos.iterator();i.hasNext();)
		{
			Nodo u=i.next();
			//if(n.getColor()=="BLANCO")
			  //DFSVisit(n);
			if(_colores.get(u)=="BLANCO")
				visitarDFS(u);
		}
	}
	public void visitarDFS(Nodo u)
	{
		//n.setColor("GRIS");
		_colores.put(u,"GRIS");
		List<Arco> adyacentes=u.getAdyacentes();
		for(Iterator<Arco> i=adyacentes.iterator();i.hasNext();)
		{
			Nodo v=((Arco)i.next()).GetNodo();
			//if(u.getColor()=="BLANCO")
			if(_colores.get(v)=="BLANCO")
			{
				_camino.put(v, u);
				this.visitarDFS(v);
			}
		}
		//n.setColor("NEGRO");
		_colores.put(u,"NEGRO");
		System.out.println("estoy en el nodo: "+u.toString());
	}
	public void recorrerCaminoDesdeNodo(Nodo raizNodo)
	{
		/*for(Enumeration<Nodo> i=this.camino.elements();i.hasMoreElements();)
		{
			
		
		}*/
		System.out.println("Parto del nodo: "+raizNodo.toString());
		//raizNodo.imprimir();
		Nodo auxNodo=_camino.get(raizNodo);
		while(auxNodo!=null)
		{
			System.out.println("estoy en el nodo: "+auxNodo.toString());
			//auxNodo.imprimir();
			auxNodo=_camino.get(auxNodo);
			
		
		}
		
	
	}
	
	public Vector<Nodo> getAllNodos()
	{
		return this._nodos;
	}
	
	public int getCantDeNodos()
	{
		return this._nodos.size();
	}

        public void clonar(Grafo g1)
    {



       


            this._nodos=g1.getAllNodos();

        }

    @Override
    public void aceptar(VisitanteGrafo v) {
       v.visitarGrafo(this);
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }


	
	

}
