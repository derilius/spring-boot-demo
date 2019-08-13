package pl.derilius.demo.config;

import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import springfox.documentation.builders.AuthorizationCodeGrantBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        List<SecurityScheme> schemeList = new ArrayList<>();
        schemeList.add(new ApiKey(HttpHeaders.AUTHORIZATION, "bearer", "header"));
        return new Docket(DocumentationType.SWAGGER_2)
                .securitySchemes(schemeList)
                .select()
                .apis(RequestHandlerSelectors.basePackage("pl.derilius.demo.api"))
                .paths(PathSelectors.any())
                .build();
    }

}