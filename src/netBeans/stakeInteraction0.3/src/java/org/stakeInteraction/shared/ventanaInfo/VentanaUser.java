/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.shared.ventanaInfo;

import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import org.stakeInteraction.client.ventanaGrafo.mediador.ContenedorGrafo;
import org.stakeInteraction.shared.EstrategiaDibujar.EstrategiaDibujarUser;
import org.stakeInteraction.shared.Informacion.Informacion;
import org.stakeInteraction.shared.Informacion.Usuario;
import org.stakeInteraction.shared.handler.BotonActualizarCrearUsuarioHandler;

/**
 *
 * @author grela
 */
public class VentanaUser extends VentanaInfo{
       private FormData formData;
private  TextField<String> nombre;
private TextField<String> link;
private TextField<String> nombreReal;
private TextField<String> apellido;
private TextField<String> edad;
private TextField<String> cargo;
private FormPanel simple;
private Usuario usuario;

//private Button botonGuardar;


 public VentanaUser()
    {

     
        super();


        this.formData = new FormData("-20");

     this.simple= new FormPanel();
    this.simple.setHeading("Formulario Usuario");

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

    this.nombreReal= new TextField<String>();
    this.nombreReal.setFieldLabel("Nombre Real");
    this.nombreReal.setAllowBlank(false);
    this.simple.add(this.nombreReal, formData);

    this.apellido= new TextField<String>();
    this.apellido.setFieldLabel("Apellido");
    this.apellido.setAllowBlank(false);
    this.simple.add(this.apellido, formData);

    this.edad= new TextField<String>();
    this.edad.setFieldLabel("Edad");
    this.edad.setAllowBlank(false);
    this.simple.add(this.edad, formData);

    this.cargo= new TextField<String>();
    this.cargo.setFieldLabel("Cargo");
    this.cargo.setAllowBlank(false);
    this.simple.add(this.cargo, formData);

   /* this.botonGuardar=new Button("Guardar");
    this.botonGuardar.setWidth("100px");
    this.botonGuardar.setPosition(30,30);*/

       //this.handler=new BotonActualizarDetallesInfoUsuarioHandler(this);

   this.window.add(this.simple);
    }

 public void setVentanaActualizar(ContenedorGrafo contenedorGrafo)
    {
          this.BotonGuardar=new com.extjs.gxt.ui.client.widget.button.Button("Actualizar");
          this.simple.add(this.BotonGuardar);
          this.handler=new BotonActualizarCrearUsuarioHandler(this,contenedorGrafo);
    }
  public void setVentanaCrear(ContenedorGrafo contenedorGrafo)
    {
          this.BotonGuardar=new com.extjs.gxt.ui.client.widget.button.Button("Crear");
          this.simple.add(this.BotonGuardar);
          this.handler=new BotonActualizarCrearUsuarioHandler(this,contenedorGrafo);
    }

    @Override
    public void cargarVentana(Informacion info) {
        this.setUsuario((Usuario) info);
        this.getFirstName().setValue(getUsuario().getNombre());
        this.getLink().setValue(getUsuario().getLink());
        this.getApellido().setValue(getUsuario().getApellido());
        this.getNombreReal().setValue(getUsuario().getNombreReal());
        this.getCargo().setValue(getUsuario().getCargo());
        this.getEdad().setValue(getUsuario().getEdad());

        //this.window.add(new Label(user.getApellido()));
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
    public void setNombre(TextField<String> nombre) {
        this.nombre = nombre;
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
     * @return the nombreReal
     */
    public TextField<String> getNombreReal() {
        return nombreReal;
    }

    /**
     * @param nombreReal the nombreReal to set
     */
    public void setNombreReal(TextField<String> nombreReal) {
        this.nombreReal = nombreReal;
    }

    /**
     * @return the apellido
     */
    public TextField<String> getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(TextField<String> apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the edad
     */
    public TextField<String> getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(TextField<String> edad) {
        this.edad = edad;
    }

    /**
     * @return the cargo
     */
    public TextField<String> getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(TextField<String> cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public void copiarCamposAUsuario()
    {
        if(this.usuario==null)
            new Usuario(-1,"","",new EstrategiaDibujarUser(),"","","","");
        this.usuario.setApellido(this.apellido.getValue());
        this.usuario.setCargo(this.cargo.getValue());
        this.usuario.setEdad(edad.getValue());
        this.usuario.setLink(this.link.getValue());
        this.usuario.setNombre(this.nombre.getValue());
        this.usuario.setNombreReal(this.nombreReal.getValue());



    }

    @Override
    public void deshabilitarVentana() {
        this.apellido.disable();
        this.cargo.disable();
        this.edad.disable();
        this.link.disable();
        this.nombre.disable();
        this.nombreReal.disable();
        this.BotonGuardar.disable();
    }

}
