package com.justright.sampleweb.template;

import com.justright.component.SimpleComponent;

public class TemplateComponent extends SimpleComponent<Object>{

	public TemplateComponent(){
		super("templateComponent.xml");
	}

	@Override
	public void assemble() {
		System.out.println("TemplateComponent assembles");
	}

}
