/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.stakeInteraction.client;




import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.core.XDOM;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.ComponentPlugin;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.CheckBoxGroup;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FormButtonBinding;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.TimeField;
import com.extjs.gxt.ui.client.widget.layout.FormData;



/**
 *
 * @author Jorge
 */
public class CargarProyecto extends VerticalPanel {



     private  FormPanel simple;
  private FormData formData;



  public CargarProyecto(){
      createForm1();
  }

 

private void   createForm1()  {
    simple = new FormPanel();
    simple.setHeading("Crear Poyecto");
    simple.setFrame(true);
    simple.setWidth(400);

  /*  ComponentPlugin plugin = new ComponentPlugin() {
      public void init(Component component) {
        component.addListener(Events.Render, new Listener<ComponentEvent>() {
          public void handleEvent(ComponentEvent be) {
            El elem = be.getComponent().el().findParent(".x-form-element", 3);
            // should style in external CSS  rather than directly
            elem.appendChild(XDOM.create("<div style='color: #615f5f;padding: 1 0 2 0px;'>" + be.getComponent().getData("text") + "</div>"));
          }
        });
      }
    };*/

    TextField<String> nombre = new TextField<String>();
    nombre.setFieldLabel("Nombre");
    nombre.setAllowBlank(false);
  // nombre.addPlugin(plugin);
    nombre.setData("text", "Enter your fist name");
    simple.add(nombre, formData);

    TextField<String> email = new TextField<String>();
    email.setFieldLabel("Email");
    email.setAllowBlank(false);
  //  email.addPlugin(plugin);
    email.setData("text", "Enter you email (required)");
    simple.add(email, formData);




    DateField date = new DateField();
    date.setFieldLabel("Birthday");
 //   date.addPlugin(plugin);
    date.setData("text", "Enter your birthday");
    simple.add(date, formData);

    TimeField time = new TimeField();
    time.setFieldLabel("Time");
 //   time.addPlugin(plugin);
    time.setData("text", "Enter the time");
    simple.add(time, formData);

   

    CheckBox check1 = new CheckBox();
    check1.setBoxLabel("Classical");

    CheckBox check2 = new CheckBox();
    check2.setBoxLabel("Rock");
    check2.setValue(true);

    CheckBox check3 = new CheckBox();
    check3.setBoxLabel("Blues");

    CheckBoxGroup checkGroup = new CheckBoxGroup();
    checkGroup.setFieldLabel("Music");
    checkGroup.add(check1);
    checkGroup.add(check2);
    checkGroup.add(check3);
  // checkGroup.addPlugin(plugin);
    checkGroup.setData("text", "Select your favorite music type");
    simple.add(checkGroup, formData);

    Radio radio = new Radio();
    radio.setBoxLabel("Red");
    radio.setValue(true);

    Radio radio2 = new Radio();
    radio2.setBoxLabel("Blue");

    RadioGroup radioGroup = new RadioGroup();
    radioGroup.setFieldLabel("Favorite Color");
    radioGroup.add(radio);
    radioGroup.add(radio2);
//    radioGroup.addPlugin(plugin);
    radioGroup.setData("text", "Select your favorite color");
    simple.add(radioGroup, formData);

    Radio radio3 = new Radio();
    radio3.setBoxLabel("Apple");
    radio3.setValue(true);

    Radio radio4 = new Radio();
    radio4.setBoxLabel("Banana");

    RadioGroup radioGroup2 = new RadioGroup();
    radioGroup2.setFieldLabel("Favorite Fruit");
    radioGroup2.add(radio3);
    radioGroup2.add(radio4);
  //  radioGroup2.addPlugin(plugin);
    radioGroup2.setData("text", "Select you favorite fruit");
    simple.add(radioGroup2, formData);

    TextArea description = new TextArea();
    description.setPreventScrollbars(true);
    description.setFieldLabel("Description");
    description.setHeight(200);
    simple.add(description, formData);

    Button b = new Button("Submit");
    simple.addButton(b);
    simple.addButton(new Button("Cancel"));

    simple.setButtonAlign(HorizontalAlignment.CENTER);

    FormButtonBinding binding = new FormButtonBinding(simple);
    binding.addButton(b);

    
   this.add(simple);
  }



}
