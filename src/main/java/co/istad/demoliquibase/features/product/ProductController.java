package co.istad.demoliquibase.features.product;

import co.istad.demoliquibase.domain.Product;
import co.istad.demoliquibase.features.product.dto.CreateProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody CreateProductRequest request) {
        productService.addProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Product added successfully");
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteProductByName(@PathVariable("name") String productName) {
        productService.deleteProductByName(productName);
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully");
    }

    @GetMapping("/{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable("name") String productName) {
        Product product = productService.getProductByName(productName);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productService.getProducts();
        return ResponseEntity.ok(products);
    }
}
