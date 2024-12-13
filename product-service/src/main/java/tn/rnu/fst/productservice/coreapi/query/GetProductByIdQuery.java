package tn.rnu.fst.productservice.coreapi.query;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Builder
public class GetProductByIdQuery {
    private final String id;
}