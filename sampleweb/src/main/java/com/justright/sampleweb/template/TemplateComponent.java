package com.justright.sampleweb.template;

import com.justright.component.SimpleComponent;
import com.justright.component.annotation.WebComponent;

@WebComponent(id="FormComponent",xmlFile="templateComponent.xml")
public class TemplateComponent extends SimpleComponent<Object>{

	public TemplateComponent(){
	}

	@Override
	public void assemble() {
		System.out.println("TemplateComponent assembles");
	}

}
