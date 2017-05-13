package com.application.kbros.gasprice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.mojLibPack.Lokacija;
import com.mojLibPack.Podatki;
import com.mojLibPack.Postaja;

import java.util.Date;

public class ActivityPostaja extends AppCompatActivity {

    ApplicationMy app;
    ImageView ivSlika;
    TextView edName;
    EditText edX;
    EditText edY;
    TextView tvDatum;
    Button save;
    Postaja p;
    String ID;
    String dc = "06:00 - 23:00";

    TextView Cena95;
    TextView Cena98;
    TextView Cena100;
    TextView CenaDiesel;
    TextView CenaPlin;

    public static String NEW_POSTAJA_ID="NEW_POSTAJA";

    TextView DelovniCas;
    private LocationUpdateReceiver dataUpdateReceiver;
    Location mLocation;
    private class LocationUpdateReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(GPSTracker.GPSTrackerEvent)) {
                mLocation = intent.getParcelableExtra(GPSTracker.GPSTrackerKeyLocation);
                app.setLastLocation(mLocation);
                System.out.println("Ali TTTdela 2"+ System.currentTimeMillis()+" "+mLocation.toString());
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postaja); //se ustvarijo vizualni objekti
        app = (ApplicationMy) getApplication();
        ivSlika =(ImageView) findViewById(R.id.imageView);
        //edX = (EditText) findViewById(R.id.editTextX);
        //edY = (EditText) findViewById(R.id.editTextY);
        edName = (TextView) findViewById(R.id.Naslov);
        Cena95 = (TextView) findViewById(R.id.cena95);
        Cena98 = (TextView) findViewById(R.id.cena98);
        Cena100 = (TextView) findViewById(R.id.cena100);
        CenaDiesel = (TextView) findViewById(R.id.cenaDiesel);
        CenaPlin = (TextView) findViewById(R.id.cenaPlin);
        DelovniCas = (TextView) findViewById(R.id.delovniCas);
        //tvDatum = (TextView) findViewById(R.id.textViewDatum);
       /* save = (Button) findViewById(R.id.buttonSave);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Klik Save");
            }
        }); */
        //update(app.getTestLocation());




    }

    void setPostaja(String ID) {
        p = app.getPostajaByID(ID);
        update(p);
    }

    public void onSave(View v) {
        System.out.println("Klik Save OnClick method");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Bundle extras = getIntent().getExtras();
        if(extras !=null)
        {
            setPostaja(extras.getString(Podatki.POSTAJA_ID));
        } else {
            System.out.println("Nič ni v extras!");
        }

        // l = app.getTestLocation();
        // update(l);
    }

    public void update(Postaja l) {
        //ivSlika
        //edX.setText(""+l.getX());
        //edY.setText(""+l.getY());
        edName.setText(p.getName());
        Cena95.setText(String.valueOf(p.getCena95()));
        Cena98.setText(String.valueOf(p.getCena98()));
        Cena100.setText(String.valueOf(p.getCena100()));
        CenaDiesel.setText(String.valueOf(p.getCenaDiesel()));
        CenaPlin.setText(String.valueOf(p.getCenaPlin()));
        DelovniCas.setText(dc);
        //tvDatum.setText(DataAll.dt.format(new Date(l.getDate())));

    }
    public void save() {
        System.out.println("Prej:"+p);
        p.setName(edName.getText().toString());
        //p.setLok(new Lokacija(edName.getText().toString(), Double.parseDouble(edX.getText().toString()), Double.parseDouble(edY.getText().toString())));
        p.setCena95(Double.parseDouble(Cena95.getText().toString()));
        p.setCena98(Double.parseDouble(Cena98.getText().toString()));
        p.setCena100(Double.parseDouble(Cena100.getText().toString()));
        p.setCenaDiesel(Double.parseDouble(CenaDiesel.getText().toString()));
        p.setCenaPlin(Double.parseDouble(CenaPlin.getText().toString()));
        System.out.println("Po:"+p);
        app.save();
    }

    /*
    public void onClickSaveMe(View v) {
        save();
        finish();
    }
    */
    public void onBackPressed() {
        System.out.println("NAZAJ + save");
        save();
        finish();
    };
}
