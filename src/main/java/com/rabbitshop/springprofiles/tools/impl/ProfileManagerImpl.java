package com.rabbitshop.springprofiles.tools.impl;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

import com.rabbitshop.springprofiles.tools.ProfileManager;

import lombok.Getter;

@Component
public class ProfileManagerImpl implements ProfileManager {
	
	@Resource(type = ConfigurableEnvironment.class)
	@Getter
	private ConfigurableEnvironment configurableEnvironment;

	@Override
	public List<String> getDefaultProfiles() {
		
		return Arrays.asList(getConfigurableEnvironment().getDefaultProfiles());
	}
	
	@Override
	public List<String> getActiveProfiles() {

		return Arrays.asList(getConfigurableEnvironment().getActiveProfiles());
	}

	@Override
	public <T> T getProperty(final String propertyKey, final Class<T> propertyExpectedClass) {
		
		return getConfigurableEnvironment().getProperty(propertyKey, propertyExpectedClass);
	}

}
