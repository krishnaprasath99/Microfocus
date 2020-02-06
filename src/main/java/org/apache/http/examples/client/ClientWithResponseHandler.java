package org.apache.http.examples.client;

import java.io.IOException;
import java.net.URL;
import java.sql.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


/**
 * This example demonstrates the use of the {@link ResponseHandler} to simplify
 * the process of processing the HTTP response and releasing associated resources.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientWithResponseHandler {
    @JsonProperty("getUsersSrvUrl")
    private String getUsersSrvUrl;
    /*@JsonProperty("getLicensesSrvUrl")
    private String getLicensesSrvUrl;
    @JsonProperty("status")
    private String status;
    @JsonProperty("user")
    private String uId;
    @JsonProperty("clientContext")
    private String clientContext;
    @JsonProperty("expirationMillis")
    private String expirationMillis;*/

    public final static void main(String[] args) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {

            /*dbconnect d=new dbconnect();
            d.connect();*/

            // Create a custom response handler
          parser p=new parser();
          String a=p.parsefn();
            parser2 p1=new parser2();
            String a1=p1.parsefn2();






            HttpGet httpget = new HttpGet(a+"?sToken=eyJleHBEYXRlIjoiMjAyMC0wOS0xNVQyMzoxNToxNi0wNzAwIiwidG9rZW4iOiI5c3RtRTcvbWFuckxJZExqcU1DeXpjaXM2S1BxZ0p3blVha1JMditVN0swdlF1RTQvWDIwdkNYeXd2U3pwZXpZQk05d3B0M0Z0bVYrSExXYldlcVRWdUhmaWxzL050ajZ1OTgzdktPckFjbkNBOHlvN0VDV09IQ1o3bm1kSDFMK09zVzdJeThUVlZ5MkNWS0JXZGVOZEE9PSIsIm9yZ05hbWUiOiJOb3ZlbGwifQ==");
            System.out.println("Executing request " + httpget.getRequestLine());
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

                @Override
                public String handleResponse(
                        final HttpResponse response) throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }

            };
            String responseBody = httpclient.execute(httpget, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);

            ObjectMapper mapper = new ObjectMapper();
            //Staff staff = createStaff();
            // pretty print
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(responseBody);
            System.out.println(json);

            System.out.println("-----------------db-----------------------");
             /* Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("create database database1");
            System.out.println("-----------------db-----------------------");
            int m = stmt.executeUpdate(String.valueOf(rs));
            if (m == 1)
                System.out.println("inserted successfully");
            else
                System.out.println("insertion failed");*/
        }
        //catch(Exception e){}
        finally {
            httpclient.close();
        }
    }

}