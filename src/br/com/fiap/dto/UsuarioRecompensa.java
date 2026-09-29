package br.com.fiap.dto;

import java.time.LocalDate;

public class UsuarioRecompensa {
    private int id;
    private String dataResgate;

    public UsuarioRecompensa(){}

    public UsuarioRecompensa(int id, String dataResgate) {
        this.id = id;
        this.dataResgate = dataResgate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataResgate() {
        return dataResgate;
    }

    public void setDataResgate(String dataResgate) {
        this.dataResgate = dataResgate;
    }

    public void resgatar(){
        this.dataResgate = LocalDate.now().toString();
    }
}
