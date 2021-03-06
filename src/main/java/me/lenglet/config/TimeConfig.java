package me.lenglet.config;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;

@AutoConfigureOrder(HIGHEST_PRECEDENCE)
@Configuration
public class TimeConfig {

    @ConditionalOnMissingBean
    @Bean
    public Clock clock() {
        return Clock.fixed(Instant.ofEpochSecond(1700000000), ZoneOffset.UTC);
    }

    @Primary
    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean(Clock clock) {
        return new LocalValidatorFactoryBean() {

            @Override
            protected void postProcessConfiguration(javax.validation.Configuration<?> configuration) {
                configuration.clockProvider(() -> clock);
            }
        };
    }
}
