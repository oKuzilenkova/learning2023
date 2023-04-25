package ru.league.academy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.league.academy.entity.Exchange;
import ru.league.academy.repository.ExchangeRepository;

@Component
public class SpringDataConnectionProvider {

    @Autowired
    private ExchangeRepository repository;

    public void printData(){
        List<Exchange> resList = repository.findAllByCodeStartsWith("H");

        System.out.println("SpringDataConnectionProvider");
        System.out.println(resList);
    }

}
