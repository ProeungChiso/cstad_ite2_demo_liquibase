package co.istad.demoliquibase.features.product;

import co.istad.demoliquibase.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findByName(String name);
}
