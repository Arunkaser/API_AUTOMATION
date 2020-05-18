package API_TestCases;

import static  com.jayway.restassured.RestAssured.*;

import com.jayway.restassured.response.Response;
import com.sun.swing.internal.plaf.synth.resources.synth_sv;
import javafx.beans.binding.When;
import org.testng.annotations.Test;

public class WeatherAPI_GETRequest {

    //Simple Get Request for Weather by City Name
    @Test
    public void Test01(){
        //https://samples.openweathermap.org/data/2.5/weather?q=London&appid=cbed121ee245816e561d3340905d141a
        //https://samples.openweathermap.org/data/2.5/weather
        try {
            System.out.println("Response Code before is : "+200);
            Response response = when().get("https://samples.openweathermap.org/data/2.5/weather?q=London&appid=cbed121ee245816e561d3340905d141a");
              System.out.println("Response Code is : "+response.getStatusCode());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

/*
    @Test
    public void Test02(){

        try {
            given().param("q","London").
                    param("appid","cbed121ee245816e561d3340905d141a").
                    when().get("").then().assertThat().statusCode(200);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }*/
}
