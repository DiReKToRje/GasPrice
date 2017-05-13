package com.mojLibPack;

import java.util.Date;
import java.util.UUID;

/**
 * Created by js on 27. 02. 2017.
 */

public class Lokacija {
    String idLokacije;
    String name;

    public String getIdLokacije() {
        return idLokacije;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    double x, y; //GPS

    public Lokacija(String name, double x, double y) {
        this.idLokacije = UUID.randomUUID().toString().replaceAll("-", "");
        this.name = name;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Lokacija --> " +
                "id lokacije='" + idLokacije + " - " +
                "name='" + name + " - " +
                "GPS (x,y)=" + x +
                " : " + y + " " +
                "<--";
    }
}
