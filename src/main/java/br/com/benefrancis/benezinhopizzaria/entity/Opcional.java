package br.com.benefrancis.benezinhopizzaria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TB_OPCIONAL")
public class Opcional {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_OPCIONAL")
    @SequenceGenerator(
            name = "SQ_OPCIONAL",
            sequenceName = "SQ_OPCIONAL",
            initialValue = 1,
            allocationSize = 1
    )
    @Column(    name = "ID_OPCIONAL")
    private Long id;

    @Column(name = "NM_OPCIONAL")
    private String nome;

    @Column(name = "VL_OPCIONAL")
    private BigDecimal preco;

}