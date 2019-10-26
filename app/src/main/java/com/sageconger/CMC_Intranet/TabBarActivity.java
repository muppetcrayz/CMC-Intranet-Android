package com.sageconger.CMC_Intranet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.net.Uri;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

public class TabBarActivity extends AppCompatActivity implements WebViewFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_bar);

        AHBottomNavigation bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);
        bottomNavigation.addItem(new AHBottomNavigationItem("Announcements", R.drawable.announcements));
        bottomNavigation.addItem(new AHBottomNavigationItem("Documents", R.drawable.documents));
        bottomNavigation.addItem(new AHBottomNavigationItem("Company News", R.drawable.news));
        bottomNavigation.addItem(new AHBottomNavigationItem("Job Openings", R.drawable.jobs));
        bottomNavigation.addItem(new AHBottomNavigationItem("Calendar", R.drawable.calendar));

        bottomNavigation.setForceTint(false);
        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);

        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                switch(position) {
                    case 0:
                        FrameLayout fl = (FrameLayout) findViewById(R.id.container);
                        fl.removeAllViews();
                        // Begin the transaction
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        // Replace the contents of the container with the new fragment
                        WebViewFragment fragment = new WebViewFragment();
                        Bundle b = new Bundle();
                        b.putString("url", "http://intranet.cmcmmi.com/announcement/");
                        fragment.setArguments(b);
                        ft.replace(R.id.container, fragment);
                        // Complete the changes added above
                        ft.commit();
                        break;
                    case 1:
                        fl = (FrameLayout) findViewById(R.id.container);
                        fl.removeAllViews();
                        // Begin the transaction
                        ft = getSupportFragmentManager().beginTransaction();
                        // Replace the contents of the container with the new fragment
                        fragment = new WebViewFragment();
                        b = new Bundle();
                        b.putString("url", "http://intranet.cmcmmi.com/document/");
                        fragment.setArguments(b);
                        ft.replace(R.id.container, fragment);
                        // Complete the changes added above
                        ft.commit();
                        break;
                    case 2:
                        fl = (FrameLayout) findViewById(R.id.container);
                        fl.removeAllViews();
                        // Begin the transaction
                        ft = getSupportFragmentManager().beginTransaction();
                        // Replace the contents of the container with the new fragment
                        fragment = new WebViewFragment();
                        b = new Bundle();
                        b.putString("url", "http://intranet.cmcmmi.com/news/");
                        fragment.setArguments(b);
                        ft.replace(R.id.container, fragment);
                        // Complete the changes added above
                        ft.commit();
                        break;
                    case 3:
                        fl = (FrameLayout) findViewById(R.id.container);
                        fl.removeAllViews();
                        // Begin the transaction
                        ft = getSupportFragmentManager().beginTransaction();
                        // Replace the contents of the container with the new fragment
                        fragment = new WebViewFragment();
                        b = new Bundle();
                        b.putString("url", "http://intranet.cmcmmi.com/job-opening/");
                        fragment.setArguments(b);
                        ft.replace(R.id.container, fragment);
                        // Complete the changes added above
                        ft.commit();
                        break;
                    case 4:
                        fl = (FrameLayout) findViewById(R.id.container);
                        fl.removeAllViews();
                        // Begin the transaction
                        ft = getSupportFragmentManager().beginTransaction();
                        // Replace the contents of the container with the new fragment
                        fragment = new WebViewFragment();
                        b = new Bundle();
                        b.putString("url", "http://intranet.cmcmmi.com/events/");
                        fragment.setArguments(b);
                        ft.replace(R.id.container, fragment);
                        // Complete the changes added above
                        ft.commit();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        bottomNavigation.setCurrentItem(0);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
