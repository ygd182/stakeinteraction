package org.stakeInteraction.shared.grafo;

//import com.orange.links.client.connection.Connection;

import java.io.Serializable;

import org.stakeInteraction.shared.VisitanteGrafo.ElementoVisitado;
import org.stakeInteraction.shared.VisitanteGrafo.VisitanteGrafo;



public class Arco implements Serializable,ElementoVisitado{
	private int id;
	
	private Nodo nodo;
        private int idNodoOrigen;
//        private Connection connection;

        private boolean valido;
        private boolean marcado=false;
	

	public Arco(Nodo n)
	{
            this.id=-1;
            this.nodo=n;
	
	}

        public Arco(Nodo n, int idNodo)
	{
		this.id=-1;
                this.nodo=n;
                this.idNodoOrigen=idNodo;

	}

        public Arco(Nodo n, int idNodoOrigen,boolean valido)
	{
		this.nodo=n;
                this.idNodoOrigen=idNodoOrigen;
                this.valido=valido;
                this.id=-1;

	}

         public Arco(Nodo n,int id, int idNodoOrigen,boolean valido)
	{
		this.nodo=n;
                this.idNodoOrigen=idNodoOrigen;
                this.valido=valido;
                this.id=id;

	}

	public Arco()
	{
	        id=-1;
            //this.nodo=n;
	
	}

	public Nodo GetNodo()
	{
		return this.nodo;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setNodo(Nodo nodo) {
		this.nodo = nodo;
	}
	public Nodo getNodo() {
		return nodo;
	}

    /**
     * @return the idNodoOrigen
     */
    public int getIdNodoOrigen() {
        return idNodoOrigen;
    }

    /**
     * @param idNodoOrigen the idNodoOrigen to set
     */
    public void setIdNodoOrigen(int idNodoOrigen) {
        this.idNodoOrigen = idNodoOrigen;
    }

    @Override
    public void aceptar(VisitanteGrafo v) {
       v.visitarArco(this);
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

    /**
     * @return the marcado
     */
    public boolean isMarcado() {
        return marcado;
    }

    /**
     * @param marcado the marcado to set
     */
    public void setMarcado(boolean marcado) {
        this.marcado = marcado;
    }

}
