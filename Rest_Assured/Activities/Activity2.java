package activities;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Activity2 {

    String baseURL = "https://petstore.swagger.io/v2/user";

    @Test(priority =1)
    void addUserFromFile() throws IOException {
        FileInputStream inputJson = new FileInputStream("src/test/java/activities/userInput.json");
        String reqBody = new String(inputJson.readAllBytes());

        Response res = given().contentType(ContentType.JSON)
                .body(reqBody)
                .when().post(baseURL);

        inputJson.close();

        System.out.println(("Post request response : "+ res.body().prettyPrint()));
        res.then().body("code", equalTo(200));
        res.then().body("message",equalTo("9901"));

    }

    //get pet details

    @Test(priority =2)
    public void getUserDetails(){

        File outputJSON = new File("src/test/java/activities/userGETResponse.json");
        Response res = given().contentType(ContentType.JSON)
                .when().get(baseURL+"/justinc");
        String ResponseBody = res.body().prettyPrint();
        System.out.println( "Get pet Details Response "+ResponseBody);

        try{
            outputJSON.createNewFile();
            FileWriter writer = new FileWriter(outputJSON.getPath());
            writer.write(ResponseBody);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        res.then().body("id", equalTo(9901));
        res.then().body("username",equalTo("justinc"));
        res.then().body("firstName",equalTo("Justin"));
        res.then().body("lastName",equalTo("Case"));
        res.then().body("email",equalTo("justincase@mail.com"));
        res.then().body("password",equalTo("password123"));
        res.then().body("phone",equalTo("9812763450"));
        res.then().body("userStatus",equalTo(0));

    }

    @Test(priority =3)
    public void deleteUser(){
        Response res = given().contentType(ContentType.JSON)
                .when().delete(baseURL+"/justinc");
        System.out.println( "Delete Response "+res.body().prettyPrint());
        res.then().body("code", equalTo(200));
        res.then().body("message",equalTo("justinc"));
    }
}
