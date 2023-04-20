package ru.league.academy.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Exchange {
    private String currencyCode;
    private BigDecimal cost;

    @Override
    public String toString(){
        return currencyCode + " : " + cost;
    }

}
