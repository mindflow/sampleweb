package com.justright.sampleweb.hello.component;

import com.justright.component.SimpleComponent;
import com.justright.component.annotation.WebComponent;

@WebComponent(id="FormComponent",xmlFile="helloComponent.xml")
public class HelloComponent extends SimpleComponent<Object>{

	public HelloComponent(){
	}
	
	@Override
	public void assemble() {
		
		
	}

}
