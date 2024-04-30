package br.com.benefrancis.benezinhopizzaria.dto.response;

import br.com.benefrancis.benezinhopizzaria.entity.Opcional;
import br.com.benefrancis.benezinhopizzaria.entity.Sabor;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.Set;

@Builder
public record ProdutoResponse(
        Long id,
        String nome,
        BigDecimal preco,
        Sabor sabor,
        Set<Opcional> opcionais
) {
}
