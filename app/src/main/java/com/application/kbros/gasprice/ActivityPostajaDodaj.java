package com.application.kbros.gasprice;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.EditText;

import com.mojLibPack.Lokacija;
import com.mojLibPack.Podatki;
import com.mojLibPack.Postaja;

/**
 * Created by js on 11. 04. 2017.
 */

public class ActivityPostajaDodaj extends AppCompatActivity {
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
        setContentView(R.layout.activity_dodaj_postajo); //se ustvarijo vizualni objekti
        app = (ApplicationMy) getApplication();
        ivSlika =(ImageView) findViewById(R.id.imageView);
        //edX = (EditText) findViewById(R.id.editTextX);
        //edY = (EditText) findViewById(R.id.editTextY);
        edName = (EditText) findViewById(R.id.Naslov);
        Cena95 = (EditText) findViewById(R.id.cena95);
        Cena98 = (EditText) findViewById(R.id.cena98);
        Cena100 = (EditText) findViewById(R.id.cena100);
        CenaDiesel = (EditText) findViewById(R.id.cenaDiesel);
        CenaPlin = (EditText) findViewById(R.id.cenaPlin);
        DelovniCas = (EditText) findViewById(R.id.delovniCas);
        save = (Button) findViewById(R.id.dodaj);



        //tvDatum = (TextView) findViewById(R.id.textViewDatum);
       /* save = (Button) findViewById(R.id.buttonSave);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Klik Save");
            }
        }); */
        //update(app.getTestLocation());

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
                finish();
            }
        });



    }

    void setPostaja(String ID) {
        p = app.getPostajaByID(ID);
        //update(p);
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
        edName.setText("Ime/Naslov");
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
        //shrani lokacijo
        if (mLocation!=null)
        p.setLok(new Lokacija(edName.getText().toString(), mLocation.getLatitude(), mLocation.getLongitude()));

        System.out.println("Po:"+p);
        app.save();
    }

    /*
    public void onClickSaveMe(View v) {
        save();
        finish();
    }
    */
    @Override
    public void onBackPressed() {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
        localBuilder.setMessage("Nadaljujem brez shranjevanja?");
        localBuilder.setTitle("Dodane informacije ne bodo shranjene!");
        localBuilder.setNegativeButton("DA", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                finish();
            }
        });
        localBuilder.setPositiveButton("NE!", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                return;
            }
        });
        localBuilder.show();
        return;
    }
}
