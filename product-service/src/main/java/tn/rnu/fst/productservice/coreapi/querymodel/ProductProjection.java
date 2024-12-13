package tn.rnu.fst.productservice.coreapi.querymodel;

import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import tn.rnu.fst.productservice.coreapi.query.GetProductByIdQuery;
import tn.rnu.fst.productservice.entity.Product;
import tn.rnu.fst.productservice.repository.ProductRepository;

@RequiredArgsConstructor
@Component
public class ProductProjection {

    private final ProductRepository productRepository;

    @QueryHandler
    public Product handle(GetProductByIdQuery query) {
        return productRepository.findById(query.id()).orElse(null);
    }
}
