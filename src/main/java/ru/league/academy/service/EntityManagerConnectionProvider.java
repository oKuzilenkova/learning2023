package ru.league.academy.service;

import java.util.List;

import org.springframework.stereotype.Component;

import ru.league.academy.entity.Exchange;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Component
public class EntityManagerConnectionProvider {

    @PersistenceContext
    EntityManager em;

    public void printData(){
        String sql = "select e from Exchange e where e.code like :code";

        TypedQuery<Exchange> typedQuery = em.createQuery(sql, Exchange.class);
        typedQuery.setParameter("code", "H%");
        List<Exchange> resList = typedQuery.getResultList();

/*
        String sqlNative = "select * from lab.exchange_rates where currency_code like ?";
        Query query = em.createNativeQuery(sqlNative, Exchange.class);
        query.setParameter(1, "H%");

        List<Exchange> resList = query.getResultList();

*/

/*        Query query = em.createNamedQuery("usefulQuery");
        List<Exchange> resList = query.getResultList();*/

        System.out.println("EntityManagerConnectionProvider");
        System.out.println(resList);
    }
}
