package com.tdorea.agentes.entities;

import com.tdorea.agentes.dto.PrecoMedioDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UuidGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
@Table(name="preco_medio")
public class PrecoMedio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @UuidGenerator
    private UUID id;

    private ArrayList<Double> valor;

    public PrecoMedio(PrecoMedioDto precoMedioDto) {
        this.id = precoMedioDto.getId();
        this.valor = precoMedioDto.getValor();
    }
}
