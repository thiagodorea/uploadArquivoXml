package com.tdorea.uploadarquivos.dtos;

import com.tdorea.uploadarquivos.entities.Agente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Builder
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AgenteDto implements Serializable {
        private static final long serialVersionUID = 1L;

        private UUID id;

        private Integer codigo;

        private Date data;

        private List<RegiaoDto> regiao;

        public AgenteDto(Agente agente) {
                this.id = agente.getId();
                this.codigo = agente.getCodigo();
                this.data = agente.getData();
                this.regiao = agente.getRegiao().stream().map(RegiaoDto::new).collect(Collectors.toList());
        }

}
