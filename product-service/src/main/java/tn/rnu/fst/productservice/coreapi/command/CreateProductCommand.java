package tn.rnu.fst.productservice.coreapi.command;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
@RequiredArgsConstructor
public class CreateProductCommand {
    @TargetAggregateIdentifier
    private final String id;
    private final String name;
    private final String description;
    private final double price;
    private final int stock;
}