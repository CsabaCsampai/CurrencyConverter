package com.example.CurrencyConverter.controller;

import com.example.CurrencyConverter.model.CurrencyRate;
import com.example.CurrencyConverter.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CurrencyRateController {

    private final CurrencyService currencyService;

    @Autowired
    public CurrencyRateController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    // Endpoint pre ziskanie zoznamu aktualnych kurzov
    @GetMapping("/currency/rates")
    public List<CurrencyRate> getAllCurrencyRates() {
        return currencyService.getAllCurrencyRates();
    }

    // Endpoint pre konverziu medzi menami
    // Parametre @RequestParam musia byt sucastou query stringu URL adresy poziadavky.
    @GetMapping("/currency/convert")
    public BigDecimal convertCurrency(@RequestParam String from, @RequestParam String to, @RequestParam BigDecimal amount) {
        return currencyService.convertCurrency(from, to, amount);
    }
}
