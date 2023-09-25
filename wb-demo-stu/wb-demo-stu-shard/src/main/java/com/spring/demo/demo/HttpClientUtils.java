package com.spring.demo.demo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientUtils {
    public static void main(String[] args) throws IOException {
        getUtils("https://timor.tech/api/holiday/year/2023");
    }
    public static Object getUtils(String url) throws IOException {
        HttpClient httpClient = new DefaultHttpClient();
        httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 1000);
        httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 1000);
        HttpGet httpGet = null;
        try {
            httpGet = new HttpGet(url);
            HttpResponse response = httpClient.execute(httpGet);
            int httpStatus = response.getStatusLine().getStatusCode();
            if(httpStatus == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();

                String contentType = ContentType.getOrDefault(entity).getMimeType();
                if(contentType.contains("application/json")) {
                    String getJson = EntityUtils.toString(entity);
                    System.out.println(getJson);
                }
                EntityUtils.consume(entity);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            httpGet.abort();
            httpClient.getConnectionManager().shutdown();
        }
        return null;
    }
}
