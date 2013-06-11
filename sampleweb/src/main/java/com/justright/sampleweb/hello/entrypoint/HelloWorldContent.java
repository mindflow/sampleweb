package com.justright.sampleweb.hello.entrypoint;

import com.justright.entrypoint.Entrypoint;
import com.justright.entrypoint.annotation.EntrypointConfig;
import com.justright.entrypoint.annotation.RoleCheck;
import com.justright.sampleweb.hello.component.HelloComponent;
import com.justright.sampleweb.hello.entrypoint.model.HelloWorldModel;
import com.justright.xml.Renderable;

@RoleCheck(roles = {"administrator"}, redirectUri = "/Login")
@EntrypointConfig(uri="/HelloContent",docType=Entrypoint.HTML_4_01_TRANSITIONAL_EN_DOCTYPE)
public class HelloWorldContent extends Entrypoint<Object> implements Renderable{

	private HelloComponent helloComponent;
	private HelloWorldModel model = new HelloWorldModel();

	@Override
	public String render() {
		System.out.println("HelloWorldContent Entrypoint renders");
		return helloComponent.render();
	}

	@Override
	public Object getInputModel() {
		return model;
	}

	@Override
	public void assemble() {
		System.out.println("HelloWorldContent Entrypoint assembles");
		helloComponent = new HelloComponent();
	}
}
