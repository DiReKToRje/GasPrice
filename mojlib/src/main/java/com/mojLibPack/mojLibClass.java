package com.mojLibPack;

public class mojLibClass {
    public static void main(String args[]){
        System.out.println("CHEAP GAS!!!");
        //Verification ver = new Verification();
        //System.out.println(ver.toString());
        Podatki podatki = Podatki.scenarijA();
        System.out.println(podatki);
        System.out.println("--------------------------------------------------------------------");
        podatki.dodajPostajo("Petrol MB", "novo@dodani.sem", "newGuy",1.22, 1.23, 1.24, 1.25, 1.26, new Lokacija("Tuki bliz", 44.434332, 61.222341), "06:00 - 23:00");
        System.out.println(podatki);
    }
}
