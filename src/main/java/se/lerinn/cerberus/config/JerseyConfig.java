package se.lerinn.cerberus.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import se.lerinn.cerberus.resource.RecipeResource;

@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(RecipeResource.class);
	}
	
}
