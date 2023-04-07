import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C11_Post_JsonPathIleBodyTesti {

    @Test

    public void test01(){
        /*
        https://restful-booker.herokuapp.com/booking url’ine
        asagidaki body'ye sahip bir POST request gonderdigimizde

            {
            "firstname" : "Ahmet",
            "lastname" : “Bulut",
            "totalprice" : 500,
            "depositpaid" : false,
            "bookingdates" : {
                "checkin" : "2023-01-10",
                "checkout" : "2023-01-20"},
            "additionalneeds" : "wi-fi"
            }

         donen Response’un,

            -- status code’unun 200,
            -- content type’inin application-json,
            -- response body’sindeki
                "firstname“in,"Aybüke",
                -- "lastname“in, "Gür",
                -- "totalprice“in,500,
                -- "depositpaid“in,false,
                -- "checkin" tarihinin 2023-01-10
                -- "checkout" tarihinin 2023-01-20
                -- "additionalneeds“in,"wi-fi"

             oldugunu test edin
         */

        // 1- endpoint ve request body olustur

        String url= "https://restful-booker.herokuapp.com/booking";

        JSONObject requestBody= new JSONObject();
        JSONObject rezervasyonTarihleriJson= new JSONObject();

        rezervasyonTarihleriJson.put("checkin","2023-01-10");
        rezervasyonTarihleriJson.put("checkout","2023-01-20");

        requestBody.put("firstname","Aybüke");
        requestBody.put("lastname","Gür");
        requestBody.put("totalprice",500);
        requestBody.put("depositpaid",false);
        requestBody.put("bookingdates",rezervasyonTarihleriJson);
        requestBody.put("additionalneeds","wi-fi");

        // 2- expected data olustur
        // 3- request gonder, donen response'i kaydet

        Response response = given().contentType(ContentType.JSON)  // --> giveb dan sonra content type
                                   .when().body(requestBody.toString())  // --> when den sonra body
                                   .post(url);

        // 4- Assertion

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("booking.firstname", equalTo("Aybüke"),
                        "booking.lastname",equalTo("Gür"),
                        "booking.totalprice",equalTo(500),
                        "booking.depositpaid",equalTo(false),
                        "booking.bookingdates.checkin",equalTo("2023-01-10"),
                        "booking.bookingdates.checkout",equalTo("2023-01-20"));



}}
