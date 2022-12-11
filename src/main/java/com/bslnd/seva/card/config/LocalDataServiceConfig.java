package com.bslnd.seva.card.config;

import com.bslnd.seva.card.service.DataService;
import com.bslnd.seva.card.service.LocalDataService;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
@EnableConfigurationProperties(LocalDataServiceProperties.class)
public class LocalDataServiceConfig {

    private final LocalDataServiceProperties properties;

    public LocalDataServiceConfig(LocalDataServiceProperties properties) {
        this.properties = properties;
    }

    @Bean
    DataService localDataService(final LocalDataServiceProperties properties, final CsvMapper csvMapper) throws IOException {
        return new LocalDataService(properties, csvMapper);
    }

}
