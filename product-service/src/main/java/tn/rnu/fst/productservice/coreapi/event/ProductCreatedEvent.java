package tn.rnu.fst.productservice.coreapi.event;

import lombok.Builder;

@Builder
public record ProductCreatedEvent(
        String id,
        String name,
        String description,
        double price,
        int stock
) {
}
