package com.justright.sampleweb.login.entrypoint;

import javax.inject.Inject;

import com.justright.entrypoint.Entrypoint;
import com.justright.entrypoint.annotation.EntrypointConfig;
import com.justright.sampleweb.login.component.LoginComponent;
import com.justright.sampleweb.template.TemplateComponent;
import com.justright.security.UserProvider;

@EntrypointConfig(uri="/Login",docType=Entrypoint.HTML_4_01_TRANSITIONAL_EN_DOCTYPE)
public class Login extends Entrypoint<Object>{

	private TemplateComponent templateComponent;
	private LoginComponent loginComponent;
	
	@Inject
	private UserProvider userProvider;
	
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
		loginComponent = new LoginComponent(getContext());
		loginComponent.setUserProvider(userProvider);
		templateComponent.setContent("contentframe",loginComponent);
	}
}
