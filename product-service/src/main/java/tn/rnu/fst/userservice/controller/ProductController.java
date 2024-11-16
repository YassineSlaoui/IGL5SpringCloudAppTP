package tn.rnu.fst.userservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.rnu.fst.userservice.entity.Product;
import tn.rnu.fst.userservice.service.ProductService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService; // Injection du service produit

    /**
     * Endpoint pour récupérer tous les produits.
     * Méthode: GET
     * URL: http://localhost:8081/products
     */
    @GetMapping
    @CircuitBreaker(name = "productService")
    public List<Product> getAllProducts() {
        // Retourner tous les produits
        return productService.getAllProducts();
    }

    /**
     * Endpoint pour récupérer un produit par ID.
     * Méthode: GET
     * URL: http://localhost:8081/products/{id}
     * Exemple: http://localhost:8081/products/1
     */
    @GetMapping("/{id}")
    @CircuitBreaker(name = "productService")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        // Retourner le produit avec l'ID spécifié
        Product product = productService.getProductById(id);
        return product != null ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
    }

    /**
     * Endpoint pour créer un nouveau produit.
     * Méthode: POST
     * URL: http://localhost:8081/products
     * Corps de la requête (JSON):
     * {
     *   "name": "Nom du produit",
     *   "description": "Description du produit",
     *   "price": 10.0
     * }
     */
    @PostMapping
    @CircuitBreaker(name = "productService")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        // Ajouter un nouveau produit
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    /**
     * Endpoint pour mettre à jour un produit existant.
     * Méthode: PUT
     * URL: http://localhost:8081/products/{id}
     * Exemple: http://localhost:8081/products/1
     * Corps de la requête (JSON):
     * {
     *   "name": "Nouveau nom du produit",
     *   "description": "Nouvelle description du produit",
     *   "price": 15.0
     * }
     */
    @PutMapping("/{id}")
    @CircuitBreaker(name = "productService")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        // Mettre à jour un produit existant
        Product updatedProduct = productService.updateProduct(id, product);
        return updatedProduct != null ? ResponseEntity.ok(updatedProduct) : ResponseEntity.notFound().build();
    }

    /**
     * Endpoint pour supprimer un produit par ID.
     * Méthode: DELETE
     * URL: http://localhost:8081/products/{id}
     * Exemple: http://localhost:8081/products/1
     */
    @DeleteMapping("/{id}")
    @CircuitBreaker(name = "productService")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        // Supprimer le produit avec l'ID spécifié
        boolean isDeleted = productService.deleteProduct(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
