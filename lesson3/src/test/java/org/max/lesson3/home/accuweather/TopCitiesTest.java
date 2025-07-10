package org.max.lesson3.home.accuweather;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class TopCitiesTest extends AccuweatherAbstractTest{
    @Test
    void Top50CitiesTestShouldReturn200 (){
        given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl()+"/locations/v1/topcities/50")
                .then()
                .statusCode(200);

    }
    @Test
    void Top100CitiesTestShouldReturn200 (){
        given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl()+"/locations/v1/topcities/100")
                .then()
                .statusCode(200);

    }
    @Test
    void Top10CitiesTestShouldReturn404 (){
        given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl()+"/locations/v1/topcities/10")
                .then()
                .statusCode(404);

    }
}
