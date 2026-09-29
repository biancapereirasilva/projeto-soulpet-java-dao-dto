package br.com.fiap.main;

import br.com.fiap.dao.*;
import br.com.fiap.dto.*;

import javax.swing.JOptionPane;
import java.sql.Connection;

public class Main {
    static Connection con = ConnectionFactory.abrirConexao();
    static UsuarioDAO usuarioDAO = new UsuarioDAO(con);
    static MissaoDAO missaoDAO = new MissaoDAO(con);
    static RecompensaDAO recompensaDAO = new RecompensaDAO(con);
    static ComunidadeOngDAO comunidadeOngDAO = new ComunidadeOngDAO(con);

    static void main(String[] args) {
        String auxiliar, nome, email, senha, telefone, descricao, tipo, contato, dataTexto;
        int opcao, id, pontos, pontosRecompensa, custoEmPontos, estoque, acao;
        boolean concluida;

        do {
            try {
                auxiliar = JOptionPane.showInputDialog("O que deseja manipular?\n1 - Usuário\n2 - Missão\n3 - Recompensa\n4 - Comunidade ONG");
                opcao = Integer.parseInt(auxiliar);

                switch (opcao) {
                    case 1:
                        auxiliar = JOptionPane.showInputDialog("Usuário:\n1 - Inserir\n2 - Alterar\n3 - Excluir");
                        acao = Integer.parseInt(auxiliar);
                        auxiliar = JOptionPane.showInputDialog("Digite o id do usuário:");
                        id = Integer.parseInt(auxiliar);

                        if (acao == 1) {
                            nome = JOptionPane.showInputDialog("Nome:");
                            email = JOptionPane.showInputDialog("Email:");
                            senha = JOptionPane.showInputDialog("Senha:");
                            telefone = JOptionPane.showInputDialog("Telefone:");
                            auxiliar = JOptionPane.showInputDialog("Pontos:");
                            pontos = Integer.parseInt(auxiliar);
                            String nivel = JOptionPane.showInputDialog("Nível:");
                            Usuario usuario = new Usuario(id, nome, email, senha, telefone, pontos, nivel);
                            JOptionPane.showMessageDialog(null, usuarioDAO.inserir(usuario), "Resultado", JOptionPane.INFORMATION_MESSAGE);
                        } else if (acao == 2) {
                            nome = JOptionPane.showInputDialog("Novo nome:");
                            email = JOptionPane.showInputDialog("Novo email:");
                            senha = JOptionPane.showInputDialog("Nova senha:");
                            telefone = JOptionPane.showInputDialog("Novo telefone:");
                            auxiliar = JOptionPane.showInputDialog("Novos pontos:");
                            pontos = Integer.parseInt(auxiliar);
                            String nivel = JOptionPane.showInputDialog("Novo nível:");
                            Usuario usuario = new Usuario(id, nome, email, senha, telefone, pontos, nivel);
                            JOptionPane.showMessageDialog(null, usuarioDAO.alterar(usuario), "Resultado", JOptionPane.INFORMATION_MESSAGE);
                        } else if (acao == 3) {
                            Usuario usuario = new Usuario();
                            usuario.setId(id);
                            JOptionPane.showMessageDialog(null, usuarioDAO.excluir(usuario), "Resultado", JOptionPane.INFORMATION_MESSAGE);
                        }

                        Usuario usuarioConsulta = new Usuario();
                        usuarioConsulta.setId(id);
                        JOptionPane.showMessageDialog(null, usuarioDAO.listarUm(usuarioConsulta), "Consulta", JOptionPane.INFORMATION_MESSAGE);
                        break;

                    case 2:
                        auxiliar = JOptionPane.showInputDialog("Missão:\n1 - Inserir\n2 - Alterar\n3 - Excluir");
                        acao = Integer.parseInt(auxiliar);
                        auxiliar = JOptionPane.showInputDialog("Digite o id da missão:");
                        id = Integer.parseInt(auxiliar);

                        if (acao == 1) {
                            String titulo = JOptionPane.showInputDialog("Título:");
                            descricao = JOptionPane.showInputDialog("Descrição:");
                            auxiliar = JOptionPane.showInputDialog("Pontos de recompensa:");
                            pontosRecompensa = Integer.parseInt(auxiliar);
                            auxiliar = JOptionPane.showInputDialog("Concluída (true/false):");
                            concluida = Boolean.parseBoolean(auxiliar);
                            Missao missao = new Missao(id, titulo, descricao, pontosRecompensa, concluida);
                            JOptionPane.showMessageDialog(null, missaoDAO.inserir(missao), "Resultado", JOptionPane.INFORMATION_MESSAGE);
                        } else if (acao == 2) {
                            String titulo = JOptionPane.showInputDialog("Novo título:");
                            descricao = JOptionPane.showInputDialog("Nova descrição:");
                            auxiliar = JOptionPane.showInputDialog("Novos pontos de recompensa:");
                            pontosRecompensa = Integer.parseInt(auxiliar);
                            auxiliar = JOptionPane.showInputDialog("Concluída (true/false):");
                            concluida = Boolean.parseBoolean(auxiliar);
                            Missao missao = new Missao(id, titulo, descricao, pontosRecompensa, concluida);
                            JOptionPane.showMessageDialog(null, missaoDAO.alterar(missao), "Resultado", JOptionPane.INFORMATION_MESSAGE);
                        } else if (acao == 3) {
                            Missao missao = new Missao();
                            missao.setId(id);
                            JOptionPane.showMessageDialog(null, missaoDAO.excluir(missao), "Resultado", JOptionPane.INFORMATION_MESSAGE);
                        }

                        Missao missaoConsulta = new Missao();
                        missaoConsulta.setId(id);
                        JOptionPane.showMessageDialog(null, missaoDAO.listarUm(missaoConsulta), "Consulta", JOptionPane.INFORMATION_MESSAGE);
                        break;

                    case 3:
                        auxiliar = JOptionPane.showInputDialog("Recompensa:\n1 - Inserir\n2 - Alterar\n3 - Excluir");
                        acao = Integer.parseInt(auxiliar);
                        auxiliar = JOptionPane.showInputDialog("Digite o id da recompensa:");
                        id = Integer.parseInt(auxiliar);

                        if (acao == 1) {
                            nome = JOptionPane.showInputDialog("Nome:");
                            descricao = JOptionPane.showInputDialog("Descrição:");
                            auxiliar = JOptionPane.showInputDialog("Custo em pontos:");
                            custoEmPontos = Integer.parseInt(auxiliar);
                            tipo = JOptionPane.showInputDialog("Tipo:");
                            auxiliar = JOptionPane.showInputDialog("Estoque:");
                            estoque = Integer.parseInt(auxiliar);
                            Recompensa recompensa = new Recompensa(id, nome, descricao, custoEmPontos, tipo, estoque);
                            JOptionPane.showMessageDialog(null, recompensaDAO.inserir(recompensa), "Resultado", JOptionPane.INFORMATION_MESSAGE);
                        } else if (acao == 2) {
                            nome = JOptionPane.showInputDialog("Novo nome:");
                            descricao = JOptionPane.showInputDialog("Nova descrição:");
                            auxiliar = JOptionPane.showInputDialog("Novo custo em pontos:");
                            custoEmPontos = Integer.parseInt(auxiliar);
                            tipo = JOptionPane.showInputDialog("Novo tipo:");
                            auxiliar = JOptionPane.showInputDialog("Novo estoque:");
                            estoque = Integer.parseInt(auxiliar);
                            Recompensa recompensa = new Recompensa(id, nome, descricao, custoEmPontos, tipo, estoque);
                            JOptionPane.showMessageDialog(null, recompensaDAO.alterar(recompensa), "Resultado", JOptionPane.INFORMATION_MESSAGE);
                        } else if (acao == 3) {
                            Recompensa recompensa = new Recompensa();
                            recompensa.setId(id);
                            JOptionPane.showMessageDialog(null, recompensaDAO.excluir(recompensa), "Resultado", JOptionPane.INFORMATION_MESSAGE);
                        }

                        Recompensa recompensaConsulta = new Recompensa();
                        recompensaConsulta.setId(id);
                        JOptionPane.showMessageDialog(null, recompensaDAO.listarUm(recompensaConsulta), "Consulta", JOptionPane.INFORMATION_MESSAGE);
                        break;

                    case 4:
                        auxiliar = JOptionPane.showInputDialog("Comunidade ONG:\n1 - Inserir\n2 - Alterar\n3 - Excluir");
                        acao = Integer.parseInt(auxiliar);
                        auxiliar = JOptionPane.showInputDialog("Digite o id da ONG:");
                        id = Integer.parseInt(auxiliar);

                        if (acao == 1) {
                            nome = JOptionPane.showInputDialog("Nome:");
                            descricao = JOptionPane.showInputDialog("Descrição:");
                            contato = JOptionPane.showInputDialog("Contato:");
                            ComunidadeOng comunidadeOng = new ComunidadeOng(id, nome, descricao, contato);
                            JOptionPane.showMessageDialog(null, comunidadeOngDAO.inserir(comunidadeOng), "Resultado", JOptionPane.INFORMATION_MESSAGE);
                        } else if (acao == 2) {
                            nome = JOptionPane.showInputDialog("Novo nome:");
                            descricao = JOptionPane.showInputDialog("Nova descrição:");
                            contato = JOptionPane.showInputDialog("Novo contato:");
                            ComunidadeOng comunidadeOng = new ComunidadeOng(id, nome, descricao, contato);
                            JOptionPane.showMessageDialog(null, comunidadeOngDAO.alterar(comunidadeOng), "Resultado", JOptionPane.INFORMATION_MESSAGE);
                        } else if (acao == 3) {
                            ComunidadeOng comunidadeOng = new ComunidadeOng();
                            comunidadeOng.setId(id);
                            JOptionPane.showMessageDialog(null, comunidadeOngDAO.excluir(comunidadeOng), "Resultado", JOptionPane.INFORMATION_MESSAGE);
                        }

                        ComunidadeOng comunidadeOngConsulta = new ComunidadeOng();
                        comunidadeOngConsulta.setId(id);
                        JOptionPane.showMessageDialog(null, comunidadeOngDAO.listarUm(comunidadeOngConsulta), "Consulta", JOptionPane.INFORMATION_MESSAGE);
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }

        } while (JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Atenção", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);

        ConnectionFactory.fecharConexao(con);
        JOptionPane.showMessageDialog(null, "Fim de programa!", null, JOptionPane.WARNING_MESSAGE);
    }
}
