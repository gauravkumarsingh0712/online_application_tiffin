package com.applicationframwork.android.network;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.applicationframwork.android.controllers.AppController;
import com.applicationframwork.android.models.LocalModel;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by ashishkumarpatel on 27/04/16.
 */
public class POSTJsonRequest extends JsonObjectRequest {
    LocalModel localModel = null;

    public POSTJsonRequest(String url, String jsonData, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {

        super(Request.Method.POST, url, jsonData, listener, errorListener);
        System.out.println(">>>> URL :"+url);
        System.out.println(">>>> DATA : "+jsonData);

        localModel = AppController.getInstance().getModelFacade().getLocalModel();
    }


    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {

        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json; charset=utf-8");
        headers.put("Accept", "application/json; charset=utf-8");

//        if (localModel.getToken() != null) {
//
//            headers.put("Authorization", "Bearer " + localModel.getToken());
//        }

        return headers;
    }

}
