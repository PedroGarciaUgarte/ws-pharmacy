package com.pharmacy.turn.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.pharmacy.turn.util.Constants;

import lombok.Getter;
import lombok.Setter;

@Configuration
@PropertySource("classpath:/application.properties")
public class WSConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(WSConfig.class);

    @Getter @Setter
    private String pharmacyScheme;

    @Getter @Setter
    private String pharmacyEndpoint;
    
    @Getter @Setter
    private String pharmacyProcess;

    @Getter @Setter
    private String communeScheme;
    
    @Getter @Setter
    private String communeEndpoint;
    
    @Getter @Setter
    private String communeProcess;

    @Autowired
    public WSConfig(@Value("${service.pharmacyScheme}") String pharmacyScheme,
            @Value("${service.pharmacyEndpoint}") String pharmacyEndpoint,
            @Value("${service.pharmacyProcess}") String pharmacyProcess,
            @Value("${service.communeScheme}") String communeScheme,
            @Value("${service.communeEndpoint}") String communeEndpoint,
            @Value("${service.communeProcess}") String communeProcess) {

        this.pharmacyScheme = pharmacyScheme;
        this.pharmacyEndpoint = pharmacyEndpoint;
        this.pharmacyProcess = pharmacyProcess;
        this.communeScheme = communeScheme;
        this.communeEndpoint = communeEndpoint;
        this.communeProcess = communeProcess;

        LOGGER.debug(Constants.SCHEME_CONFIG, this.pharmacyScheme);
        LOGGER.debug(Constants.ENDPOINT_CONFIG, this.pharmacyEndpoint);
        LOGGER.debug(Constants.PROCESS_CONFIG, this.pharmacyProcess);
        LOGGER.debug(Constants.SCHEME_CONFIG, this.communeScheme);
        LOGGER.debug(Constants.ENDPOINT_CONFIG, this.communeEndpoint);
        LOGGER.debug(Constants.PROCESS_CONFIG, this.communeProcess);
    }

}
