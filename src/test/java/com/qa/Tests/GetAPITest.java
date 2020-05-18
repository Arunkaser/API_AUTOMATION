package com.qa.Tests;

import com.qa.Base.TestBase;
import com.qa.Client.RestClent;
import com.qa.commonfunction.CommonFunction;
import com.qa.util.TestUtils;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.testng.annotations.BeforeMethod;
import org.json.JSONObject;
import org.testng.annotations.Test;


import java.io.IOException;
import java.util.HashMap;

public class GetAPITest extends TestBase {
    TestBase TestBase=null;
    String ServiceURL;
    String APIURL;
    String URL;
    RestClent Restclient;

    @BeforeMethod
    public void SetUP() throws IOException {
        TestBase = new TestBase();

         ServiceURL = prop.getProperty("URL");
         APIURL = prop.getProperty("APIUrl");
         URL = ServiceURL+APIURL;
         System.out.println("URL is ==>>> "+URL);
    }


    @Test(priority = 1,enabled = false)
    public void GETAPI_Test01() throws IOException {
        Restclient  = new RestClent();
        CommonFunction cfun = new CommonFunction();
        Restclient.GET_Method(URL);

        //Status Code
        cfun.Get_StatusCode();

        //JSON Response
        JSONObject ResponseJSON = cfun.GetJSONResponse();
        String per_page= TestUtils.GetvaluebyJpath(ResponseJSON,"/per_page");
        System.out.println("per_page value is "+per_page);

        // JSON Array
        String Lastname= TestUtils.GetvaluebyJpath(ResponseJSON,"/data[0]/last_name");
        String id= TestUtils.GetvaluebyJpath(ResponseJSON,"/data[0]/id");
        String avatar  = TestUtils.GetvaluebyJpath(ResponseJSON,"/data[0]/avatar");
        String Firstname= TestUtils.GetvaluebyJpath(ResponseJSON,"/data[0]/first_name");

        System.out.println("Lastname value is "+Lastname);
        System.out.println("id value is "+id);
        System.out.println("avatar value is "+avatar);
        System.out.println("Firstname value is "+Firstname);

    }

    @Test(priority = 2,enabled = false)
    public void GETAPI_Test02() throws IOException {
        Restclient  = new RestClent();
        CommonFunction cfun = new CommonFunction();
        HashMap<String,String> headermap = new HashMap<String, String>();
        headermap.put("Content-Type","application/json");
        Restclient.GET_Method(URL,headermap);

        //Status Code
        cfun.Get_StatusCode();

        //JSON Response
        JSONObject ResponseJSON = cfun.GetJSONResponse();
        String per_page= TestUtils.GetvaluebyJpath(ResponseJSON,"/per_page");
        System.out.println("per_page value is "+per_page);

        // JSON Array
        String Lastname= TestUtils.GetvaluebyJpath(ResponseJSON,"/data[1]/last_name");
        String id= TestUtils.GetvaluebyJpath(ResponseJSON,"/data[1]/id");
        String avatar  = TestUtils.GetvaluebyJpath(ResponseJSON,"/data[1]/avatar");
        String Firstname= TestUtils.GetvaluebyJpath(ResponseJSON,"/data[1]/first_name");

        System.out.println("Lastname value is "+Lastname);
        System.out.println("id value is "+id);
        System.out.println("avatar value is "+avatar);
        System.out.println("Firstname value is "+Firstname);

    }

    @Test
    public void GetAPITestWithQueryParam(){
        try {
            System.out.println(" Query Parameter Test Case ===== > START");
            Restclient  = new RestClent();
            CommonFunction cfun = new CommonFunction();
            HashMap<String,String> headermap = new HashMap<String, String>();
            headermap.put("Content-Type","application/json");

            Restclient.GET_Method(URL,headermap,"2");

            //Status Code
            cfun.Get_StatusCode();
            cfun.GetJSONResponse();

           /* //JSON Response
            JSONObject ResponseJSON = cfun.GetJSONResponse();
            String per_page = TestUtils.GetvaluebyJpath(ResponseJSON,"/per_page");
            System.out.println("per_page value is "+ per_page);
*/


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
