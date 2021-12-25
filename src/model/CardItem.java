package model;

import lombok.Data;
import model.product.Product;

import javax.persistence.*;

@Data
@Entity
public class CardItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "card_Id")
    private Card card;

    private int count;

    @OneToOne
    private Product product;

    private double costOfItems;

    public CardItem() {
    }

    @Override
    public String toString() {
        return "CardItem{" +
                ", costOfItems=" + costOfItems +
                ", count=" + count +
                ", product=" + product +
                '}';
    }
}