package com.justright.sampleweb.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.justright.config.AbstractAppConfig;
import com.justright.entrypoint.EntrypointMap;
import com.justright.entrypoint.ErrorEntrypoint;
import com.justright.sampleweb.exception.SampleErrorEntrypoint;
import com.justright.sampleweb.hello.entrypoint.HelloWorld;
import com.justright.sampleweb.hello.entrypoint.HelloWorldContent;
import com.justright.sampleweb.login.entrypoint.Login;
import com.justright.servlet.ContextProcessor;
import com.justright.servlet.ContextProcessorList;

@Configuration
public class AppConfig extends AbstractAppConfig{
	
	@Override
	@Bean
	public ContextProcessorList contextProcessors() {
		List<ContextProcessor> contextProcessorList = new ArrayList<ContextProcessor>();
		ContextProcessorList contextProcessors = new ContextProcessorList(contextProcessorList);
		return contextProcessors;
	}
	
	@Bean
	public EntrypointMap entrypoints(){
		return newConfigBuilder()
				.withEntrypoint(Login.class)
				.withEntrypoint(HelloWorld.class)
				.withEntrypoint(HelloWorldContent.class)
				.build();
	}
	
	@Bean(name={"errorEntrypoint"})
	public ErrorEntrypoint defaultErrorEntrypoint(){
		return new SampleErrorEntrypoint();
	}

}
