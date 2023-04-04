import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C02_GetRequest_ResponseBilgilerininManuelTestEdilmesi {

    @Test

    public void test01(){

        /* https://restful-booker.herokuapp.com/booking/10 url'ine
        bir GET request gönderdiğimizde dönen response'un,
        --> status code unun 200,
        --> content type' ının application/json; charset=utf-8,
        --> server isimli Header'ın değerinin cowboy,
        --> Status Line' ın HTTP/1.1 200 OK,
        --> response süresinin 5 sn den kısa olduğunu manuel olarak test ediniz
         */

        // 1) gerekli body ve endpoint hazırla
        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2) Expected body oluştur

        // 3) request gönder ve dönen response u kaydet
        Response response = given().when().get(url);

        response.prettyPrint();   // --> response body yi bu şekilde yazdırıyoruz
                                  // --> response üzerinden .get diyerek de response ile ilgili status code u,
                                  //     content type ı, header değerini, status line ı, response süresini,
                                  //     bu tür bilgileri alabilirsiniz.

        System.out.println("status code : "+response.getStatusCode()+
                           "\nContent type : "+response.getContentType()+
                           "\nServer Header Değeri : "+response.getHeader("Server")+
                           "\nStatus Line : "+response.getStatusLine()+
                           "\nResponse Süresi : "+response.getTime());
    }}