package tn.rnu.fst.productservice.coreapi.command;

import lombok.Builder;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Builder
public record CreateProductCommand(
        @TargetAggregateIdentifier
        String id,
        String name,
        String description,
        double price,
        int stock
) {
}