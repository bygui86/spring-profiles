package com.rabbitshop.springprofiles.configs.pojos;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.rabbitshop.springprofiles.constants.ProfileConstants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
/**
 * As a quick sidenote, profile names can also be prefixed with a NOT operator e.g. “!dev” to exclude them from a profile. In the below example,
 * the component is activated only if “dev” profile is not active
 */
@Configuration
@ConfigurationProperties(prefix = "database")
@PropertySource("classpath:/application-configs/database.properties")
@Profile({ ProfileConstants.DEV_PROFILE, ProfileConstants.PROD_PROFILE })
public class DatabaseConfigs {
	
	private String url;
	
	private String username;
	
	private String password;

}
