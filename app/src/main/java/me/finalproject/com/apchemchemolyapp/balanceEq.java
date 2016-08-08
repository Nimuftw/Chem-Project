package me.finalproject.com.apchemchemolyapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Collections;
import android.view.View.OnClickListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import android.util.Log;
import android.widget.Toast;


/**
 * Created by Shishir on 6/9/2016.
 */
public class balanceEq extends Fragment implements TextWatcher
{
    View rootview;
    int i = 0;
    int j = 0;
    int a = 0;
    int b = 0;
    ArrayList<Integer> reacarr = new ArrayList<>();
    ArrayList<Integer> prodarr = new ArrayList<>();
    ArrayList<String> reactants_elements = new ArrayList<>();
    ArrayList<String> products_elements = new ArrayList<>();
    ArrayList<String> rcompounds = new ArrayList<>();
    ArrayList<Integer> rcoeffs = new ArrayList<>();
    ArrayList<String> pcompounds = new ArrayList<>();
    ArrayList<Integer> pcoeffs = new ArrayList<>();
    ArrayList<String> total = new ArrayList<>();
    ArrayList<Integer> dummy = new ArrayList<>();
    boolean getElements = true;
    String relement;
    String pelement;
    String compound;
    boolean getrc = true;
    boolean getpc = true;
    String element = "";
    double[][]matrix;
    double[][]copy;
    EditText reactants;
    EditText products;
    TextView beq;

    String balancedEQ;
    int temp;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        rootview = inflater.inflate(R.layout.balance_eq_layout, container, false);
        reactants = (EditText) rootview.findViewById(R.id.reactants);
        products = (EditText) rootview.findViewById(R.id.products);
        beq = (TextView) rootview.findViewById(R.id.balanced_equation);
        Button go = (Button) rootview.findViewById(R.id.button);
        go.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {
                setBalancedEq();
                beq.setText(balancedEQ);
            }
        });
        reactants.addTextChangedListener(this);
        products.addTextChangedListener(this);
        return rootview;
    }

    //takes string input and gets reactant elements
    public void getReacElements(String s)
    {
        while(getElements)
        {
            if(s.length() == 1)
            {
                reactants_elements.add(s);
                reacarr.add(1);
                getElements = false;
            }
            String let = s.substring(i, i+1);
            if (let.equals("1") || let.equals("2") || let.equals("3") || let.equals("4") || let.equals("5") || let.equals("6") || let.equals("7") || let.equals("8") || let.equals("9")) {
                if (i == s.length() - 2)
                {
                    if (s.substring(i+1).equals("0")||s.substring(i+1).equals("1")||s.substring(i+1).equals("2")||s.substring(i+1).equals("3")||s.substring(i+1).equals("4")||s.substring(i+1).equals("5")||s.substring(i+1).equals("6")||s.substring(i+1).equals("7")||s.substring(i+1).equals("8")||s.substring(i+1).equals("9"))
                    {
                        reacarr.add(Integer.parseInt(s.substring(i,i+2)));
                        reactants_elements.add(element);
                        element = "";
                        i++;
                    }
                    else
                    {
                        reactants_elements.add(element);
                        reacarr.add(Integer.parseInt(let));
                        reactants_elements.add(s.substring(s.length() - 1));
                        reacarr.add(1);
                        getElements = false;
                    }

                }
                else if (s.substring(i+1,i+2).equals("0")||s.substring(i+1,i+2).equals("1")||s.substring(i+1,i+2).equals("2")||s.substring(i+1,i+2).equals("3")||s.substring(i+1,i+2).equals("4")||s.substring(i+1,i+2).equals("5")||s.substring(i+1,i+2).equals("6")||s.substring(i+1,i+2).equals("7")||s.substring(i+1,i+2).equals("8")||s.substring(i+1,i+2).equals("9"))
                {
                    if (s.substring(i+2,i+3).equals("0")||s.substring(i+2,i+3).equals("1")||s.substring(i+2,i+3).equals("2")||s.substring(i+2,i+3).equals("3")||s.substring(i+2,i+3).equals("4")||s.substring(i+2,i+3).equals("5")||s.substring(i+2,i+3).equals("6")||s.substring(i+2,i+3).equals("7")||s.substring(i+2,i+3).equals("8")||s.substring(i+2,i+3).equals("9"))
                    {
                        reacarr.add(Integer.parseInt(s.substring(i,i+3)));
                        reactants_elements.add(element);
                        element = "";
                        i += 2;
                    }
                    else
                    {
                        reacarr.add(Integer.parseInt(s.substring(i,i+2)));
                        reactants_elements.add(element);
                        element = "";
                        i++;
                    }
                }
                else {
                    temp = Integer.parseInt(let);
                    reacarr.add(temp);
                    reactants_elements.add(element);
                    element = "";
                    temp = 0;
                }
            }
            else if((let.toLowerCase()).compareTo(let) > 0)
            {
                element += let;
                if(i == s.length()-2)
                {
                    if(s.substring(s.length()-1).equals("2")||s.substring(s.length()-1).equals("3")||s.substring(s.length()-1).equals("4")||s.substring(s.length()-1).equals("5")||s.substring(s.length()-1).equals("6")||s.substring(s.length()-1).equals("7")||s.substring(s.length()-1).equals("8")||s.substring(s.length()-1).equals("9"))
                    {
                        reacarr.add(Integer.parseInt(s.substring(s.length()-1)));
                        reactants_elements.add(let);
                        getElements= false;
                    }
                    else
                    {
                        element += s.substring(s.length()-1);
                        reactants_elements.add(element);
                        reacarr.add(1);
                    }
                }
                else if(s.substring(i+1, i+2).compareTo(s.substring(i+1, i+2).toLowerCase()) != 0)
                {
//                    if(!re.substring(i+1,i+2).equals("2")||!re.substring(i+1,i+2).equals("3")||!re.substring(i+1,i+2).equals("4")||!re.substring(i+1,i+2).equals("5")||!re.substring(i+1,i+2).equals("6")||!re.substring(i+1,i+2).equals("7")||!re.substring(i+1,i+2).equals("8")||!re.substring(i+1,i+2).equals("9"))
//                    {
                    reacarr.add(1);
                    reactants_elements.add(element);
                    element = "";
//                    }
                }
            }
            else if(let.compareTo(let.toLowerCase()) == 0)
            {
                element += let;
                if(i == s.length()-2)
                {
                    if(s.substring(s.length()-1).equals("2")||s.substring(s.length()-1).equals("3")||s.substring(s.length()-1).equals("4")||s.substring(s.length()-1).equals("5")||s.substring(s.length()-1).equals("6")||s.substring(s.length()-1).equals("7")||s.substring(s.length()-1).equals("8")||s.substring(s.length()-1).equals("9"))
                    {
                        reacarr.add(Integer.parseInt(s.substring(s.length()-1)));
                        reactants_elements.add(let);
                    }
                    else
                    {
                        element += s.substring(s.length()-1);
                        reactants_elements.add(element);
                        reacarr.add(1);
                    }
                    getElements = false;
                }
                else if(!s.substring(i+1,i+2).equals("2")||s.substring(i+1,i+2).equals("3")||s.substring(i+1,i+2).equals("4")||s.substring(i+1,i+2).equals("5")||s.substring(i+1,i+2).equals("6")||s.substring(i+1,i+2).equals("7")||s.substring(i+1,i+2).equals("8")||s.substring(i+1,i+2).equals("9"))
                {
                    temp = 1;
                    reacarr.add(temp);
                    temp = 0;
                }
            }

            i++;
            if(i == s.length())
            {
                getElements = false;
            }
        }
        // displays the elements isolated on the reactant side
        // to test to make sure my logic works
//        for(int a = 0; a<reactants_elements.size(); a++)
//        {
//            relement += (reactants_elements.get(a) + " : " + reacarr.get(a) + "\n");
//        }
    }


    public void getProdElements(String s)
    {
        while(getElements)
        {
            if(s.length() == 1)
            {
                reactants_elements.add(s);
                reacarr.add(1);
                getElements = false;
            }
            String let = s.substring(i, i+1);
            if (let.equals("1") || let.equals("2") || let.equals("3") || let.equals("4") || let.equals("5") || let.equals("6") || let.equals("7") || let.equals("8") || let.equals("9")) {
                if (i == s.length() - 2)
                {
                    if (s.substring(i+1).equals("0")||s.substring(i+1).equals("1")||s.substring(i+1).equals("2")||s.substring(i+1).equals("3")||s.substring(i+1).equals("4")||s.substring(i+1).equals("5")||s.substring(i+1).equals("6")||s.substring(i+1).equals("7")||s.substring(i+1).equals("8")||s.substring(i+1).equals("9"))
                    {
                        reacarr.add(Integer.parseInt(s.substring(i,i+2)));
                        reactants_elements.add(element);
                        element = "";
                        i++;
                    }
                    else
                    {
                        reactants_elements.add(element);
                        reacarr.add(Integer.parseInt(let));
                        reactants_elements.add(s.substring(s.length() - 1));
                        reacarr.add(1);
                        getElements = false;
                    }

                }
                else if (s.substring(i+1,i+2).equals("0")||s.substring(i+1,i+2).equals("1")||s.substring(i+1,i+2).equals("2")||s.substring(i+1,i+2).equals("3")||s.substring(i+1,i+2).equals("4")||s.substring(i+1,i+2).equals("5")||s.substring(i+1,i+2).equals("6")||s.substring(i+1,i+2).equals("7")||s.substring(i+1,i+2).equals("8")||s.substring(i+1,i+2).equals("9"))
                {
                    if (s.substring(i+2,i+3).equals("0")||s.substring(i+2,i+3).equals("1")||s.substring(i+2,i+3).equals("2")||s.substring(i+2,i+3).equals("3")||s.substring(i+2,i+3).equals("4")||s.substring(i+2,i+3).equals("5")||s.substring(i+2,i+3).equals("6")||s.substring(i+2,i+3).equals("7")||s.substring(i+2,i+3).equals("8")||s.substring(i+2,i+3).equals("9"))
                    {
                        reacarr.add(Integer.parseInt(s.substring(i,i+3)));
                        reactants_elements.add(element);
                        element = "";
                        i += 2;
                    }
                    else
                    {
                        reacarr.add(Integer.parseInt(s.substring(i,i+2)));
                        reactants_elements.add(element);
                        element = "";
                        i++;
                    }
                }
                else {
                    temp = Integer.parseInt(let);
                    reacarr.add(temp);
                    reactants_elements.add(element);
                    element = "";
                    temp = 0;
                }
            }
            else if((let.toLowerCase()).compareTo(let) > 0)
            {
                element += let;
                if(i == s.length()-2)
                {
                    if(s.substring(s.length()-1).equals("2")||s.substring(s.length()-1).equals("3")||s.substring(s.length()-1).equals("4")||s.substring(s.length()-1).equals("5")||s.substring(s.length()-1).equals("6")||s.substring(s.length()-1).equals("7")||s.substring(s.length()-1).equals("8")||s.substring(s.length()-1).equals("9"))
                    {
                        reacarr.add(Integer.parseInt(s.substring(s.length()-1)));
                        reactants_elements.add(let);
                        getElements= false;
                    }
                    else
                    {
                        element += s.substring(s.length()-1);
                        reactants_elements.add(element);
                        reacarr.add(1);
                    }
                }
                else if(s.substring(i+1, i+2).compareTo(s.substring(i+1, i+2).toLowerCase()) != 0)
                {
//                    if(!re.substring(i+1,i+2).equals("2")||!re.substring(i+1,i+2).equals("3")||!re.substring(i+1,i+2).equals("4")||!re.substring(i+1,i+2).equals("5")||!re.substring(i+1,i+2).equals("6")||!re.substring(i+1,i+2).equals("7")||!re.substring(i+1,i+2).equals("8")||!re.substring(i+1,i+2).equals("9"))
//                    {
                    reacarr.add(1);
                    reactants_elements.add(element);
                    element = "";
//                    }
                }
            }
            else if(let.compareTo(let.toLowerCase()) == 0)
            {
                element += let;
                if(i == s.length()-2)
                {
                    if(s.substring(s.length()-1).equals("2")||s.substring(s.length()-1).equals("3")||s.substring(s.length()-1).equals("4")||s.substring(s.length()-1).equals("5")||s.substring(s.length()-1).equals("6")||s.substring(s.length()-1).equals("7")||s.substring(s.length()-1).equals("8")||s.substring(s.length()-1).equals("9"))
                    {
                        reacarr.add(Integer.parseInt(s.substring(s.length()-1)));
                        reactants_elements.add(let);
                    }
                    else
                    {
                        element += s.substring(s.length()-1);
                        reactants_elements.add(element);
                        reacarr.add(1);
                    }
                    getElements = false;
                }
                else if(!s.substring(i+1,i+2).equals("2")||s.substring(i+1,i+2).equals("3")||s.substring(i+1,i+2).equals("4")||s.substring(i+1,i+2).equals("5")||s.substring(i+1,i+2).equals("6")||s.substring(i+1,i+2).equals("7")||s.substring(i+1,i+2).equals("8")||s.substring(i+1,i+2).equals("9"))
                {
                    temp = 1;
                    reacarr.add(temp);
                    temp = 0;
                }
            }

            i++;
            if(i == s.length())
            {
                getElements = false;
            }
        }
    }

    //isolates compounds from initial input
    public void getrCompounds()
    {
        String reactant = reactants.getText().toString();
        String re = reactant.replaceAll("\\s+","");
        i = 0;
        while(getrc)
        {
            String let = re.substring(i, i+1);
            if(!let.equals("+"))
            {
                compound += let;
            }
            else
            {
                rcompounds.add(compound);
                this.a++;
                rcoeffs.add(1);
                compound = "";
            }
            i++;
            if(i == re.length())
            {
                rcompounds.add(compound);
                this.a++;
                rcoeffs.add(1);
                getrc = false;
            }
        }
        for(int a = 0; a < rcompounds.size(); a++)
        {
            String s = rcompounds.get(a);
            if (s.substring(0,1).equals("2")||s.substring(0,1).equals("3")||s.substring(0,1).equals("4")||s.substring(0,1).equals("5")||s.substring(0,1).equals("6")||s.substring(0,1).equals("7")||s.substring(0,1).equals("8")||s.substring(0,1).equals("9"))
            {
                String d = s.substring(1);
                s = d;
                rcompounds.remove(a);
                rcompounds.add(a, s);
                s = "";
            }
        }
        compound = "";
    }
    public void getpCompounds()
    {
        //may have to change compound to pCompound
        String p = products.getText().toString();
        String prod = p.replaceAll("\\s+","");
        i = 0;
        while(getpc)
        {
            String let = prod.substring(i, i+1);
            if(!let.equals("+"))
            {
                compound += let;
            }
            else
            {
                pcompounds.add(compound);
                this.a++;
                pcoeffs.add(1);
                compound = "";
            }
            i++;
            if(i == prod.length())
            {
                pcompounds.add(compound);
                this.a++;
                pcoeffs.add(1);
                getpc = false;
            }
        }
        //get rid of coefficients
        for(int a = 0; a < pcompounds.size(); a++)
        {
            String s = pcompounds.get(a);
            if (s.substring(0,1).equals("2")||s.substring(0,1).equals("3")||s.substring(0,1).equals("4")||s.substring(0,1).equals("5")||s.substring(0,1).equals("6")||s.substring(0,1).equals("7")||s.substring(0,1).equals("8")||s.substring(0,1).equals("9"))
            {
                String d = s.substring(1);
                s = d;
                pcompounds.remove(a);
                pcompounds.add(a, s);
                s = "";
            }
        }
    }

    //removes duplicates from ArrayLists
    public void removeReacDuplicates()
    {
        for(int a = 0; a<rcompounds.size(); a++)
        {
            for(int b = 0; b<rcompounds.size(); b++)
            {
                String dup = rcompounds.get(a);
                if(dup.equals(rcompounds.get(b)) && a != b)
                {
                    int dup1 = rcoeffs.get(a) + rcoeffs.get(b);
                    rcompounds.remove(b);
                    rcoeffs.remove(a);
                    rcoeffs.add(a, dup1);
                    rcoeffs.remove(b);
                }
            }
        }
    }
    public void removeProdDuplicates()
    {
        for(int a = 0; a<pcompounds.size(); a++)
        {
            for(int b = 0; b<pcompounds.size(); b++)
            {
                String dup = pcompounds.get(a);
                if(dup.equals(pcompounds.get(b)) && a != b)
                {
                    int dup1 = pcoeffs.get(a) + pcoeffs.get(b);
                    pcompounds.remove(b);
                    pcoeffs.remove(a);
                    pcoeffs.add(a, dup1);
                    pcoeffs.remove(b);
                }
            }
        }
    }
    //sometimes the outputs have "null" in them
    public String removeNull(String s)
    {
        for(int a = 0; a<s.length() - 4; a++)
        {
            if(s.substring(a, a+4).equals("null"))
            {
                s = s.substring(a+4);
            }
        }
        return s;
    }
    public void removeExcess(ArrayList<String> strings, ArrayList<Integer> arr)
    {
        for (int a = 0; a < strings.size(); a++)
        {
            for(int b = 0; b<strings.size(); b++)
            {
                String dup = strings.get(a);
                if(dup.equals(strings.get(b)))
                {
                    if(a != b)
                    {
                        int dup1 = arr.get(a) + arr.get(b);
                        strings.remove(b);
                        arr.remove(b);
                        arr.remove(a);
                        arr.add(a, dup1);
                    }
                }
            }
        }
    }
    public void setB()
    {
        getrCompounds();
        getpCompounds();
        removeReacDuplicates();
        removeProdDuplicates();
        this.b = rcompounds.size() + pcompounds.size();
        for (int i = 0; i<rcompounds.size(); i++)
        {
            getReacElements(rcompounds.get(i));
            removeReacDuplicates();
        }
        for(int i = 0; i<reactants_elements.size(); i++)
        {
            String temp = removeNull(reactants_elements.get(i));
            reactants_elements.remove(i);
            reactants_elements.add(i, temp);
        }
        for (int i = 0; i<pcompounds.size();  i++)
        {
            getProdElements(pcompounds.get(i));
            removeProdDuplicates();
        }
        for (int i = 0; i<products_elements.size(); i++)
        {
            String temp = removeNull(products_elements.get(i));
            products_elements.remove(i);
            products_elements.add(i, temp);
        }
        for (int i = 0; i<reactants_elements.size(); i++)
        {
            total.add(reactants_elements.get(i));
        }
        for (int i = 0; i<total.size(); i++)
        {
            dummy.add(0);
        }
        for (int i = 0; i<products_elements.size(); i++)
        {
            total.add(products_elements.get(i));
            dummy.add(0);
        }
        b = reactants_elements.size();
    }
    public void getElements(String compound, String element)
    {
        this.j = 0;
        int relement =  reactants_elements.size();
        int rnums = reacarr.size();
        int prodelement = products_elements.size();
        int pnums = prodarr.size();
//        removeDuplicates(reactants_elements, reacarr);
        while(reactants_elements.size() > 0)
        {
            reactants_elements.remove(0);
        }
        while(reacarr.size() > 0)
        {
            reacarr.remove(0);
        }
        while(products_elements.size()> 0)
        {
            products_elements.remove(0);
        }
        while(prodarr.size()>0)
        {
            prodarr.remove(0);
        }
        getReacElements(compound);
        for (int i = 0; i<reactants_elements.size(); i++)
        {
            for(int j = 0; j<reactants_elements.get(i).length() - 4; j++)
            {
                if(reactants_elements.get(i).substring(a, a+4).equals("null"))
                {
                    String s = reactants_elements.get(i);
                    s = s.substring(j+4);
                    reactants_elements.remove(i);
                    reactants_elements.add(i, s);
                }
            }
        }
        if (element.contains("ll"))
        {
            element = element.substring(element.indexOf("ll") + 2);
        }
        for (int i = 0; i<reactants_elements.size();i++)
        {
            if(reactants_elements.get(i).equals(element))
            {
                this.j = reacarr.get(i);
            }
        }
    }
    public int[] getNumOfElement(String compound, String element)
    {
        this.j = 0;
        int a = 0;
        removeReacDuplicates();
        for (int i = 0; i<reactants_elements.size();i++)
        {
            reactants_elements.remove(i);
        }
        for (int i = 0; i<products_elements.size(); i++)
        {
            products_elements.remove(i);
        }
        getReacElements(compound);
        for (int i = 0; i<reactants_elements.size();i++)
        {
            a = i;
            String temp = removeNull(reactants_elements.get(i));
            reactants_elements.remove(i);
            reactants_elements.add(i,temp);
            if(reactants_elements.get(i).equals(element))
            {
                this.j = reacarr.get(i);
            }
        }
        int arr[] = new int[2];
        arr[0] = a;
        arr[1] = this.j;
        return arr;
    }
    public void setMatrix()
    {
        setB();
        //maybe matrix = new double[this.a][this.b];
        matrix = new double[reactants_elements.size()][rcompounds.size() + pcompounds.size()];
        for (int j = 0; j<reactants_elements.size(); j++)
        {
            for (int i = 0; i<rcompounds.size(); i++)
            {
                getElements(rcompounds.get(i), total.get(j));
                matrix[j][i] = this.j;
            }
            for (int i = rcompounds.size(); i<rcompounds.size()+pcompounds.size(); i++)
            {
                getElements((pcompounds.get(i-rcompounds.size())), total.get(j));
                matrix[j][i] = -1 * this.j;
            }
        }
    }
    //use if you manipulate ArrayLists
    public void setBalancedEq()
    {
        setB();
        //maybe matrix = new double[this.a][this.b];
        for(int i = 0; i<rcompounds.size(); i++)
        {
            for(int a = 0; a<rcompounds.get(i).length() - 4; a++)
            {
                if(rcompounds.get(i).substring(a, a+4).equals("null"))
                {
                    String s = rcompounds.get(i);
                    s = s.substring(a+4);
                    rcompounds.remove(i);
                    rcompounds.add(i, s);
                }
            }
        }
        for(int i = 0; i<pcompounds.size(); i++)
        {
            for(int a = 0; a<pcompounds.get(i).length() - 4; a++)
            {
                if (pcompounds.get(i).substring(a, a + 4).equals("null"))
                {
                    String s = pcompounds.get(i);
                    s = s.substring(a + 4);
                }
            }
        }
        setMatrix();
        copy = matrix;
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        int sum4 = 0;
        int sum5  = 0;
        //changes matrix
        for (int i = 0; i<this.b; i++)
        {
            if (matrix.length == 1)
            {
                sum1 += matrix[0][i];
                while(sum1 != 0)
                {
                    double t = matrix[0][1]/matrix[0][0];
                    if (matrix[0][1] > matrix[0][0])
                    {
                        matrix[0][0] *= t;
                    }
                    else
                    {
                        matrix[0][1] *= t;
                    }
                }
            }
            else if (matrix.length == 2)
            {
                sum1 += matrix[0][i];
                Log.d("balanceEq", "i = " + i);
                sum2 += matrix[1][i];
            }
            else if (matrix.length == 3)
            {
                sum1 += matrix[0][i];
                sum2 += matrix[1][i];
                sum3 += matrix[2][i];
            }
            else if (matrix.length == 4)
            {
                sum1 += matrix[0][i];
                sum2 += matrix[1][i];
                sum3 += matrix[2][i];
                sum4 += matrix[3][i];
            }
            else if (matrix.length == 5)
            {
                sum1 += matrix[0][i];
                sum2 += matrix[1][i];
                sum3 += matrix[2][i];
                sum4 += matrix[3][i];
                sum5 += matrix[4][i];
            }
        }
        getrCompounds();
        getpCompounds();
        removeReacDuplicates();
        removeProdDuplicates();
        //sets balanced equation
        for(int i = 0; i<rcompounds.size()+pcompounds.size(); i++)
        {
            if(matrix.length == 1)
            {
                double coeff1 = matrix[0][0]/copy[0][0];
                double coeff2 = matrix[0][1]/copy[0][1];
                if (coeff1 != 1 && coeff2 != 1)
                {
                    balancedEQ = coeff1 + rcompounds.get(0) + "\u2192" + coeff2 + pcompounds.get(0);
                }
                else if (coeff1 == 1 && coeff2 != 1)
                {
                    balancedEQ = rcompounds.get(0)  + "\u2192" + coeff2 + pcompounds.get(0);
                }
                else if (coeff1 != 1 && coeff2 == 1)
                {
                    balancedEQ = coeff1 + rcompounds.get(0) + "\u2192" + pcompounds.get(0);
                }
                else if (coeff1 == 1 && coeff2 == 1)
                {
                    Toast.makeText(getActivity(), "The Equation is already Balanced!", Toast.LENGTH_LONG).show();
                }
            }
            else if (matrix.length == 2)
            {
                while(sum1 != 0 && sum2 != 0)
                {

                }
                balancedEQ = "";
            }
            else if (matrix.length == 3)
            {
                balancedEQ = "";
            }
            else if (matrix.length == 4)
            {
                balancedEQ = "";
            }
            else if (matrix.length == 5)
            {
                balancedEQ = "";
            }
        }
    }

    //make subscripts and superscripts while typing
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after)
    {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count)
    {

    }

    @Override
    public void afterTextChanged(Editable s)
    {
        String str = s.toString();

    }
    //Gaussian Elimination Algorithm


}