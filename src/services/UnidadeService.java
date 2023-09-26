package services;

import dao.UnidadeDAO;
import model.Unidade;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UnidadeService {
    private UnidadeDAO unidadeDAO;

    public UnidadeService(Connection conexao) {
        this.unidadeDAO = new UnidadeDAO(conexao);
    }

    public void adicionarUnidade(Unidade unidade) throws SQLException, SQLException {
        unidadeDAO.adicionarUnidade(unidade);
        System.out.println("*** SALVO => "+unidade);

    }

    public List<Unidade> listarUnidades() throws SQLException {
        return unidadeDAO.listarUnidades();
    }

    public void atualizarUnidade(Unidade unidade) throws SQLException {
        unidadeDAO.atualizarUnidade(unidade);
    }

    public void deletarUnidade(int id) throws SQLException {
        unidadeDAO.deletarUnidade(id);
    }

    public Unidade encontrarUnidadePorId(int id) throws SQLException {
        return unidadeDAO.encontrarUnidadePorId(id);
    }


}
