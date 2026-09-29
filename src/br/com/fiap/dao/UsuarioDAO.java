package br.com.fiap.dao;

import br.com.fiap.dto.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO implements IDAO {
    private Connection con;
    private Usuario usuario;

    public UsuarioDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public String inserir(Object object) {
        usuario = (Usuario) object;
        String sql = "insert into soulpet_usuario(id,nome,email,senha,telefone,pontos,nivel) values(?,?,?,?,?,?,?)";
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, usuario.getId());
            ps.setString(2, usuario.getNome());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, usuario.getSenha());
            ps.setString(5, usuario.getTelefone());
            ps.setInt(6, usuario.getPontos());
            ps.setString(7, usuario.getNivel());
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
        usuario = (Usuario) object;
        String sql = "update soulpet_usuario set nome = ?, email = ?, senha = ?, telefone = ?, pontos = ?, nivel = ? where id = ?";
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getSenha());
            ps.setString(4, usuario.getTelefone());
            ps.setInt(5, usuario.getPontos());
            ps.setString(6, usuario.getNivel());
            ps.setInt(7, usuario.getId());
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
        usuario = (Usuario) object;
        String sql = "delete from soulpet_usuario where id = ?";
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, usuario.getId());
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
        usuario = (Usuario) object;
        String sql = "select * from soulpet_usuario where id = ?";
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, usuario.getId());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return "Id: " + rs.getInt("id")
                            + "\nNome: " + rs.getString("nome")
                            + "\nEmail: " + rs.getString("email")
                            + "\nTelefone: " + rs.getString("telefone")
                            + "\nPontos: " + rs.getInt("pontos")
                            + "\nNível: " + rs.getString("nivel");
                } else {
                    return "Registro não encontrado";
                }
            }
        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }
}
