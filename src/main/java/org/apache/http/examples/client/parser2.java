package org.apache.http.examples.client;


import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class parser2 {

    public String ss2;
    public String fieldName;
    public String parsefn2() {
        System.out.println("In parser2");
        ObjectMapper objectMapper = new ObjectMapper();
        URL url = null;
        try {
            url = new URL("  https://vpp.itunes.apple.com/mdm/registerVPPUserSrv?sToken=eyJleHBEYXRlIjoiMjAyMC0wOS0xNVQyMzoxNToxNi0wNzAwIiwidG9rZW4iOiI5c3RtRTcvbWFuckxJZExqcU1DeXpjaXM2S1BxZ0p3blVha1JMditVN0swdlF1RTQvWDIwdkNYeXd2U3pwZXpZQk05d3B0M0Z0bVYrSExXYldlcVRWdUhmaWxzL050ajZ1OTgzdktPckFjbkNBOHlvN0VDV09IQ1o3bm1kSDFMK09zVzdJeThUVlZ5MkNWS0JXZGVOZEE9PSIsIm9yZ05hbWUiOiJOb3ZlbGwifQ==&clientUserIdStr=100002");


            ClientWithResponseHandler car = objectMapper.readValue(url, ClientWithResponseHandler.class);
            System.out.println(car);
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(car);
            System.out.println(json);

            JsonFactory factory = new JsonFactory();
            JsonParser parser = factory.createParser(json);

            //Car car = new Car();
            while (!parser.isClosed()) {
                JsonToken jsonToken = parser.nextToken();

                if (JsonToken.FIELD_NAME.equals(jsonToken)) {
                    fieldName = parser.getCurrentName();
                    System.out.println("fieldName");
                    System.out.println(fieldName);
                    jsonToken = parser.nextToken();

                    if ("status".equals(fieldName)) {
                        ss2 = parser.getValueAsString();
                        System.out.println("ss2 = "+ss2);
                    }
                }
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("parser2 ends");
        return ss2;
    }
}

