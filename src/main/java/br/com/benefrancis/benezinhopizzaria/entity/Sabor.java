package br.com.benefrancis.benezinhopizzaria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TB_SABOR")
public class Sabor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_SABOR")
    @SequenceGenerator(
            name = "SQ_SABOR",
            sequenceName = "SQ_SABOR",
            initialValue = 1,
            allocationSize = 1
    )
    @Column(name = "ID_SABOR")
    private Long id;


    @Column(name = "NM_SABOR")
    private String nome;

    @Column(name = "DS_SABOR")
    private String descricao;

}