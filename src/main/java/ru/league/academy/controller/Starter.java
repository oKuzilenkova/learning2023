package ru.league.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ru.league.academy.service.NativeJdbcConnectionProvider;
import ru.league.academy.service.SpringJdbcConnectionProvider;

@Controller
public class Starter {

    @Autowired
    private NativeJdbcConnectionProvider nativeJdbcConnectionProvider;

    @Autowired
    private SpringJdbcConnectionProvider springJdbcConnectionProvider;

    public void run() {
        nativeJdbcConnectionProvider.printData();

        springJdbcConnectionProvider.printData();
    }
}
