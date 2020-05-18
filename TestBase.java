package com.qa.Base;

import com.sun.deploy.panel.IProperty;

import java.io.FileInputStream;
import java.util.Properties;

public class TestBase {
    public Properties prop = null;
    public int RESPONSE_STATUS_CODE_200 = 200;
    public int RESPONSE_STATUS_CODE_201 = 201;
    public int RESPONSE_STATUS_CODE_204 = 204;
    public int RESPONSE_STATUS_CODE_400 = 400;
    public int RESPONSE_STATUS_CODE_404 = 404;
    public int RESPONSE_STATUS_CODE_500 = 500;
    public int RESPONSE_STATUS_CODE_501 = 501;

    public TestBase(){
        try{

            prop = new Properties();
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/config/config.properties");
            prop.load(fis);
        }catch (Exception e){
            e.printStackTrace();
        }
       }
}
