import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C10_JsonPathKullanimi {

    @Test

    public void method01(){
        /*
           NOT : * JSONPath JSON verilerini okuma ve update etme fırsatı verir.
                 * JSONPath sayesinde kompleks yapısaki JSON objelerinin
                   içerisinde ki bilgilere kolayca ulaşabiliyoruz.
                 * Bir JSON objesinin içinde birden fazla data türünde
                   primitive data veya obje bulunabilir
         */

        JSONObject kisiBilgileriJsonObje = new JSONObject();

        JSONObject adresJsonObje = new JSONObject();

        JSONArray telefonBilgileriArray = new JSONArray();
        JSONObject cepTelefonuJsonObje = new JSONObject();
        JSONObject evTelefonuJsonObje = new JSONObject();

        adresJsonObje.put("streetAddress","naist street");
        adresJsonObje.put("city","Nara");
        adresJsonObje.put("postalCode","630-0192");

        cepTelefonuJsonObje.put("type","iPhone");
        cepTelefonuJsonObje.put("number","0123-4567-8888");
        evTelefonuJsonObje.put("type","home");
        evTelefonuJsonObje.put("number","0123-4567-8910");
        telefonBilgileriArray.put(cepTelefonuJsonObje);
        telefonBilgileriArray.put(evTelefonuJsonObje);

        kisiBilgileriJsonObje.put("firstName","John");
        kisiBilgileriJsonObje.put("lastName","Doe");
        kisiBilgileriJsonObje.put("age",26);
        kisiBilgileriJsonObje.put("address",adresJsonObje);
        kisiBilgileriJsonObje.put("phoneNumbers",telefonBilgileriArray);

        /*
           --> JSON çok esnek bir data türü, key lerin karşına "String", "Integer", "Json Objesi", "Json Array" i
               Value değerleri konulabilir.
         */

        System.out.println(kisiBilgileriJsonObje);

        System.out.println("firstName : "+kisiBilgileriJsonObje.get("firstName"));
        System.out.println("lastName : "+kisiBilgileriJsonObje.get("lastName"));

        System.out.println("cadde: " + kisiBilgileriJsonObje.getJSONObject("address")
                                                            .get("streetAddress"));

        System.out.println("city : " + kisiBilgileriJsonObje.getJSONObject("address")
                                                            .get("city"));

        System.out.println("cep tel no : " + kisiBilgileriJsonObje.getJSONArray("phoneNumbers")
                                                                  .getJSONObject(0)
                                                                  .get("number"));







    }
}
