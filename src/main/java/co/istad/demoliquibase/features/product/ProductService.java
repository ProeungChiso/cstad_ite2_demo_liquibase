package co.istad.demoliquibase.features.product;

import co.istad.demoliquibase.domain.Product;
import co.istad.demoliquibase.features.product.dto.CreateProductRequest;

import java.util.List;

public interface ProductService {
    void addProduct(CreateProductRequest request);
    void deleteProductByName(String productName);
    Product getProductByName(String productName);
    List<Product> getProducts();
}
