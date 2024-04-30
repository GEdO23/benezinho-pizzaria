package br.com.benefrancis.benezinhopizzaria.dto.response;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record SaborResponse(
        Long id,
        String nome,
        String descricao
) {
}
