package com.marcosfa.wonderboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;



@ConfigurationProperties(prefix = "location.api")
public class LocationApiProperties {
    private final String host;
    private LocationApiProperties(final String host) {this.host = host;}
    public String getHost() {return host;}

}
