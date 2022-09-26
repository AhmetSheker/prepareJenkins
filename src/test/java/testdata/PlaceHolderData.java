package testdata;

import java.util.HashMap;
import java.util.Map;

public class PlaceHolderData {


    public Map<String, Object> testData(Integer userId, String title, Boolean completed){

        Map<String, Object> testDataMap = new HashMap<>();
        testDataMap.put("userId", userId);
        testDataMap.put("title", title);
        testDataMap.put("completed", completed);
        return testDataMap;
    }
}
