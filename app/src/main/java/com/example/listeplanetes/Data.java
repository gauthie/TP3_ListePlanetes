package com.example.listeplanetes;

import java.util.ArrayList;

public class Data {
    private ArrayList<Planete> planetes;
    private String[] taillePlanetes;

    public Data(){
        this.planetes = new ArrayList<Planete>();
        this.planetes.add(new Planete("Mercure",null));
        this.planetes.add(new Planete("Venus",null));
        this.planetes.add(new Planete("Terre",null));
        this.planetes.add(new Planete("Mars",null));
        this.planetes.add(new Planete("Jupiter",null));
        this.planetes.add(new Planete("Saturne",null));
        this.planetes.add(new Planete("Uranus",null));
        this.planetes.add(new Planete("Neptune",null));
        this.planetes.add(new Planete("Pluton",null));
        this.taillePlanetes = new String[]{"4900", "12000", "12800", "6800", "144000", "120000", "52000", "50000", "2300"};
    }

    public Planete get(int position){
        return this.planetes.get(position);
    }

    public int size(){
        return this.planetes.size();
    }

    public String[] getTaillePlanete(){
        return this.taillePlanetes;
    }
}
