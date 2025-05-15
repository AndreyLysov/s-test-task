package org.api.core;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;

import static io.restassured.http.ContentType.JSON;
import static java.lang.System.getProperty;

public class ApiConfig {

    @Getter
    private String baseUri = getProperty("url");

    public RequestSpecification getBaseSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(baseUri)
                .setContentType(JSON)
                .setConfig(new RestAssuredConfig()
                        .logConfig(LogConfig
                                .logConfig()
                                .enableLoggingOfRequestAndResponseIfValidationFails()))
                .setAccept(JSON)
                .addFilter(new AllureRestAssured())
                .build();
    }
}