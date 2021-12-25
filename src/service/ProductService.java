package service;

import dao.ProductDao;
import model.enumeration.Category;
import model.product.Product;

import java.util.List;

public class ProductService {
    ProductDao productDao = new ProductDao();

    public void save(Product product) {
        productDao.save(product);
    }
    public void update(Product product) {
        productDao.update(product);
    }

    public Product find(int id){
        return productDao.findById(id);
    }
    public List<Product> getAllThisType(Category category){
        return productDao.getAllThisType(category);
    }
}
