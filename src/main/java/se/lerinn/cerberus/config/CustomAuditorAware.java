package se.lerinn.cerberus.config;

import org.springframework.data.domain.AuditorAware;

public final class CustomAuditorAware implements AuditorAware<String> {

	@Override
	public String getCurrentAuditor() {

		String username = "";

		username = System.getProperty("user.name");

		return username;
	}

}
