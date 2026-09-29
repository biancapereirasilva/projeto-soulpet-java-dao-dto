package br.com.fiap.dto;

public class ComunidadeOng {
    private int id;
    private String nome;
    private String descricao;
    private String contato;

    public ComunidadeOng(){}

    public ComunidadeOng(int id, String nome, String descricao, String contato) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.contato = contato;
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

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String exibirImpacto(){
        return "ONG: " + nome + "\n" +
                "Descrição: " + descricao + "\n" +
                "Contato: " + contato;
    }
}
