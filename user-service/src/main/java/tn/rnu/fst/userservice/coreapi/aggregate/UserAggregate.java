package tn.rnu.fst.userservice.coreapi.aggregate;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import tn.rnu.fst.userservice.coreapi.command.CreateUserCommand;
import tn.rnu.fst.userservice.coreapi.event.UserCreatedEvent;

@Data
@NoArgsConstructor
@Aggregate
public class UserAggregate {
    @AggregateIdentifier
    private String id;
    private String username;
    private String password;
    private String email;

    @CommandHandler
    public UserAggregate(CreateUserCommand command) {
        // Publier un événement
        AggregateLifecycle.apply(UserCreatedEvent.builder()
                .id(command.getId())
                .username(command.getUsername())
                .password(command.getPassword())
                .email(command.getEmail())
                .build());
    }

    @EventSourcingHandler
    public void on(UserCreatedEvent event) {
        this.id = event.id();
        this.username = event.username();
        this.password = event.password();
        this.email = event.email();
    }
}
