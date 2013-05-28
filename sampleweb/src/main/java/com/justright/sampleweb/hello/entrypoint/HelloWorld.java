package com.justright.sampleweb.hello.entrypoint;

import com.justright.entrypoint.Entrypoint;
import com.justright.entrypoint.RoleCheck;
import com.justright.sampleweb.hello.component.HelloComponent;
import com.justright.sampleweb.template.TemplateComponent;
import com.justright.xml.Raw;
import com.justright.xml.Renderable;

@RoleCheck(roles = {"administrator"}, redirectUri = "/Login")
public class HelloWorld extends Entrypoint<Object> implements Renderable{

	private TemplateComponent templateComponent;
	private HelloComponent helloComponent;
	private HelloWorldModel model = new HelloWorldModel();
	
	public void assemble(){
		templateComponent = new TemplateComponent();
		helloComponent = new HelloComponent();
		templateComponent.setContent("id1",helloComponent);
	}
	
	public void load(){
		if(model.getInput() != null){
			templateComponent.addContent("id1",new Raw(model.getInput()));
		}
	}

	@Override
	public String render() {
		return templateComponent.render();
	}

	@Override
	public String getDoctype() {
		return HTML_4_01_TRANSITIONAL_EN_DOCTYPE;
	}

	@Override
	public String getUri() {
		return "/Hello";
	}

	@Override
	public Object getInputModel() {
		return model;
	}

	@Override
	public void validate() {
		
	}
}
