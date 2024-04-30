package br.com.benefrancis.benezinhopizzaria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Id
 * Nome
 * Cardapio (produtos)
 * */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "TB_PIZZARIA")
public class Pizzaria {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PIZZARIA")
    @SequenceGenerator(
            name = "SQ_PIZZARIA",
            sequenceName = "SQ_PIZZARIA",
            initialValue = 1,
            allocationSize = 1
    )
    @Column(name = "ID_PIZZARIA")
    private Long id;


    @Column(name = "NM_PIZZARIA")
    private String nome;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "TB_CARDAPIO",
            joinColumns = {
                    @JoinColumn(
                            name = "PIZZARIA",
                            referencedColumnName = "ID_PIZZARIA",
                            foreignKey = @ForeignKey(name = "FK_PIZZARIA_CARDAPIO")
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "PRODUTO",
                            referencedColumnName = "ID_PRODUTO",
                            foreignKey = @ForeignKey(name = "FK_CARDAPIO_PIZZARIA")
                    )
            }
    )
    private Set<Produto> cardapio = new LinkedHashSet<>();
}
