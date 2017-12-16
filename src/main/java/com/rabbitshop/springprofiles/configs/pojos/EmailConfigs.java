package com.rabbitshop.springprofiles.configs.pojos;

import java.util.List;
import java.util.Map;

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
@Configuration
@ConfigurationProperties(prefix = "email")
@PropertySource("classpath:/application-configs/email.properties")
@Profile(ProfileConstants.PROD_PROFILE)
public class EmailConfigs {

	private String host;

	private long port;

	private String from;
	
	private List<String> defaultRecipients;
	
	private Map<String, Boolean> additionalHeaders;

}
