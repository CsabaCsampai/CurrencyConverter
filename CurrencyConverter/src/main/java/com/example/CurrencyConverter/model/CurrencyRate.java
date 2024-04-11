package com.example.CurrencyConverter.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class CurrencyRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fromCurrency;
    private String toCurrency;
    @Column(name = "rate", precision=15, scale=9)   /* Presnost cisel v DB*/
    private BigDecimal rate;

    public CurrencyRate(Long id, String fromCurrency, String toCurrency, BigDecimal rate) {
    }

    public CurrencyRate() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}
