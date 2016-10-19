package com.example.roopa.simplyguest;

import android.content.Context;
import android.content.Context;
import android.util.Log;

import com.example.roopa.simplyguest.WebInterface;
//import com.coachfinder.utils.ProgressLoader;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.Header;


/**
 * Created by Roopa on 18-10-2016.
 */
public class WebServiceController {

    Context context;
    //ProgressLoader progressLoader;
    WebInterface myInterface;
    boolean progressFlag = false;

    public WebServiceController(Context context, Object obj) {
        this.context = context;
        this.myInterface = (WebInterface) obj;
        //progressLoader = new ProgressLoader();

    }

    public void getRequest(String url, final int flag,final boolean progressFlag) {
        this.progressFlag =progressFlag;
        if(progressFlag){
            //progressLoader.showProgress(context);
        }
        AsyncHttpClient client = new AsyncHttpClient();
        client.setTimeout(60000);
        client.get(url, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
                // TODO Auto-generated method stub

                if(progressFlag){
                    //progressLoader.DismissProgress();
                }
                String response = "";
                try {
                    response = new String(arg2, "UTF-8");
                    System.out.println("response" + response);

                } catch (UnsupportedEncodingException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                myInterface.getResponse(response, flag);
            }

            @Override
            public void onFailure(int arg0, Header[] arg1, byte[] arg2,
                                  Throwable arg3) {
                // TODO Auto-generated method stub
                if(progressFlag){
                    //progressLoader.DismissProgress();
                }


            }

        });

    }

    public void postRequest(String url, RequestParams params, final int flag) {

        //progressLoader.showProgress(context);
        AsyncHttpClient client = new AsyncHttpClient();
        client.setTimeout(60000);
        Log.e("url",url+params.toString());
        client.post(url, params, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
                // TODO Auto-generated method stub
                //progressLoader.DismissProgress();
                String response = "";

                try {
                    response = new String(arg2, "UTF-8");
                    System.out.println("live_booking_response" + response);
                } catch (UnsupportedEncodingException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                myInterface.getResponse(response, flag);
            }

            @Override
            public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
                // TODO Auto-generated method stub
                //progressLoader.DismissProgress();
                Log.e("Error msg", "" + arg3.getMessage());

            }

        });

    }
}
