package tn.rnu.fst.userservice.coreapi.command;

import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
@RequiredArgsConstructor
public class CreateUserCommand {
    @TargetAggregateIdentifier
    private final String id;
    private final String username;
    private final String password;
    private final String email;
}