package com.justright.sampleweb.login.entrypoint;

import com.justright.entrypoint.Entrypoint;
import com.justright.entrypoint.EntrypointConfig;
import com.justright.sampleweb.login.component.LoginComponent;
import com.justright.sampleweb.template.TemplateComponent;

@EntrypointConfig(uri="/Login",docType=Entrypoint.HTML_4_01_TRANSITIONAL_EN_DOCTYPE)
public class Login extends Entrypoint<Object>{

	private TemplateComponent templateComponent;
	private LoginComponent loginComponent;
	
	@Override
	public Object getInputModel() {
		return null;
	}

	@Override
	public String render() {
		return templateComponent.render();
	}

	@Override
	public void assemble() {
		templateComponent = new TemplateComponent();
		loginComponent = new LoginComponent();
		templateComponent.setContent("contentframe",loginComponent);
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}

}
