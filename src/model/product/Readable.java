package model.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import model.enumeration.Category;
import model.enumeration.ReadingTypes;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@ToString(callSuper = true)
@AllArgsConstructor
@Entity
public class Readable extends Product {
    private String publisherName;
    private String authorName;
    private String genre;
    private String title;
    @Enumerated(EnumType.STRING)
    private ReadingTypes readingTypes;
    private int page;


    @Builder(setterPrefix = "with")
    public Readable(double price, String description, Category category, String publisherName, String authorName, String genre, String title, ReadingTypes readingTypes, int page) {
        super(price, description, category);
        this.publisherName = publisherName;
        this.authorName = authorName;
        this.genre = genre;
        this.title = title;
        this.readingTypes = readingTypes;
        this.page = page;
    }
}
