package ru.league.academy.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ru.league.academy.dto.Exchange;

@Component
public class NativeJdbcConnectionProvider {

    private static Connection getDbConnection() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/league_db", "admin", "qwerty$4");
        System.out.println("Connected to database");
        return conn;
    }

    public void printData(){
        List<Exchange> resList = new ArrayList<>();
        String sql = "select * from lab.exchange_rates where currency_code like ?";

        try(Connection conn = getDbConnection();
                PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, "H%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Exchange exchange = new Exchange();
                exchange.setCurrencyCode(rs.getString(2));
                exchange.setCost(rs.getBigDecimal("cost"));
                resList.add(exchange);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("NativeJdbcConnectionProvider");
        System.out.println(resList);
    }
}
