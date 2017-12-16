package com.rabbitshop.springprofiles;

import javax.annotation.Resource;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;

import com.rabbitshop.springprofiles.constants.ProfileConstants;
import com.rabbitshop.springprofiles.services.ProfileTestService;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * . Spring Profiles implementation and usage steps:
 *		. define profiles
 *		. use @Profile annotation to configure beans and properties to be loaded basing on active profile
 *		. define how to set the active profile at runtime
 *
 * . Profiles in Spring Boot
 *		The initialization parameter "spring.profiles.active", introduced in section 4, can also be set up as a property in Spring Boot to define currently
 *		active profiles. This is a standard property that Spring Boot will pick up automatically.
 *
 * *** PLEASE NOTE ***
 *	. Any bean that does not specify a profile belongs to “default” profile.
 *	. The choose of a profile could affect beans initialization, so it is possible to selective instantiate beans regarding
 *	  the active profiles.
 *	. [TO BE VERIFIED, PROBABLY DEPRECATED] Spring also provides a way to set the default profile when no other profile is active, by using the
 *	  “spring.profiles.default” property.
 *
 * *** PLEASE NOTE - SPRING BOOT ***
 * But the most important profiles-related feature that Spring Boot brings is profile-specific properties files. These have to be named in the format
 * "application-{profile}.properties". Spring Boot will automatically load the properties in an application.properties file for all profiles, and the ones in
 * profile-specific .properties files only for the specified profile.
 */
@Slf4j
@SpringBootApplication
public class SpringProfilesApplication implements ApplicationRunner {

	@Resource(type = ConfigurableEnvironment.class)
	@Getter
	private ConfigurableEnvironment configurableEnvironment;

	@Resource(type = ProfileTestService.class)
	@Getter
	private ProfileTestService profileTestService;
	
	/**
	 * THE MAIN
	 */
	public static void main(final String[] args) {

		SpringApplication.run(SpringProfilesApplication.class, args);
	}
	
	/**
	 * THE RUN
	 */
	@Override
	public void run(final ApplicationArguments arg0) throws Exception {

		//		log.info("");
		//		log.info("");
		//		configureProfiles();
		
		log.info("");
		log.info("");
		getProfileTestService().testProfiles();
		log.info("");
		log.info("");
		getProfileTestService().testConfigs();
		log.info("");
		log.info("");
		getProfileTestService().testSpringBootConfigs();
		log.info("");
		log.info("");
	}
	
	/**
	 * This call comes AFTER beans initialization, so it won't affect those creation.
	 * The only ways to affect also beans init with profile configurations, are these:
	 *	. passing the profile config as java option "-Dspring.profiles.active=..."
	 *	. setting the active profiles environment variable "export spring_profiles_active=..." (just Unix environments)
	 *	. setting the property "spring.profiles.active=..." (just with Spring Boot)
	 */
	protected void configureProfiles() {
		
		log.warn("Configuring Profiles in ConfigurableEnvironment..."); // TODO back to debug after tests

		setDefaultProfiles();
		setActiveProfiles();
	}
	
	protected void setDefaultProfiles() {

		log.warn("Setting default profiles..."); // TODO back to debug after tests

		//		getConfigurableEnvironment().setDefaultProfiles(ProfileConstants.DEV_PROFILE, ProfileConstants.PROD_PROFILE);
	}

	protected void setActiveProfiles() {
		
		log.warn("Setting active profiles..."); // TODO back to debug after tests

		//		getConfigurableEnvironment().setActiveProfiles(ProfileConstants.DEV_PROFILE);
		getConfigurableEnvironment().setActiveProfiles(ProfileConstants.PROD_PROFILE);
	}

}
