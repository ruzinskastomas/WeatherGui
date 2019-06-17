/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playonapi;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marius
 */
public class WeatherGuiTest {
    
    public WeatherGuiTest() {
    }

    @Test
    public void testGetWeather() {
        System.out.println("getWeather");
        WeatherGui instance = new WeatherGui();
        int expResult = 200;
        int result = instance.getWeather();
        assertEquals(expResult, result);
        
    }

    
}
