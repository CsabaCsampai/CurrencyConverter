package com.example.CurrencyConverter.service;

import com.example.CurrencyConverter.model.CurrencyRate;
import com.example.CurrencyConverter.repository.CurrencyRateRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class CurrencyServiceTest {
    @Autowired
    private CurrencyService currencyService;
    @Autowired
    private CurrencyRateRepository currencyRateRepository;

    @Mock
    private CurrencyRateRepository currencyRateRepositoryMock;

    @BeforeEach
    public void setUp() {
        currencyService = new CurrencyService(currencyRateRepository);
    }


    @Test
    void contextLoads() {
        assertNotNull(currencyService, "currencyService nemoze byt NULL! ");
        assertNotNull(currencyRateRepository, "currencyRateRepository nemoze byt NULL! ");
    }

    @Test
    void testLoadCurrencyRates() {
        // predpokladajme, ze v DB uz mame urcité kurzy
        List<CurrencyRate> rates = currencyRateRepository.findAll();
        assertFalse(rates.isEmpty(), "Kurzy by nemali byt prazdne! ");

        // overenie konkrétnych kurzov
        Optional<CurrencyRate> rate = currencyRateRepository.findById(String.valueOf(1));
        CurrencyRate currencyRate = rate.get();

        assertNotNull(currencyRate.getRate());
        assertEquals(BigDecimal.valueOf(0.920217171), currencyRate.getRate(), "Kurz je nespravny! ");
    }

    @Test
    void testCurrencyConversion() {
        // Test na metodu convertCurrency()
        // Overenie konverovanej sumy
        BigDecimal amount = new BigDecimal("100");
        BigDecimal expectedRate = new BigDecimal("92.3");// 92.0217171
        BigDecimal result = currencyService.convertCurrency("USD", "EUR", amount);
        assertEquals(expectedRate, result.stripTrailingZeros(), "Konvertovana suma nezodpoveda ocakavanej hodnote! ");
    }

    @Test
    void testInvalidCurrencyConversion() {
        // Nastavenie, aby pri hladani konverzie medzi "EUR" a "USD" vratilo Optional.empty()
        when(currencyRateRepositoryMock.findByFromCurrencyAndToCurrency("EUR", "USD")).thenReturn(Optional.empty());

        // Test, ci je vyvolana vynimka pri pokuse o konverziu s neexistujucim menovým párom
        assertThrows(RuntimeException.class, () -> {
            currencyService.convertCurrency("EUR", "USD", new BigDecimal("100"));
        }, "Vyvolana vynimka pre neplatny menovy par");
    }

    @Test
    public void testGetAllCurrencyRates() {
        // Test ci sa v zozname nachadza spravny pocet zaznamov - Test na metodu getAllCurrencyRates()
        List<CurrencyRate> result = currencyService.getAllCurrencyRates();
        assertEquals(60, result.size(), "Mal by vrátiť 60 záznamov.");
    }
}