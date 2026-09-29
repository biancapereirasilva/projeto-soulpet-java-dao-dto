package br.com.fiap.dto;

public class Recompensa {
    private int id;
    private String nome;
    private String descricao;
    private int custoEmPontos;
    private String tipo;
    private int estoque;

    public Recompensa(){}

    public Recompensa(int id, String nome, String descricao, int custoEmPontos, String tipo, int estoque){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.custoEmPontos = custoEmPontos;
        this.tipo = tipo;
        this.estoque = estoque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCustoEmPontos() {
        return custoEmPontos;
    }

    public void setCustoEmPontos(int custoEmPontos) {
        this.custoEmPontos = custoEmPontos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public void resgatar() {
        if (this.estoque > 0) {
            this.estoque--;
        }
    }
}
