package tn.rnu.fst.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.*;
import tn.rnu.fst.userservice.coreapi.command.CreateUserCommand;
import tn.rnu.fst.userservice.coreapi.query.GetUserByIdQuery;
import tn.rnu.fst.userservice.entity.User;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserCommandController {

    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;

    @PostMapping("/create-command")
    public String createUser(@RequestBody User user) {
        String id = UUID.randomUUID().toString();
        CreateUserCommand command = CreateUserCommand.builder()
                .id(id)
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .build();
        commandGateway.sendAndWait(command);
        return id;
    }

    @GetMapping("/get-query")
    public User getUserById(@RequestParam String id) {
        return queryGateway.query(new GetUserByIdQuery(id), User.class).join();
    }
}
