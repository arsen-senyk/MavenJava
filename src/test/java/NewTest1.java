import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import org.json.JSONException;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class NewTest1 {

    @Test
    public void test1()
            throws ClientProtocolException, IOException {

        // Given

        HttpGet request = new HttpGet( "https://api.github.com/users/arsen-senyk" );
        HttpGet request1 = new HttpGet( "http://stage.dsources.com/api/v1/health_check" );

        // When
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        System.out.println(httpResponse);
        HttpResponse httpResponse1 = HttpClientBuilder.create().build().execute( request1 );
        System.out.println(httpResponse1);

        // Then
        AssertJUnit.assertEquals(200, httpResponse.getStatusLine().getStatusCode());
        AssertJUnit.assertEquals(200, httpResponse1.getStatusLine().getStatusCode());

        AssertJUnit.assertEquals("application/json", ContentType.getOrDefault(httpResponse.getEntity()).getMimeType() );
        String mimeType1 = ContentType.getOrDefault(httpResponse1.getEntity()).getMimeType();
        AssertJUnit.assertEquals( mimeType1, "application/json" );

    }
    @Test
    public void test2() throws ClientProtocolException, IOException, JSONException {

        //make get request

        HttpGet request = new HttpGet( "https://api.github.com/users/arsen-senyk" );
        HttpGet resp = new HttpGet("http://stage.dsources.com/api/v1/health_check");
        //Get response
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(resp);
        HttpResponse httpResponse2 = HttpClientBuilder.create().build().execute(request);

        // We convert the JSON response to a string, and save it in a variable called 'jsonAsString'
        String json = EntityUtils.toString(httpResponse.getEntity());
        String json2 = EntityUtils.toString(httpResponse2.getEntity());

        //Parse to JsonObject
        JsonParser parser = new JsonParser();
        JsonObject mainObject = parser.parse(json).getAsJsonObject();
        System.out.println(mainObject);
        JsonObject mainObject2 = parser.parse(json2).getAsJsonObject();
        System.out.println(mainObject2);

        //Assertions
        AssertJUnit.assertEquals(true, ((JsonObject) mainObject.get("actorsStatuses")).get("suppWorkActor").getAsBoolean());
        AssertJUnit.assertEquals(true, ((JsonObject) mainObject.get("dbsStatuses")).get("cassandraStatus").getAsBoolean());
        AssertJUnit.assertEquals(true, mainObject.get("kafkaStatus").getAsBoolean());

        AssertJUnit.assertEquals("arsen-senyk",mainObject2.get("login").getAsString());
        AssertJUnit.assertEquals("28435814", mainObject2.get("id").getAsString());
        AssertJUnit.assertEquals("https://github.com/arsen-senyk", mainObject2.get("html_url").getAsString());
        AssertJUnit.assertEquals("User", mainObject2.get("type").getAsString());
    }

    @Test
    public void test3() throws ClientProtocolException, IOException, JSONException {

        HttpGet request = new HttpGet( "https://maps.googleapis.com/maps/api/geocode/json?latlng=40.714224,-73.961452&key=AIzaSyBO3l_U2XvF43FrY0YamYNtUC0wO52rGhk" );
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        System.out.println(httpResponse);
        String json = EntityUtils.toString(httpResponse.getEntity());

        JsonParser parser = new JsonParser();
        JsonObject mainObject = parser.parse(json).getAsJsonObject();
        System.out.println(mainObject);

        //Asserts
        AssertJUnit.assertEquals(200, httpResponse.getStatusLine().getStatusCode());
        AssertJUnit.assertEquals( "application/json", ContentType.getOrDefault(httpResponse.getEntity()).getMimeType());
        AssertJUnit.assertEquals("OK", mainObject.get("status").getAsString());
        System.out.println(((JsonArray) mainObject.get("results")));
        JsonArray ja = (JsonArray) mainObject.get("results");

        System.out.println("array element: " + ((JsonObject) ((JsonObject) ja.get(0)).get("geometry")).get("location_type"));

        int count = 0;
        String s1 = "ChIJ3YJV4PRWwokRFFI21ZrHXtQ";
        for (JsonElement i: ja) {
            count += 1;
            //System.out.println("formatted_address: " + ((JsonObject) i).get("formatted_address").toString());
            //System.out.println("place_id: " + ((JsonObject) i).get("place_id").toString());
            if ((((JsonObject) i).get("place_id").toString()).contains(s1)) {
                System.out.println("types: " + ((JsonObject) i).get("types").toString());
                System.out.println("formatted_address: " + ((JsonObject) i).get("formatted_address").toString());
                System.out.println("place_id: " + ((JsonObject) i).get("place_id").toString());
            }
        }
        System.out.println("Amount of addreses: " + count);


    }



    @Test
    public void test4() throws ClientProtocolException, IOException, JSONException {


        HttpGet request = new HttpGet(
                "https://api.trello.com/1/boards/tBmYPSYe?fields=id,name,idOrganization,dateLastActivity&lists=open&list_fields=id,name&key=a6ec09376428d672ffedf5efe73c0031&token=aedb25aed9412d1b99375f910b4a36b1012909f6b0e99f9f7d1ff42aab4250c0" );
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        System.out.println(httpResponse);

        AssertJUnit.assertEquals(200, httpResponse.getStatusLine().getStatusCode());
        AssertJUnit.assertEquals("application/json", ContentType.getOrDefault(httpResponse.getEntity()).getMimeType() );

        String json = EntityUtils.toString(httpResponse.getEntity());
        JsonParser parser = new JsonParser();
        JsonObject mainObject = parser.parse(json).getAsJsonObject();
        System.out.println(mainObject);

        AssertJUnit.assertEquals("\"US National Parks\"", mainObject.get("name").toString());

        HttpGet request1 = new HttpGet(
                "https://api.trello.com/1/boards/9clNtU6v/shortUrl");
        HttpResponse httpResponse1 = HttpClientBuilder.create().build().execute(request1);
        System.out.println(httpResponse1);

        String json1 = EntityUtils.toString(httpResponse1.getEntity());

        JsonObject mainObject1 = parser.parse(json1).getAsJsonObject();
        System.out.println(mainObject1);


        //Post
        HttpPost post = new HttpPost("https://api.trello.com/1/boards/?name=55&defaultLabels=true&defaultLists=true&desc=Arsen&prefs_selfJoin=false&key=a6ec09376428d672ffedf5efe73c0031&token=aedb25aed9412d1b99375f910b4a36b1012909f6b0e99f9f7d1ff42aab4250c0" );
        HttpResponse httpResponse3 = HttpClientBuilder.create().build().execute(post);
        System.out.println(httpResponse3);

        AssertJUnit.assertEquals(200, httpResponse3.getStatusLine().getStatusCode());
        AssertJUnit.assertEquals("application/json", ContentType.getOrDefault(httpResponse3.getEntity()).getMimeType() );

        String json3 = EntityUtils.toString(httpResponse3.getEntity());
        JsonObject mainObject3 = parser.parse(json3).getAsJsonObject();
        System.out.println(mainObject3);
        AssertJUnit.assertEquals("\"55\"", mainObject3.get("name").toString());
        System.out.println(mainObject3.get("name"));





    }
}
