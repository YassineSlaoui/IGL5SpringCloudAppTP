package tn.rnu.fst.userservice.coreapi.query;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Builder
public class GetUserByIdQuery {
    private final String id;
}