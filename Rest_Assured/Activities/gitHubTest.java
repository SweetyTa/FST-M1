package Project;

import static org.hamcrest.CoreMatchers.equalTo;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;


public class gitHubTest {
    RequestSpecification requestSpec;
    String sshKey ;
    int ssh_id;

    @BeforeClass
    public void setUp() {
        requestSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://api.github.com")
                .build();
        Header authorization = new Header("Authorization", "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");

    }
    @Test(priority=0)
    public void postReq(){

       String title = "TestAPIKey";
       String sshKey= " ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAICaUFx3ocklzRPNszmtiO3gNSsT9cM0PRz/2VNHeZGsD" ;

        Response response = given().spec(requestSpec) // Use requestSpec
                .body(sshKey) // Send request body
                .when().post(); // Send POST request

        ssh_id = response.then().extract().path("id");
        String body = response.getBody().asPrettyString();

        System.out.println(body);
        response.then().body("code", equalTo(201));


    }
    @Test(priority = 1)
    public void getReq(String sshKey){
        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .when()
                        .pathParam("keyId",ssh_id).get("/{keyId}");

        System.out.println(response.asPrettyString());
        // Assertions
        response.then().body("code", equalTo(200));

    }
    @Test(priority = 2)
    public void deleteReq(){
        given().contentType(ContentType.JSON) // Set headers
                .when()
                .pathParam("keyId",ssh_id).get("/{keyId}");
        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .when().delete(baseURI +
                                "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAICaUFx3ocklzRPNszmtiO3gNSsT9cM0PRz/2VNHeZGsD");
        response.then().body("code", equalTo(204));
        response.then().body("message", equalTo("ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAICaUFx3ocklzRPNszmtiO3gNSsT9cM0PRz/2VNHeZGsD"));
    }

}
