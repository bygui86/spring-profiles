package com.rabbitshop.springprofiles.services.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabbitshop.springprofiles.configs.pojos.DatabaseConfigs;
import com.rabbitshop.springprofiles.configs.pojos.EmailConfigs;
import com.rabbitshop.springprofiles.services.ProfileTestService;
import com.rabbitshop.springprofiles.tools.ProfileManager;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProfileTestServiceImpl implements ProfileTestService {

	@Resource(type = ProfileManager.class)
	@Getter
	private ProfileManager profileManager;

	/**
	 * PLEASE NOTE
	 * The choose of a profile could affect beans initialization, so it is possible to selective instantiate beans regarding
	 * the active profiles.
	 *
	 * Here to demonstrate the functionalities of Spring profiling, we are forced to use @Autowired in order not to become
	 * a NoSuchBeanDefinitionException.
	 */
	@Autowired(required = false)
	@Getter
	private DatabaseConfigs dbConfigs;
	
	@Autowired(required = false)
	@Getter
	private EmailConfigs emailConfigs;
	
	@Override
	public void testProfiles() {
		
		logDefaultProfiles();
		logActiveProfiles();
		
	}

	@Override
	public void testConfigs() {

		logDatabaseConfig();
		logEmailConfig();
	}

	@Override
	public void testSpringBootConfigs() {
		
		log.info("Profile specific property: " + getProfileManager().getProperty("profile.specific.property", String.class));
	}

	protected void logDefaultProfiles() {
		
		log.info("Default profiles:");
		getProfileManager().getDefaultProfiles()
				.forEach(
						p -> log.info("\t" + p));
	}

	protected void logActiveProfiles() {
		
		log.info("Active profiles:");
		getProfileManager().getActiveProfiles()
				.forEach(
						p -> log.info("\t" + p));
	}
	
	protected void logDatabaseConfig() {
		
		if (getDbConfigs() != null) {
			log.info("Database configs: " + getDbConfigs().toString());
		}
	}
	
	protected void logEmailConfig() {
		
		if (getEmailConfigs() != null) {
			log.info("Email configs: " + getEmailConfigs().toString());
		}
	}

}
