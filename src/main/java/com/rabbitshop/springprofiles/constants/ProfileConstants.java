package com.rabbitshop.springprofiles.constants;

public class ProfileConstants {
	
	private ProfileConstants() {}
	
	// NOT USED at the moment of writing this comment, but useful to know the name of ServletContext parameters
	public static final String SERVLET_CONTEXT_DEFAULT_PROFILES_PARAM = "spring.profiles.default";
	public static final String SERVLET_CONTEXT_ACTIVE_PROFILES_PARAM = "spring.profiles.active";
	
	public static final String DEV_PROFILE = "dev";
	public static final String STAGING_PROFILE = "staging";
	public static final String PROD_PROFILE = "prod";
	public static final String TEST_PROFILE = "test";

}
