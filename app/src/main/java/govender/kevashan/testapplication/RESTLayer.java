package govender.kevashan.testapplication;

import android.webkit.WebView;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by kevashan on 2017/02/13.
 */

public class RESTLayer{

    private final OkHttpClient client;
    private final MediaType mediaType;
    private String token;
    private WebView webView;

    public RESTLayer(WebView webView) {

        client = new OkHttpClient();
        mediaType = MediaType.parse("application.json");

        this.webView = webView;
        TokenHandler tokenHandler = new TokenHandler(webView);
        token = tokenHandler.getToken();
    }

    public void POSTAuthorize(){



        RequestBody requestBody = RequestBody.create(mediaType,"{\"payment\":{\"amount\":\"ciiw\",\"currency\":\"NOK\",\"subscription-token\":\"a94ce2ef057a5d2b7ec770c460986dca86fda826b2228ea72900fbb8dcf83694\",\"digital-id\":3717134483980288,\"tags\":[{\"name\":\"Calvin Rowe\",\"value\":\"fapzihu\"}]}}" );

        Request request = new Request.Builder()
                .url("https://gatewaynp.standardbank.co.za:5543/npextorg/extnonprod/payments/authorise")
                .post(requestBody)
                .addHeader("x-ibm-client-id", "317440fc-5172-4e71-bf80-8e3461dcab88")
                .addHeader("x-ibm-client-secret", "gR4dW6fU0yL7oY2nK8tQ3nD3sQ2rK5hA8aD0pU3hY1fW3iX7nY")
                .addHeader("authorization", "Bearer " + token)
                .addHeader("content-type", "application/json")
                .addHeader("accept", "application/json")
                .build();

        try {

            Response response = client.newCall(request).execute();
            System.out.println(response.toString());

        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public void POSTExecute(){

        RequestBody requestBody = RequestBody.create(mediaType, "{\"payment\":{\"amount\":\"genku\",\"currency\":\"LAK\",\"subscription-token\":\"822119686b590b51d8114528d198082bdc872b32a8dc154fc50e461d360f1f5a\",\"digital-id\":1707222711140352,\"tags\":[{\"name\":\"Craig Fernandez\",\"value\":\"viukaivu\"}]},\"otp\":\"coerac\",\"otp-reference\":\"popc\",\"transaction-time\":\"15:28\",\"security-code\":\"bumem\"}");
        Request request = new Request.Builder()
                .url("https://gatewaynp.standardbank.co.za:5543/npextorg/extnonprod/payments/execute")
                .post(requestBody)
                .addHeader("x-ibm-client-id", "317440fc-5172-4e71-bf80-8e3461dcab88")
                .addHeader("x-ibm-client-secret", "gR4dW6fU0yL7oY2nK8tQ3nD3sQ2rK5hA8aD0pU3hY1fW3iX7nY")
                .addHeader("authorization", "Bearer " + token)
                .addHeader("content-type", "application/json")
                .addHeader("accept", "application/json")
                .build();
        try {

            Response response = client.newCall(request).execute();

        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public void POSTRegister(){

        RequestBody requestBody = RequestBody.create(mediaType, "{\"user-id\":\"Esther\"}");
        Request request = new Request.Builder()
                .url("https://gatewaynp.standardbank.co.za:5543/npextorg/extnonprod/payments/register")
                .post(requestBody)
                .addHeader("x-ibm-client-id", "317440fc-5172-4e71-bf80-8e3461dcab88")
                .addHeader("x-ibm-client-secret", "gR4dW6fU0yL7oY2nK8tQ3nD3sQ2rK5hA8aD0pU3hY1fW3iX7nY")
                .addHeader("authorization", "Bearer " + token)
                .addHeader("content-type", "application/json")
                .addHeader("accept", "application/json")
                .build();

        try {

            Response response = client.newCall(request).execute();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }
}
