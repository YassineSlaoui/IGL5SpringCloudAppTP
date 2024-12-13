package tn.rnu.fst.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.rnu.fst.productservice.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
