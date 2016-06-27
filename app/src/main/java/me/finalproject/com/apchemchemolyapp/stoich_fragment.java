package me.finalproject.com.apchemchemolyapp;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;


/**
 * Created by Shishir on 6/9/2016.
 */
public class stoich_fragment extends Fragment implements View.OnClickListener
{
    View rootview;
    int i = 0;
    ArrayList<Integer> arr = new ArrayList<>();
    ArrayList<String> elements = new ArrayList<>();
    boolean getElements = true;
    String s1;
    String element = "";
    EditText reactants;
    TextView beq;
    Button go;
    int temp;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        rootview = inflater.inflate(R.layout.stoich_layout, container, false);
        reactants = (EditText) rootview.findViewById(R.id.reactants);
        go = (Button) rootview.findViewById(R.id.button);
        go.setOnClickListener(this);
        return rootview;
    }
    public void onClick(View v)
    {
        getReactants(s1);
        beq = (TextView) rootview.findViewById(R.id.balanced_equation);
        beq.setText(s1);
    }
    public void getReactants(String s)
    {
        String reactant = reactants.getText().toString();
        //saying that reactants is null even after it went through the onCreateView method
        String re = reactant.replaceAll("\\s+","");
        while(getElements)
        {
            String let = re.substring(i, i+1);
            if(let.compareTo(let.toLowerCase()) > 0)
            {
                element += let;
                if(re.substring(i+1, i+2).compareTo(re.substring(i+1, i+2).toLowerCase()) != 0)
                {
                    if(!re.substring(i+1,i+2).equals("2")||re.substring(i+1,i+2).equals("3")||re.substring(i+1,i+2).equals("4")||re.substring(i+1,i+2).equals("5")||re.substring(i+1,i+2).equals("6")||re.substring(i+1,i+2).equals("7")||re.substring(i+1,i+2).equals("8")||re.substring(i+1,i+2).equals("9"))
                    {
                        temp = 1;
                        arr.add(temp);
                    }
                }
                i++;
                if(i == re.length())
                {
                    getElements = false;
                }
            }
            else if(let.compareTo(let.toLowerCase()) == 0)
            {
                element += let;
                if(!re.substring(i+1,i+2).equals("2")||re.substring(i+1,i+2).equals("3")||re.substring(i+1,i+2).equals("4")||re.substring(i+1,i+2).equals("5")||re.substring(i+1,i+2).equals("6")||re.substring(i+1,i+2).equals("7")||re.substring(i+1,i+2).equals("8")||re.substring(i+1,i+2).equals("9"))
                {
                    temp = 1;
                    arr.add(temp);
                }
                i++;
                if(i == re.length())
                {
                    getElements = false;
                }
            }
            else if (let.equals("2")||let.equals("3")||let.equals("4")||let.equals("5")||let.equals("6")||let.equals("7")||let.equals("8")||let.equals("9"))
            {
                temp = Integer.parseInt(let);
                arr.add(temp);
                elements.add(element);
                element = "";
                if(i == re.length())
                {
                    getElements = false;
                }
            }
        }
        // displays the elements isolated on the reactant side
        // to test to make sure my logic works
        for(int a = 0; a<elements.size(); a++)
        {
            s += (elements.get(a) + " : " + arr.get(a) + "\n");
        }
    }
}