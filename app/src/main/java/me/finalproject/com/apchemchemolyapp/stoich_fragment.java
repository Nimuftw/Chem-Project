package me.finalproject.com.apchemchemolyapp;

import android.app.Fragment;
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
    ArrayList<String> reactants_elements = new ArrayList<>();
    ArrayList<String> products_elements = new ArrayList<>();
    ArrayList<String> rcompounds = new ArrayList<>();
    ArrayList<String> pcompounds = new ArrayList<>();
    boolean getElements = true;
    String relement;
    String pelement;
    String compound;
    boolean getrc = true;
    boolean getpc = true;
    String element = "";
    EditText reactants;
    EditText products;
    TextView beq;
    Button go;
    String balancedeq;
    int temp;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        rootview = inflater.inflate(R.layout.stoich_layout, container, false);
        reactants = (EditText) rootview.findViewById(R.id.reactants);
        products = (EditText) rootview.findViewById(R.id.products);
        go = (Button) rootview.findViewById(R.id.button);
        go.setOnClickListener(this);
        return rootview;
    }
    public void onClick(View v)
    {
        getpCompounds();
        beq = (TextView) rootview.findViewById(R.id.balanced_equation);
        //have to create many methods to achieve
//        beq.setText(balancedeq);
        beq.setText(balancedeq);
    }
    //Can I use this to isolate individual elements from each reactant/product?
    //Will be more simple alternative to what we currently have
    public void getReactants()
    {
        String reactant = reactants.getText().toString();
        String re = reactant.replaceAll("\\s+","");
        while(getElements)
        {
            if(re.length() == 1)
            {
                reactants_elements.add(re);
                arr.add(1);
                getElements = false;
            }
            String let = re.substring(i, i+1);
            if (let.equals("2")||let.equals("3")||let.equals("4")||let.equals("5")||let.equals("6")||let.equals("7")||let.equals("8")||let.equals("9"))
            {
                if(i == re.length()-2)
                {
                    reactants_elements.add(element);
                    arr.add(Integer.parseInt(let));
                    reactants_elements.add(re.substring(re.length()-1));
                    arr.add(1);
                    getElements = false;
                }
                else
                {
                    temp = Integer.parseInt(let);
                    arr.add(temp);
                    reactants_elements.add(element);
                    element = "";
                    temp = 0;
                }
            }
            else if((let.toLowerCase()).compareTo(let) > 0)
            {
                element += let;
                if(i == re.length()-2)
                {
                    if(re.substring(re.length()-1).equals("2")||re.substring(re.length()-1).equals("3")||re.substring(re.length()-1).equals("4")||re.substring(re.length()-1).equals("5")||re.substring(re.length()-1).equals("6")||re.substring(re.length()-1).equals("7")||re.substring(re.length()-1).equals("8")||re.substring(re.length()-1).equals("9"))
                    {
                        arr.add(Integer.parseInt(re.substring(re.length()-1)));
                        reactants_elements.add(let);
                        getElements= false;
                    }
                    else
                    {
                        element += re.substring(re.length()-1);
                        reactants_elements.add(element);
                        arr.add(1);
                    }
                }
                else if(re.substring(i+1, i+2).compareTo(re.substring(i+1, i+2).toLowerCase()) != 0)
                {
//                    if(!re.substring(i+1,i+2).equals("2")||!re.substring(i+1,i+2).equals("3")||!re.substring(i+1,i+2).equals("4")||!re.substring(i+1,i+2).equals("5")||!re.substring(i+1,i+2).equals("6")||!re.substring(i+1,i+2).equals("7")||!re.substring(i+1,i+2).equals("8")||!re.substring(i+1,i+2).equals("9"))
//                    {
                        arr.add(1);
                        reactants_elements.add(element);
                        element = "";
//                    }
                }
            }
            else if(let.compareTo(let.toLowerCase()) == 0)
            {
                element += let;
                if(i == re.length()-2)
                {
                    if(re.substring(re.length()-1).equals("2")||re.substring(re.length()-1).equals("3")||re.substring(re.length()-1).equals("4")||re.substring(re.length()-1).equals("5")||re.substring(re.length()-1).equals("6")||re.substring(re.length()-1).equals("7")||re.substring(re.length()-1).equals("8")||re.substring(re.length()-1).equals("9"))
                    {
                        arr.add(Integer.parseInt(re.substring(re.length()-1)));
                        reactants_elements.add(let);
                    }
                    else
                    {
                        element += re.substring(re.length()-1);
                        reactants_elements.add(element);
                        arr.add(1);
                    }
                    getElements = false;
                }
                else if(!re.substring(i+1,i+2).equals("2")||re.substring(i+1,i+2).equals("3")||re.substring(i+1,i+2).equals("4")||re.substring(i+1,i+2).equals("5")||re.substring(i+1,i+2).equals("6")||re.substring(i+1,i+2).equals("7")||re.substring(i+1,i+2).equals("8")||re.substring(i+1,i+2).equals("9"))
                {
                    temp = 1;
                    arr.add(temp);
                    temp = 0;
                }
            }

            i++;
            if(i == re.length())
            {
                getElements = false;
            }
        }
        // displays the elements isolated on the reactant side
        // to test to make sure my logic works
        rDuplicates();
        for(int a = 0; a<reactants_elements.size(); a++)
        {
            relement += (reactants_elements.get(a) + " : " + arr.get(a) + "\n");
        }
    }
    public void getProducts()
    {
        String p = products.getText().toString();
        //can take input right here
        String prod = p.replaceAll("\\s+","");
        while(getElements)
        {
            String let = prod.substring(i, i+1);
            if(let.compareTo(let.toLowerCase()) > 0)
            {
                element += let;
                if(i == prod.length()-1 || i == prod.length())
                {
                    products_elements.add(element);
                    if(prod.substring(prod.length()-1).equals("2")||prod.substring(prod.length()-1).equals("3")||prod.substring(prod.length()-1).equals("4")||prod.substring(prod.length()-1).equals("5")||prod.substring(prod.length()-1).equals("6")||prod.substring(prod.length()-1).equals("7")||prod.substring(prod.length()-1).equals("8")||prod.substring(prod.length()-1).equals("9"))
                    {
                        arr.add(Integer.parseInt(prod.substring(prod.length()-1)));
                    }
                    else
                    {
                        arr.add(1);
                        products_elements.add(prod.substring(prod.length()-1));
                        arr.add(1);
                    }
                    getElements = false;
                }
                else if(prod.substring(i+1, i+2).compareTo(prod.substring(i+1, i+2).toLowerCase()) != 0)
                {
                    if(!prod.substring(i+1,i+2).equals("2")||!prod.substring(i+1,i+2).equals("3")||!prod.substring(i+1,i+2).equals("4")||!prod.substring(i+1,i+2).equals("5")||!prod.substring(i+1,i+2).equals("6")||!prod.substring(i+1,i+2).equals("7")||!prod.substring(i+1,i+2).equals("8")||!prod.substring(i+1,i+2).equals("9"))
                    {
                        temp = 1;
                        arr.add(temp);
                    }
                }
            }
            else if(let.compareTo(let.toLowerCase()) == 0)
            {
                element += let;
                if(i == prod.length()-1 || i == prod.length())
                {
                    products_elements.add(element);
                    if(prod.substring(prod.length()-1).equals("2")||prod.substring(prod.length()-1).equals("3")||prod.substring(prod.length()-1).equals("4")||prod.substring(prod.length()-1).equals("5")||prod.substring(prod.length()-1).equals("6")||prod.substring(prod.length()-1).equals("7")||prod.substring(prod.length()-1).equals("8")||prod.substring(prod.length()-1).equals("9"))
                    {
                        arr.add(Integer.parseInt(prod.substring(prod.length()-1)));
                    }
                    else
                    {
                        arr.add(1);
                        products_elements.add(prod.substring(prod.length()-1));
                        arr.add(1);
                    }
                    getElements = false;
                }
                else if(!prod.substring(i+1,i+2).equals("2")||prod.substring(i+1,i+2).equals("3")||prod.substring(i+1,i+2).equals("4")||prod.substring(i+1,i+2).equals("5")||prod.substring(i+1,i+2).equals("6")||prod.substring(i+1,i+2).equals("7")||prod.substring(i+1,i+2).equals("8")||prod.substring(i+1,i+2).equals("9"))
                {
                    temp = 1;
                    arr.add(temp);
                }
            }
            else if (let.equals("2")||let.equals("3")||let.equals("4")||let.equals("5")||let.equals("6")||let.equals("7")||let.equals("8")||let.equals("9"))
            {
                temp = Integer.parseInt(let);
                arr.add(temp);
                products_elements.add(element);
                element = "";
            }
            i++;
            if(i == prod.length()+1)
            {
                getElements = false;
            }
        }
        // displays the elements isolated on the reactant side
        // to test to make sure my logic works
        for(int a = 0; a<products_elements.size(); a++)
        {
            p += (products_elements.get(a) + " : " + arr.get(a) + "\n");
        }
    }
    public void getrCompounds()
    {
        String reactant = reactants.getText().toString();
        String re = reactant.replaceAll("\\s+","");
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
                compound = "";
            }
            i++;
            if(i == re.length())
            {
                pcompounds.add(compound);
                getpc = false;
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
                compound = "";
            }
            i++;
            if(i == prod.length())
            {
                pcompounds.add(compound);
                getpc = false;
            }
        }
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
    public void rDuplicates()
    {
        for(int a = 0; a<reactants_elements.size(); a++)
        {
            for(int b = 0; b<reactants_elements.size(); b++)
            {
                String dup = reactants_elements.get(a);
                if(dup.equals(reactants_elements.get(b)))
                {
                    if(a != b)
                    {
                        int dup1 = arr.get(a) + arr.get(b);
                        reactants_elements.remove(b);
                        arr.remove(a);
                        arr.add(a, dup1);

                    }
                }
            }
        }
    }

    public void removeNull()
    {
        for(int a = 0; a<balancedeq.length() - 4; a++)
        {
            if(balancedeq.substring(a, a+4).equals("null"))
            {
                balancedeq = balancedeq.substring(a+4);
            }
        }
    }
}