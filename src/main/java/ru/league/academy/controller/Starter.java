package ru.league.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ru.league.academy.service.EntityManagerConnectionProvider;
import ru.league.academy.service.NativeJdbcConnectionProvider;
import ru.league.academy.service.SpringDataConnectionProvider;
import ru.league.academy.service.SpringJdbcConnectionProvider;

@Controller
public class Starter {

    @Autowired
    private NativeJdbcConnectionProvider nativeJdbcConnectionProvider;

    @Autowired
    private SpringJdbcConnectionProvider springJdbcConnectionProvider;

    @Autowired
    private SpringDataConnectionProvider springDataConnectionProvider;

    @Autowired
    private EntityManagerConnectionProvider entityManagerConnectionProvider;

    public void run() {
        nativeJdbcConnectionProvider.printData();

        springJdbcConnectionProvider.printData();

        entityManagerConnectionProvider.printData();

        springDataConnectionProvider.printData();


    }
}
