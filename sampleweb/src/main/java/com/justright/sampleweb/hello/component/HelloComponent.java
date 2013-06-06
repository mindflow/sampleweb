package com.justright.sampleweb.hello.component;

import com.justright.component.FormComponent;
import com.justright.component.annotation.ClientStored;
import com.justright.component.annotation.EventListener;
import com.justright.component.annotation.InputValidation;
import com.justright.session.Session;
import com.justright.xml.Raw;

public class HelloComponent extends FormComponent<HelloComponentModel>{

	private HelloComponentModel model;
	
	@ClientStored
	private Integer someSavedValue;
	
	@ClientStored 
	private Raw raw;
	
	public HelloComponent(Session session){
		super(session,"HelloForm","helloComponent.xml");
		System.out.println("HelloComponent constructs");
	}
	
	@Override
	@InputValidation(HelloComponentValidator.class)
	public HelloComponentModel getInputModel() {
		if(model == null){
			model = new HelloComponentModel();
		}
		return model;
	}
	
	@EventListener("button1")
	public void button1Clicked() {
		System.out.println("HelloComponent receives button1 click");
		someSavedValue = 10;
		raw.setValue("Changed by click1");
		addContent("id1", new Raw("Button1 clicked. Input is: '" + getInputModel().getFormInput() + "' Client stored is: '" + someSavedValue + "'<br/> "));
	}

	@EventListener("button2")
	public void button2Clicked() {
		System.out.println("HelloComponent receives button2 click");
		addContent("id1", new Raw("Button2 clicked. Input is: '" + getInputModel().getFormInput() + "' Client stored is: '" + someSavedValue + "'<br/> "));
	}

	@Override
	public void assemble() {
		System.out.println("HelloComponent assembles");
		this.raw = new Raw("hello World!");
		setContent("id2", raw);
	}

	@Override
	public void wakeup() {
		System.out.println("HelloComponent wakes up");
	}


}
