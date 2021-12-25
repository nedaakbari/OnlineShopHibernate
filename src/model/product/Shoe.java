package model.product;


import lombok.Builder;
import lombok.Data;
import model.enumeration.Category;
import model.enumeration.ShoeType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Entity
public class Shoe extends Product {
    private String model;
    private int size;
    @Enumerated(EnumType.STRING)
    private ShoeType shoeType;

    public Shoe() {
    }

    public Shoe(int id, double price, String description, Category category, int available) {
        super(id, price, description, category, available);
    }

    public Shoe(int id, double price, String description, Category category, String model, int size, ShoeType shoeType, int available) {
        super(id, price, description, category, available);
        this.model = model;
        this.size = size;
        this.shoeType = shoeType;
    }

    public Shoe(String model, int size, ShoeType shoeType) {
        this.model = model;
        this.size = size;
        this.shoeType = shoeType;
    }

    @Builder
    public Shoe(double price, String description, Category category, String model, int size, ShoeType shoeType) {
        super(price, description, category);
        this.model = model;
        this.size = size;
        this.shoeType = shoeType;
    }

    @Override
    public String toString() {
        return "Shoe{" + super.getId() +
                ", price= " + super.getPrice() +
                ", description= '" + super.getDescription() + '\'' +
                ", category= " + super.getCategory() +
                ", available= " + super.getAvailable() +
                "model='" + model + '\'' +
                ", size=" + size +
                ", shoeType=" + shoeType +
                '}';
    }
}
