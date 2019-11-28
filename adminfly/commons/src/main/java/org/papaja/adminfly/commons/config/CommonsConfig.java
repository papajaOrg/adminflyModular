package org.papaja.adminfly.commons.config;

import org.papaja.adminfly.commons.support.SystemLocales;
import org.papaja.adminfly.commons.support.SystemThemes;
import org.papaja.adminfly.commons.mvc.module.ThemeData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonsConfig {

    @Bean
    public SystemLocales availableLocales() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>> CommonsConfig.availableLocales");
        return new SystemLocales();
    }

    @Bean
    public SystemThemes availableThemes() {
        return new SystemThemes();
    }

    @Bean
    public ThemeData themeData() {
        return new ThemeData();
    }

}
