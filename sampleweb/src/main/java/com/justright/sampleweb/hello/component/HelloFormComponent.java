package com.justright.sampleweb.hello.component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.justright.component.FormComponent;
import com.justright.component.annotation.ClientStored;
import com.justright.component.annotation.EventListener;
import com.justright.component.annotation.InputValidation;
import com.justright.component.annotation.WebComponent;
import com.justright.exception.WebException;
import com.justright.xml.Raw;

@WebComponent(id="HelloForm",xmlFile="helloFormComponent.xml")
public class HelloFormComponent extends FormComponent<HelloFormComponentModel>{

	private HelloFormComponentModel model;
	
	@ClientStored
	private Integer someSavedValue;
	
	@ClientStored 
	private Raw raw;
	
	public HelloFormComponent(){
	}
	
	@Override
	@InputValidation(HelloFormComponentValidator.class)
	public HelloFormComponentModel getInputModel() {
		if(model == null){
			model = new HelloFormComponentModel();
		}
		return model;
	}
	
	@EventListener("button1")
	public void button1Clicked() {
		System.out.println("HelloComponent receives button1 click");
		someSavedValue = 10;
		raw.setValue("Clientstored value Changed by click1");
		addContent("id1", new Raw("Button1 clicked. Input is: '" + getInputModel().getFormInput() + "' Client stored is: '" + someSavedValue + "'<br/> "));
	}

	@EventListener("button2")
	public void button2Clicked() {
		System.out.println("HelloComponent receives button2 click");
		addContent("id1", new Raw("Button2 clicked. Input is: '" + getInputModel().getFormInput() + "' Client stored is: '" + someSavedValue + "'<br/> "));
	}

	@EventListener("button3")
	public void button3Clicked() throws WebException {
		System.out.println("HelloComponent receives button3 click");
		List list = new ArrayList();
		list.get(0).toString();
		throw new WebException("My exception");
	}
	
	@Override
	public void assemble() {
		raw = new Raw("Client stored value");
		System.out.println("HelloComponent assembles");
		setContent("id2", new Date().toString());
	}

	@Override
	public void wakeup() {
		setContent("id3",new Date().toString());
		System.out.println("HelloComponent wakes up");
	}


}
