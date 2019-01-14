
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.lang.String;


public class NasaAPITest {

    @Test
    public void verifyValidAPIKey() {
        RestAssured.baseURI = "https://api.nasa.gov";

        given().
                param("api_key", "x8W1ZrGQcR783nnOH5QLelRFcZAZ0xdOYCOn7kDB").
                when().
                get("/planetary/apod").
                then().
                assertThat().
                statusCode(200);

    }

    @Test
    public void verifyDateandCopyright() {
        RestAssured.baseURI = "https://api.nasa.gov";

        given().
                param("api_key", "x8W1ZrGQcR783nnOH5QLelRFcZAZ0xdOYCOn7kDB").
                when().
                get("/planetary/apod").
                then().
                assertThat().
                statusCode(200).
                and().
                contentType(ContentType.JSON).
                and().
                body("date", equalTo("2019-01-14")).
                and().
                body("copyright", equalTo("Nicholas RoemmeltVenture Photography"));
    }
    @Test
    public void testDuplicateImageURLs() {
        RestAssured.baseURI = "https://api.nasa.gov";

        String url =
                given().
                        param("api_key", "x8W1ZrGQcR783nnOH5QLelRFcZAZ0xdOYCOn7kDB").
                        when().
                        get("/planetary/apod").
                        then().
                        statusCode(200).
                        extract().
                        path("url");

        String hdUrl =
                given().
                        param("api_key", "x8W1ZrGQcR783nnOH5QLelRFcZAZ0xdOYCOn7kDB").
                        when().
                        get("/planetary/apod").
                        then().
                        statusCode(200).
                        extract().
                        path("hdurl");

        Assert.assertNotEquals(url, hdUrl, "URL and HdURl Parameters are not the same");

    }
        @Test
        public void verifyInvalidAPIKey() {
            RestAssured.baseURI = "https://api.nasa.gov";

            given().
                    param("api_key", "dmcnsmcnknk123").
                    when().
                    get("/planetary/apod").
                    then().
                    assertThat().
                    statusCode(200);

        }

    @Test
    public void verifyNullAPIKey() {
        RestAssured.baseURI = "https://api.nasa.gov";

        given().
                param("api_key", " ").
                when().
                get("/planetary/apod").
                then().
                assertThat().
                statusCode(200);

    }

    @Test
    public void verifyInvalidDateandInvalidCopyright() {
        RestAssured.baseURI = "https://api.nasa.gov";

        given().
                param("api_key", "x8W1ZrGQcR783nnOH5QLelRFcZAZ0xdOYCOn7kDB").
                when().
                get("/planetary/apod").
                then().
                assertThat().
                statusCode(200).
                and().
                contentType(ContentType.JSON).
                and().
                body("date", equalTo("2019-01-13")).
                and().
                body("copyright", equalTo("RoemmeltVenture Photography"));
    }

    @Test
    public void verifyInvalidDateandValidCopyright() {
        RestAssured.baseURI = "https://api.nasa.gov";

        given().
                param("api_key", "x8W1ZrGQcR783nnOH5QLelRFcZAZ0xdOYCOn7kDB").
                when().
                get("/planetary/apod").
                then().
                assertThat().
                statusCode(200).
                and().
                contentType(ContentType.JSON).
                and().
                body("date", equalTo("2019-01-13")).
                and().
                body("copyright", equalTo("Nicholas RoemmeltVenture Photography"));
    }
    @Test
    public void verifyValidDateandInvalidCopyright() {
        RestAssured.baseURI = "https://api.nasa.gov";

        given().
                param("api_key", "x8W1ZrGQcR783nnOH5QLelRFcZAZ0xdOYCOn7kDB").
                when().
                get("/planetary/apod").
                then().
                assertThat().
                statusCode(200).
                and().
                contentType(ContentType.JSON).
                and().
                body("date", equalTo("2019-01-14")).
                and().
                body("copyright", equalTo("RoemmeltVenture Photography"));
    }

    @Test
    public void verifyEmptyDateandCopyright() {
        RestAssured.baseURI = "https://api.nasa.gov";

        given().
                param("api_key", "x8W1ZrGQcR783nnOH5QLelRFcZAZ0xdOYCOn7kDB").
                when().
                get("/planetary/apod").
                then().
                assertThat().
                statusCode(200).
                and().
                contentType(ContentType.JSON).
                and().
                body("date", equalTo(" ")).
                and().
                body("copyright", equalTo(" "));
    }
    }





