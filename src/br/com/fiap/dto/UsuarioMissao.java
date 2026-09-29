package br.com.fiap.dto;

import java.time.LocalDate;

public class UsuarioMissao {
    private int id;
    private boolean concluida;
    private String dataConclusao;

    public UsuarioMissao(){}

    public UsuarioMissao(int id, boolean concluida, String dataConclusao) {
        this.id = id;
        this.concluida = concluida;
        this.dataConclusao = dataConclusao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public String getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(String dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public void concluir(){
        this.concluida = true;
        this.dataConclusao = LocalDate.now().toString();
    }
}
