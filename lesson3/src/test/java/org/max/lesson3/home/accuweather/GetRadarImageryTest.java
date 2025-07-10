package org.max.lesson3.home.accuweather;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetRadarImageryTest extends AccuweatherAbstractTest{
    @Test
    void GerRadarImageryShouldReturn401Test() {
        given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl()+"/imagery/v1/maps/radsat/1024x1024/294021")
                .then()
                .statusCode(401);

    }
}
