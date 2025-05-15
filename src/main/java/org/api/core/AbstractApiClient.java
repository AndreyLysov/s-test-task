package org.api.core;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.api.models.core.RequestModel;
import org.api.models.core.ResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;

public abstract class AbstractApiClient {

    private static final Logger log = LoggerFactory.getLogger(AbstractApiClient.class);

    private final ApiClientManager apiClientManager;

    protected AbstractApiClient(ApiClientManager apiClientManager) {
        this.apiClientManager = apiClientManager;
    }

    protected RequestSpecification getRequestSpec() {
        return given()
                .spec(apiClientManager.getRequestSpec())
                .log().all();
    }

    protected Response get(String path) {
        log.info("Making GET request to: {}", path);
        return getRequestSpec()
                .when()
                .get(path)
                .then()
                .log().all()
                .extract().response();
    }

    protected Response post(String path, RequestModel body) {
        log.info("Making POST request to: {}", path);
        return getRequestSpec()
                .body(body)
                .when()
                .post(path)
                .then()
                .log().all()
                .extract().response();
    }

    protected Response put(String path, RequestModel body) {
        log.info("Making PUT request to: {}", path);
        return getRequestSpec()
                .body(body)
                .when()
                .put(path)
                .then()
                .log().all()
                .extract().response();
    }

    protected Response delete(String path) {
        log.info("Making DELETE request to: {}", path);
        return getRequestSpec()
                .when()
                .delete(path)
                .then()
                .log().all()
                .extract().response();
    }

    protected <T extends ResponseModel> T post(String path, RequestModel body, Class<T> responseClass) {
        log.info("Making POST request to: {} expecting response type {}", path, responseClass.getSimpleName());
        return getRequestSpec()
                .body(body)
                .when()
                .post(path)
                .then()
                .log().all()
                .extract().as(responseClass);
    }
}