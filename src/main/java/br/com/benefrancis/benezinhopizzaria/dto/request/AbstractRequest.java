package br.com.benefrancis.benezinhopizzaria.dto.request;

import jakarta.validation.constraints.NotNull;

public record AbstractRequest(
        @NotNull(message = "Por favor insira o ID.")
        Long id
) {
}
