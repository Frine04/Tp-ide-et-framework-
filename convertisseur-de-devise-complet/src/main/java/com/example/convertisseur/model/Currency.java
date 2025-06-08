package com.example.convertisseur.model;

import jakarta.persistence.*;

@Entity
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String code;

    private String name;


    @Column(name = "rate_to_xof")
    private Double rateToXof;

    // === Getters et Setters ===

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRateToXof() {
        return rateToXof;
    }

    public void setRateToXof(Double rateToXof) {
        this.rateToXof = rateToXof;
    }
}
