package pl.derilius.demo.config;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class FlywayConfig {

    /**
     * Override default flyway initializer to do nothing
     */
    @Bean
    FlywayMigrationInitializer flywayInitializer(Flyway flyway) {
        flyway.setValidateOnMigrate(false);
        return new FlywayMigrationInitializer(flyway, Flyway::migrate);
    }


    /**
     * Create a second flyway initializer to run after jpa has created the schema
     */
    @Bean
    @DependsOn("entityManagerFactory")
    FlywayMigrationInitializer delayedFlywayInitializer(Flyway flyway) {
        flyway.setLocations("filesystem:src/main/resources/db/data");
        flyway.setValidateOnMigrate(false);
        return new FlywayMigrationInitializer(flyway, Flyway::migrate);
    }

}
