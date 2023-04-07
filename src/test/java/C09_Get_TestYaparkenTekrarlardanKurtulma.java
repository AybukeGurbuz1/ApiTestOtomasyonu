import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C09_Get_TestYaparkenTekrarlardanKurtulma {

    @Test

    public void test01(){

        /*
        https://restful-booker.herokuapp.com/booking/10 url’ine
        bir GET request gonderdigimizde donen Response’un,
 	        -- status code’unun 200,
	        -- content type’inin application-json,
	        -- response body’sindeki "firstname“in,"Mary",
            -- "lastname“in, "Jackson",
            -- "totalprice“in,1000'den kucuk oldugu,
            -- "depositpaid“in, false,
            -- "additionalneeds“in, bos biralkildığını test edin
         */

        // 1- endpoint ve request body hazirla
        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2- expected data olustur
        // 3- request gonderip, donen response'i kaydet
        Response response= given().when().get(url);

        // 4- Assertion

        /* ikinci yontem ile yaptigimizda bu testimizdeki yazilanlar degismesin diye yoruma aldim.

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", Matchers.equalTo("Mary"))
                .body("lastname",Matchers.equalTo("Jackson"))
                .body("totalprice",Matchers.lessThan(1000))
                .body("depositpaid",Matchers.equalTo(false))
                .body("additionalneeds",Matchers.NullValue());
        */

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname",equalTo("Susan"),
                        "lastname", equalTo("Brown"),
                        "totalprice",lessThan(1000),
                        "depositpaid",equalTo(false));






    }


}
