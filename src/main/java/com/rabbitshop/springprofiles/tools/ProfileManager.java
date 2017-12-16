package com.rabbitshop.springprofiles.tools;

import java.util.List;

public interface ProfileManager {
	
	List<String> getDefaultProfiles();
	
	List<String> getActiveProfiles();
	
	<T> T getProperty(String propertyKey, Class<T> propertyExpectedClass);
	
}
