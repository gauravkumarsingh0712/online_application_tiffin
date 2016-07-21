package com.applicationframwork.android.models;

import android.app.ProgressDialog;

import com.applicationframwork.android.views.AbstractView;

import java.util.Vector;

/**
 * Created by gauravkumar.singh on 7/19/2016.
 * This class is parent of all class which should extend it while implementing
 * the abstract view class, This class helps to achieve the MVC Design
 * Patterns
 */

public class BaseModel {


    int state = -1;

    public ProgressDialog progressDialog;
    /**
     * The reference to an Array/Vector of Abstract View class
     */
    public Vector<AbstractView> views;

    /**
     * Constructor
     */
    public BaseModel() {
        views = new Vector<AbstractView>();
    }

    /**
     * Informing to different views registered to this model
     */
    public void informViews() {

        for (int i = 0; i < views.size(); i++) {

            AbstractView abstractView = views.elementAt(i);
            abstractView.update();

        }
    }

    /**
     * To register a view reference later the model can inform view about any changes in model
     * @param abstractView
     */
    public void registerView(AbstractView abstractView) {
        views.add(abstractView);
    }

    /**
     * To unregister a view so that model can stop informing about any changes to this view
     * @param abstractView
     */
    public void unRegisterView(AbstractView abstractView) {
        views.removeElement(abstractView);
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public ProgressDialog getProgressDialog() {
        return progressDialog;
    }

    public void setProgressDialog(ProgressDialog progressDialog) {
        this.progressDialog = progressDialog;
    }

}
