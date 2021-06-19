package com.pnt.restapi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class TestRestEndpoints {

 /*   There are following public apis
#	        Route	Method	Type	Full route	Description	Details
            1	/employee	GET	JSON	http://dummy.restapiexample.com/api/v1/employees	Get all employee data	Details
            2	/employee/{id}	GET	JSON	http://dummy.restapiexample.com/api/v1/employee/1	Get a single employee data	Details
            3	/create	POST	JSON	http://dummy.restapiexample.com/api/v1/create	Create new record in database	Details
            4	/update/{id}	PUT	JSON	http://dummy.restapiexample.com/api/v1/update/21	Update an employee record	Details
            5	/delete/{id}	DELETE	JSON	http://dummy.restapiexample.com/api/v1/delete/2	Delete an employee record	Details
*/

    private String baseURL= RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/";

    private String employeesEndpoint = "employees";
    private String employeeEndpoint = "employee/5";
    private String createEmployee = "create";
    private String updateEmployee ="update/5";
    private String deleteEmployee = "delete/6";

    @Test
    public void deleteAnEmployee(){


        Response response = RestAssured.given().when().delete(deleteEmployee)
                .then().assertThat().statusCode(200).extract().response();
        System.out.println(response.asString());
        System.out.println(response.getStatusCode());
    }

    @Test
    public void updateAnEmployee(){

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("salary", "120000");

        Response response = RestAssured.given().contentType(ContentType.JSON).body(jsonObject).when().put(updateEmployee)
                .then().assertThat().statusCode(200).extract().response();
        System.out.println(response.asString());
        System.out.println(response.getStatusCode());
    }

    @Test
    public void createEmployee(){

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "pnt");
        jsonObject.put("salary", "100000");
        jsonObject.put("age", 27);
        System.out.println(jsonObject);

        Response response = RestAssured.given().contentType(ContentType.JSON).body(jsonObject).when().post(createEmployee)
                .then().assertThat().statusCode(200).extract().response();
        System.out.println(response.asString());
        System.out.println(response.getStatusCode());
    }

    @Test
    public void getAllEmployees(){

        Response response = RestAssured.given().when().get(employeesEndpoint)
                .then().assertThat().statusCode(200).extract().response();
        System.out.println(response.asString());
        System.out.println(response.getStatusCode());

        JsonPath js = new JsonPath(response.asString());
        JSONArray jsonArray = new JSONArray(js.get("data").toString());
        System.out.println(jsonArray.get(0));
        System.out.println(js.get("data").toString());

    }

    @Test
    public void getIndividualEmployee(){
        Response response = RestAssured.given().when().get(employeesEndpoint)
                .then().assertThat().statusCode(200).extract().response();
        System.out.println(response.asString());
        System.out.println(response.getStatusCode());
    }

}