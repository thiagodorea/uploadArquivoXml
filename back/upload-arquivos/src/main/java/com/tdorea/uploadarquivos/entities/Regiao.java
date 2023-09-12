package com.tdorea.uploadarquivos.entities;


import com.tdorea.uploadarquivos.dtos.RegiaoDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;
import java.util.UUID;

@Builder
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class Regiao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @XmlAttribute
    private String sigla;

    @OneToOne
    private Geracao geracao;

    @OneToOne
    private Compra compra;

    @OneToOne
    private PrecoMedio precoMedio;

    public Regiao(RegiaoDto regiaoDto) {
        this.id = regiaoDto.getId();
        this.sigla = regiaoDto.getSigla();
        this.geracao = new Geracao(regiaoDto.getGeracao());
        this.compra = new Compra(regiaoDto.getCompra());
        this.precoMedio = new PrecoMedio(regiaoDto.getPrecoMedio());
    }
}
