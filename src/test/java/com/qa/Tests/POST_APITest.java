package com.qa.Tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.Base.TestBase;
import com.qa.Client.RestClent;
import com.qa.data.User;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.*;
import java.io.IOException;
import java.util.HashMap;

public class POST_APITest extends TestBase {
    TestBase TestBase = null;
    String ServiceURL;
    String APIURL;
    String URL;
    RestClent Restclient;

    @BeforeMethod
    public void SetUP() throws IOException {
        try {
            TestBase = new TestBase();
            ServiceURL = prop.getProperty("URL");
            APIURL = prop.getProperty("APIUrl");
            URL = ServiceURL + APIURL;
            System.out.println("URL is ==>>> " + URL);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    @Test
    public void POSTTest() throws IOException {

        TestBase testBase = new TestBase();
        try {
            Restclient = new RestClent();

            HashMap<String, String> headermap = new HashMap<String, String>();
            headermap.put("Content-Type", "application/json");

            //jackson API
            ObjectMapper mapper = new ObjectMapper();
            User user = new User("morpheus", "leader");

            //Object to JSON file conversion
            mapper.writeValue(new File("C:\\Users\\Arun\\IdeaProjects\\API_Automation\\src\\main\\java\\com\\qa\\data\\User.json"), user);

            //Object to JSON in String
            String StringJSON = mapper.writeValueAsString(user);
            System.out.println("user to String JSON ===> " + StringJSON);

            CloseableHttpResponse ResponsePost = Restclient.PostMethod(URL, StringJSON, headermap); // Post Method Invoke

            //1. Status Code
            int StatusCode = ResponsePost.getStatusLine().getStatusCode();
            Assert.assertEquals(StatusCode, testBase.RESPONSE_STATUS_CODE_201);

            // Json Response validation
            String ResponseString = EntityUtils.toString(ResponsePost.getEntity(), "UTF-8");
            JSONObject ResponseJSOn = new JSONObject(ResponseString);
            System.out.println(ResponseJSOn);

            //JSON to Java Object
            User UserRespose = mapper.readValue(ResponseString, User.class);
            Assert.assertTrue(user.getName().equals(UserRespose.getName()));
            Assert.assertTrue(user.getJob().equals(UserRespose.getJob()));
            System.out.println(UserRespose.getId());
            System.out.println(UserRespose.getCreatedAt());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
