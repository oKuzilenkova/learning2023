package ru.league.academy.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "exchange_rates", schema = "lab")
@NamedNativeQueries({
        @NamedNativeQuery(name = "usefulNativeQuery", query = "select * from lab.exchange_rates;")
})
@NamedQueries({
        @NamedQuery(name = "usefulQuery", query = "select e from Exchange e")
})
public class Exchange implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@SequenceGenerator(name = "id_generator", sequenceName = "id_seq", schema = "lab", allocationSize = 1)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    private Long id;
    @Column(name = "currency_code")
    private String code;
    @Column
    private BigDecimal cost;

    @Override
    public String toString(){
        return code + " : " + cost;
    }
}
