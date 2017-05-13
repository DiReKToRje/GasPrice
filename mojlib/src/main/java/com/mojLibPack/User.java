package com.mojLibPack;

/**
 * Created by js on 27. 02. 2017.
 */

public class User {
    private String idUser; //mail (private)
    private String vzdevek;
    private int tocke;

    public User(String idUser, String vzdevek) {
        this.idUser = idUser;
        this.vzdevek = vzdevek;
        this.tocke = 0;
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

    //TOČKE
    public int getTocke() {
        return tocke;
    }

    public void setTocke(int tocke) {
        this.tocke = tocke;
    }

    @Override
    public String toString() {
        return "User --> " +
                "idUser/Mail='" + idUser + " - " +
                "Vzdevek='" + vzdevek + " - " +
                "Tocke='" + tocke + " " +
                "<--\n";
    }
}
