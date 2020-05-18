package com.qa.commonfunction;

import com.qa.Base.TestBase;
import com.qa.Client.RestClent;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;

import java.util.HashMap;

public class CommonFunction extends TestBase {
    CloseableHttpResponse GetResponse = null;

    public void Get_StatusCode() {
        GetResponse = RestClent.GetResponse;
        TestBase testBase = new TestBase();
        try {
            // Status code
            int StatusCode = GetResponse.getStatusLine().getStatusCode();
            System.out.println("Status Code is " + StatusCode);
            Assert.assertEquals(testBase.RESPONSE_STATUS_CODE_200, StatusCode, "Unexpected Status Code " + StatusCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return
     */
    public JSONObject GetJSONResponse() {
        JSONObject ResponseJSON = null;
        GetResponse = RestClent.GetResponse;
        try {
            String ResponseString = EntityUtils.toString(GetResponse.getEntity(), "UTF-8");
            //TO convert response to JSON format

            ResponseJSON = new JSONObject(ResponseString);

            // JSON String
            System.out.println("Json Response is ===> "+ResponseJSON);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseJSON;
    }

    public void Get_HeaderArray() {
        try {


            Header[] HeaderArray = GetResponse.getAllHeaders();
            HashMap<String, String> AllheaderMap = new HashMap<String, String>();

            for (Header myheader : HeaderArray) {
                AllheaderMap.put(myheader.getName(), myheader.getValue());
            }
            //All Headers
            System.out.println(AllheaderMap);


        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}

