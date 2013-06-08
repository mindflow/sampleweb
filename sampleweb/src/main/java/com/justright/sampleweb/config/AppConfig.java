package com.justright.sampleweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.justright.config.AbstractAppConfig;
import com.justright.entrypoint.Entrypoint;
import com.justright.entrypoint.EntrypointMap;
import com.justright.entrypoint.ErrorEntrypoint;
import com.justright.sampleweb.exception.SampleErrorEntrypoint;
import com.justright.sampleweb.hello.entrypoint.HelloWorld;
import com.justright.sampleweb.login.entrypoint.Login;

@Configuration
public class AppConfig extends AbstractAppConfig{
	
	@Bean
	public EntrypointMap entrypoints(){
		return newConfigBuilder()
				.withEntrypoint(Login.class)
				.withEntrypoint(HelloWorld.class)
				.build();
	}
	
	@Bean(name={"errorEntrypoint"})
	public ErrorEntrypoint defaultErrorEntrypoint(){
		return new SampleErrorEntrypoint();
	}
}
