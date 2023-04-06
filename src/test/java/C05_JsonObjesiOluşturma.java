import org.json.JSONObject;
import org.junit.Test;

public class C05_JsonObjesiOluşturma {

    @Test

    public void test01() {

         /*
        {
         "firstname":"Jim",
         "additionalneeds":"Breakfast",
         "bookingdates":{                  --> bookingdates ayrı bir json objesi // içerideki json objesi
                 "checkin":"2018-01-01",
                 "checkout":"2019-01-01"
            },
          "totalprice":111,
          "depositpaid":true,
          "lastname":"Brown"
     }
         */


        // önce inner json objesini oluşturalım.
        JSONObject dateJsonObject = new JSONObject();
        dateJsonObject.put("checkin","2018-01-01");
        dateJsonObject.put("checkout","2019-01-01");

        // sonra outer json objesini oluşturup, yeri geldiğinde inner objeyi koyalım.
        JSONObject requestBody = new JSONObject();
        requestBody.put("firstname","Jim");
        requestBody.put("additionalneeds","Breakfast");
        requestBody.put("bookingdates",dateJsonObject);
        requestBody.put("totalprice",111);
        requestBody.put("depositpaid",true);
        requestBody.put("lastname","Brown");

        System.out.println(requestBody);

        // {"firstname":"Jim","additionalneeds":"Breakfast","bookingdates":{"checkin":"2018-01-01","checkout":"2019-01-01"},"totalprice":111,"depositpaid":true,"lastname":"Brown"}



    }
}
