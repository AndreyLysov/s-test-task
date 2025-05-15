package org.core;

import io.restassured.RestAssured;
import org.api.core.ApiClientManager;
import org.api.core.ApiConfig;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    protected static ApiClientManager apiClientManager;

    @BeforeSuite
    public void setupConfig() {
        ApiConfig config = new ApiConfig();
        apiClientManager = new ApiClientManager(config);
    }

    @AfterMethod
    public void cleanupApiManager() {
        apiClientManager.removeRequestSpec();
    }
}
