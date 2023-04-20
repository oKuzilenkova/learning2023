package ru.league.academy.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import ru.league.academy.dto.Exchange;

@Component
public class SpringJdbcConnectionProvider {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void printData() {
        String sql = "select * from lab.exchange_rates where currency_code like ?";

        ExchangeMapper mapper = new ExchangeMapper();
        List<Exchange> resList = jdbcTemplate.query(sql, mapper, "H%");

        System.out.println("SpringJdbcConnectionProvider");
        System.out.println(resList);
    }

    private static class ExchangeMapper implements RowMapper<Exchange> {

        @Override
        public Exchange mapRow(ResultSet rs, int rowNum) throws SQLException {
            Exchange exchange = new Exchange();
            exchange.setCurrencyCode(rs.getString(2));
            exchange.setCost(rs.getBigDecimal("cost"));
            return exchange;
        }
    }

}
