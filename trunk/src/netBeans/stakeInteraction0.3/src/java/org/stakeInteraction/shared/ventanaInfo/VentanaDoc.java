/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.shared.ventanaInfo;


import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextArea;

import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FormData;

import org.stakeInteraction.client.ventanaGrafo.mediador.ContenedorGrafo;
import org.stakeInteraction.shared.EstrategiaDibujar.EstrategiaDibujarDoc;
import org.stakeInteraction.shared.Informacion.Documento;
import org.stakeInteraction.shared.Informacion.Informacion;
import org.stakeInteraction.shared.handler.BotonActualizaroCrearDocumentoHandler;

/**
 *
 * @author grela
 */
public class VentanaDoc extends VentanaInfo{
private FormData formData;
private  TextField<String> nombre;
private TextField<String> link;
private FormPanel simple;
 private TextArea cuerpoDoc;
 private Documento documento;
    public VentanaDoc( )
    {
        super();
         formData = new FormData("-20");
         
     this.simple= new FormPanel();
    this.simple.setHeading("Formulario Documento");

    this.simple.setFrame(true);
    this.simple.setWidth(this.window.getWidth());

    this.nombre = new TextField<String>();
    nombre.setFieldLabel("Nombre");
    nombre.setAllowBlank(false);
    nombre.getFocusSupport().setPreviousId(this.window.getButtonBar().getId());
    this.simple.add(nombre, formData);

    this.link = new TextField<String>();
    this.link.setFieldLabel("Link");
    this.link.setAllowBlank(false);
    this.simple.add(this.link, formData);

    this.cuerpoDoc= new TextArea();
    this.cuerpoDoc.setPreventScrollbars(true);
    this.cuerpoDoc.setFieldLabel("Cuerpo documento");

    this.simple.add(this.cuerpoDoc, formData);
    
  
   //this.handler=new BotonActualizarDetallesInfoDocumentoHandler(this);
   this.window.add(this.simple);



    }
    
    public void setVentanaActualizar(ContenedorGrafo contenedorGrafo)
    {
          this.BotonGuardar=new com.extjs.gxt.ui.client.widget.button.Button("Actualizar");
          this.simple.add(this.BotonGuardar);
          this.handler=new BotonActualizaroCrearDocumentoHandler(this,contenedorGrafo);
    }
    public void setVentanaCrear(ContenedorGrafo contenedorGrafo)
    {
        this.contenedorGrafo=contenedorGrafo;
          this.BotonGuardar=new com.extjs.gxt.ui.client.widget.button.Button("Crear");
          this.simple.add(this.BotonGuardar);
          this.handler=new BotonActualizaroCrearDocumentoHandler(this,contenedorGrafo);
    }


  

    @Override
    public void cargarVentana(Informacion info) {
        this.documento=(Documento)info;


       // this.window.add(new Label(doc.getCuerpoDocumento()));
        this.getFirstName().setValue(documento.getNombre());
        this.getLink().setValue(documento.getLink());
        this.getCuerpoDoc().setValue(documento.getCuerpoDocumento());
        
        this.window.layout(true);
    }

    /**
     * @return the firstName
     */
    public TextField<String> getFirstName() {
        return nombre;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(TextField<String> firstName) {
        this.nombre = firstName;
    }

    /**
     * @return the link
     */
    public TextField<String> getLink() {
        return link;
    }

    /**
     * @param link the link to set
     */
    public void setLink(TextField<String> link) {
        this.link = link;
    }

    /**
     * @return the cuerpoDoc
     */
    public TextArea getCuerpoDoc() {
        return cuerpoDoc;
    }

    /**
     * @param cuerpoDoc the cuerpoDoc to set
     */
    public void setCuerpoDoc(TextArea cuerpoDoc) {
        this.cuerpoDoc = cuerpoDoc;
    }

    public Documento getDocumento()
    {
        return this.documento;
    }
    public void copiarCamposADocumento()
    {
        if(documento==null)
            documento=new Documento(-1,"","",new EstrategiaDibujarDoc());
        this.documento.setCuerpoDocumento(this.cuerpoDoc.getValue());
        this.documento.setLink(this.link.getValue());
        this.documento.setNombre(this.nombre.getValue());
    }

    @Override
    public void deshabilitarVentana() {
        this.BotonGuardar.disable();
        this.cuerpoDoc.disable();
        this.link.disable();
        this.nombre.disable();

    }
}
