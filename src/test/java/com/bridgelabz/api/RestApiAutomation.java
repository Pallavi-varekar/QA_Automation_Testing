//****************
//Author Name : Pallavi Varekar
//Project     : Rest Automation JDBC
//Date        : 29/01/2023
//****************
package com.bridgelabz.api;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestApiAutomation {
    @Test
    public void getCurrentUserProfile(){
      Response result =  given().contentType("application/json")
                                .accept("application/json")
                                .header("Authorization","Bearer BQBavhAy9Kj9QvrnNY7TE5GQiznPr7DHlDxxHcxf4y7G2vDKZlW_XNo6tc_yMdOHOiFEowHlqLm0JoIHvdBS4h3BG-xLuBeUnub4dl0RViBJvfgUwNGpzcnWwd4wyyIEzrekU414r6fJi4fLF03JXwVmTvaJQdLmt4SvobS1NRSeLpG4u3hNN6FckOfstuRwUvMy_KpuMr_sbShP2vMzgrLqJtpkAkxJrVCXfSolzE2FSw27WSjiX64_tpu_wUq-Qb9853mwQfL7HiZFAu81xVlUqwES7SXF")
                                .when()
                                .get("https://api.spotify.com/v1/me");
      //System.out.println("Response: " +result);
        String userId =result.path("id");
        System.out.println("UserId : "+userId);
        result.prettyPrint();
        result.then().assertThat().statusCode(200);


    }


}
