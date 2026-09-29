package br.com.fiap.dao;

import br.com.fiap.dto.Recompensa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecompensaDAO implements IDAO {
    private Connection con;
    private Recompensa recompensa;

    public RecompensaDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public String inserir(Object object) {
        recompensa = (Recompensa) object;
        String sql = "insert into soulpet_recompensa(id,nome,descricao,custoEmPontos,tipo,estoque) values(?,?,?,?,?,?)";
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, recompensa.getId());
            ps.setString(2, recompensa.getNome());
            ps.setString(3, recompensa.getDescricao());
            ps.setInt(4, recompensa.getCustoEmPontos());
            ps.setString(5, recompensa.getTipo());
            ps.setInt(6, recompensa.getEstoque());
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
        recompensa = (Recompensa) object;
        String sql = "update soulpet_recompensa set nome = ?, descricao = ?, custoEmPontos = ?, tipo = ?, estoque = ? where id = ?";
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setString(1, recompensa.getNome());
            ps.setString(2, recompensa.getDescricao());
            ps.setInt(3, recompensa.getCustoEmPontos());
            ps.setString(4, recompensa.getTipo());
            ps.setInt(5, recompensa.getEstoque());
            ps.setInt(6, recompensa.getId());
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
        recompensa = (Recompensa) object;
        String sql = "delete from soulpet_recompensa where id = ?";
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, recompensa.getId());
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
        recompensa = (Recompensa) object;
        String sql = "select * from soulpet_recompensa where id = ?";
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, recompensa.getId());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return "Id: " + rs.getInt("id")
                            + "\nNome: " + rs.getString("nome")
                            + "\nDescrição: " + rs.getString("descricao")
                            + "\nCusto em pontos: " + rs.getInt("custoEmPontos")
                            + "\nTipo: " + rs.getString("tipo")
                            + "\nEstoque: " + rs.getInt("estoque");
                } else {
                    return "Registro não encontrado";
                }
            }
        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }
}
