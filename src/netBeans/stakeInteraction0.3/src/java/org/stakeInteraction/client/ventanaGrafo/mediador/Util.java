package org.stakeInteraction.client.ventanaGrafo.mediador;

import com.google.gwt.user.client.ui.Widget;

public abstract class Util {
	private DirectorDialogo director;
	
	public void modificado()
	{
		this.director.utilModificado(this);
	}
        public void agregarDirector(DirectorDialogo director)
    {
            this.director=director;
        }
	public abstract void manejarRaton();
   //     public abstract  Widget Dibujar();
    //    public abstract Widget DibujarDetalles();

}
