package com.justright.sampleweb.login.component;

import com.justright.component.SessionComponent;
import com.justright.component.annotation.EventListener;
import com.justright.security.DefaultRoleProvider;
import com.justright.security.DefaultUserProvider;
import com.justright.security.User;
import com.justright.session.Session;
import com.justright.xml.Raw;

public class LoginComponent extends SessionComponent<LoginComponentModel>{

	private LoginComponentModel model;
	
	public LoginComponent(Session session){
		super(session,"loginComponent.xml");
		this.enableForm("LoginForm");
	}

	@Override
	public LoginComponentModel getInputModel() {
		if(model == null){
			model = new LoginComponentModel();
		}
		return model;
	}
	
	@EventListener("login")
	public void login(){
		User user = new DefaultUserProvider().getUser(getInputModel().getUsername(), getInputModel().getPassword());
		if(user != null){
			new DefaultRoleProvider().populateRoles(user);
			getSession().login(user);
			setContent("loginMessage", new Raw("You are logged in"));
		}else{
			setContent("loginMessage", new Raw("Login failed"));
		}
	}
	
	@EventListener("logout")
	public void logout(){
		if(getSession().getUser() != null){
			getSession().logout();
			setContent("loginMessage", new Raw("You are logged out"));
		}else{
			setContent("loginMessage", new Raw("Logout failed"));
		}
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
