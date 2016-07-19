package me.finalproject.com.apchemchemolyapp;

import android.content.Context;
import android.content.EntityIterator;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.view.View.OnClickListener;


public class pHCalc_fragment extends Fragment
{
    View rootview;
    Spinner spin;
    EditText et1;
    EditText et2;
    EditText et3;
    EditText et4;
    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView Answer;
    Button go;
    String spinner;
    String resp;
    ArrayAdapter<CharSequence> choices;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        rootview = inflater.inflate(R.layout.phcalc_layout, container, false);
        et1 = (EditText) rootview.findViewById(R.id.editText1);
        et1.setVisibility(View.GONE);
        et2 = (EditText) rootview.findViewById(R.id.editText2);
        et2.setVisibility(View.GONE);
        et3 = (EditText) rootview.findViewById(R.id.editText3);
        et3.setVisibility(View.GONE);
        et4 = (EditText) rootview.findViewById(R.id.editText4);
        et4.setVisibility(View.GONE);
        tv1 = (TextView)rootview.findViewById(R.id.textView1);
        tv1.setVisibility(View.GONE);
        tv2 = (TextView) rootview.findViewById(R.id.textView2);
        tv2.setVisibility(View.GONE);
        tv3 = (TextView) rootview.findViewById(R.id.textView3);
        tv3.setVisibility(View.GONE);
        tv4 = (TextView) rootview.findViewById(R.id.textView4);
        tv4.setVisibility(View.GONE);
        Answer = (TextView) rootview.findViewById(R.id.FinalAnswer);
        Answer.setVisibility(View.GONE);
        go = (Button) rootview.findViewById(R.id.GO);
        go.setVisibility(View.GONE);
        //loading spinner
        spin = (Spinner) rootview.findViewById(R.id.spinner);
        choices = ArrayAdapter.createFromResource( getActivity(), R.array.pHOptions, android.R.layout.simple_spinner_item);
        choices.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(choices);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                spinner = "" + parent.getItemAtPosition(position);
                switch (spinner)
                {
                    case "Strong Acid - Strong Base Titration":
                        et1.setVisibility(View.VISIBLE);
                        et2.setVisibility(View.VISIBLE);
                        et3.setVisibility(View.VISIBLE);
                        et4.setVisibility(View.VISIBLE);
                        tv1.setVisibility(View.VISIBLE);
                        tv1.setText(R.string.StrongA);
                        tv2.setVisibility(View.VISIBLE);
                        tv2.setText(R.string.VolStrongA);
                        tv3.setVisibility(View.VISIBLE);
                        tv3.setText(R.string.StrongB);
                        tv4.setVisibility(View.VISIBLE);
                        tv4.setText(R.string.VolStrongB);
                        go.setVisibility(View.VISIBLE);
                        break;
                    case "Strong Acid - Weak Base Titration":

                        break;
                    case "Weak Acid - Strong Base Titration":

                        break;
                    case "Conjugate Salt":

                        break;
                    case "One Acid":

                        break;
                }
            }
            public void onNothingSelected(AdapterView<?> parent)
            {
                Toast.makeText(getActivity(), "Please select an Option", Toast.LENGTH_LONG).show();
            }
        });
        go.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {
                switch(spinner)
                {
                    case "Strong Acid - Strong Base Titration":
                        Answer.setVisibility(View.VISIBLE);
                        strongAstrongB();
                        Answer.setText(resp);
                        break;
                    case "Strong Acid - Weak Base Titration":

                        break;
                    case "Weak Acid - Strong Base Titration":

                        break;
                    case "Conjugate Salt":

                        break;
                    case "One Acid":

                        break;
                }
            }
        });
        return rootview;
    }
    public void strongAstrongB()
    {
        double concSA = Double.parseDouble(et1.getText().toString());
        double volSA = Double.parseDouble(et2.getText().toString());
        double concSB = Double.parseDouble(et3.getText().toString());
        double volSB = Double.parseDouble(et4.getText().toString());
        double molH  = concSA * volSA;
        double molOH = concSB * volSB;
        double finalpH = 0;
        if (molH > molOH)
        {
            finalpH = -1 * Math.log10(molH - molOH);
            resp = "The pH is " + finalpH;
        }
        else
        {
            finalpH = 14 - (-1 * Math.log10(molOH - molH));
            resp = "The pH is " + finalpH;
        }
    }
    public void strongAweakB()
    {

    }
    public void weakAstrongB()
    {

    }
    public void oneAcid()
    {

    }
}
