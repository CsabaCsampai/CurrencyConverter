package com.example.CurrencyConverter.service;

import com.example.CurrencyConverter.model.CurrencyRate;
import com.example.CurrencyConverter.repository.CurrencyRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {

    private final CurrencyRateRepository currencyRateRepository;

    @Autowired
    public CurrencyService(CurrencyRateRepository currencyRateRepository) {
        this.currencyRateRepository = currencyRateRepository;
    }

    // Metoda na ziskanie vsetkych kurzov
    public List<CurrencyRate> getAllCurrencyRates() {
        return currencyRateRepository.findAll();
    }

    // Metoda na konverziu sumy medzi dvoma menami
    public BigDecimal convertCurrency(String fromCurrency, String toCurrency, BigDecimal amount) {
        System.out.println("fromCurrency: " + fromCurrency);
        System.out.println("toCurrency: " + toCurrency);
        System.out.println("amount: " + amount);

        Optional<CurrencyRate> rateOptional = currencyRateRepository.findByFromCurrencyAndToCurrency(fromCurrency,toCurrency);
        System.out.println("rateOptional: " + rateOptional);

        if (rateOptional.isPresent()) {
            CurrencyRate currencyRate = rateOptional.get();
            System.out.println("currencyRate.getRate(): " + currencyRate.getRate());
            return amount.multiply(currencyRate.getRate());
        } else {
            throw new RuntimeException("Konverzny kurz pre dvojicu " + fromCurrency + " a " + toCurrency + "sa nenasiel.");
        }
    }
}
