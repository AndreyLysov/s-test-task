package org.api.core;

import io.restassured.specification.RequestSpecification;
import lombok.AllArgsConstructor;

import static java.util.Objects.isNull;

@AllArgsConstructor
public class ApiClientManager {

    private static final ThreadLocal<RequestSpecification> REQUEST_SPECIFICATIONS = new ThreadLocal<>();

    private final ApiConfig config;

    public RequestSpecification getRequestSpec() {
        if (isNull(REQUEST_SPECIFICATIONS.get())) {
            REQUEST_SPECIFICATIONS.set(config.getBaseSpec());
        }
        return REQUEST_SPECIFICATIONS.get();
    }

    public void removeRequestSpec() {
        REQUEST_SPECIFICATIONS.remove();
    }
}