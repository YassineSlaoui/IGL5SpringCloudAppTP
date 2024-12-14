package tn.rnu.fst.productservice.coreapi.aggregate;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import tn.rnu.fst.productservice.coreapi.command.CreateProductCommand;
import tn.rnu.fst.productservice.coreapi.event.ProductCreatedEvent;

@Data
@NoArgsConstructor
@Aggregate
public class ProductAggregate {
    @AggregateIdentifier
    private String id;
    private String name;
    private String description;
    private double price;
    private int stock;

    @CommandHandler
    public ProductAggregate(CreateProductCommand command) {
        // Publier un événement
        AggregateLifecycle.apply(ProductCreatedEvent.builder()
                .id(command.getId())
                .name(command.getName())
                .description(command.getDescription())
                .price(command.getPrice())
                .stock(command.getStock())
                .build());
    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();
        this.price = event.getPrice();
        this.stock = event.getStock();
    }
}
