package com.example.roopa.simplyguest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Spinner;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import com.example.roopa.simplyguest.SpinnerNavItem;
import com.example.roopa.simplyguest.MenuNavigationAdapter;

public class HomePage extends Activity implements ActionBar.OnNavigationListener{

    // Action Bar
    private ActionBar actionBar;

    //Menu navigation Spinner data

    private ArrayList<SpinnerNavItem> navSpinner;
    private MenuNavigationAdapter menuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        ImageAdapter adapter = new ImageAdapter(this);
        viewPager.setAdapter(adapter);

        actionBar = getActionBar();
        // Hide the action bar title
        actionBar.setDisplayShowTitleEnabled(false);

        // Enabling Spinner dropdown navigation
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        // Spinner title navigation data
        navSpinner = new ArrayList<SpinnerNavItem>();
        navSpinner.add(new SpinnerNavItem("SimplyGuest Intro", R.drawable.ic_slideshow_black_24dp));
        navSpinner.add(new SpinnerNavItem("Features of our Flats", R.drawable.ic_home_black_24dp));
        navSpinner.add(new SpinnerNavItem("House Rules", R.drawable.ic_view_list_black_24dp));
        navSpinner.add(new SpinnerNavItem("Short Listed", R.drawable.ic_favorite_border_black_24dp));

        // title drop down adapter
        menuAdapter = new MenuNavigationAdapter(getApplicationContext(), navSpinner);

        // assigning the spinner navigation
        actionBar.setListNavigationCallbacks(menuAdapter, (ActionBar.OnNavigationListener) this);
    }

    public boolean onNavigationItemSelected(int itemPosition, long itemId) {
        // Action to be taken after selecting a spinner item
        return false;
    }

    public void onClickLogin(View v) {

        Intent intent = new Intent(this, LoginPage.class);
        startActivity(intent);

    }

}
