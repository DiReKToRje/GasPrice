package com.application.kbros.gasprice;

import android.app.Application;
import android.location.Location;

import com.mojLibPack.Lokacija;
import com.mojLibPack.Podatki;
import com.mojLibPack.Postaja;

import java.io.File;
import java.util.List;

/**
 * Created by js on 13. 03. 2017.
 */

public class ApplicationMy extends Application {

    int x;
    Podatki all;
    private static final String DATA_MAP = "GasPriceData";
    private static final String FILE_NAME = "GasPrice.json";
    private Location mLastLocation;

    @Override
    public void onCreate() {
        super.onCreate();

        mLastLocation=null;
        x= 5;
        if (!load())
            all = Podatki.scenarijA();
    }
    public Location getLastLocation() {
        return mLastLocation;
    }

    public void setLastLocation(Location mLastLocation) {
        this.mLastLocation = mLastLocation;
    }
    public boolean hasLocation() {
        if (mLastLocation==null) return false;
        return true;
    }

    public int getX() {
        return x;
    }

    public Podatki getAll() {
        return  all;
    }

    public Postaja getTestPostaja() {
        return all.getPostaja(0);
    }

    public Postaja getNewPostaja(String name, String vzdevek, double cena95, double cena98, double cena100, double cenaDiesel, double cenaPlin, String imeLokacije, double X, double Y, String delovniCas) {
        return all.getNewPostaja(name, vzdevek, cena95, cena98, cena100, cenaDiesel, cenaPlin, imeLokacije, X, Y, delovniCas);
    }

    public Postaja getPostajaByID(String id) {
        return all.getPostajaByID(id);
    }

    public List<Postaja> getPostajeAll() {
        return all.getPostaje();
    }


    public boolean save() {
        File file = new File(this.getExternalFilesDir(DATA_MAP), ""
                + FILE_NAME);

        return ApplicationJson.save(all,file);
    }
    public boolean load(){
        File file = new File(this.getExternalFilesDir(DATA_MAP), ""
                + FILE_NAME);
        Podatki tmp = ApplicationJson.load(file);
        if (tmp!=null) all = tmp;
        else return false;
        return true;
    }
}
