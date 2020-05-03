package id.my.ter.webservice.client;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;

public class NoteRestClient {

    private static final String BASE_URL = "http://192.168.141.103:5000/";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(Context context, String url, Header[] headers, RequestParams requestParams, AsyncHttpResponseHandler responseHandler){
        client.get(context,getAbsoluteUrl(url),headers,requestParams,responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl){
        return (BASE_URL + relativeUrl);
    }
}
