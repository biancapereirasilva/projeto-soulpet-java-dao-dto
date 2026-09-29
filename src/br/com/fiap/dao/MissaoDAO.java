package br.com.fiap.dao;

import br.com.fiap.dto.Missao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MissaoDAO implements IDAO {
    private Connection con;
    private Missao missao;

    public MissaoDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public String inserir(Object object) {
        missao = (Missao) object;
        String sql = "insert into soulpet_missao(id,titulo,descricao,pontosRecompensa,concluida) values(?,?,?,?,?)";
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, missao.getId());
            ps.setString(2, missao.getTitulo());
            ps.setString(3, missao.getDescricao());
            ps.setInt(4, missao.getPontosRecompensa());
            ps.setBoolean(5, missao.isConcluida());
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
        missao = (Missao) object;
        String sql = "update soulpet_missao set titulo = ?, descricao = ?, pontosRecompensa = ?, concluida = ? where id = ?";
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setString(1, missao.getTitulo());
            ps.setString(2, missao.getDescricao());
            ps.setInt(3, missao.getPontosRecompensa());
            ps.setBoolean(4, missao.isConcluida());
            ps.setInt(5, missao.getId());
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
        missao = (Missao) object;
        String sql = "delete from soulpet_missao where id = ?";
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, missao.getId());
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
        missao = (Missao) object;
        String sql = "select * from soulpet_missao where id = ?";
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, missao.getId());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return "Id: " + rs.getInt("id")
                            + "\nTítulo: " + rs.getString("titulo")
                            + "\nDescrição: " + rs.getString("descricao")
                            + "\nPontos: " + rs.getInt("pontosRecompensa")
                            + "\nConcluída: " + rs.getBoolean("concluida");
                } else {
                    return "Registro não encontrado";
                }
            }
        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }
}
