package com.mengxk.utils;

import com.sun.deploy.net.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.util.Map;

public class HttpUtil {

    /**
     *
     * @param url
     * @param requestMethod
     * @param request
     * @param mediaType
     * @return
     */
    public static String send(String url, RequestMethod requestMethod, Object request, MediaType mediaType) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(mediaType);
        HttpEntity<Object> requestEntity = new HttpEntity<Object>(request, headers);
        String result = "";
        if (requestMethod.equals(RequestMethod.POST)) {
            result = restTemplate.postForObject(url, requestEntity, String.class);
        } else if (requestMethod.equals(RequestMethod.DELETE)) {
            restTemplate.delete(url, requestEntity, String.class);
        } else if (requestMethod.equals(RequestMethod.GET)){
           ResponseEntity<String> result2 = restTemplate.getForEntity(url, String.class);
           System.out.println(result2);
        }
        return result;
    }

    public static String send(String s, Map<String, Object> params, MediaType applicationFormUrlencoded) {
        return "";
    }

    public static String doGet(String url) {
        try {
            DefaultHttpClient client = new DefaultHttpClient();
            //发送get请求
            HttpGet request = new HttpGet(url);
            CloseableHttpResponse response = client.execute(request);

            /**请求发送成功，并得到响应**/
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                /**读取服务器返回过来的json字符串数据**/
                String strResult = EntityUtils.toString(response.getEntity());
                return strResult;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
