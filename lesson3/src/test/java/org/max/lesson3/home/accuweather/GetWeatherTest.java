package org.max.lesson3.home.accuweather;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.max.lesson3.home.accuweather.weather.Metric;
import org.max.lesson3.home.accuweather.weather.Temperature;
import org.max.lesson3.home.accuweather.weather.Weather;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetWeatherTest extends AccuweatherAbstractTest{
    @Test
    void GetWeatherHaveMetricPathTest(){
        List<Weather> response = given()
                .queryParam("apikey", getApiKey())
                .when()
                .get(getBaseUrl()+"/currentconditions/v1/294021")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000l))
                .extract()
                .body().jsonPath().getList(".", Weather.class);

        Assertions.assertEquals("C", response.get(0).getTemperature().getMetric().getUnit());

    }
}
