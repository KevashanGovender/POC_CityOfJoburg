package govender.kevashan.testapplication.Service;

import android.app.Activity;
import android.content.Context;
import android.net.http.SslError;
import android.os.AsyncTask;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by kevashan on 2017/02/13.
 */

public class TokenHandler {

    private WebView webView;

    public static String token;

    public TokenHandler(WebView webView) {

        this.webView = webView;

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);

    }

    public void setWebViewClient() {

        webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }

            @Override
            public void onPageFinished(WebView view, String url) {

                if (webView.getUrl().contains("#access_token")) {

                    updateToken();

                    System.out.println("Kevashan " + token);


                    //RESTLayer restLayer = new RESTLayer(webView);
                    //restLayer.POSTAuthorize();

                    //System.out.println("POSTAuthorize ran");
                    //System.out.println("POSTAuthorize url: " + webView.getUrl());

                    //updateToken();

                    //restLayer.POSTExecute();
                    //System.out.println("POSTExecute ran");

                   // updateToken();

                    //restLayer.POSTRegister();
                    //System.out.println("POSTRegister ran");

                }
            }
        });
    }

    public void loadURL() {

        webView.loadUrl("https://testappmanager.standardbank.co.za/app.html");
    }

    public void updateToken(){

        String URL = webView.getUrl();
        token = URL.substring(URL.indexOf("access_token=") + 13, URL.indexOf("&expires_in="));

    }

}
