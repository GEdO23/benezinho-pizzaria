package br.com.benefrancis.benezinhopizzaria.dto.request;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record OpcionalRequest(
        @NotNull(message = "Por favor, insira o nome.")
        String nome,

        @NotNull(message = "Por favor, insira o preço")
        BigDecimal preco
) {
}
