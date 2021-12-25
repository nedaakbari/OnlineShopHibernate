package model.product;

import lombok.*;
import model.enumeration.Category;
import model.enumeration.ElectronicTypes;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@ToString(callSuper = true)
@AllArgsConstructor
@Entity
public class ElectronicDevices extends Product {
    private String model;
    private String manufacturer;
    @Enumerated(EnumType.STRING)
    private ElectronicTypes electronicTypes;


    @Builder
    public ElectronicDevices(int id, double price, String description, Category category, String model, String manufacturer, ElectronicTypes electronicTypes, int available) {
        super(id, price, description, category, available);
        this.model = model;
        this.manufacturer = manufacturer;
        this.electronicTypes = electronicTypes;
    }

    /*  @Builder
    public ElectronicDevices(double price, String description, Category category, String model, String manufacturer, ElectronicTypes electronicTypes) {
        super(price, description, category);
        this.model = model;
        this.manufacturer = manufacturer;
        this.electronicTypes = electronicTypes;
    }*/
}
