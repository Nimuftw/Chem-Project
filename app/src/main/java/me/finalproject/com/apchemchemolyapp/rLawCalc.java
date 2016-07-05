package me.finalproject.com.apchemchemolyapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;
//import android.widget.Toast;



public class rLawCalc extends Fragment
{
    View rootview;
    Spinner spin;
    TextView trial;
    TextView r1;
    TextView r2;
    TextView r3;
    TextView A;
    TextView B;
    TextView C;
    TextView D;
    ArrayAdapter<CharSequence> choices;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        rootview = inflater.inflate(R.layout.fragment_r_law_calc, container, false);

        spin = (Spinner) rootview.findViewById(R.id.numReactants);
        choices = ArrayAdapter.createFromResource( getActivity(), R.array.numOfReactants, android.R.layout.simple_spinner_item);
        choices.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(choices);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                //Made to Test Spinner
//                Toast.makeText(getActivity(), parent.getItemAtPosition(position) + " is selected", Toast.LENGTH_LONG).show();
                String test = "" + parent.getItemAtPosition(position);
                switch (test)
                {
                    case "1":
                        trial = (TextView) rootview.findViewById(R.id.Trial);
                        trial.setText(R.string.t1);
                        r1 = (TextView) rootview.findViewById(R.id.tv1);
                        r1.setText("1");
                        r2 = (TextView) rootview.findViewById(R.id.tv2);
                        r2.setText("2");
                        A = (TextView) rootview.findViewById(R.id.concA);
                        A.setText("[A]");

                        break;

                    case "2":
                        trial = (TextView) rootview.findViewById(R.id.Trial);
                        trial.setText(R.string.t1);
                        r1 = (TextView) rootview.findViewById(R.id.tv1);
                        r1.setText("1");
                        r2 = (TextView) rootview.findViewById(R.id.tv2);
                        r2.setText("2");
                        A = (TextView) rootview.findViewById(R.id.concA);
                        A.setText("[A]");
                        B = (TextView) rootview.findViewById(R.id.concB);
                        B.setText("[B]");
                        break;

                    case"3":
                        trial = (TextView) rootview.findViewById(R.id.Trial);
                        trial.setText(R.string.t1);
                        r1 = (TextView) rootview.findViewById(R.id.tv1);
                        r1.setText("1");
                        r2 = (TextView) rootview.findViewById(R.id.tv2);
                        r2.setText("2");
                        r3 = (TextView) rootview.findViewById(R.id.tv3);
                        r3.setText("3");
                        A = (TextView) rootview.findViewById(R.id.concA);
                        A.setText("[A]");
                        B = (TextView) rootview.findViewById(R.id.concB);
                        B.setText("[B]");
                        C = (TextView) rootview.findViewById(R.id.concC);
                        C.setText("[C]");
                        break;

                    case"4":
                        trial = (TextView) rootview.findViewById(R.id.Trial);
                        trial.setText(R.string.t1);
                        r1 = (TextView) rootview.findViewById(R.id.tv1);
                        r1.setText("1");
                        r2 = (TextView) rootview.findViewById(R.id.tv2);
                        r2.setText("2");
                        r3 = (TextView) rootview.findViewById(R.id.tv3);
                        r3.setText("3");
                        A = (TextView) rootview.findViewById(R.id.concA);
                        A.setText("[A]");
                        B = (TextView) rootview.findViewById(R.id.concB);
                        B.setText("[B]");
                        C = (TextView) rootview.findViewById(R.id.concC);
                        C.setText("[C]");
                        break;
                }


            }
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
        return rootview;
    }
}
