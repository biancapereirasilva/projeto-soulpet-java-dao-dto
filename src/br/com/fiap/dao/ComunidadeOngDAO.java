package br.com.fiap.dao;

import br.com.fiap.dto.ComunidadeOng;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ComunidadeOngDAO implements IDAO {
    private Connection con;
    private ComunidadeOng comunidadeOng;

    public ComunidadeOngDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public String inserir(Object object) {
        comunidadeOng = (ComunidadeOng) object;
        String sql = "insert into soulpet_comunidadeong(id,nome,descricao,contato) values(?,?,?,?)";
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, comunidadeOng.getId());
            ps.setString(2, comunidadeOng.getNome());
            ps.setString(3, comunidadeOng.getDescricao());
            ps.setString(4, comunidadeOng.getContato());
            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso.";
            } else {
                return "Erro ao inserir";
            }
        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }

    public String alterar(Object object) {
        comunidadeOng = (ComunidadeOng) object;
        String sql = "update soulpet_comunidadeong set nome = ?, descricao = ?, contato = ? where id = ?";
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setString(1, comunidadeOng.getNome());
            ps.setString(2, comunidadeOng.getDescricao());
            ps.setString(3, comunidadeOng.getContato());
            ps.setInt(4, comunidadeOng.getId());
            if (ps.executeUpdate() > 0) {
                return "Alterado com sucesso.";
            } else {
                return "Erro ao alterar";
            }
        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }

    public String excluir(Object object) {
        comunidadeOng = (ComunidadeOng) object;
        String sql = "delete from soulpet_comunidadeong where id = ?";
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, comunidadeOng.getId());
            if (ps.executeUpdate() > 0) {
                return "Excluído com sucesso.";
            } else {
                return "Erro ao excluir";
            }
        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }

    public String listarUm(Object object) {
        comunidadeOng = (ComunidadeOng) object;
        String sql = "select * from soulpet_comunidadeong where id = ?";
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, comunidadeOng.getId());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return "Id: " + rs.getInt("id")
                            + "\nNome: " + rs.getString("nome")
                            + "\nDescrição: " + rs.getString("descricao")
                            + "\nContato: " + rs.getString("contato");
                } else {
                    return "Registro não encontrado";
                }
            }
        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }
}
