package dto;

import model.enumeration.Category;

public class CardDto {
    private Category productCategory;
    private double totalCostOfEachProduct;
    private double totalCost;
    private int id;
    private int count;

    public CardDto(Category productCategory, double totalCostOfEachProduct, double totalCost, int id, int count) {
        this.productCategory = productCategory;
        this.totalCostOfEachProduct = totalCostOfEachProduct;
        this.totalCost = totalCost;
        this.id = id;
        this.count = count;
    }
}
