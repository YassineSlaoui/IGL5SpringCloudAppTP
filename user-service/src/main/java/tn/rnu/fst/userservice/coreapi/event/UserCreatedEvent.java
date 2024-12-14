package tn.rnu.fst.userservice.coreapi.event;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Builder
public class UserCreatedEvent {
    private final String id;
    private final String username;
    private final String password;
    private final String email;
}