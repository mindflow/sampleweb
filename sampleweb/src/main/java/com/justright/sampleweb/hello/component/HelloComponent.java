package com.justright.sampleweb.hello.component;

import com.justright.component.ClientStored;
import com.justright.component.Component;
import com.justright.component.EventListener;
import com.justright.component.InputValidation;
import com.justright.xml.Raw;

public class HelloComponent extends Component<HelloComponentModel>{

	private HelloComponentModel model;
	
	@ClientStored
	private Integer someSavedValue;
	
	@ClientStored 
	private Raw raw;
	
	public HelloComponent(){
		super("helloComponent.xml");
		this.enableForm("Form1");
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
		someSavedValue = 10;
		raw.setValue("Changed by click2");
		addContent("id1", new Raw("Button1 clicked. Input is: '" + getInputModel().getFormInput() + "' Client stored is: '" + someSavedValue + "'<br/> "));
	}

	@EventListener("button2")
	public void button2Clicked() {
		addContent("id1", new Raw("Button2 clicked. Input is: '" + getInputModel().getFormInput() + "' Client stored is: '" + someSavedValue + "'<br/> "));
	}

	@Override
	public void assemble() {
		this.raw = new Raw("hello World!");
		setContent("id2", raw);
	}

	@Override
	public void load() {
		
	}


}
