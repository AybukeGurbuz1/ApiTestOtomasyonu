import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_GetRequest_ResponseBodyYazdırma {

    @Test

    public void get01(){

        /* https://restful-booker.herokuapp.com/booking/10 url'ine
        bir GET request gönderdiğimizde dönen response'ı yazdırın*/

        // 1) Request body ve endpoint hazırlama
        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2) Expected Data Hazırlama
        // 3) Request gönderip, dönen response' ı kaydetme
        Response response = given().when().get(url);
        response.prettyPrint();

        // 4) Assertion

        /*
           NOT: Intellij de API sorguları yapmak için io.restassured kütüphanesi kullanılır.
                Ve Response class ' ından bir obje oluşturmamız gerekir.

                Response response = given().when().get(url);

                     ==> Response oluştururken kullandığımız;

                given : Testimize başlarken bize verilen başlangıç değerlerini ifade eder.
                when : Testimizde gerçekleştirdiğimiz işlemleri ifade eder.
                then : Response değerlerini değerlendirmek için yapılan işlemleri ifade eder.
                and : Birbirine bağlı işlemleri ifade eder.
         */



}}
