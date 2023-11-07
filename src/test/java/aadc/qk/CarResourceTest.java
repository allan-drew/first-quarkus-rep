package aadc.qk;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;


@QuarkusTest
public class CarResourceTest {

    @Test
    public void shouldGetAllBooks() {
        given().header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .when().get("/api/car")
                .then().statusCode(200).body("size()", is(5));
    }

    @Test
    public void shouldCountAllCars() {
        given().header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN)
                .when().get("/api/car/count")
                .then().statusCode(200).body(is("5"));
    }


    @Test
    public void shouldGetSpecificCar() {
        given().header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .pathParams("id", 1)
                .when().get("api/car/{id}")
                .then().statusCode(200).body("brand", is("VW")).body("name", is("Polo")).body("year", is(2022));
    }


}




