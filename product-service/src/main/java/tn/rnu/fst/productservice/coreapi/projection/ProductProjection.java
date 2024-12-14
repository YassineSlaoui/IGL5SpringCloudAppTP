package tn.rnu.fst.productservice.coreapi.projection;

import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import tn.rnu.fst.productservice.coreapi.event.ProductCreatedEvent;
import tn.rnu.fst.productservice.coreapi.query.GetProductByIdQuery;
import tn.rnu.fst.productservice.entity.Product;
import tn.rnu.fst.productservice.repository.ProductRepository;

@RequiredArgsConstructor
@Component
public class ProductProjection {

    private final ProductRepository productRepository;

    @QueryHandler
    public Product handle(GetProductByIdQuery query) {
        return productRepository.findById(query.getId()).orElse(null);
    }

    @EventHandler
    public void on(ProductCreatedEvent event) {
        productRepository.save(Product.builder()
                .id(event.getId())
                .name(event.getName())
                .description(event.getDescription())
                .price(event.getPrice())
                .stock(event.getStock())
                .build());
    }
}
