package tn.rnu.fst.productservice.controller;

import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.*;
import tn.rnu.fst.productservice.coreapi.command.CreateProductCommand;
import tn.rnu.fst.productservice.coreapi.query.GetProductByIdQuery;
import tn.rnu.fst.productservice.entity.Product;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductCommandController {

    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;

    @PostMapping("/create-command")
    public String createProduct(@RequestBody Product product) {
        String id = UUID.randomUUID().toString();
        CreateProductCommand command = new CreateProductCommand(
                id, product.getName(), product.getDescription(), product.getPrice(),
                product.getStock());
        commandGateway.sendAndWait(command);
        return id;
    }

    @GetMapping("/get-query")
    public Product getProductById(@RequestParam String id) {
        return queryGateway.query(new GetProductByIdQuery(id), Product.class).join();
    }
}
