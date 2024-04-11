package com.example.CurrencyConverter.repository;

import com.example.CurrencyConverter.model.CurrencyRate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class CurrencyRateRepositoryTest {

    @Autowired
    private CurrencyRateRepository repository;


    @Test
    public void testFindByFromCurrencyAndToCurrency() {
        // Vyhlada zaznam na zaklade mien a overi, ci vrateny objekt ma ocakavanu hodnotu
        Optional<CurrencyRate> found = repository.findByFromCurrencyAndToCurrency("USD", "EUR");

        assertThat(found.get().getFromCurrency()).isEqualTo("USD");
        assertThat(found.get().getToCurrency()).isEqualTo("EUR");
        assertThat(found.get().getRate()).isEqualByComparingTo("0.920217171");
    }
}
