package br.com.benefrancis.benezinhopizzaria.dto.response;

import br.com.benefrancis.benezinhopizzaria.entity.Produto;
import lombok.Builder;

import java.util.Set;

@Builder
public record PizzariaResponse(
        Long id,
        String nome,
        Set<Produto> cardapio
) {
}
