package com.mojLibPack;

import java.util.ArrayList;

/**
 * Created by js on 27. 02. 2017.
 */

public class Verification {
    private ArrayList<Tag> list;

    public Verification() {
        list = new ArrayList<>();
        list.add(new Tag("Preverjeno!"));
        list.add(new Tag("Napačna informacija!"));
        list.add(new Tag("Potrebno preveriti!"));

    }

    @Override
    public String toString() {
        return "Verifikacije --> "  +
                "list=" + list + " " +
                "<--";
    }

    public Tag getJePreverjeno() {
        return list.get(0);
    }
    public Tag getNapacnaInfo() {
        return list.get(1);
    }
    public Tag getPreveri() {
        return list.get(2);
    }
}
