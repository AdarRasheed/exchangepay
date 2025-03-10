package com.exercise.transformers;

import java.util.List;
import java.util.stream.Collectors;

public interface Transformer<DTO, Domain> {

    Domain toDomain(DTO dto);

    DTO toDTO(Domain domain);

    default List<Domain> toDomains(List<DTO> dtos) {
        return dtos.stream().map(this::toDomain).collect(Collectors.toList());
    }

}
