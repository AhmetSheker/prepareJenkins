package testdata;

import java.util.HashMap;
import java.util.Map;

public class GorestData {

    public Map<String, Object> inner(Integer id, String name, String email, String gender, String status){
        Map<String, Object> innerData = new HashMap<>();
        innerData.put("id", id);
        innerData.put("name", name);
        innerData.put("email", email);
        innerData.put("gender", gender);
        innerData.put("status", status);

        return innerData;
    }
}
