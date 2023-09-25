package dao;

import enums.TipoMovimento;
import model.Movimentacao;
import model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovimentacaoDAO {
    private Connection conexao;

    public MovimentacaoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    // Método para adicionar uma movimentação ao banco de dados
    public void adicionarMovimentacao(Movimentacao movimentacao) throws SQLException {
        String sql = "INSERT INTO movimentacoes (codigo, tipo_movimento, produto_id, quantidade) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, movimentacao.getCodigo());
            stmt.setString(2, movimentacao.getTipoMovimento().toString());
            stmt.setInt(3, movimentacao.getProduto().getCodigo());
            stmt.setInt(4, movimentacao.getQuantidade());
            stmt.executeUpdate();
        }
    }

    // Método para listar todas as movimentações do banco de dados
    public List<Movimentacao> listarMovimentacoes() throws SQLException {
        List<Movimentacao> movimentacoes = new ArrayList<>();
        String sql = "SELECT m.*, p.nome AS nome_produto, p.unidade_id, p.codigo AS codigo_produto " +
                "FROM movimentacoes m " +
                "INNER JOIN produtos p ON m.produto_id = p.codigo";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Movimentacao movimentacao = new Movimentacao();
                movimentacao.setCodigo(rs.getInt("codigo"));
                movimentacao.setTipoMovimento(TipoMovimento.valueOf(rs.getString("tipo_movimento")));

                Produto produto = new Produto();
                produto.setCodigo(rs.getInt("codigo_produto"));
                produto.setNome(rs.getString("nome_produto"));
                // Configurar a unidade do produto, se necessário
                // produto.setUnidade(unidade);

                movimentacao.setProduto(produto);
                movimentacao.setQuantidade(rs.getInt("quantidade"));

                movimentacoes.add(movimentacao);
            }
        }

        return movimentacoes;
    }

    // Método para encontrar uma movimentação pelo seu código
    public Movimentacao encontrarMovimentacaoPorCodigo(int codigo) throws SQLException {
        String sql = "SELECT m.*, p.nome AS nome_produto, p.unidade_id, p.codigo AS codigo_produto " +
                "FROM movimentacoes m " +
                "INNER JOIN produtos p ON m.produto_id = p.codigo " +
                "WHERE m.codigo = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, codigo);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Movimentacao movimentacao = new Movimentacao();
                    movimentacao.setCodigo(rs.getInt("codigo"));
                    movimentacao.setTipoMovimento(TipoMovimento.valueOf(rs.getString("tipo_movimento")));

                    Produto produto = new Produto();
                    produto.setCodigo(rs.getInt("codigo_produto"));
                    produto.setNome(rs.getString("nome_produto"));
                    // Configurar a unidade do produto, se necessário
                    // produto.setUnidade(unidade);

                    movimentacao.setProduto(produto);
                    movimentacao.setQuantidade(rs.getInt("quantidade"));

                    return movimentacao;
                } else {
                    // Retorna null se a movimentação não for encontrada
                    return null;
                }
            }
        }
    }

    // Método para atualizar uma movimentação no banco de dados
    public void atualizarMovimentacao(Movimentacao movimentacao) throws SQLException {
        String sql = "UPDATE movimentacoes SET tipo_movimento = ?, produto_id = ?, quantidade = ? WHERE codigo = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, movimentacao.getTipoMovimento().toString());
            stmt.setInt(2, movimentacao.getProduto().getCodigo());
            stmt.setInt(3, movimentacao.getQuantidade());
            stmt.setInt(4, movimentacao.getCodigo());
            stmt.executeUpdate();
        }
    }

    // Método para deletar uma movimentação do banco de dados pelo seu código
    public void deletarMovimentacaoPorCodigo(int codigo) throws SQLException {
        String sql = "DELETE FROM movimentacoes WHERE codigo = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        }
    }
}
