package com.application.kbros.gasprice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mojLibPack.Podatki;
import com.mojLibPack.Postaja;

public class ActivityList extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private LocationUpdateReceiver dataUpdateReceiver;
    Location mLocation;
    private class LocationUpdateReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(GPSTracker.GPSTrackerEvent)) {
                mLocation = intent.getParcelableExtra(GPSTracker.GPSTrackerKeyLocation);
                app.setLastLocation(mLocation);
                System.out.println("Ali dela "+ System.currentTimeMillis()+" "+mLocation.toString());
            }
        }
    }
    ApplicationMy app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        mRecyclerView = (RecyclerView) findViewById(R.id.myrecycleview);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        // specify an adapter (see also next example)
        app = (ApplicationMy) getApplication();
        mAdapter = new AdapterPostaja(app.getAll(), this);
        mRecyclerView.setAdapter(mAdapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab); //dej da gre na activity dodaj postajo pa pol ko vnese pa prtisne shrani doda postajo!
                                                                                  //preveri če so vsi podatki vneseni
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Postaja l = app.getTestPostaja();
                //  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //         .setAction("Action", null).show();
                Intent i = new Intent(getBaseContext(), ActivityPostajaDodaj.class);

                //i.putExtra(Podatki.POSTAJA_ID, ActivityPostaja.NEW_POSTAJA_ID);
                i.putExtra(Podatki.POSTAJA_ID, app.getNewPostaja("PostajaTest","mojVzdevek",1.31, 1.33, 1.44, 1.29, 0.72, "Maribor Center", 53.223445, 31.222222, "01:00 - 22:00").getId());
                startActivity(i);
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.notifyDataSetChanged();
        if (dataUpdateReceiver == null) dataUpdateReceiver = new LocationUpdateReceiver();
        IntentFilter intentFilter = new IntentFilter(GPSTracker.GPSTrackerEvent);
        registerReceiver(dataUpdateReceiver, intentFilter);
        startService(new Intent(app, GPSTracker.class));
    }

}
