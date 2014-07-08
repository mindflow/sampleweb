package com.justright.sampleweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.justright.config.AbstractAppConfig;
import com.justright.entrypoint.Entrypoint;
import com.justright.entrypoint.EntrypointMap;
import com.justright.entrypoint.ErrorEntrypoint;
import com.justright.sampleweb.exception.SampleErrorEntrypoint;
import com.justright.sampleweb.hello.entrypoint.HelloWorld;
import com.justright.sampleweb.hello.entrypoint.HelloWorldContent;
import com.justright.sampleweb.login.entrypoint.Login;
import com.justright.servlet.ContextProcessorList;

@Configuration
public class AppConfig extends AbstractAppConfig{
	
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

	@Override
	public ContextProcessorList contextProcessors() {
		// TODO Auto-generated method stub
		return null;
	}
}
