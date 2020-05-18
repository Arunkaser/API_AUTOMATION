package com.qa.util;


import org.json.JSONArray;
import org.json.JSONObject;

public class TestUtils {

   // public static JSONObject responsejson;


    public static String GetvaluebyJpath(JSONObject responsejson, String Jpath) {
        Object obj = responsejson;
        try {
            for (String s : Jpath.split("/")) {
                if (!s.isEmpty()) {
                    if (!(s.contains("[") || s.contains("]"))) {
                        obj = ((JSONObject) obj).get(s);
                    } else if (s.contains("[") || s.contains("]")) {
                        obj = ((JSONArray) ((JSONObject) obj).get(s.split("\\[")[0]))
                                .get(Integer.parseInt(s.split("\\[")[1].replace("]", "")));
                    }

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj.toString();

    }

}
