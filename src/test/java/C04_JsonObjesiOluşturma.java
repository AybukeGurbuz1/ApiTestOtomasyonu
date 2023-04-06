import org.json.JSONObject;
import org.junit.Test;

public class C04_JsonObjesiOluşturma {

    @Test

    public void test01() {

         /*
            {
            "title":"Aybüke",
            "body":"Merhaba",
            "userId":1
            }
         */

        JSONObject obje1= new JSONObject();
        obje1.put("title","Aybüke");
        obje1.put("body","Merhaba");
        obje1.put("userId",1);

        System.out.println(obje1);

        // {"title":"Aybüke","body":"Merhaba","userId":1}

    }
}
