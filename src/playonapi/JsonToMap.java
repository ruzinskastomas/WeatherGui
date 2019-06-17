/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playonapi;

/**
 *
 * @author marius
 */
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.Map;

public class JsonToMap {
    //parsing Json to Map
    public Map<String, Object> jsonToMap(String str) {
        Map<String, Object> map = new Gson().fromJson(str, new TypeToken<HashMap<String, Object>>() {
        }.getType());
        return map;
    }
}
