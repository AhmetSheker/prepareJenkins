package testdata;

import java.util.HashMap;
import java.util.Map;

public class HerOkuAPPData {

    public Map<String, String> bookingDate(String chekcin, String checkout){
        Map<String, String> bookDate = new HashMap<>();
        bookDate.put("checkin", chekcin);
        bookDate.put("checkout", checkout);
        return bookDate;
    }

    public Map<String, Object> herOkuAppData(String firstname, String lastname, Integer totalprice, Boolean depositpaid, String additionalneeds){
        Map<String, Object> herOkuAppTestData = new HashMap<>();
        herOkuAppTestData.put("firstname", firstname);
        herOkuAppTestData.put("lastname", lastname);
        herOkuAppTestData.put("totalprice", totalprice);
        herOkuAppTestData.put("depositpaid", depositpaid);
        herOkuAppTestData.put("additionalneeds", additionalneeds);
        return herOkuAppTestData;

    }
}
