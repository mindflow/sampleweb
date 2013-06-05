package com.justright.sampleweb.hello.component;

import com.justright.component.validation.Validator;

public class HelloComponentValidator implements Validator<HelloComponentModel,HelloComponent>{
	
	@Override
	public void validate(HelloComponentModel inputModel, HelloComponent component) {
		inputModel.getInput();
	}
}
