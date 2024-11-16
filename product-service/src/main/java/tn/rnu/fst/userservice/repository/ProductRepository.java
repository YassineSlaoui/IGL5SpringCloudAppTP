package tn.rnu.fst.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.rnu.fst.userservice.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
