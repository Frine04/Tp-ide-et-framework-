package com.example.convertisseur.service;

import com.example.convertisseur.model.Currency;
import com.example.convertisseur.model.*;
import com.example.convertisseur.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ConversionService {

    @Autowired
    private CurrencyRepository currencyRepo;

    @Autowired
    private ConversionRepository conversionRepo;

    public Double convert(String from, String to, Double amount) {
        Currency fromCurrency = currencyRepo.findByCode(from)
                .orElseThrow(() -> new RuntimeException("Devise source inconnue"));
        Currency toCurrency = currencyRepo.findByCode(to)
                .orElseThrow(() -> new RuntimeException("Devise cible inconnue"));

        double rate = toCurrency.getRateToEuro() / fromCurrency.getRateToEuro();
        double result = amount * rate;

        Conversion conversion = new Conversion();
        conversion.setFromCurrency(fromCurrency); // ✅ passe l’objet
        conversion.setToCurrency(toCurrency);     // ✅ passe l’objet
        conversion.setAmount(amount);
        conversion.setResult(result);
        conversion.setDate(LocalDateTime.now());

        conversionRepo.save(conversion);
        return result;
    }

    public List<Conversion> getAllConversions() {
        return conversionRepo.findAll();
    }
}
