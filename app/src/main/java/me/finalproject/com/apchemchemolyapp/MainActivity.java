package me.finalproject.com.apchemchemolyapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.graphics.*;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        //load pictures for navigation bar
//        Bitmap quantum;
//        Bitmap stoich;
//        Bitmap thermo;
//        Bitmap bonding;
//        Bitmap gases;
//        Bitmap phases;
//        Bitmap kinetics;
//        Bitmap solutions;
//        Bitmap equilibrium;
//        Bitmap acid;
//        Bitmap electrochem;
//        Bitmap spectroscopy;
//        Bitmap complexes;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    public void PeriodicTable(View view)
    {
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, new periodic_fragment())
                .commit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        // Handle navigation view item clicks here.
        FragmentManager fragmentManager = getFragmentManager();
        int id = item.getItemId();
        if(id == R.id.nav_Acids)
        {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new acid_fragment())
                    .commit();
        }
        else if(id == R.id.nav_bonding)
        {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new bonding_fragment())
                    .commit();
        }
        else if(id == R.id.nav_Coordinate)
        {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new complexes_fragment())
                    .commit();
        }
        else if(id == R.id.nav_Electrochem)
        {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new electrochem_fragment())
                    .commit();
        }
        else if(id == R.id.nav_Equilibrium)
        {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new equilibrium_fragment())
                    .commit();
        }
        else if(id == R.id.nav_IdealGases)
        {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new gases_fragment())
                    .commit();
        }
        else if(id == R.id.nav_Kinetics)
        {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new kinetics_fragment())
                    .commit();
        }
        else if(id == R.id.nav_PhaseChanges)
        {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new phases_fragment())
                    .commit();
        }
        else if(id == R.id.nav_QuantumMechanics)
        {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new quantum_fragment())
                    .commit();
        }
        else if(id == R.id.nav_Solutions)
        {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new solutions_fragment())
                    .commit();
        }
        else if(id == R.id.nav_Spectroscopy)
        {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new spectroscopy_fragment())
                    .commit();
        }
        else if(id == R.id.nav_Stoichiometry)
        {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new stoich_fragment())
                    .commit();
        }
        else if(id == R.id.nav_thermodynamics)
        {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new thermo_fragment())
                    .commit();
        }
        else if(id == R.id.rate_law)
        {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new rLawCalc())
                    .commit();
        }
        else if(id == R.id.nav_BEQ)
        {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new stoich_fragment())
                    .commit();
        }
        else if(id == R.id.nav_sol_rule)
        {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new solrules_fragment())
                    .commit();
        }
        else if(id == R.id.nav_strong_acids)
        {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new acid_baselist())
                    .commit();
        }
        else if(id == R.id.nav_ox_rule)
        {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new oxstaterules())
                    .commit();
        }
        else if(id == R.id.nav_red_potentials)
        {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new redpotentials())
                    .commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
