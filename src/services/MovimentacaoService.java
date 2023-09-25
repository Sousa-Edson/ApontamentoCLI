package services;

import dao.MovimentacaoDAO;
import model.Movimentacao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MovimentacaoService {
    private MovimentacaoDAO movimentacaoDAO;

    public MovimentacaoService(Connection conexao) {
        this.movimentacaoDAO = new MovimentacaoDAO(conexao);
    }

    public void adicionarMovimentacao(Movimentacao movimentacao) throws SQLException {
        movimentacaoDAO.adicionarMovimentacao(movimentacao);
    }

    public List<Movimentacao> listarMovimentacoes() throws SQLException {
        return movimentacaoDAO.listarMovimentacoes();
    }

    public Movimentacao encontrarMovimentacaoPorCodigo(int codigo) throws SQLException {
        return movimentacaoDAO.encontrarMovimentacaoPorCodigo(codigo);
    }

    public void atualizarMovimentacao(Movimentacao movimentacao) throws SQLException {
        movimentacaoDAO.atualizarMovimentacao(movimentacao);
    }

    public void deletarMovimentacaoPorCodigo(int codigo) throws SQLException {
        movimentacaoDAO.deletarMovimentacaoPorCodigo(codigo);
    }
}

