import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C03_Get_ResponseDeğerleriniOtomasyonIleTestEtme {

    @Test

    public void test02(){

         /* https://restful-booker.herokuapp.com/booking/10 url'ine
        bir GET request gönderdiğimizde dönen response'un,
        --> status code unun 200,
        --> content type' ının application/json; charset=utf-8,
        --> server isimli Header'ın değerinin Cowboy,
        --> Status Line' ın HTTP/1.1 200 OK,
        --> response süresinin 5 sn den kısa olduğunu manuel olarak test ediniz
         */

        // NOT --> API de de UI da da çalışsanız bir işlemi kod yazmadan önce çok iyi okumak gereklidir.

        // 1) Endpoint ve request body oluştur (-->  çünkü GET request de body ye ihtiyaç yok, bilgi dönecek sadece)
        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2) Expected body oluştur  ( --> Expected Body ye gerek yok çünkü soruda dönen response un expected body sini test et demiyor)

        // 3) Request gönderip dönen response u kaydet  ( --> Bizim verdiğimiz endpointe gidecek ve GET request yapıcak ve response dönecek)

        Response response = given().when().get(url);

        // 4) Assertion  ( --> expected değerlerin test edilmesi)

                 // response u al ve ondan sonra şunları test et.
        response.then().assertThat().statusCode(200)
                       .contentType("application/json; charset=utf-8")
                       .header("Server", "Cowboy")
                       .statusLine("HTTP/1.1 200 OK");

    }
}
