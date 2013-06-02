package com.justright.sampleweb.login.component;

import java.util.List;

import com.justright.component.FormComponent;
import com.justright.component.annotation.EventListener;
import com.justright.security.RoleProvider;
import com.justright.security.User;
import com.justright.security.UserProvider;
import com.justright.session.Session;
import com.justright.xml.Raw;

public class LoginComponent extends FormComponent<LoginComponentModel>{
	
	private LoginComponentModel model;
	
	private UserProvider userProvider;
	private RoleProvider roleProvider;
	
	public LoginComponent(Session session){
		super(session,"LoginForm","loginComponent.xml");
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
		User user = userProvider.getUser(getInputModel().getUsername(), getInputModel().getPassword());
		if(user != null){
			List<String> roles = roleProvider.getRoles(user);
			getSession().login(user,roles);
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
		System.out.println("Loading");
	}

	public void setUserProvider(UserProvider userProvider) {
		this.userProvider = userProvider;
	}

	public void setRoleProvider(RoleProvider roleProvider) {
		this.roleProvider = roleProvider;
	}
	
}
