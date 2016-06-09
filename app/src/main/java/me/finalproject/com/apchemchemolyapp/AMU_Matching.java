package me.finalproject.com.apchemchemolyapp;
import java.util.Scanner;
/**
 * Created by Vishnu on 5/30/2016.
 */
public class AMU_Matching
{
    public static void main(String[]args)
    {
        String[] elements = new String[118];
        elements[0] = "H";
        int[] amu = new int[118];
        amu[0] = 1;
        //Statement which asks to enter either a number or String
        Scanner kb = new Scanner(System.in);
        System.out.println("Please enter the CHEMICAL SYMBOL of the element (not full name)");
        // not sure whether to use XML for the display of this information and how to retrieve it if so
        String resp = kb.nextLine();
        String output = "";
        for(int i = 0; i<elements.length; i++)
        {
            if(elements[i].equals(resp))
            {
                output += amu[i] + "is the atomic mass number of "+resp;
                System.out.println(output);
            }
        }
        if(output.equals(""))
        {
            System.out.println("Sorry, your element does not exist :("+"\n"+"Please find the correct chemical symbol and try again");
        }
    }
}
