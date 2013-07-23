package com.justright.sampleweb.login.component;

import com.justright.component.FormComponent;
import com.justright.component.annotation.EventListener;
import com.justright.context.Context;
import com.justright.security.User;
import com.justright.security.UserProvider;
import com.justright.xml.Raw;

public class LoginComponent extends FormComponent<LoginComponentModel>{
	
	private LoginComponentModel model;
	
	private UserProvider userProvider;
	
	public LoginComponent(Context context){
		super(context,"LoginForm","loginComponent.xml");
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
			getContext().login(user);
			setContent("loginMessage", new Raw("You are logged in"));
			getContext().sendRedirect(getInputModel().getReferrer());
		}else{
			setContent("loginMessage", new Raw("Login failed"));
		}
	}
	
	@EventListener("logout")
	public void logout(){
		if(getContext().getUser() != null){
			getContext().logout();
			setContent("loginMessage", new Raw("You are logged out"));
		}else{
			setContent("loginMessage", new Raw("Logout failed"));
		}
	}

	@Override
	public void assemble() {
		
	}

	public void setUserProvider(UserProvider userProvider) {
		this.userProvider = userProvider;
	}

	@Override
	public void wakeup() {
		
	}
	
}
