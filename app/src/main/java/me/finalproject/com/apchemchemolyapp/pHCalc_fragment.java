package me.finalproject.com.apchemchemolyapp;

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
    EditText et5;
    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv5;
    TextView Answer;
    Button go;
    String spinner;
    String resp;
    double finalpH;
    double molOH;
    double molH;
    double pKa;
    double pKb;
    double Ka;
    double Kb;
    double Kw = Math.pow(10, -14);
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
        et5 = (EditText) rootview.findViewById(R.id.editText5);
        et5.setVisibility(View.GONE);
        tv1 = (TextView)rootview.findViewById(R.id.textView1);
        tv1.setVisibility(View.GONE);
        tv2 = (TextView) rootview.findViewById(R.id.textView2);
        tv2.setVisibility(View.GONE);
        tv3 = (TextView) rootview.findViewById(R.id.textView3);
        tv3.setVisibility(View.GONE);
        tv4 = (TextView) rootview.findViewById(R.id.textView4);
        tv4.setVisibility(View.GONE);
        tv5 = (TextView) rootview.findViewById(R.id.textView5);
        tv5.setVisibility(View.GONE);
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
                        et1.setVisibility(View.VISIBLE);
                        et2.setVisibility(View.VISIBLE);
                        et3.setVisibility(View.VISIBLE);
                        et4.setVisibility(View.VISIBLE);
                        et5.setVisibility(View.VISIBLE);
                        //have to change the strings
                        tv1.setVisibility(View.VISIBLE);
                        tv1.setText(R.string.StrongA);
                        tv2.setVisibility(View.VISIBLE);
                        tv2.setText(R.string.VolStrongA);
                        tv3.setVisibility(View.VISIBLE);
                        tv3.setText(R.string.WeakB);
                        tv4.setVisibility(View.VISIBLE);
                        tv4.setText(R.string.VolWeakB);
                        tv5.setVisibility(View.VISIBLE);
                        tv5.setText(R.string.pKb);
                        go.setVisibility(View.VISIBLE);
                        break;
                    case "Weak Acid - Strong Base Titration":
                        et1.setVisibility(View.VISIBLE);
                        et2.setVisibility(View.VISIBLE);
                        et3.setVisibility(View.VISIBLE);
                        et4.setVisibility(View.VISIBLE);
                        et5.setVisibility(View.VISIBLE);
                        tv1.setVisibility(View.VISIBLE);
                        tv1.setText(R.string.WeakA);
                        tv2.setVisibility(View.VISIBLE);
                        tv2.setText(R.string.VolWeakA);
                        tv3.setVisibility(View.VISIBLE);
                        tv3.setText(R.string.StrongB);
                        tv4.setVisibility(View.VISIBLE);
                        tv4.setText(R.string.VolStrongB);
                        tv5.setVisibility(View.VISIBLE);
                        tv5.setText(R.string.pKaWeakAcid);
                        go.setVisibility(View.VISIBLE);
                        break;
                    case "One Acid":
                        et1.setVisibility(View.VISIBLE);
                        et4.setVisibility(View.VISIBLE);
                        et5.setVisibility(View.VISIBLE);
                        tv1.setVisibility(View.VISIBLE);
                        tv4.setVisibility(View.VISIBLE);
                        tv5.setVisibility(View.VISIBLE);
                        tv1.setText(R.string.concAcid);
                        tv4.setText(R.string.VolAcid);
                        tv5.setText(R.string.oneKa);
                        go.setVisibility(View.VISIBLE);
                        break;
                    case "One Base":
                        et1.setVisibility(View.VISIBLE);
                        et4.setVisibility(View.VISIBLE);
                        et5.setVisibility(View.VISIBLE);
                        tv1.setVisibility(View.VISIBLE);
                        tv4.setVisibility(View.VISIBLE);
                        tv5.setVisibility(View.VISIBLE);
                        tv1.setText(R.string.concBase);
                        tv4.setText(R.string.VolBase);
                        tv5.setText(R.string.oneKb);
                        go.setVisibility(View.VISIBLE);
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
                        Answer.setVisibility(View.VISIBLE);
                        strongAweakB();
                        Answer.setText(resp);
                        break;
                    case "Weak Acid - Strong Base Titration":
                        Answer.setVisibility(View.VISIBLE);
                        weakAstrongB();
                        Answer.setText(resp);
                        break;
                    case "One Acid":
                        Answer.setVisibility(View.VISIBLE);
                        oneAcid();
                        Answer.setText(resp);
                        break;
                    case "One Base":
                        Answer.setVisibility(View.VISIBLE);
                        oneBase();
                        Answer.setText(resp);
                }
            }
        });
        return rootview;
    }
    public void strongAstrongB()
    {

        try
        {
            double concSA = Double.parseDouble(et1.getText().toString());
            double volSA = Double.parseDouble(et2.getText().toString());
            double concSB = Double.parseDouble(et3.getText().toString());
            double volSB = Double.parseDouble(et4.getText().toString());
            molH  = concSA * volSA;
            molOH = concSB * volSB;
            finalpH = 0;
            if (molH > molOH)
            {
                finalpH = -1 * Math.log10(molH - molOH);
                resp = "The pH is " + finalpH;
            }
            else
            {
                if ((molOH - molH) != 0)
                {
                    finalpH = Math.round((14 - (-1 * Math.log10(molOH - molH)))*100);
                    finalpH/=100;
                }
                else
                {
                    finalpH = 7;
                }
                resp = "The pH is " + finalpH;
            }
        }
        catch(NumberFormatException n)
        {
            Toast.makeText(getActivity(), "Please select an Option", Toast.LENGTH_LONG).show();
        }
    }
    public void strongAweakB()
    {
        if (molH==molOH)
        {
            try
            {
                pKb = -1*Math.log10(Double.parseDouble(et5.getText().toString()));
                molH = Double.parseDouble(et1.getText().toString()) * Double.parseDouble(et2.getText().toString());
                molOH = Double.parseDouble(et3.getText().toString()) * Double.parseDouble(et4.getText().toString());
                Kb = Double.parseDouble(et5.getText().toString());
                double concHA = Double.parseDouble(et1.getText().toString());
                double volHA = Double.parseDouble(et2.getText().toString());
                double concB = Double.parseDouble(et3.getText().toString());
                double volB = Double.parseDouble(et4.getText().toString());Ka = Kw/Kb;
                double mol = concB*volB;
                double vol = volB+volHA;
                double newConc = mol/vol;
                double a = Math.round(Math.log10(Math.sqrt(Ka * newConc))*100);
                a /= 100;
                resp = "The pH is "+(a);
            }
            catch (NumberFormatException n)
            {
                if (et5.getText().toString().contains(" ")||et1.getText().toString().contains(" ")||et2.getText().toString().contains(" ")||et3.getText().toString().contains(" ")||et4.getText().toString().contains(" "))
                {
                    Toast.makeText(getActivity(), "Please get rid of all spaces", Toast.LENGTH_LONG).show();
                }
                else if (et5.getText().toString().equals("")||et1.getText().toString().equals("")||et2.getText().toString().equals("")||et3.getText().toString().equals("")||et4.getText().toString().equals(""))
                {
                    Toast.makeText(getActivity(), "Please fill all Text Boxes", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getActivity(), "Please enter numbers only", Toast.LENGTH_LONG).show();
                }
            }

        }
        else
        {
            try
            {
                pKb = -1*Math.log10(Double.parseDouble(et5.getText().toString()));
                molH = Double.parseDouble(et1.getText().toString()) * Double.parseDouble(et2.getText().toString());
                molOH = Double.parseDouble(et3.getText().toString()) * Double.parseDouble(et4.getText().toString());
                double concHB = molH;
                double concB = (molOH - molH);
                double answer = Math.round((14 - (pKb + Math.log10(concHB/concB)))*100);
                answer /= 100;
                resp = "The pH is " + answer;
            }
            catch (NumberFormatException n)
            {
                if (et5.getText().toString().contains(" ")||et1.getText().toString().contains(" ")||et2.getText().toString().contains(" ")||et3.getText().toString().contains(" ")||et4.getText().toString().contains(" "))
                {
                    Toast.makeText(getActivity(), "Please get rid of all spaces", Toast.LENGTH_LONG).show();
                }
                else if (et5.getText().toString().equals("")||et1.getText().toString().equals("")||et2.getText().toString().equals("")||et3.getText().toString().equals("")||et4.getText().toString().equals(""))
                {
                    Toast.makeText(getActivity(), "Please fill all Text Boxes", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getActivity(), "Please enter numbers only", Toast.LENGTH_LONG).show();
                }
            }
        }

    }
    public void weakAstrongB()
    {
        if(molOH==molH)
        {
            try
            {
                Ka = Double.parseDouble(et5.getText().toString());
                pKa = -(Math.log10(Double.parseDouble(et5.getText().toString())));
                molH = Double.parseDouble(et1.getText().toString()) * Double.parseDouble(et2.getText().toString());
                molOH = Double.parseDouble(et3.getText().toString()) * Double.parseDouble(et4.getText().toString());
                double concHA = Double.parseDouble(et1.getText().toString());
                double volHA = Double.parseDouble(et2.getText().toString());
                double concB = Double.parseDouble(et3.getText().toString());
                double volB = Double.parseDouble(et4.getText().toString());
                Kb = Kw/Ka;
                double mol = concB*volB;
                double vol = volB+volHA;
                double newConc = mol/vol;
                double a = Math.round(Math.log10(Math.sqrt(Kb * newConc))*100);
                a /= 100;
                resp = "The pH is " + a;
            }
            catch (NumberFormatException n)
            {
                if (et5.getText().toString().contains(" ")||et1.getText().toString().contains(" ")||et2.getText().toString().contains(" ")||et3.getText().toString().contains(" ")||et4.getText().toString().contains(" "))
                {
                    Toast.makeText(getActivity(), "Please get rid of all spaces", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getActivity(), "Please enter numbers only", Toast.LENGTH_LONG).show();
                }
            }
        }
        else
        {
            try
            {
                pKa = -(Math.log10(Double.parseDouble(et5.getText().toString())));
                if(Double.parseDouble(et2.getText().toString()) == 0)
                {
                    molH = Double.parseDouble(et1.getText().toString());
                }
                else
                {
                    molH = Double.parseDouble(et1.getText().toString()) * Double.parseDouble(et2.getText().toString());
                }
                if (Double.parseDouble(et4.getText().toString())==0)
                {
                    molOH = Double.parseDouble(et3.getText().toString());
                }
                else
                {
                    molOH = Double.parseDouble(et3.getText().toString()) * Double.parseDouble(et4.getText().toString());
                }
                double concA = molOH / (Double.parseDouble(et2.getText().toString()) + Double.parseDouble(et4.getText().toString()));
                double concHA = (molH - molOH)/(Double.parseDouble(et2.getText().toString()) + Double.parseDouble(et4.getText().toString()));
                double answer = Math.round((pKa + Math.log10(concA/concHA))*100);
                answer /= 100;
                resp = "The pH is " + (answer);
            }
            catch (NumberFormatException n)
            {
                if (et5.getText().toString().contains(" ")||et1.getText().toString().contains(" ")||et2.getText().toString().contains(" ")||et3.getText().toString().contains(" ")||et4.getText().toString().contains(" "))
                {
                    Toast.makeText(getActivity(), "Please get rid of all spaces", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getActivity(), "Please enter numbers only", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
    public void oneAcid()
    {
        try
        {
            molH = Double.parseDouble(et1.getText().toString()) * Double.parseDouble(et4.getText().toString());
            double concA = Double.parseDouble(et1.getText().toString());
            double answer;
            if (et5.getText().toString().equals(""))
            {
                answer = Math.round((-1 * Math.log10(molH))*100);
                answer /= 100;
                if (answer < 0)
                {
                    answer = 0.0;
                }
                resp = "The pH is " + (answer);
            }
            else
            {
                Ka = Double.parseDouble(et5.getText().toString());
                answer = Math.round(Math.sqrt(Ka * concA));
                resp = "The pH is " + answer;
            }
        }
        catch (NumberFormatException n)
        {
            if (et5.getText().toString().contains(" ")||et1.getText().toString().contains(" ")||et4.getText().toString().contains(" "))
            {
                Toast.makeText(getActivity(), "Please get rid of all spaces", Toast.LENGTH_LONG).show();
            }
            else if (et1.getText().toString().equals("")||et4.getText().toString().equals(""))
            {
                Toast.makeText(getActivity(), "Please fill the concentration and volume boxes", Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getActivity(), "Please enter numbers only", Toast.LENGTH_LONG).show();
            }
        }
    }
    public void oneBase()
    {
        try
        {
            molOH = Double.parseDouble(et1.getText().toString()) * Double.parseDouble(et4.getText().toString());
            double concB = Double.parseDouble(et1.getText().toString());
            double answer;
            if (et5.getText().toString().equals(""))
            {
                answer = Math.round((-1 * Math.log10(molH))*100);
                answer /= 100;
                resp = "The pH is " + (answer);
            }
            else
            {
                Kb = Double.parseDouble(et5.getText().toString());
                answer = Math.round(14 - Math.sqrt(Kb * concB));
                resp = "The pH is " + answer;
            }
        }
        catch (NumberFormatException n)
        {
            if (et5.getText().toString().contains(" ")||et1.getText().toString().contains(" ")||et4.getText().toString().contains(" "))
            {
                Toast.makeText(getActivity(), "Please get rid of all spaces", Toast.LENGTH_LONG).show();
            }
            else if (et1.getText().toString().equals("")||et4.getText().toString().equals(""))
            {
                Toast.makeText(getActivity(), "Please fill the concentration and volume boxes", Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getActivity(), "Please enter numbers only", Toast.LENGTH_LONG).show();
            }
        }
    }
    public void exps(String s, double num)
    {
        int a = 0;
        String s1;
        String s2;
        if (s!= null && (s.contains("x10^") || s.contains("*10^")))
        {
            a = s.indexOf("10^");
            if (s.substring(a-1, a).equals("*") || s.substring(a-1,a).equals("x"))
            {
                s1 = s.substring(0, a-1);
                s.equals(s.substring(a+3));
                try
                {
                    num = Double.parseDouble(s1) * Math.pow(10, Double.parseDouble(s));
                }
                catch (NumberFormatException  n)
                {
                    Toast.makeText(getActivity(), "Please enter numbers only", Toast.LENGTH_LONG).show();
                }
            }
        }
        else if (s != null && s.contains("^"))
        {
            a = s.indexOf("^");
            s1 = s.substring(a+1);
            s.equals(s.substring(0,a));
            try
            {
                num = Math.pow(Double.parseDouble(s), Double.parseDouble(s1));
            }
            catch (NumberFormatException n)
            {
                Toast.makeText(getActivity(), "Please only type numbers", Toast.LENGTH_LONG).show();
            }
        }


    }
}
