package com.applicationframwork.android.models;

/**
 * Created by gauravkumar.singh on 7/19/2016.
 */
public class RemoteModel implements IModel {


    HomeModel homeModel;

    @Override
    public void initialize() {

        homeModel = new HomeModel();

    }

    @Override
    public void destroy() {

    }

    public HomeModel getHomeModel() {
        return homeModel;
    }

    public void setHomeModel(HomeModel homeModel) {
        this.homeModel = homeModel;
    }

}
