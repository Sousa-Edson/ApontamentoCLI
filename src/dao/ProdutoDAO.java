package dao;

import model.Produto;
import model.Unidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    private Connection conexao;

    public ProdutoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    // Método para adicionar um produto ao banco de dados
    public void adicionarProduto(Produto produto) throws SQLException {
        String sql = "INSERT INTO produtos ( nome, unidade_id) VALUES (?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getUnidade().getCodigo());
            stmt.executeUpdate();
        }
    }

    // Método para listar todos os produtos do banco de dados
    public List<Produto> listarProdutos() throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT p.*, u.nome AS nome_unidade, u.sigla AS sigla_unidade FROM produtos p " +
                "INNER JOIN unidades u ON p.unidade_id = u.id";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setCodigo(rs.getInt("codigo"));
                produto.setNome(rs.getString("nome"));

                Unidade unidade = new Unidade();
                unidade.setCodigo(rs.getInt("unidade_id"));
                unidade.setNome(rs.getString("nome_unidade"));
                unidade.setSimbolo(rs.getString("sigla_unidade"));

                produto.setUnidade(unidade);

                produtos.add(produto);
            }
        }

        return produtos;
    }

    // Método para encontrar um produto pelo seu código
    public Produto encontrarProdutoPorCodigo(int codigo) throws SQLException {
        String sql = "SELECT p.*, u.nome AS nome_unidade, u.sigla AS sigla_unidade FROM produtos p " +
                "INNER JOIN unidades u ON p.unidade_id = u.id " +
                "WHERE p.codigo = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, codigo);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Produto produto = new Produto();
                    produto.setCodigo(rs.getInt("codigo"));
                    produto.setNome(rs.getString("nome"));

                    Unidade unidade = new Unidade();
                    unidade.setCodigo(rs.getInt("unidade_id"));
                    unidade.setNome(rs.getString("nome_unidade"));
                    unidade.setSimbolo(rs.getString("sigla_unidade"));

                    produto.setUnidade(unidade);

                    return produto;
                } else {
                    // Retorna null se o produto não for encontrado
                    return null;
                }
            }
        }
    }

    // Método para atualizar um produto no banco de dados
    public void atualizarProduto(Produto produto) throws SQLException {
        String sql = "UPDATE produtos SET nome = ?, unidade_id = ? WHERE codigo = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getUnidade().getCodigo());
            stmt.setInt(3, produto.getCodigo());
            stmt.executeUpdate();
        }
    }

    // Método para deletar um produto do banco de dados pelo seu código
    public void deletarProdutoPorCodigo(int codigo) throws SQLException {
        String sql = "DELETE FROM produtos WHERE codigo = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        }
    }
}
