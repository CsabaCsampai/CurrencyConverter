package com.example.CurrencyConverter.repository;

import com.example.CurrencyConverter.model.CurrencyRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyRateRepository extends JpaRepository<CurrencyRate, String> {

     Optional<CurrencyRate> findByFromCurrencyAndToCurrency(String fromCurrency, String toCurrency);
}
