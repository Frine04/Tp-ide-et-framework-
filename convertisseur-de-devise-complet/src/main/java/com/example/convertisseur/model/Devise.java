package com.example.convertisseur.model;

public class Devise {
    private String code;
    private String nom;
    private double tauxVersEuro;

    public Devise() {}

    public Devise(String code, String nom, double tauxVersEuro) {
        this.code = code;
        this.nom = nom;
        this.tauxVersEuro = tauxVersEuro;
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

    public double getTauxVersEuro() {
        return tauxVersEuro;
    }

    public void setTauxVersEuro(double tauxVersEuro) {
        this.tauxVersEuro = tauxVersEuro;
    }
}
