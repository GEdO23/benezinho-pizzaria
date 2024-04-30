package br.com.benefrancis.benezinhopizzaria.dto.request;

import br.com.benefrancis.benezinhopizzaria.entity.Produto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record PizzariaRequest(
        @NotNull(message = "Por favor, insira o nome.")
        String nome,

        @NotNull(message = "Por favor, insira o cardápio.")
        @Min(0)
        Set<Produto> cardapio
) {
}
