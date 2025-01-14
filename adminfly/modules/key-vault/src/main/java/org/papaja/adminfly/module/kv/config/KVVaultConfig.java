package org.papaja.adminfly.module.kv.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = {
        "classpath:properties/module/kv/module.properties",
}, ignoreResourceNotFound = true)
public class KVVaultConfig {

    protected Environment environment;

    public @Autowired
    KVVaultConfig(Environment environment) {
        this.environment = environment;
    }

}
