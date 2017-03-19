package com.kowalik.dominik.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by dominik on 2017-03-12.
 */

@Configuration
@ComponentScan(basePackages = {"com.kowalik.dominik" },excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
        value = EnableWebMvc.class)})
public class RootConfig {
}
