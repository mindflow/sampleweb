package com.justright.sampleweb.hello.entrypoint;

import com.justright.entrypoint.Entrypoint;
import com.justright.entrypoint.annotation.EntrypointConfig;
import com.justright.entrypoint.annotation.RoleCheck;
import com.justright.sampleweb.hello.component.HelloFormComponent;
import com.justright.sampleweb.hello.entrypoint.model.HelloWorldModel;
import com.justright.sampleweb.template.TemplateComponent;
import com.justright.xml.Raw;
import com.justright.xml.Renderable;

@RoleCheck(roles = {"administrator"}, redirectUri = "/Login")
@EntrypointConfig(uri="/Hello",docType=Entrypoint.HTML_4_01_TRANSITIONAL_EN_DOCTYPE)
public class HelloWorld extends Entrypoint<Object> implements Renderable{

	private TemplateComponent templateComponent;
	private HelloFormComponent helloComponent;
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
		System.out.println("HelloWorld Entrypoint assembles");
		templateComponent = new TemplateComponent();
		helloComponent = new HelloFormComponent(getContext());
		templateComponent.setContent("contentframe",helloComponent);
		if(model.getInput() != null){
			templateComponent.addContent("contentframe",new Raw(model.getInput()));
		}
	}

}
