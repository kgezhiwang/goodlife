package com.goodlife.simple.util;


import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.*;

import javax.net.ssl.SSLContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

/**
 * TSP透传请求
 */
@Slf4j
public class HuManager {

    /**
     * HU功能，用于发送URL请求，返回String类型结果
     *
     * @param url
     * @return
     */
    public static String send(String url) {
        CloseableHttpClient httpClient = createSSLInsecureClient();
        url = url.replace(" ", "%20");
        HttpGet httpget = new HttpGet(url);
        HttpResponse response = null;
        try {
            response = httpClient.execute(httpget);

            response.setHeader("Content-type", "charset=ISO-8859");
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpEntity entitys = response.getEntity();
        InputStream is = null;
        try {
            is = entitys.getContent();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        log.debug("请求地址：" + httpget.getURI());
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        StringBuffer sb = new StringBuffer();
        String line = null;
        try {
            while ((line = in.readLine()) != null)
                sb = sb.append(line);
            httpget.releaseConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }


    public static String post(String body, String url) {
        CloseableHttpClient httpClient = createSSLInsecureClient();
        HttpPost post = new HttpPost(url);

        post.setHeader("Content-type", "charset=utf-8");
        post.setHeader("Connection", "Close");

        // 构建消息实体
        StringEntity entity = new StringEntity(body, Charset.forName("UTF-8"));
        entity.setContentEncoding("UTF-8");
        // 发送Json格式的数据请求
//        entity.setContentType("application/json");
        post.setEntity(entity);


        HttpResponse response = null;
        try {
            response = httpClient.execute(post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpEntity entitys = response.getEntity();
        InputStream is = null;
        try {
            is = entitys.getContent();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        log.debug("请求地址：" + httpget.getURI());
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        StringBuffer sb = new StringBuffer();
        String line = null;
        try {
            while ((line = in.readLine()) != null)
                sb = sb.append(line);
            post.releaseConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    protected static CloseableHttpClient createSSLInsecureClient() {
        CookieStore cookieStore = new BasicCookieStore();

        // 配置超时时间（连接服务端超时1秒，请求数据返回超时2秒）
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(HttpConstants.HTTP_TIMEOUT).setSocketTimeout(HttpConstants.HTTP_TIMEOUT)
                .setConnectionRequestTimeout(HttpConstants.HTTP_TIMEOUT).build();

        try {
            SSLContext sslContext = new SSLContextBuilder()
                    .loadTrustMaterial(null, new TrustStrategy() {
                        //信任所有
                        public boolean isTrusted(X509Certificate[] chain,
                                                 String authType) {
                            return true;
                        }
                    }).build();
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
            return HttpClients.custom()
                    .setSSLSocketFactory(sslsf)
                    .setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy())
                    .setRedirectStrategy(new DefaultRedirectStrategy())
                    .setDefaultRequestConfig(requestConfig)
                    .setDefaultCookieStore(cookieStore)
                    .build();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        return HttpClients.createDefault();
    }

}
