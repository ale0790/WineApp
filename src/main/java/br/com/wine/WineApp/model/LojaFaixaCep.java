package br.com.wine.WineApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class LojaFaixaCep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String codigoLoja;

    @Column(nullable = false)
    private String faixaInicio;

    @Column(nullable = false)
    private String faixaFim;

}
