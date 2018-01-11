package fr.clbonnefoy1.projet_if26_android;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ArrayList<Logement> logements;

    private ListView lv_logements;

    private Context mContext;

    private LinearLayout mRootView;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mContext = this;

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_ajouter_annonce);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DeposerLogement.class);
                startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

       ModulePersistance mp = new ModulePersistance(this);
/*
        ArrayList<Proprietaire> liste_p = Proprietaire.getInitialProprietaires();
        for (Proprietaire p : liste_p) {
            mp.addProprietaire(p);
        }

        ArrayList<Logement> liste = Logement.getInitialLogements();

        for (Logement l: liste) {
            mp.addLogement(l);
        }
*/
        lv_logements = (ListView) findViewById(R.id.lv_logements);

        logements = mp.getAllLogements();

        LogementsAdapter la = new LogementsAdapter(this,
                R.layout.listview_item_logement,
                logements);

        lv_logements.setAdapter(la);

        lv_logements.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Logement l = logements.get(position);

                Intent intent = new Intent(mContext, Details.class);
                intent.putExtra("label", l.getLabel());
                startActivity(intent);

            }
        });

        mRootView = (LinearLayout) findViewById(R.id.linearLayout);
        Snackbar.make(mRootView, String.format("%d annonces", mp.getLogementCount()), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            Intent intent = new Intent(this, Parametres.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_annonces) {
            // Handle the camera action
        } else if (id == R.id.nav_carte) {

            Intent intent = new Intent(this, MapsActivity.class);
            startActivity(intent);


        } else if (id == R.id.nav_deposer) {

            Intent intent = new Intent(this, DeposerLogement.class);
            startActivity(intent);

        } else if (id == R.id.nav_aide) {
            Intent intent = new Intent(this, Aide.class);
            startActivity(intent);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
