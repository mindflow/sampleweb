package com.justright.sampleweb.hello.component;

import com.justright.component.validation.Validator;

public class HelloFormComponentValidator implements Validator<HelloFormComponentModel,HelloFormComponent>{
	
	@Override
	public void validate(HelloFormComponentModel inputModel, HelloFormComponent component) {
		inputModel.getInput();
	}
}
