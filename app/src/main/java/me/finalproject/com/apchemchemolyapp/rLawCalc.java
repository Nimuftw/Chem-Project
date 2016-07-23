package me.finalproject.com.apchemchemolyapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;


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
    double concD1;
    double concD2;
    double concD3;
    double rateA;
    double rateB;
    double rateC;
    double concA;
    double concB;
    double concC;
    double rate1;
    double rate2;
    double rate3;
    double rate4;
    int expA;
    int expB;
    int expC;
    boolean onClick = false;
    String resp;
    String spinner = "";
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
        //load spinner
        spin = (Spinner) rootview.findViewById(R.id.numReactants);
        choices = ArrayAdapter.createFromResource( getActivity(), R.array.numOfReactants, android.R.layout.simple_spinner_item);
        choices.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(choices);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                spinner = "" + parent.getItemAtPosition(position);
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
                        break;

                    case "2":
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
                        GO.setVisibility(View.VISIBLE);
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
                        D.setText(R.string.rate);
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
                        GO.setVisibility(View.VISIBLE);
                        break;
                }
            }
            public void onNothingSelected(AdapterView<?> parent)
            {
                Toast.makeText(getActivity(), "Please select an Option", Toast.LENGTH_LONG).show();
            }
        });
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
        return rootview;
    }
    public void case1Ints()
    {
        try
        {
            concA1= Double.parseDouble((A1.getText().toString()));
            concA2 = Double.parseDouble((B1.getText().toString()));
            rate1 = Double.parseDouble((A2.getText().toString()));
            rate2 = Double.parseDouble((B2.getText().toString()));
        }
        catch(NumberFormatException n)
        {
            if (A1.getText().toString().contains(" ") || B1.getText().toString().contains(" ") || A2.getText().toString().contains(" ") || B2.getText().toString().contains(" "))
            {
                Toast.makeText(getActivity(), "Please get rid of all spaces", Toast.LENGTH_LONG).show();
            }
            else if (A1.getText().toString().equals("") || B1.getText().toString().equals("") || A2.getText().toString().equals("") || B2.getText().toString().equals(""))
            {
                Toast.makeText(getActivity(), "Please fill all Text Boxes", Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getActivity(), "Please enter numbers only", Toast.LENGTH_LONG).show();
            }
        }
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
        String A_1 = A1.getText().toString().replaceAll("\\s+","");
        String A_2 = A2.getText().toString().replaceAll("\\s+","");
        try
        {
            concA1 = Double.parseDouble(A_1);
            concA2 = Double.parseDouble(A_2);
            concB1 = Double.parseDouble(B1.getText().toString().replaceAll("\\s+",""));
            concB2 = Double.parseDouble(B2.getText().toString().replaceAll("\\s+",""));
            concC1 = Double.parseDouble(C1.getText().toString().replaceAll("\\s+",""));
            concC2 = Double.parseDouble(C2.getText().toString().replaceAll("\\s+",""));
            rate1 = Double.parseDouble(A3.getText().toString().replaceAll("\\s+",""));
            rate2 = Double.parseDouble(B3.getText().toString().replaceAll("\\s+",""));
            rate3 = Double.parseDouble(C3.getText().toString().replaceAll("\\s+",""));
        }
        catch (NumberFormatException n)
        {
            if (A_1.contains(" ") || A_2.contains(" ") || B1.getText().toString().contains(" ") ||B2.getText().toString().contains(" ") ||C1.getText().toString().contains(" ") ||C2.getText().toString().contains(" ") ||A3.getText().toString().contains(" ") ||B3.getText().toString().contains(" ") ||C3.getText().toString().contains(" "))
            {
                Toast.makeText(getActivity(), "Please get rid of all Spaces", Toast.LENGTH_LONG).show();
            }
            else if (A_1.equals("") || A_2.equals("") || B1.getText().toString().equals("") ||B2.getText().toString().equals("") ||C1.getText().toString().equals("") ||C2.getText().toString().equals("") ||A3.getText().toString().equals("") ||B3.getText().toString().equals("") ||C3.getText().toString().equals(""))
            {
                Toast.makeText(getActivity(), "Please fill all Text Boxes", Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getActivity(), "Please enter Numbers Only", Toast.LENGTH_LONG).show();
            }
        }

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
                if (concC1 == concA1)
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
        setResp(2);
    }
    public void case3Ints()
    {
        try
        {
            concA1 = Double.parseDouble(A1.getText().toString().replaceAll("\\s+",""));
            concA2 = Double.parseDouble(A2.getText().toString().replaceAll("\\s+",""));
            concA3 = Double.parseDouble(A3.getText().toString().replaceAll("\\s+",""));
            concB1 = Double.parseDouble(B1.getText().toString().replaceAll("\\s+",""));
            concB2 = Double.parseDouble(B2.getText().toString().replaceAll("\\s+",""));
            concB3 = Double.parseDouble(B3.getText().toString().replaceAll("\\s+",""));
            concC1 = Double.parseDouble(C1.getText().toString().replaceAll("\\s+",""));
            concC2 = Double.parseDouble(C2.getText().toString().replaceAll("\\s+",""));
            concC3 = Double.parseDouble(C3.getText().toString().replaceAll("\\s+",""));
            concD1 = Double.parseDouble(D1.getText().toString().replaceAll("\\s+",""));
            concD2 = Double.parseDouble(D2.getText().toString().replaceAll("\\s+",""));
            concD3 = Double.parseDouble(D3.getText().toString().replaceAll("\\s+",""));
            rate1 = Double.parseDouble(A4.getText().toString().replaceAll("\\s+",""));
            rate2 = Double.parseDouble(B4.getText().toString().replaceAll("\\s+",""));
            rate3 = Double.parseDouble(C4.getText().toString().replaceAll("\\s+",""));
            rate4 = Double.parseDouble(D4.getText().toString().replaceAll("\\s+",""));
        }
        catch(NumberFormatException n)
        {
            if (A1.getText().toString().equals("") || A2.getText().toString().equals("") || B1.getText().toString().equals("") ||B2.getText().toString().equals("") ||C1.getText().toString().equals("") ||C2.getText().toString().equals("") ||A3.getText().toString().equals("") ||B3.getText().toString().equals("") ||C3.getText().toString().equals("") || D1.getText().toString().equals("") ||D2.getText().toString().equals("") ||D3.getText().toString().equals("") ||A4.getText().toString().equals("") ||B4.getText().toString().equals("") ||C4.getText().toString().equals("") ||D4.getText().toString().equals(""))
            {
                Toast.makeText(getActivity(), "Please fill all Text Boxes", Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getActivity(), "Please enter numbers Only", Toast.LENGTH_LONG).show();
            }
        }
        double[] ratearr = new double[4];
        ratearr[0] = rate1;
        ratearr[1] = rate2;
        ratearr[2] = rate3;
        ratearr[3] = rate4;
        double[][] concarray = new double[4][3];
        concarray[0][0] = concA1;
        concarray[0][1] = concA2;
        concarray[0][2] = concA3;
        concarray[1][0] = concB1;
        concarray[1][1] = concB2;
        concarray[1][2] = concB3;
        concarray[2][0] = concC1;
        concarray[2][1] = concC2;
        concarray[2][2] = concC3;
        concarray[3][0] = concD1;
        concarray[3][1] = concD2;
        concarray[3][2] = concD3;
        boolean A = false;
        boolean B = false;
        boolean C = false;
        int i = 0;
        int j = 0;
        double temp = concarray[j][i];
        //get first element
        for (int a = 0; a<3; a++)
        {
            for (int b = 0; b<4; b++)
            {

                if (concarray[b][a] != temp && i == a)
                {
                    if (a == 0)
                    {
                        concA = concarray[b][a]/temp;
                        rateA = ratearr[b]/ratearr[j];
                        if (concarray[b][a+1] == concarray[j][a+1] && concarray[b][a+2] == concarray[j][a+2])
                        {
                            getExp("A");
                            A = true;
                            j = b;
                            i = a;
                            concarray[j][i]= temp;
                        }
                    }
                    else if (a == 1)
                    {
                        concB = concarray[b][a]/temp;
                        rateB = ratearr[b]/ratearr[j];
                        if (concarray[b][a-1] == concarray[j][a-1] && concarray[b][a+1] == concarray[j][a+1])
                        {
                            getExp("B");
                            B = true;
                            j = b;
                            i = a;
                            concarray[b][a]= temp;
                        }
                    }
                    else if (a == 2)
                    {
                        concC = concarray[b][a]/temp;
                        rateC = ratearr[b]/ratearr[j];
                        if (concarray[b][a-2] == concarray[j][a-2] && concarray[b][a-1] == concarray[b][a-1])
                        {
                            getExp("C");
                            C = true;
                            j = b;
                            i = a;
                            concarray[b][a]= temp;
                        }
                    }
                }
                else if (i != a)
                {
                    j = b;
                    i = a;
                    concarray[b][a]= temp;
                }
            }
        }
        //Get Remaining Elements
        while(!A && !B && !C)
        {
        for (int a = 0; a<3; a++)
        {
            for (int b = 0; b < 4; b++)
            {
                temp = concarray[j][i];
                if (concarray[b][a] != temp && i == a)
                {
                    if (a == 0)
                    {
                        concA = concarray[b][a] / temp;
                        rateA = ratearr[b] / ratearr[j];
                        if (concarray[b][a + 1] != concarray[j][a + 1] && concarray[b][a + 2] == concarray[j][a + 2] && B)
                        {
                            if (expB == 0)
                            {
                                getExp("a");
                            }
                            else if (expB == 1)
                            {
                                double t = concB;
                                rateA /= t;
                                getExp("a");
                            }
                            else if (expB == 2)
                            {
                                double t = concB * concB;
                                rateA /= t;
                                getExp("a");
                            }
                        }
                        else if (concarray[b][a + 1] == concarray[j][a + 1] && concarray[b][a + 2] != concarray[j][a + 2] && C)
                        {
                            if (expC == 0)
                            {
                                getExp("a");
                            }
                            else if (expC == 1)
                            {
                                double t = concC;
                                rateA /= t;
                                getExp("a");
                            }
                            else if (expC == 2)
                            {
                                double t = concC * concC;
                                rateA /= t;
                                getExp("a");
                            }
                        }
                    }
                    else if (a == 1)
                    {
                        concB = concarray[b][a] / temp;
                        rateB = ratearr[b] / ratearr[j];
                        if (concarray[b][a + 1] != concarray[j][a + 1] && concarray[b][a - 1] == concarray[j][a - 1] && C)
                        {
                            if (expC == 0)
                            {
                                getExp("b");
                            }
                            else if (expC == 1)
                            {
                                double t = concC;
                                rateB /= t;
                                getExp("b");
                            }
                            else if (expC == 2)
                            {
                                double t = concC * concC;
                                rateB /= t;
                                getExp("b");
                            }
                        }
                        else if (concarray[b][a + 1] == concarray[j][a + 1] && concarray[b][a - 1] != concarray[j][a - 1] && A)
                        {
                            if (expA == 0)
                            {
                                getExp("b");
                            }
                            else if (expA == 1)
                            {
                                double t = concA;
                                rateB /= t;
                                getExp("b");
                            }
                            else if (expA == 2)
                            {
                                double t = concA * concA;
                                rateB /= t;
                                getExp("b");
                            }
                        }
                    }
                    else if (a == 2)
                    {
                        concC = concarray[b][a] / temp;
                        rateC = ratearr[b] / ratearr[j];
                        if (concarray[b][a - 2] != concarray[j][a - 2] && concarray[b][a - 1] == concarray[j][a - 1] && A)
                        {
                            if (expA == 0)
                            {
                                getExp("c");
                            }
                            else if (expA == 1)
                            {
                                double t = concA;
                                rateB /= t;
                                getExp("c");
                            }
                            else if (expA == 2)
                            {
                                double t = concA * concA;
                                rateB /= t;
                                getExp("c");
                            }
                        }
                        else if (concarray[b][a - 2] == concarray[j][a - 2] && concarray[b][a - 1] != concarray[j][a - 1] && B)
                        {
                            if (expB == 0)
                            {
                                getExp("c");
                            }
                            else if (expB == 1)
                            {
                                double t = concB;
                                rateB /= t;
                                getExp("c");
                            }
                            else if (expB == 2)
                            {
                                double t = concB * concB;
                                rateB /= t;
                                getExp("c");
                            }
                        }
                    }
                }
                else if (i != a)
                {
                    j = b;
                    i = a;
                    concarray[b][a] = temp;
                }
            }
        }
        }

        //horizontal scan
//        for (int a = 0; a<4; a++)
//        {
//            for (int b = 0; b<3; b++)
//            {
//                if (concarray[a][b] != concarray[a][b+1] && b<3)
//                {
//                    if (b == 1)
//                    {
//                        if (concarray[a][b-1] == concarray[a+1][b-1] && concarray[a][b+1] == concarray[a+1][b+1])
//                        {
//                            concB = concarray[a+1][b]/concarray[a][b];
//                            rateB = ratearr[a+1]/ratearr[a];
//                            getExp(rateB, concB, expB);
//                        }
//                    }
//                    if (b == 0)
//                    {
//                        if (concarray[a][b+1] == concarray[a+1][b+1] && concarray[a][b+2] == concarray[a+1][b+2])
//                        {
//                            concA = concarray[a+1][b]/concarray[a][b];
//                            rateA = ratearr[a+1]/ratearr[a];
//                            getExp(rateA, concA, expA);
//                        }
//                    }
//                    if (b == 2)
//                    {
//                        if(concarray[a][b-1] == concarray[a+1][b-1] && concarray[a][b-2] == concarray[a+1][b-2])
//                        {
//                            concC = concarray[a+1][b]/concarray[a][b];
//                            rateC = ratearr[a+1]/ratearr[a];
//                            getExp(rateC, concC, expC);
//                        }
//                    }
//                }
//            }
//        }
//        //get remaining exponents
//        while(!A && !B && !C)
//        {
//            if (expA == 0 || expA == 1 || expA == 2)
//            {
//                A = true;
//            }
//            else if (expB == 0 || expB == 1 || expB == 2)
//            {
//                B = true;
//            }
//            else if (expC == 0 || expC == 1 || expC == 2)
//            {
//                C = true;
//            }
//            for (int a = 0; a<3; a++)
//            {
//                for (int b = 0; b < 4; b++)
//                {
//                    if (concarray[a][b] != concarray[a][b+1] && b<3)
//                    {
//                        if (a == 1)
//                        {
//                            if (concarray[a-1][b] != concarray[a-1][b+1] && A)
//                            {
//                                concB = concarray[a][b+1]/concarray[a][b];
//                                rateB = ratearr[b+1]/ratearr[b];
//                                concA = concarray[a-1][b+1]/concarray[a-1][b];
//                                double temp = 1;
//                                if (expA == 1)
//                                {
//                                    temp = concA;
//                                }
//                                else if (expA == 2)
//                                {
//                                    temp = concA*concA;
//                                }
//                                rateB /= temp;
//                                getExp(rateB, concB, expB);
//                            }
//                            else if (concarray[a+1][b] != concarray[a+1][b+1] && C)
//                            {
//                                concB = concarray[a][b+1]/concarray[a][b];
//                                rateB = ratearr[b+1]/ratearr[b];
//                                concC = concarray[a+1][b+1]/concarray[a+1][b];
//                                double temp = 1;
//                                if (expC == 1)
//                                {
//                                    temp = concC;
//                                }
//                                else if (expC == 2)
//                                {
//                                    temp = concC*concC;
//                                }
//                                rateB /= temp;
//                                getExp(rateB, concB, expB);
//                            }
//                        }
//                        if (a == 0)
//                        {
//                            if (concarray[a+1][b] != concarray[a+1][b+1] && B)
//                            {
//                                concA = concarray[a][b+1]/concarray[a][b];
//                                concB = concarray[a+1][b+1]/concarray[a+1][b];
//                                rateA = ratearr[b+1]/ratearr[b];
//                                double temp = 1;
//                                if (expB == 1)
//                                {
//                                    temp = concB;
//                                }
//                                else if (expB == 2)
//                                {
//                                    temp = concB*concB;
//                                }
//                                rateA /= temp;
//                                getExp(rateA, concA, expA);
//                            }
//                            else if (concarray[a+2][b] != concarray[a+2][b+1] && C)
//                            {
//                                concA = concarray[a][b+1]/concarray[a][b];
//                                concC = concarray[a+2][b+1]/concarray[a+2][b];
//                                rateA = ratearr[b+1]/ratearr[b];
//                                double temp = 1;
//                                if (expC == 1)
//                                {
//                                    temp = concC;
//                                }
//                                else if (expC == 2)
//                                {
//                                    temp = concC*concC;
//                                }
//                                rateA /= temp;
//                                getExp(rateA, concA, expA);
//                            }
//                        }
//                        if (a == 2)
//                        {
//                            if(concarray[a-1][b] != concarray[a-1][b+1] && B)
//                            {
//                                concC = concarray[a][b+1]/concarray[a][b];
//                                rateC = ratearr[b+1]/ratearr[b];
//                                concB = concarray[a-1][b+1]/concarray[a-1][b];
//                                double temp = 1;
//                                if (expC == 1)
//                                {
//                                    temp = concC;
//                                }
//                                else if (expC == 2)
//                                {
//                                    temp = concC*concC;
//                                }
//                                rateC /= temp;
//                                getExp(rateC, concC, expC);
//                            }
//                            else if (A && concarray[a-2][b] != concarray[a-2][b+1])
//                            {
//                                concC = concarray[a][b+1]/concarray[a][b];
//                                rateC = ratearr[b+1]/ratearr[b];
//                                concA = concarray[a-2][b+1]/concarray[a-2][b];
//                                double temp = 1;
//                                if (expA == 1)
//                                {
//                                    temp = concA;
//                                }
//                                else if (expA == 2)
//                                {
//                                    temp = concA*concA;
//                                }
//                                rateC /= temp;
//                                getExp(rateC, concC, expC);
//                            }
//                        }
//                    }
//                }
        setResp(3);
            }
    public void setResp(int num)
    {
        try
        {
            if (num == 1)
            {
                resp = "rate = k[A]"+expA;
                if (expA == 0)
                {
                    resp = "rate = k";
                }
            }
            else if (num == 2)
            {
                resp = "rate = k[A]" + expA + "[B]" + expB;
            }
            else if (num == 3)
            {
                resp = "rate = k[A]" +expA+ "[B]" + expB + "[C]" +expC;
            }
            while (resp.contains("0"))
            {
                if (resp.indexOf("0") == resp.length()-1)
                {
                    resp = resp.substring(0, resp.indexOf("0")-3);
                }
                resp = resp.substring(0,resp.indexOf("0")-3) + resp.substring(resp.indexOf("0")+1, resp.length());
            }
            resp = resp.replaceAll("1", "");
            resp = resp.replaceAll("2", "²");
        }
        catch (StringIndexOutOfBoundsException s)
        {
            resp = resp.replaceAll("1", "");
            resp = resp.replaceAll("2", "²");
        }
    }
    public void getExp(String s)
    {
        if (s.equalsIgnoreCase("A"))
        {
            if (rateA == 1)
            {
                expA = 0;
            }
            else if (rateA == concA)
            {
                expA = 1;
            }
            else if (rateA == concA*concA)
            {
                expA = 2;
            }
            else if (rateA == concA*concA*concA)
            {
                expA = 3;
            }
        }
        else if (s.equalsIgnoreCase("B"))
        {
            if (rateB == 1)
            {
                expB = 0;
            }
            else if (rateB == concB)
            {
                expB = 1;
            }
            else if (rateB == concB*concB)
            {
                expB = 2;
            }
            else if (rateB == concB*concB*concB)
            {
                expB = 3;
            }
        }
        else if (s.equalsIgnoreCase("C"))
        {
            if (rateC == 1)
            {
                expC = 0;
            }
            else if (rateC == concC)
            {
                expC = 1;
            }
            else if (rateC == concC*concC)
            {
                expC = 2;
            }
            else if (rateC == concC*concC*concC)
            {
                expC = 3;
            }
        }
    }
}