package me.finalproject.com.apchemchemolyapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class oxstaterules extends Fragment
{
    View rootview;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        rootview =  inflater.inflate(R.layout.oxstaterules_layout, container, false);
        return rootview;
    }

    // TODO: Rename method, update argument and hook method into UI event

}
