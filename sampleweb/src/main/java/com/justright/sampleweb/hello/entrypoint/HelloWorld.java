package com.justright.sampleweb.hello.entrypoint;

import com.justright.entrypoint.Entrypoint;
import com.justright.entrypoint.EntrypointConfig;
import com.justright.entrypoint.RoleCheck;
import com.justright.sampleweb.hello.component.HelloComponent;
import com.justright.sampleweb.template.TemplateComponent;
import com.justright.xml.Raw;
import com.justright.xml.Renderable;

@RoleCheck(roles = {"administrator"}, redirectUri = "/Login")
@EntrypointConfig(uri="/Hello",docType=Entrypoint.HTML_4_01_TRANSITIONAL_EN_DOCTYPE)
public class HelloWorld extends Entrypoint<Object> implements Renderable{

	private TemplateComponent templateComponent;
	private HelloComponent helloComponent;
	private HelloWorldModel model = new HelloWorldModel();

	@Override
	public String render() {
		System.out.println("HelloWorld Entrypoint renders");
		return templateComponent.render();
	}

	@Override
	public Object getInputModel() {
		return model;
	}

	@Override
	public void assemble() {
		templateComponent = new TemplateComponent();
		helloComponent = new HelloComponent(getSession());
		templateComponent.setContent("contentframe",helloComponent);
		if(model.getInput() != null){
			templateComponent.addContent("contentframe",new Raw(model.getInput()));
		}
	}
}
