package AutenticationTest;
// Importing static methods for cleaner syntax

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.codehaus.groovy.ast.tools.GeneralUtils.param;

public class Auth2_0_GenerateTokenwithOutHardodedTest {
    @Test(priority = 0)
    public void Auth2_TokenUsingAutomation() {
        // Step 1: Generate an OAuth2.0 access token dynamically (no hardcoding)
        // We call the token endpoint with client_id, client_secret, and grant_type as parameters.
       Response response = given().
                param("client_id", "RestAPIs").
                param("client_secret", "826ad36b232430645b1e25144f82bdba").
                param("grant_type", "client_credentials").
                post("http://coop.apps.symfonycasts.com/token");

        // Step 2: (Optional) Print the full JSON response of token generation for debugging
        // response.prettyPrint();  // Uncomment this to view complete token details in console

        // Step 3: Extract only the "access_token" value from the JSON response
        // This token will be used for authentication in the next API call.

              String token =  response.jsonPath().get("access_token")
                      ;
        // Step 4: Use the generated token to call another protected API endpoint
        // Here we are calling the "barn-unlock" API using the Bearer token for authorization.

       Response response1 = given()
                .auth()
                .oauth2(token)
                .post("http://coop.apps.symfonycasts.com/api/4413/barn-unlock");

        // Step 5: Print the access token value to confirm it was generated successfully
        System.out.println("Access Token: " + token);

        // Step 6: Pretty-print the full API response (formatted JSON)
        response1.prettyPrint();
        // Step 7: Print the HTTP status code returned by the API (e.g., 200 for success)
        System.out.println("Status Code: " + response1.getStatusCode());
        // Step 8: Print the raw response body as a string representation
        System.out.println(response1.getBody().toString());



    }
    @Test(priority = 1)
    public void GenerateTokenForToiletSeatDown()
    {
       Response response =  given().
                param("client_id","RestAssuredAut").
                param("client_secret", "36e5c67b3ea5a91558224643748cd9b5").
                param("grant_type", "client_credentials").
              // param("redirect_uri ","https://restapi.com").
               post("http://coop.apps.symfonycasts.com/token");
             response.prettyPrint();
              String token = response.jsonPath().get("access_token");
              System.out.println("token:" +token);

          Response reponse2 = given().
                  auth().
                  oauth2(token).
                  post("http://coop.apps.symfonycasts.com/api/4413/toiletseat-down");
        System.out.println("Status Code: " + reponse2.getStatusCode());
        System.out.println(reponse2.getBody().toString());
    }
    @Test(priority = 2)
    public void GenerateTokenForFeedYourChickens()
    {
        Response response =  given().
                param("client_id","RestAssuredAute").
                param("client_secret", "dba33f40a4d5db60e80563c0b9b68dd4").
                param("grant_type", "client_credentials").
                param("redirect_uri ","https://restapi.com").
                post("http://coop.apps.symfonycasts.com/token");
        response.prettyPrint();
        String token = response.jsonPath().get("access_token");
        System.out.println("token:" +token);

        Response reponse3 = given().
                auth().
                oauth2(token).
                post("http://coop.apps.symfonycasts.com/api/4413/chickens-feed");
        System.out.println("Status Code: " + reponse3.getStatusCode());
        System.out.println(reponse3.getBody().toString());
    }
    @Test(priority = 3)
    public void GenerateTokenForCollectEggsFromYourChickens()
    {
        Response response =  given().
                param("client_id","RestAssuredAutomate").
                param("client_secret", "47f951957e5325e5c122f0620a578480").
                param("grant_type", "client_credentials").
                param("redirect_uri ","https://restapi.com").
                post("http://coop.apps.symfonycasts.com/token");
        response.prettyPrint();
        String token = response.jsonPath().get("access_token");
        System.out.println("token:" +token);

        Response reponse4 = given().
                auth().
                oauth2(token).
                post("http://coop.apps.symfonycasts.com/api/4413/eggs-collect");
        System.out.println("Status Code: " + reponse4.getStatusCode());
        System.out.println(reponse4.getBody().toString());
    }
    @Test(priority = 4)
    public void GenerateTokenForGetTheNumberOfEggsCollectedToday()
    {
        Response response =  given().
                param("client_id","RestAssuredAutomates").
                param("client_secret", "4a6307c4ad2e22d159efd1f39d0b4227").
                param("grant_type", "client_credentials").
                param("redirect_uri ","https://restapi.com").
                post("http://coop.apps.symfonycasts.com/token");
        response.prettyPrint();
        String token = response.jsonPath().get("access_token");
        System.out.println("token:" +token);

        Response reponse5 = given().
                auth().
                oauth2(token).
                post("http://coop.apps.symfonycasts.com/api/4413/eggs-count");
        System.out.println("Status Code: " + reponse5.getStatusCode());
        System.out.println(reponse5.getBody().toString());
    }
}
