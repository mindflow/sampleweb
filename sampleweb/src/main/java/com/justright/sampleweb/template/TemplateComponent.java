package com.justright.sampleweb.template;

import com.justright.component.Component;

public class TemplateComponent extends Component<Object>{

	public TemplateComponent(){
		super("templateComponent.xml");
	}

	@Override
	public Object getInputModel() {
		return null;
	}

	@Override
	public void assemble() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}

}
