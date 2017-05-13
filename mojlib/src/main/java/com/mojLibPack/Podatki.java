package com.mojLibPack;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by js on 27. 02. 2017.
 */

public class Podatki {
    public static final String POSTAJA_ID = "Postaja_idXX";
    //format datuma
    public static SimpleDateFormat dt = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public ArrayList<Postaja> listaPostaj;
    //postaja ma lokacijo in verifikacijo, verifikacija ma tage

    public ArrayList<User> listaUserjev;
    //userji

    public Podatki() {
        listaPostaj = new ArrayList<>();
        listaUserjev = new ArrayList<>();
    }

    public Postaja dodajPostajo(String name, String idUser, String vzdevek, double cena95, double cena98, double cena100, double cenaDiesel, double cenaPlin, Lokacija lok, String delovniCas) {
        Date date = new Date();
        Postaja tmp = new Postaja(name, idUser, vzdevek, cena95, cena98, cena100, cenaDiesel, cenaPlin, date, lok, delovniCas);
        listaPostaj.add(tmp);
        return tmp;
    }


    public User dodajUserja(String id, String vzdevek) {
        User u = new User(id, vzdevek);
        listaUserjev.add(u);
        return u;
    }

    @Override
    public String toString() {
        return "Podatki --> \n" +
                "Uporabniki:\n" + listaUserjev + " - " +
                "\nPostaje:\n" + listaPostaj + " " +
                "\n<--";
    }

    public static Podatki scenarijA() {
        Podatki pod = new Podatki();
        Lokacija lok = new Lokacija("Glavna cesta 2", 43.335344, 66.426442);


        //*** Poprav da izpiše datum format!
        //OBVEZNO L NA KONCU!
        Date datum1=new Date(1265997124000L);
        Date datum2=new Date(1266125484000L);

        pod.listaUserjev.add(new User("neznan1@p.com", "unknown1"));
        pod.listaUserjev.add(new User("neznan2@p.com", "unknown2"));
        pod.listaUserjev.add(new User("neznan3@p.com", "unknown3"));

        pod.listaPostaj.add(new Postaja("OMV Maribor", pod.listaUserjev.get(1).getIdUser(), pod.listaUserjev.get(1).getVzdevek(), 1.23, 1.27, 1.31, 1.19, 0.62, datum1, lok, "06:00 - 23:00"));
        pod.listaPostaj.add(new Postaja("OMV MB", pod.listaUserjev.get(0).getIdUser(), pod.listaUserjev.get(0).getVzdevek(), 1.24, 1.31, 1.33, 1.11, 0.58, datum2, lok, "00:00 - 23:00"));
        pod.listaPostaj.add(new Postaja("Petrol MB", pod.listaUserjev.get(0).getIdUser(), pod.listaUserjev.get(0).getVzdevek(), 1.11, 2.22, 3.33, 4.44, 5.55, datum2, lok,"06:00 - 18:00"));
        pod.listaPostaj.add(new Postaja("Petrol Celje", pod.listaUserjev.get(0).getIdUser(), pod.listaUserjev.get(0).getVzdevek(), 5.55, 4.44, 3.33, 2.22, 1.11, datum2, lok, "04:00 - 24:00"));

        return pod;
    }

    public Postaja getPostaja(int i) {
        return listaPostaj.get(i);
    }

    public List<Postaja> getPostaje() {
        return listaPostaj;
    }

    public int getPostajeSize() {
        return listaPostaj.size();
    }

    public Postaja getNewPostaja(String name, String vzdevek, double cena95, double cena98, double cena100, double cenaDiesel, double cenaPlin, String imeLokacije, double X, double Y, String delovniCas) {
        return dodajPostajo(name, "1_ID-trenutni_user_1", vzdevek, cena95, cena98, cena100, cenaDiesel, cenaPlin, new Lokacija(imeLokacije,X,Y), delovniCas);
    }

    public Postaja getPostajaByID(String ID) {
        for (Postaja l: listaPostaj) { //TODO this solution is relatively slow! If possible don't use it!
            // if (l.getId() == ID) return l; //NAPAKA primerja reference
            if (l.getId().equals(ID)) return l;
        }
        return null;
    }
}
