package com.pharmacy.turn.config;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import springfox.documentation.spring.web.plugins.Docket;

@RunWith(MockitoJUnitRunner.class)
public class SwaggerConfigurationTest {
	
	public static final String NOT_NULL = "No debe ser nulo";

	@InjectMocks
	private SwaggerConfiguration swaggerConfiguration = new SwaggerConfiguration();
	
	@Test
	public void microserviceApi () {
		Docket actual = swaggerConfiguration.productApi();
		Assert.assertNotNull(NOT_NULL, actual);
	}
	
}
