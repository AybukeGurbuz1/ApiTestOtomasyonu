import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C12_Get_ResponseBodyTestiListKullanimi {

    @Test
    public void test01(){
        /*
            http://dummy.restapiexample.com/api/v1/employees url'ine
            bir GET request yolladigimizda
                donen Response'in
                    -- status code'unun 200,
                    -- content type'inin Aplication.JSON,
                    -- response body'sindeki
                    -- employees sayisinin 24
                    -- employee'lerden birinin "Ashton Cox"
                    -- girilen yaslar icinde 61,21 ve 35 degerinin oldugunu test edin.
         */

        //1- end point ve request body olustur

        String url = "http://dummy.restapiexample.com/api/v1/employees";

        //2- Expected data olustur
        //3- Request gonder ve donen response'i kaydet
        Response response= given()
                .when()
                .get(url);

        response.prettyPrint();

        //4- Assertion
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data.id", hasSize(24),
                        "data.employee_name",hasItem("Ashton Cox"),
                        "data.employee_age",hasItems(61,21,35));
}}
