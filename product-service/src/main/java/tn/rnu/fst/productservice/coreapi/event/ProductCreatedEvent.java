package tn.rnu.fst.productservice.coreapi.event;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class ProductCreatedEvent {
    private final String id;
    private final String name;
    private final String description;
    private final double price;
    private final int stock;
}