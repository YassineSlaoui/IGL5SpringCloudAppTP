package tn.rnu.fst.userservice.coreapi.event;

import lombok.Builder;

@Builder
public record UserCreatedEvent(
        String id,
        String username,
        String password,
        String email
) {
}
