package me.finalproject.com.apchemchemolyapp;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

public class acid_fragment extends Fragment {




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.acid_layout, container, false);

        TextView tvWhatAcid = (TextView)view.findViewById(R.id.tvWhatAcid);
        TextView tvWeakVsStrong = (TextView)view.findViewById(R.id.tvWeakVsStrong);
        TextView tvKaKb = (TextView)view.findViewById(R.id.tvKaKb);
        TextView tvIndicators = (TextView)view.findViewById(R.id.tvIndicators);
        TextView tvTitrations = (TextView)view.findViewById(R.id.tvTitrations);
        TextView tvBuffers = (TextView)view.findViewById(R.id.tvBuffers);
        TextView tvPolyproticAcids = (TextView)view.findViewById(R.id.tvPolyproticAcids);
        final ScrollView svWhatAcid = (ScrollView)view.findViewById(R.id.svWhatAcid);
        final ScrollView svWeakVsStrong = (ScrollView)view.findViewById(R.id.svWeakVsStrong);
        final ScrollView svKaKb = (ScrollView)view.findViewById(R.id.svKaKb);
        final ScrollView svIndicators = (ScrollView)view.findViewById(R.id.svIndicators);
        final ScrollView svTitrations = (ScrollView)view.findViewById(R.id.svTitrations);
        final ScrollView svBuffers = (ScrollView)view.findViewById(R.id.svBuffers);
        final ScrollView svPolyproticAcids = (ScrollView)view.findViewById(R.id.svPolyproticAcids);

        tvWhatAcid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                svWhatAcid.setVisibility((svWhatAcid.getVisibility() == View.VISIBLE) ? View.GONE : View.VISIBLE);
            }
        });

        tvWeakVsStrong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                svWeakVsStrong.setVisibility((svWeakVsStrong.getVisibility() == View.VISIBLE) ? View.GONE : View.VISIBLE);
            }
        });

        tvKaKb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                svKaKb.setVisibility((svKaKb.getVisibility() == View.VISIBLE) ? View.GONE : View.VISIBLE);
            }
        });

        tvIndicators.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                svIndicators.setVisibility((svIndicators.getVisibility() == View.VISIBLE) ? View.GONE : View.VISIBLE);
            }
        });

        tvTitrations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                svTitrations.setVisibility((svTitrations.getVisibility() == View.VISIBLE) ? View.GONE : View.VISIBLE);
            }
        });

        tvBuffers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                svBuffers.setVisibility((svBuffers.getVisibility() == View.VISIBLE) ? View.GONE : View.VISIBLE);
            }
        });

        tvPolyproticAcids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                svPolyproticAcids.setVisibility((svPolyproticAcids.getVisibility() == View.VISIBLE) ? View.GONE : View.VISIBLE);
            }
        });

        return view;
    }

}
