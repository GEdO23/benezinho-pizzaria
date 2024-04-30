package br.com.benefrancis.benezinhopizzaria.dto.request;

import br.com.benefrancis.benezinhopizzaria.entity.Opcional;
import br.com.benefrancis.benezinhopizzaria.entity.Sabor;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Set;

public record ProdutoRequest(
        @NotNull(message = "Por favor, insira o nome.")
        String nome,

        @Min(0)
        @NotNull(message = "Por favor, insira o preço.")
        BigDecimal preco,

        @NotNull(message = "Por favor, insira o sabor.")
        Sabor sabor,

        Set<Opcional> opcionais
) {
}
