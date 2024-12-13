package tn.rnu.fst.userservice.coreapi.command;

import lombok.Builder;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Builder
public record CreateUserCommand(
        @TargetAggregateIdentifier
        String id,
        String username,
        String password,
        String email
) {
}