package com.mojLibPack;

import java.util.Date;
import java.util.UUID;

/**
 * Created by js on 27. 02. 2017.
 */

public class Postaja {
    public Lokacija getLok() {
        return lok;
    }

    public void setLok(Lokacija lok) {
        this.lok = lok;
    }

    public Verification getVer() {
        return ver;
    }

    public void setVer(Verification ver) {
        this.ver = ver;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getVzdevek() {
        return vzdevek;
    }

    public void setVzdevek(String vzdevek) {
        this.vzdevek = vzdevek;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCena95() {
        return cena95;
    }

    public void setCena95(double cena95) {
        this.cena95 = cena95;
    }

    public double getCena98() {
        return cena98;
    }

    public void setCena98(double cena98) {
        this.cena98 = cena98;
    }

    public double getCena100() {
        return cena100;
    }

    public void setCena100(double cena100) {
        this.cena100 = cena100;
    }

    public double getCenaDiesel() {
        return cenaDiesel;
    }

    public void setCenaDiesel(double cenaDiesel) {
        this.cenaDiesel = cenaDiesel;
    }

    public double getCenaPlin() {
        return cenaPlin;
    }

    public void setCenaPlin(double cenaPlin) {
        this.cenaPlin = cenaPlin;
    }

    String name;

    //lokacija
    Lokacija lok;
    //verifikacija
    Verification ver = new Verification();
    Tag tag;

    String idUser; //kdo je dodal (private)
    String vzdevek; //kdo je dodal (public)
    double cena95; //cena na liter
    double cena98;
    double cena100;
    double cenaDiesel;
    double cenaPlin;
    Date date; //kdaj je dodal/spremenil
    String delovniCas;

    public Postaja(String name, String idUser, String vzdevek, double cena95, double cena98, double cena100, double cenaDiesel, double cenaPlin, Date date, Lokacija lok, String delovniCas) {
        this.id = UUID.randomUUID().toString().replaceAll("-", "");
        this.name = name;
        this.idUser = idUser;
        this.vzdevek = vzdevek;
        this.cena95 = cena95;
        this.cena98 = cena98;
        this.cena100 = cena100;
        this.cenaDiesel = cenaDiesel;
        this.cenaPlin = cenaPlin;
        this.date = date;
        this.lok = lok;
        this.tag = ver.getPreveri();
        this.delovniCas = delovniCas;
    }

    @Override
    public String toString() {
        return "Postaja --> " +
        "id='" + id + " - " +
        "name='" + name + " - " +
        "dodal/spremenil='" + idUser + " - " +
        "znan kot='" + vzdevek + " - " +
        "cena 95='" + cena95 + " - " + "cena 98='" + cena98 + " - " + "cena 100='" + cena100 + " - " + "cena Diesel='" + cenaDiesel + " - " + "cena Plin='" + cenaPlin + " - " +
        "zadnja sprememba=" + date + " " +
        "Delovni Čas=" + delovniCas + " " +
        "<--\n";
    }

}
