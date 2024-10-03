package co.istad.demoliquibase.features.product;

import co.istad.demoliquibase.domain.Product;
import co.istad.demoliquibase.features.product.dto.CreateProductRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public void addProduct(CreateProductRequest request) {
        Product addedProduct = new Product();
        addedProduct.setName(request.name());
        addedProduct.setDescription(request.description());
        productRepository.save(addedProduct);
        log.info("Product added successfully: {}", addedProduct);
    }

    @Override
    public void deleteProductByName(String productName) {
        Product product = productRepository.findByName(productName);
        if (product != null) {
            productRepository.delete(product);
            log.info("Product deleted successfully: {}", productName);
        } else {
            log.warn("Product not found with name: {}", productName);
        }
    }

    @Override
    public Product getProductByName(String productName) {
        return productRepository.findByName(productName);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }
}
