package activities;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import org.testng.annotations.DataProvider;
import org.testng.annotations.*;
import static org.hamcrest.CoreMatchers.equalTo;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
public class Activity3 {
    RequestSpecification reqSpec;
    ResponseSpecification resSpec;

    @BeforeTest
    public void setUp(){
        reqSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://petstore.swagger.io/v2/pet")
                .build();
        resSpec = new ResponseSpecBuilder()
                .expectContentType("application/json")
                .expectStatusCode(200)
                .expectBody("status", equalTo("alive"))
                .build();
    }

    @DataProvider
    public Object[][] inputData(){
        Object[][] testdata = new Object[][]
         {
                 { 77232, "Riley", "alive" },
                 { 77233, "Hansel", "alive" }
        };
        return testdata;
    }
 @Test(priority =1)
 public void addPets(){
      String reqBody = """
              {"id": 77232, "name": "Riley", "status": "alive"}
              """;
      Response res = given().spec(reqSpec)
              .body(reqBody)
              .when().post();

     reqBody = """
             {"id": 77233, "name": "Hansel", "status": "alive"}
             """;
     res =  given().spec(reqSpec) // Use requestSpec
             .body(reqBody) // Send request body
             .when().post();

     res.then().spec(resSpec);
 }

 @Test(priority =2, dataProvider = "inputData")
    public void getPet(int id, String name, String status){
        Response res = given().spec(reqSpec)
                .pathParam("petId",id)
                .when().get("/{petId}");
        System.out.println("Get pets Response :" + res.prettyPrint());
       res.then()
               .spec(resSpec)
               .body("name", equalTo(name));
 }

 @Test(priority =3,dataProvider ="inputData")
    public void deletePets(int id, String name, String status){
        Response res = given().spec(reqSpec)
                .pathParam("petId",id)
                .when().delete("/{petId}");
     System.out.println( "Delete Response "+res.body().prettyPrint());
        res.then().body("code", equalTo(200));
 }

}
