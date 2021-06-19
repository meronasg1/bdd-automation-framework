package com.pnt.restapi;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;

public class ReadJsonFiles {

    // this method allows you to read a .json file
    public static JSONArray getJsonArray(String fileName) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(fileName));
        return jsonArray;
    }

    public static void main(String[] args) throws IOException, ParseException {
       JSONArray jsonArray = getJsonArray("src/api/test/java/com/pnt/restapi/SingleArray_ArrayInMultipleJson.json");
        System.out.println(jsonArray);
        System.out.println(jsonArray.get(0));
        JSONObject jsonObject =(JSONObject) jsonArray.get(0);
        System.out.println(jsonObject);
        System.out.println(jsonObject.get("feature"));
        System.out.println(jsonObject.get("data"));

        JSONArray jsonArrayFromData = (JSONArray) jsonObject.get("data");
        System.out.println(jsonArrayFromData);

        JSONObject jsonObject1 = (JSONObject) jsonArrayFromData.get(1);
        System.out.println(jsonObject1);
        System.out.println(jsonObject1.get("name"));
        System.out.println(jsonObject1.get("salary"));





    }

}
