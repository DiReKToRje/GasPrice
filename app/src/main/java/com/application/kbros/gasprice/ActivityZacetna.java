package com.application.kbros.gasprice;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.mojLibPack.Podatki;
import com.mojLibPack.Postaja;

public class ActivityZacetna extends AppCompatActivity {
    ApplicationMy app;
    Spinner mySpin;
    Spinner mySpin2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        app = (ApplicationMy) getApplication();
        setContentView(R.layout.activity_zacetna);
        mySpin = (Spinner) findViewById(R.id.spinnerTest);
        mySpin2= (Spinner) findViewById(R.id.spinner2);
       // setSpinner();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Postaja l = app.getTestPostaja();
              //  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
               //         .setAction("Action", null).show();
                Intent i = new Intent(getBaseContext(), ActivityPostaja.class);
                i.putExtra(Podatki.POSTAJA_ID, app.getNewPostaja("PostajaTest","mojVzdevek",1.31, 1.33, 1.44, 1.29, 0.72, "Maribor Center", 53.223445, 31.222222, "01:00 - 22:00").getId());
                startActivity(i);
            }
        });
    }
    public void onClickOpen(View view){
       // Snackbar.make(view, "Izbral si xxx:" + mySpin.getSelectedItem().toString(), Snackbar.LENGTH_LONG)
       //         .setAction("Action", null).show();
        Intent i = new Intent(getBaseContext(), ActivityPostaja.class);
        i.putExtra(Podatki.POSTAJA_ID,  mySpin.getSelectedItem().toString());
        startActivity(i);

    }
    public void onClickOpen2(View view){
        // Snackbar.make(view, "Izbral si xxx:" + mySpin.getSelectedItem().toString(), Snackbar.LENGTH_LONG)
        //         .setAction("Action", null).show();
        Intent i = new Intent(getBaseContext(), ActivityPostaja.class);
        i.putExtra(Podatki.POSTAJA_ID,  ((Postaja)mySpin2.getSelectedItem()).getId());
        startActivity(i);

    }

    @Override
    protected void onResume() {
        super.onResume();
        setSpinner();
    }

    public void setSpinner() {
        ArrayAdapter<Postaja> dataAdapter2 = new ArrayAdapter<Postaja>(this, android.R.layout.simple_spinner_item, app.getPostajeAll());
        mySpin2.setAdapter(dataAdapter2);

        //ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, app.getListLocationID());
        mySpin.setAdapter(dataAdapter2);

        mySpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Snackbar.make(view, "Izbral si:" + mySpin.getAdapter().getItem(position), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }



}
