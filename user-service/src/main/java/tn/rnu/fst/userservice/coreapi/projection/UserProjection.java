package tn.rnu.fst.userservice.coreapi.projection;

import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import tn.rnu.fst.userservice.coreapi.event.UserCreatedEvent;
import tn.rnu.fst.userservice.coreapi.query.GetUserByIdQuery;
import tn.rnu.fst.userservice.entity.User;
import tn.rnu.fst.userservice.repository.UserRepository;

@RequiredArgsConstructor
@Component
public class UserProjection {

    private final UserRepository userRepository;

    @QueryHandler
    public User handle(GetUserByIdQuery query) {
        return userRepository.findById(query.getId()).orElse(null);
    }

    @EventHandler
    public void on(UserCreatedEvent event) {
        userRepository.save(User.builder()
                .id(event.getId())
                .username(event.getUsername())
                .password(event.getPassword())
                .email(event.getEmail())
                .build());
    }
}
