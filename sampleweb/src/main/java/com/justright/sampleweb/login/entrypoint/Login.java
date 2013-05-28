package com.justright.sampleweb.login.entrypoint;

import com.justright.entrypoint.Entrypoint;
import com.justright.sampleweb.login.component.LoginComponent;
import com.justright.sampleweb.template.TemplateComponent;

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
	public String getDoctype() {
		return Entrypoint.HTML_4_01_TRANSITIONAL_EN_DOCTYPE;
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

	@Override
	public String getUri() {
		return "/Login";
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub
		
	}

}
