package me.finalproject.com.apchemchemolyapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class redpotentials extends Fragment
{
    View rootview;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.redpotentials_layout, container, false);
        return rootview;
    }
}
