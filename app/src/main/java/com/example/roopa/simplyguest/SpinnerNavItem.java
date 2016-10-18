package com.example.roopa.simplyguest;

/**
 * Created by Roopa on 17-10-2016.
 */
public class SpinnerNavItem {

    private String title;
    private int icon;

    public SpinnerNavItem(String title, int icon){

        this.title = title;
        this.icon = icon;
    }

    public String getTitle(){

        return this.title;
    }

    public int getIcon(){

        return this.icon;
    }

}

