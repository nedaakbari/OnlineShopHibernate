package model;

import lombok.Data;
import model.enumeration.CardState;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany(mappedBy = "card")
    private Set<CardItem> cardItems = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;
    private double totalCost;
    @CreationTimestamp
    private Date cartDate;
    @Enumerated(EnumType.STRING)
    private CardState cardState;

}