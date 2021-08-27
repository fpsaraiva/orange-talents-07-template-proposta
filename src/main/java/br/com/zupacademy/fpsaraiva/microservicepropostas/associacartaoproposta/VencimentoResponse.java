package br.com.zupacademy.fpsaraiva.microservicepropostas.associacartaoproposta;

import java.time.LocalDateTime;

public class VencimentoResponse {

    private String id;

    private Integer dia;

    private LocalDateTime dataDeCriacao;

    public VencimentoResponse(String id, Integer dia, LocalDateTime dataDeCriacao) {
        this.id = id;
        this.dia = dia;
        this.dataDeCriacao = dataDeCriacao;
    }

    public Vencimento toModel() {
        return new Vencimento(id, dia, dataDeCriacao);
    }

    public String getId() {
        return id;
    }

    public Integer getDia() {
        return dia;
    }

    public LocalDateTime getDataDeCriacao() {
        return dataDeCriacao;
    }

}
