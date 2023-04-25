package ru.league.academy.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ru.league.academy.entity.Exchange;

@Repository
public interface ExchangeRepository extends JpaRepository<Exchange, Long> {

    List<Exchange> findAllByCodeStartsWith(String firstLetters);

    @Query("select e from Exchange e where e.code like :code")
    List<Exchange> jpqlFindAllByCode(@Param("code") String code);

    @Query(value = "select * from lab.exchange_rates where currency_code like ? and cost = ?",
            nativeQuery = true)
    List<Exchange> nativeFindAllByCodeAndCost(String code, BigDecimal cost);
}
