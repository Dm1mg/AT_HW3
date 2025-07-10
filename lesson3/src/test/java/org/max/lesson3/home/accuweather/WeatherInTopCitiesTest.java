package org.max.lesson3.home.accuweather;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.max.lesson3.home.accuweather.location.Location;
import org.max.lesson3.home.accuweather.weather.Weather;

import java.util.List;

import static io.restassured.RestAssured.given;

public class WeatherInTopCitiesTest extends AccuweatherAbstractTest{
    @Test
    void GetWeatherInTopCitiesShouldCorrect(){
        given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl()+"/currentconditions/v1/topcities/50")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000l));



    }
}
