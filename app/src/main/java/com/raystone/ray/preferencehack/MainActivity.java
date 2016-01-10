package com.raystone.ray.preferencehack;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preference_fragment_container);
        FragmentManager fragmentManager = getFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.preference_container);
        if(fragment == null)
        {fragment = MyPreferenceFragment.newInstance();}
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.preference_container,fragment, "PREFERENCEFRAGMENT");
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
