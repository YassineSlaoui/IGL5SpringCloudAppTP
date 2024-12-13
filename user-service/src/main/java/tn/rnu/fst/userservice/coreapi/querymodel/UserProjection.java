package tn.rnu.fst.userservice.coreapi.querymodel;

import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import tn.rnu.fst.userservice.coreapi.query.GetUserByIdQuery;
import tn.rnu.fst.userservice.entity.User;
import tn.rnu.fst.userservice.repository.UserRepository;

@RequiredArgsConstructor
@Component
public class UserProjection {

    private final UserRepository userRepository;

    @QueryHandler
    public User handle(GetUserByIdQuery query) {
        return userRepository.findById(query.getId()).orElse(User.builder().username("not found").build());
    }
}
