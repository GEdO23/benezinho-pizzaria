package br.com.benefrancis.benezinhopizzaria.dto.response;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record OpcionalResponse(
        Long id,
        String nome,
        BigDecimal preco
) {
}
