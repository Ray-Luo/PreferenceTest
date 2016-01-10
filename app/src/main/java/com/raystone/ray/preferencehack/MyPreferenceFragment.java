package com.raystone.ray.preferencehack;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;

/**
 * Created by Ray on 1/9/2016.
 */
public class MyPreferenceFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener{


    public static MyPreferenceFragment newInstance()
    {
        return new MyPreferenceFragment();
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        getPreferenceScreen().getSharedPreferences()
                .unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        Preference sharePreference = findPreference("pref_share");
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Check this app!");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Check this app at https://play.google.com/store/apps/details?id=com.raystone.ray.goplaces");
        sharePreference.setIntent(shareIntent);

        Preference ratePreference = findPreference("pref_rate");
        Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.raystone.ray" +
                ".goplaces");
        Intent goToMarket = new Intent(Intent.ACTION_VIEW,uri);
        ratePreference.setIntent(goToMarket);

        getPreferenceScreen().getSharedPreferences()
                .registerOnSharedPreferenceChangeListener(this);
    }





    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key)
    {
        if(key.equals("preference_user"))
            updateUserText();
    }

    private void updateUserText()
    {
        EditTextPreference preference;
        preference = (EditTextPreference)findPreference("preference_user");
        String user = preference.getText();

        if(user == null)
            user = "?";

        preference.setSummary(String.format("User Name: %s", user));
    }


}
