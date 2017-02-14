package govender.kevashan.testapplication.Service;


import android.webkit.WebView;

import org.apache.http.client.HttpClient;

import java.io.IOException;
import java.security.cert.CertificateException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by kevashan on 2017/02/13.
 */

public class RESTLayer{

    private OkHttpClient httpClient = new OkHttpClient();


    Headers headers = new Headers.Builder()
                                .add("x-ibm-client-id", "317440fc-5172-4e71-bf80-8e3461dcab88")
                                .add("x-ibm-client-secret", "gR4dW6fU0yL7oY2nK8tQ3nD3sQ2rK5hA8aD0pU3hY1fW3iX7nY")
                                .add("authorization", "Bearer AAEkMzE3NDQwZmMtNTE3Mi00ZTcxLWJmODAtOGUzNDYxZGNhYjg4_1iRmDoGsLGuUTv-ExVZzt-vlphAw2LbsRO8lZBlm0TGSUHTHEdhMjNu_ifLFax1wRnXhA03_acc5aD6h_1iRQ")
                                .add("content-type", "application/json")
                                .add("accept", "application/json")
                                .build();


    public void POSTAuthorize(){

        String body = "{\"payment\":{\"amount\": \"\", \"currency\": \"\",\"subscription-token\": \"\",\"digital-id\": \"\",\"tags\": [{\"name\": \"\",\"value\": \"\"}]}}";

        MediaType mediaType = MediaType.parse("application/json");

        RequestBody requestBody = RequestBody.create(mediaType, body);

        Request request = new Request.Builder()
                            .url("https://gatewaynp.standardbank.co.za:5543/npextorg/extnonprod/payments/authorise")
                            .post(requestBody)
                            .headers(headers)
                            .build();

        try
        {
            Response response = httpClient.newCall(request).execute();
            System.out.println(response.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String args []){

        RESTLayer restLayer = new RESTLayer();

        restLayer.POSTAuthorize();
    }
}
