/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.client;


import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;

import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FormData;

import com.google.gwt.user.client.rpc.AsyncCallback;

import org.stakeInteraction.shared.CuentaUsuario.CuentaUsuario;
import org.stakeInteraction.shared.EstrategiaDibujar.EstrategiaDibujarPantallaPrincipal;




/**
 *
 * @author Jorge
 */
public class Login extends Window {

  /*  private Label userLabel,passLabel;
             TextField<String> usuario,pass;*/
    private  TextField<String> pass,  usuario;
    FormPanel simple;
    FormData formData;

    private boolean datosCorrectos;


    public Login(){
  
  datosCorrectos=false;



        formData= new FormData("-20");

         simple = new FormPanel();
    simple.setHeading("Login");


    simple.setFrame(true);
    simple.setWidth(350);

   usuario = new TextField<String>();
    usuario.setFieldLabel("Usuario");
    usuario.setAllowBlank(false);
    usuario.getFocusSupport().setPreviousId(simple.getButtonBar().getId());
    simple.add(usuario, formData);

    pass = new TextField<String>();
    pass.setFieldLabel("Contraseña");
    pass.setAllowBlank(false);
    simple.add(pass,formData);
    final Login l=this;
    Button conectar=new Button("Conectar" ,new SelectionListener<ButtonEvent>() {
      @Override
      public void componentSelected(ButtonEvent ce) {
         conectar();
      }
    });


    simple.add(conectar);
    //this.add(simple);
    
    //this.setMaximizable(true);

    this.add(simple);
     this.setClosable(false);
     this.show();
     this.setVisible(true);
     
       this.setWidth(simple.getWidth()+10);
  this.setHeight(simple.getHeight()+30);
      
            
    //this.layout(true);
  
            
    }




    private void ocultar()
    {
      //  RootPanel.get().remove(this);
        this.hide();
    }


private void conectar(){
   // usuario.setValue("admin1");
    //pass.setValue("1234");

     final AsyncCallback<CuentaUsuario> callback = new AsyncCallback<CuentaUsuario>() {
            @Override
            public void onSuccess(CuentaUsuario cuenta) {
                if(cuenta!=null){
                    datosCorrectos=true;
              ocultar();

             cuenta.getEstrategia().crearSesion(cuenta);
              EstrategiaDibujarPantallaPrincipal estr=cuenta.getEstrategia().crearEstrategiaDibujarPantalla();

              estr.dibujarPantalla();
                }
               else{
                       final Listener<MessageBoxEvent> l = new Listener<MessageBoxEvent>() {
                        public void handleEvent(MessageBoxEvent ce) {
                               com.google.gwt.user.client.Window.Location.reload();

                          }
                        };
                       PantallaMensaje.mostrarDialogo("Datos incorrectos",l);
                      
                   }
             
            }

            @Override
            public void onFailure(Throwable caught) {
                 
                 PantallaMensaje.mostrarDialogo("Error al conectar",null);

            }
        };


       Service.getService().conectar(usuario.getValue(),pass.getValue(),callback);

}


private void reset(){
     usuario.setValue("");
    pass.setValue("");
}



}
