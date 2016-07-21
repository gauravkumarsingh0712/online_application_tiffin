package com.applicationframwork.android.models;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.applicationframwork.android.controllers.AppController;
import com.applicationframwork.android.defines.AppDefines;
import com.applicationframwork.android.dto.HomeDto;
import com.applicationframwork.android.network.GETJsonRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gauravkumar.singh on 7/19/2016.
 */
public class HomeModel extends BaseModel {

    private ArrayList<HomeDto> homeArrayList;


    public HomeModel()
    {
        homeArrayList = new ArrayList<>();
    }


    public void loadHomeData()
    {
        String url = AppDefines.HOME_URL;

        GETJsonRequest jsonRequest = new GETJsonRequest(url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            //state = STATE_SUCCESS;
                            System.out.println("executeFetchUserDetails Response" + response);
                            //Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();
                             Gson gson = new Gson();

                            java.lang.reflect.Type listType = new TypeToken<List<HomeDto>>() {
                            }.getType();


                            ArrayList<HomeDto> arrayList = gson.fromJson(response.getJSONArray("data").toString(), listType);


                            if (arrayList.size() == 0) {
                                //state = STATE_RESULT_NOT_FOUND;
                            }




                            homeArrayList.addAll(arrayList);

                            System.out.println("homeArrayList : "+homeArrayList.size());


                            informViews();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        error.printStackTrace();

                    }
                });


        Volley.newRequestQueue(AppController.getInstance().getApplicationContext()).add(jsonRequest);

    }

    public void resetData() {
        homeArrayList.clear();
    }

    public ArrayList<HomeDto> getCityArrayList() {
        return homeArrayList;
    }


}
