package com.backend.config;


import com.backend.components.CustomPathProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfiguration {

    // Каким типы авторизации поддерживает сервис
    private SecurityScheme jwtScheme() {
        return HttpAuthenticationScheme.JWT_BEARER_BUILDER
                .name("JWT")
                .build();
    }
    // Каким url добавлять возможность авторизации(сейчас всем)
    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(Collections.singletonList(defaultAuth()))
                .operationSelector(o -> o.requestMappingPattern().matches("/.*"))
                .build();
    }
    // Конфигурация авторизаций
    private SecurityReference defaultAuth() {
        return SecurityReference.builder()
                .scopes(new AuthorizationScope[0])
                .reference("JWT")
                .build();
    }
    @Bean
    public Docket api(CustomPathProvider customPathProvider) {
        return new Docket(DocumentationType.OAS_30)
                .pathProvider(customPathProvider)
                .securityContexts(Collections.singletonList(securityContext()))
                .securitySchemes(Collections.singletonList(jwtScheme()))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

}