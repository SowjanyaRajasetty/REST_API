package JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class JsonParsing {
  @Test
  public void f() throws IOException {
	  File jsonDataInFile = new File("src/test/resources/jsonFiles/details.json");
//	  RestAssured.baseURI="";
//	  RequestSpecification reqSpec=RestAssured.given().header(header);
	  String exampleRequest = FileUtils.readFileToString(jsonDataInFile, StandardCharsets.UTF_8);
	  JSONObject JO=new JSONObject(exampleRequest);
	  System.out.println(JO.toString());
	  JSONArray addressArray=JO.getJSONObject("sampleData").getJSONArray("address");
	  for(int i=0;i<addressArray.length();i++)
	  {
		  System.out.println(addressArray.getJSONObject(i).get("city"));
	  }
  }
}
