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
import android.view.View.OnClickListener;

import org.w3c.dom.Text;


public class rLawCalc extends Fragment
{
    View rootview;
    Spinner spin;
    TextView trial;
    TextView r1;
    TextView r2;
    TextView r3;
    TextView r4;
    TextView A;
    TextView B;
    TextView C;
    TextView D;
    TextView Answer;
    EditText A1;
    EditText A2;
    EditText A3;
    EditText A4;
    EditText B1;
    EditText B2;
    EditText B3;
    EditText B4;
    EditText C1;
    EditText C2;
    EditText C3;
    EditText C4;
    EditText D1;
    EditText D2;
    EditText D3;
    EditText D4;
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
    double rateA;
    double rateB;
    double rateC;
    double concA;
    double concB;
    double concC;
    double expA;
    double expB;
    double expC;
    boolean onClick = false;
    String resp;
    String spinner;
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
        A4 = (EditText) rootview.findViewById(R.id.A4);
        A4.setVisibility(View.GONE);
        B1 = (EditText) rootview.findViewById(R.id.B1);
        B1.setVisibility(View.GONE);
        B2 = (EditText) rootview.findViewById(R.id.B2);
        B2.setVisibility(View.GONE);
        B3 = (EditText) rootview.findViewById(R.id.B3);
        B3.setVisibility(View.GONE);
        B4 = (EditText) rootview.findViewById(R.id.B4);
        B4.setVisibility(View.GONE);
        C1 = (EditText) rootview.findViewById(R.id.C1);
        C1.setVisibility(View.GONE);
        C2 = (EditText) rootview.findViewById(R.id.C2);
        C2.setVisibility(View.GONE);
        C3 = (EditText) rootview.findViewById(R.id.C3);
        C3.setVisibility(View.GONE);
        C4 = (EditText) rootview.findViewById(R.id.C4);
        C4.setVisibility(View.GONE);
        D1 = (EditText) rootview.findViewById(R.id.D1);
        D1.setVisibility(View.GONE);
        D2 = (EditText) rootview.findViewById(R.id.D2);
        D2.setVisibility(View.GONE);
        D3 = (EditText) rootview.findViewById(R.id.D3);
        D3.setVisibility(View.GONE);
        D4 = (EditText) rootview.findViewById(R.id.D4);
        D4.setVisibility(View.GONE);
        //load Button
        GO = (Button) rootview.findViewById(R.id.GO);
        GO.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {
                switch(spinner)
                {
                    case "1":
                        case1Ints();
                        Answer = (TextView) rootview.findViewById(R.id.Answer);
                        Answer.setText(resp);
                        break;
                    case "2":
                        case2Ints();
                        Answer = (TextView) rootview.findViewById(R.id.Answer);
                        Answer.setText(resp);
                        break;
                    case "3":
                        case3Ints();
                        Answer = (TextView) rootview.findViewById(R.id.Answer);
                        Answer.setText(resp);
                }
            }
        });
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
                String spinner = "" + parent.getItemAtPosition(position);
                switch (spinner)
                {
                    case "1":
                        trial = (TextView) rootview.findViewById(R.id.Trial);
                        trial.setText(R.string.t1);
                        r1 = (TextView) rootview.findViewById(R.id.tv1);
                        r1.setText("1");
                        r2 = (TextView) rootview.findViewById(R.id.tv2);
                        r2.setText("2");
                        A = (TextView) rootview.findViewById(R.id.concA);
                        A.setText("   [A]");
                        B = (TextView) rootview.findViewById(R.id.concB);
                        B.setText(R.string.rxnrate);
                        B.setTextSize(15);
                        A1.setVisibility(View.VISIBLE);
                        A2.setVisibility(View.VISIBLE);
                        B1.setVisibility(View.VISIBLE);
                        B2.setVisibility(View.VISIBLE);
                        GO.setVisibility(View.VISIBLE);
                        if (onClick)
                        {
                            case1Ints();
                            Answer = (TextView) rootview.findViewById(R.id.Answer);
                            Answer.setText(R.string.test);
                        }
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
                        C = (TextView) rootview.findViewById(R.id.concC);
                        C.setText(R.string.rxnrate);
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

                    case"3":
                        trial = (TextView) rootview.findViewById(R.id.Trial);
                        trial.setText(R.string.t1);
                        r1 = (TextView) rootview.findViewById(R.id.tv1);
                        r1.setText("1");
                        r2 = (TextView) rootview.findViewById(R.id.tv2);
                        r2.setText("2");
                        r3 = (TextView) rootview.findViewById(R.id.tv3);
                        r3.setText("3");
                        r4 = (TextView) rootview.findViewById(R.id.tv4);
                        r4.setText("4");
                        A = (TextView) rootview.findViewById(R.id.concA);
                        A.setText("[A]");
                        B = (TextView) rootview.findViewById(R.id.concB);
                        B.setText("[B]");
                        C = (TextView) rootview.findViewById(R.id.concC);
                        C.setText("[C]");
                        D = (TextView) rootview.findViewById(R.id.concD);
                        D.setText(R.string.rxnrate);
                        A1.setVisibility(View.VISIBLE);
                        A2.setVisibility(View.VISIBLE);
                        A3.setVisibility(View.VISIBLE);
                        A4.setVisibility(View.VISIBLE);
                        B1.setVisibility(View.VISIBLE);
                        B2.setVisibility(View.VISIBLE);
                        B3.setVisibility(View.VISIBLE);
                        B4.setVisibility(View.VISIBLE);
                        C1.setVisibility(View.VISIBLE);
                        C2.setVisibility(View.VISIBLE);
                        C3.setVisibility(View.VISIBLE);
                        C4.setVisibility(View.VISIBLE);
                        D1.setVisibility(View.VISIBLE);
                        D2.setVisibility(View.VISIBLE);
                        D3.setVisibility(View.VISIBLE);
                        D4.setVisibility(View.VISIBLE);
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
                        r4 = (TextView) rootview.findViewById(R.id.tv4);
                        r4.setText("4");
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
//                while(!onClick)
//                {
//                    if (test.equals("1"))
//                    {
//                        trial = (TextView) rootview.findViewById(R.id.Trial);
//                        trial.setText(R.string.t1);
//                        r1 = (TextView) rootview.findViewById(R.id.tv1);
//                        r1.setText("1");
//                        r2 = (TextView) rootview.findViewById(R.id.tv2);
//                        r2.setText("2");
//                        A = (TextView) rootview.findViewById(R.id.concA);
//                        A.setText("   [A]");
//                        B = (TextView) rootview.findViewById(R.id.concB);
//                        B.setText(R.string.rxnrate);
//                        B.setTextSize(15);
//                        A1.setVisibility(View.VISIBLE);
//                        A2.setVisibility(View.VISIBLE);
//                        B1.setVisibility(View.VISIBLE);
//                        B2.setVisibility(View.VISIBLE);
//                        GO.setVisibility(View.VISIBLE);
//                    }
//                    else if (test.equals("2"))
//                    {
//                        trial = (TextView) rootview.findViewById(R.id.Trial);
//                        trial.setText(R.string.t1);
//                        r1 = (TextView) rootview.findViewById(R.id.tv1);
//                        r1.setText("1");
//                        r2 = (TextView) rootview.findViewById(R.id.tv2);
//                        r2.setText("2");
//                        A = (TextView) rootview.findViewById(R.id.concA);
//                        A.setText("[A]");
//                        B = (TextView) rootview.findViewById(R.id.concB);
//                        B.setText("[B]");
//                        A1.setVisibility(View.VISIBLE);
//                        A2.setVisibility(View.VISIBLE);
//                        B1.setVisibility(View.VISIBLE);
//                        B2.setVisibility(View.VISIBLE);
//                    }
//                    else if (test.equals("3"))
//                    {
//                        trial = (TextView) rootview.findViewById(R.id.Trial);
//                        trial.setText(R.string.t1);
//                        r1 = (TextView) rootview.findViewById(R.id.tv1);
//                        r1.setText("1");
//                        r2 = (TextView) rootview.findViewById(R.id.tv2);
//                        r2.setText("2");
//                        r3 = (TextView) rootview.findViewById(R.id.tv3);
//                        r3.setText("3");
//                        A = (TextView) rootview.findViewById(R.id.concA);
//                        A.setText("[A]");
//                        B = (TextView) rootview.findViewById(R.id.concB);
//                        B.setText("[B]");
//                        C = (TextView) rootview.findViewById(R.id.concC);
//                        C.setText("[C]");
//                        A1.setVisibility(View.VISIBLE);
//                        A2.setVisibility(View.VISIBLE);
//                        A3.setVisibility(View.VISIBLE);
//                        B1.setVisibility(View.VISIBLE);
//                        B2.setVisibility(View.VISIBLE);
//                        B3.setVisibility(View.VISIBLE);
//                        C1.setVisibility(View.VISIBLE);
//                        C2.setVisibility(View.VISIBLE);
//                        C3.setVisibility(View.VISIBLE);
//                    }
//                }
//                if (test.equals("1"))
//                {
//                    case1Ints();
//                    Answer = (TextView) rootview.findViewById(R.id.Answer);
//                    Answer.setText(resp);
//                }
//                else if (test.equals("2"))
//                {
//                    case2Ints();
//                    Answer = (TextView) rootview.findViewById(R.id.Answer);
//                    Answer.setText(resp);
//                }
//                else if (test.equals("3"))
//                {
//                    case3Ints();
//                    Answer = (TextView) rootview.findViewById(R.id.Answer);
//                    Answer.setText(resp);
//                }
            }
            public void onNothingSelected(AdapterView<?> parent)
            {
                Toast.makeText(getActivity(), "Please select an Option", Toast.LENGTH_LONG).show();
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
        concB1 = Double.parseDouble(B1.getText().toString());
        concB2 = Double.parseDouble(B2.getText().toString());
        concC1 = Double.parseDouble(C1.getText().toString());
        concC2 = Double.parseDouble(C2.getText().toString());
        double rate1 = Double.parseDouble(A3.getText().toString());
        double rate2 = Double.parseDouble(B3.getText().toString());
        double rate3 = Double.parseDouble(C3.getText().toString());
        //get first exp
            if (concA1 != concB1)
            {
                if (concA2 == concB2)
                {
                    concA = concB1 / concA1;
                    rateA = rate2 / rate1;
                }
            }
            else if (concA1 != concC1)
            {
                if (concA2 == concC2)
                {
                    concA = concC1 / concA1;
                    rateA = rate3 / rate1;
                }
            }
            else if (concB1 != concC1)
            {
                if (concB2 == concC2)
                {
                    concA = concC1 / concB1;
                    rateA = rate3 / rate2;
                }
            }
            if (rateA == concA)
            {
                expA = 1;
            }
            else if (rateA == (concA * concA))
            {
                expA = 2;
            }
            else if (rateA == 1)
            {
                expA = 0;
            }
            if (concA2 != concB2)
            {
                if (concA1 == concB1)
                {
                    rateB = rate2 / rate1;
                    concB = concB2/concA2;
                }
            }
            else if (concB2 != concC2)
            {
                if (concB1 == concC1)
                {
                    rateB = rate3/rate2;
                    concB = concC2/concB2;
                }
            }
            else if (concC2 != concA2)
            {
                if (concC1 == concB1)
                {
                    rateB = rate3/rate1;
                    concB = concC2/concA2;
                }
            }
        //Need to find acceptable range
            if(concB == rateB)
            {
                expB = 1;
            }
            else if(rateB == (concB*concB))
            {
                expB = 2;
            }
            else if (rateB == 1)
            {
                expB = 0;
            }
        //find second exponent
        if (concA1 != concB1)
        {
            if (concA2 != concB2)
            {
                if (expA == 0 || expA == 1 || expA == 2)
                {
                    concB = concB2/concA2;
                    rateB = (rate2/rate1) / ((concB1/concA1)*expA);
                }
                else if (expB == 0 || expB == 1 || expB == 2)
                {
                    concA = concB1/concA1;
                    rateA = rate2/rate1;
                    double temp = (concB2/concA2)*expB;
                    rateA = rateA/temp;
                }
            }
        }
        else if (concA1 != concC1)
        {
            if (concA2 != concC2)
            {
                if (expA == 0 || expA == 1 || expA == 2)
                {
                    concB = concC2/concA2;
                    rateB = (rate2/rate1) / ((concC1/concA1)*expA);
                }
                else if (expB == 0 || expB == 1 || expB == 2)
                {
                    concA = concC1/concA1;
                    rateA = (rate2/rate1)/((concC2/concA2)*expB);
                }
            }
        }
        else if (concB1 != concC1)
        {
            if (concB2 != concC2) {
                if (expA == 0 || expA == 1 || expA == 2) {
                    concB = concC2 / concB2;
                    rateB = (rate2 / rate1) / ((concC1 / concB1) * expA);
                } else if (expB == 0 || expB == 1 || expB == 2) {
                    concA = concC1 / concB1;
                    rateA = (rate2 / rate1) / ((concC2 / concB2) * expB);
                }
            }
        }
        // Print Solution
        if((expA == 0 || expA == 1 || expA == 2) && (expB == 0 || expB == 1 || expB == 2))
        {
            resp = "rate = k[A]" + expA + "[B]" + expB;
            resp = resp.replaceAll("2", "²");
            resp = resp.replaceAll("1", "");
            if (expA == 0)
            {
                resp = "rate = k[B]" + expB;
                resp = resp.replaceAll("2", "²");
                if (expB == 0)
                {
                    resp = "rate = k";
                }
            }
            if(expB == 0)
            {
                resp = "rate = k[A]" + expB;
                resp = resp.replaceAll("2", "²");
            }

        }
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
        concA1 = Double.parseDouble(A_1);
        concA2 = Double.parseDouble(A_2);
        concA3 = Double.parseDouble(A_3);
        concB1 = Double.parseDouble(B_1);
        concB2 = Double.parseDouble(B_2);
        concB3 = Double.parseDouble(B_3);
        concC1 = Double.parseDouble(C_1);
        concC2 = Double.parseDouble(C_2);
        concC3 = Double.parseDouble(C_3);

    }

}
