package br.com.benefrancis.benezinhopizzaria.dto.request;

import jakarta.validation.constraints.NotNull;

public record SaborRequest(
        @NotNull(message = "Por favor, insira o nome.")
        String nome,
        String descricao
) {
}
