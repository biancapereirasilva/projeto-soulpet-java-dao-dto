package br.com.fiap.dto;

public class Missao {
    private int id;
    private String titulo;
    private String descricao;
    private int pontosRecompensa;
    private boolean concluida;

    public Missao(){}

    public Missao(int id, String titulo, String descricao, int pontosRecompensa, boolean concluida){
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.pontosRecompensa = pontosRecompensa;
        this.concluida = concluida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPontosRecompensa() {
        return pontosRecompensa;
    }

    public void setPontosRecompensa(int pontosRecompensa) {
        this.pontosRecompensa = pontosRecompensa;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public void concluirMissao() {
        this.concluida = true;
    }

    public String exibirMissao(){
        return "Missão: " + titulo + "\n" +
                "Descrição: " + descricao + "\n" +
                "Pontos: " + pontosRecompensa + "\n" +
                "Missão concluída: " + concluida;
    }
}
