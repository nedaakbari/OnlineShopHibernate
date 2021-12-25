package model.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import model.enumeration.Category;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private double price;
    private String description;
    @Enumerated(EnumType.STRING)
    private Category category;
    private int available;
    public Product() {
    }

    @Override
    public String toString() {
        return ", price=" + price +
                ", available=" + available +
                ", description='" + description + '\'' +
                ", category=" + category;
    }

    public Product(double price, String description, Category category) {
        this.price = price;
        this.description = description;
        this.category = category;
    }
}
