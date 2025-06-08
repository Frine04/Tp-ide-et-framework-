package com.example.convertisseur.repository;

import com.example.convertisseur.model.Conversion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversionRepository extends JpaRepository<Conversion, Long> {
}
