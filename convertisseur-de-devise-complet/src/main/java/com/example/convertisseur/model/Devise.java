package com.example.convertisseur.model;

public class Devise {
    private String code;
    private String nom;
    private double tauxVersXof; 

    public Devise() {}

    public Devise(String code, String nom, double tauxVersXof) {
        this.code = code;
        this.nom = nom;
        this.tauxVersXof = tauxVersXof;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getTauxVersXof() {
        return tauxVersXof;
    }

    public void setTauxVersXof(double tauxVersXof) {
        this.tauxVersXof = tauxVersXof;
    }
}
