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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.awt.font.TextAttribute;
import java.text.AttributedString;
//import android.widget.Toast;



public class rLawCalc extends Fragment implements View.OnClickListener
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
    TextView Answer;
    EditText A1;
    EditText A2;
    EditText A3;
    EditText B1;
    EditText B2;
    EditText B3;
    EditText C1;
    EditText C2;
    EditText C3;
    Button GO;
    double concA1;
    double concA2;
    double concA3;
    double concB1;
    double concB2;
    double concB3;
    double concC1;
    double concC2;
    double concC3;
    String resp;
    double expA;
    double expB;
    double expC;
    boolean onClick = false;
    ArrayAdapter<CharSequence> choices;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //inflate rootview
        rootview = inflater.inflate(R.layout.fragment_r_law_calc, container, false);
        //load EditText
        A1 = (EditText) rootview.findViewById(R.id.A1);
        A1.setVisibility(View.GONE);
        A2 = (EditText) rootview.findViewById(R.id.A2);
        A2.setVisibility(View.GONE);
        A3 = (EditText) rootview.findViewById(R.id.A3);
        A3.setVisibility(View.GONE);
        B1 = (EditText) rootview.findViewById(R.id.B1);
        B1.setVisibility(View.GONE);
        B2 = (EditText) rootview.findViewById(R.id.B2);
        B2.setVisibility(View.GONE);
        B3 = (EditText) rootview.findViewById(R.id.B3);
        B3.setVisibility(View.GONE);
        C1 = (EditText) rootview.findViewById(R.id.C1);
        C1.setVisibility(View.GONE);
        C2 = (EditText) rootview.findViewById(R.id.C2);
        C2.setVisibility(View.GONE);
        C3 = (EditText) rootview.findViewById(R.id.C3);
        C3.setVisibility(View.GONE);
        //load Button
        GO = (Button) rootview.findViewById(R.id.GO);
        GO.setVisibility(View.GONE);
        //load spinner
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
                        B = (TextView) rootview.findViewById(R.id.concB);
                        B.setText(R.string.rxnrate);
                        B.setTextSize(15);
                        A1.setVisibility(View.VISIBLE);
                        A3.setVisibility(View.VISIBLE);
                        B1.setVisibility(View.VISIBLE);
                        B3.setVisibility(View.VISIBLE);
                        GO.setVisibility(View.VISIBLE);
                        if (onClick)
                        {
                            case1Ints();
                        }
                        Answer = (TextView) rootview.findViewById(R.id.Answer);
                        Answer.setText("Set Text");
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
                        A1.setVisibility(View.VISIBLE);
                        A2.setVisibility(View.VISIBLE);
                        B1.setVisibility(View.VISIBLE);
                        B2.setVisibility(View.VISIBLE);
                        if (onClick)
                        {
                            case2Ints();
                        }

                        onClick = false;
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
                        A1.setVisibility(View.VISIBLE);
                        A2.setVisibility(View.VISIBLE);
                        A3.setVisibility(View.VISIBLE);
                        B1.setVisibility(View.VISIBLE);
                        B2.setVisibility(View.VISIBLE);
                        B3.setVisibility(View.VISIBLE);
                        C1.setVisibility(View.VISIBLE);
                        C2.setVisibility(View.VISIBLE);
                        C3.setVisibility(View.VISIBLE);
                        if(onClick)
                        {
                            case3Ints();
                        }
                        onClick = false;
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
                        A1.setVisibility(View.VISIBLE);
                        A2.setVisibility(View.VISIBLE);
                        A3.setVisibility(View.VISIBLE);
                        B1.setVisibility(View.VISIBLE);
                        B2.setVisibility(View.VISIBLE);
                        B3.setVisibility(View.VISIBLE);
                        C1.setVisibility(View.VISIBLE);
                        C2.setVisibility(View.VISIBLE);
                        C3.setVisibility(View.VISIBLE);
                        break;
                }


            }
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
        return rootview;
    }
    public void case1Ints()
    {
        String A_1 = A1.getText().toString();
        String A_2 = B1.getText().toString();
        concA1 = Double.parseDouble(A_1);
        concA2 = Double.parseDouble(A_2);
        double rate1 = Double.parseDouble(A3.getText().toString());
        double rate2 = Double.parseDouble(B3.getText().toString());
        double temp = concA2/concA1;
        double rate_change = rate2/rate1;
        if(rate_change == temp)
        {
            resp = "Rate = k[A]";
        }
        else if(rate_change == temp*temp)
        {
            resp = "Rate = k[A]2";
            resp = resp.replaceAll("2", "²");
        }
        else if(rate_change == 1)
        {
            resp = "Rate = k";
        }
        //have to make everything within an acceptable range
    }
    public void case2Ints()
    {
        String A_1 = A1.getText().toString();
        String A_2 = A2.getText().toString();
        concA1 = Double.parseDouble(A_1);
        concA2 = Double.parseDouble(A_2);
        concA3 = Double.parseDouble(A3.getText().toString());
    }
    public void case3Ints()
    {
        String A_1 = A1.getText().toString();
        String A_2 = A2.getText().toString();
        String A_3 = A3.getText().toString();
        String B_1 = B1.getText().toString();
        String B_2 = B2.getText().toString();
        String B_3 = B3.getText().toString();
        String C_1 = C1.getText().toString();
        String C_2 = C2.getText().toString();
        String C_3 = C3.getText().toString();
        concA1 = Integer.parseInt(A_1);
        concA2 = Integer.parseInt(A_2);
        concA3 = Integer.parseInt(A_3);
        concB1 = Integer.parseInt(B_1);
        concB2 = Integer.parseInt(B_2);
        concB3 = Integer.parseInt(B_3);
        concC1 = Integer.parseInt(C_1);
        concC2 = Integer.parseInt(C_2);
        concC3 = Integer.parseInt(C_3);
    }
    public void onClick(View v)
    {
        onClick = true;
    }
}
