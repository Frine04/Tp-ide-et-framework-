package com.example.convertisseur.model;

import jakarta.persistence.*;

@Entity
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private double rateToEuro;

    // Constructeurs
    public Currency() {
    }

    public Currency(String code, double rateToEuro) {
        this.code = code;
        this.rateToEuro = rateToEuro;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getRateToEuro() {
        return rateToEuro;
    }

    public void setRateToEuro(double rateToEuro) {
        this.rateToEuro = rateToEuro;
    }
}
