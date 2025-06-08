package com.example.convertisseur.service;

import com.example.convertisseur.model.Currency;
import com.example.convertisseur.model.Conversion;
import com.example.convertisseur.repository.CurrencyRepository;
import com.example.convertisseur.repository.ConversionRepository;
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
        // Récupère les devises source et cible
        Currency fromCurrency = currencyRepo.findByCode(from)
                .orElseThrow(() -> new RuntimeException("Devise source inconnue"));
        Currency toCurrency = currencyRepo.findByCode(to)
                .orElseThrow(() -> new RuntimeException("Devise cible inconnue"));


        if (fromCurrency.getRateToXof() == null || toCurrency.getRateToXof() == null) {
            throw new RuntimeException("Taux de conversion (par rapport au XOF) manquant pour une des devises.");
        }

        double rate = toCurrency.getRateToXof() / fromCurrency.getRateToXof();
        double result = amount * rate;

        // Sauvegarde la conversion
        Conversion conversion = new Conversion();
        conversion.setFromCurrency(fromCurrency);
        conversion.setToCurrency(toCurrency);
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
