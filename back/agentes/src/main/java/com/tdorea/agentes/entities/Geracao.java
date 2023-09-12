package com.tdorea.agentes.entities;

import com.tdorea.agentes.dto.GeracaoDto;
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
@Table(name="geracao")
public class Geracao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @UuidGenerator
    private UUID id;

    private ArrayList<Double> valor;

    public Geracao(GeracaoDto geracaoDto) {
        this.id = geracaoDto.getId();
        this.valor = geracaoDto.getValor();
    }

}
