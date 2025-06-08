package com.example.convertisseur.controller;

import com.example.convertisseur.dto.ConversionRequest;
import com.example.convertisseur.model.Conversion;
import com.example.convertisseur.service.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conversion")
public class ConversionController {

    @Autowired
    private ConversionService service;

    // POST /api/conversion  -> Conversion avec body JSON
    @PostMapping
    public ResponseEntity<Double> convert(@RequestBody ConversionRequest request) {
        double result = service.convert(request.getFrom(), request.getTo(), request.getAmount());
        return ResponseEntity.ok(result);
    }

    // GET /api/conversion/history -> Récupérer toutes les conversions sauvegardées
    @GetMapping("/history")
    public List<Conversion> getAllConversions() {
        return service.getAllConversions();
    }

    // GET /api/conversion/simple?from=EUR&to=USD&amount=10
    // Conversion simple sans passer par le service ni sauvegarde (méthode rapide)
    @GetMapping("/simple")
    public double simpleConvert(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam double amount
    ) {
        double rate = getConversionRate(from.toUpperCase(), to.toUpperCase());
        return amount * rate;
    }

    private double getConversionRate(String from, String to) {
        if (from.equals("EUR") && to.equals("USD")) return 1.1;
        if (from.equals("USD") && to.equals("EUR")) return 0.91;
        if (from.equals("EUR") && to.equals("XOF")) return 655.957;
        if (from.equals("XOF") && to.equals("EUR")) return 0.00152;
        if (from.equals("USD") && to.equals("XOF")) return 594.27;
        if (from.equals("XOF") && to.equals("USD")) return 0.00168;

        // Valeur par défaut si taux non trouvé
        return 1.0;
    }
}
