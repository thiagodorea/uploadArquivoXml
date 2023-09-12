package com.tdorea.uploadarquivos.entities;

import com.tdorea.uploadarquivos.dtos.PrecoMedioDto;
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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

@Builder
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class PrecoMedio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private ArrayList<Double> valor;

    public PrecoMedio(PrecoMedioDto precoMedioDto) {
        this.id = precoMedioDto.getId();
        this.valor = precoMedioDto.getValor();
    }
}
