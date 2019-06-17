/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playonapi;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marius
 */
public class Testing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            String address = "https://api.openweathermap.org/data/2.5/forecast/daily?q=London&appid=ae3723984918e29156906ffa2182bf02&units=celsius";
            String urlofget = address;
            try {
            URL url = new URL(urlofget);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            String apikey = "ae3723984918e29156906ffa2182bf02";
            connection.setReadTimeout(15 * 1000);
            connection.setRequestMethod("GET");
            connection.connect();
            BufferedReader in = new BufferedReader(
            new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
                System.out.println(content);
            JsonToMap gson = new JsonToMap();
            int i = 0;
            double deg;
            while(i < 6) {
            Map<String, Object> resultMap = gson.jsonToMap(content.toString());
                System.out.println(resultMap.keySet());
            ArrayList<Map<String, Object>> list = (ArrayList<Map<String, Object>>) resultMap.get("list");
            Map<String, Object> city = (Map<String, Object>) resultMap.get("city");
                System.out.println(city.get("timezone"));
            Map<String, Object> listMap = list.get(i);
            Map<String, Object> temps = (Map<String, Object>) listMap.get("temp");
            deg = (Double) temps.get("day") - 273.15;
            System.out.println("Day" + (int) deg);
            ArrayList<Map<String, Object>> weathers = (ArrayList<Map<String, Object>>) listMap.get("weather");
            Map<String, Object> weatherMap = weathers.get(0);
            i++;
            }
            in.close();
            }
            catch(MalformedURLException e) {
                System.out.println(e.getMessage());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
        }
    
}
}
