package com.example.convertisseur.dto;

public class ConversionRequest {
    private String from;
    private String to;
    private Double amount;

    // Constructeur vide
    public ConversionRequest() {}

    // Getters
    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public Double getAmount() {
        return amount;
    }

    // Setters
    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
