package cli;

import conexao.ConexaoMySQL;
import model.Unidade;
import services.UnidadeService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;


public class GerenciadorUnidade  {

    private static final Scanner scanner = new Scanner(System.in);

    public void adicionarUnidade() throws SQLException {
        System.out.println("\n--- Adicionar unidade ---");
        System.out.print("Digite o nome da unidade:");
        String nome = scanner.nextLine();

        System.out.print("Digite o simbolo da unidade:");
        String simbolo = scanner.nextLine();

        try (Connection conexao = ConexaoMySQL.obterConexao()) {
            UnidadeService unidadeService = new UnidadeService(conexao);
            unidadeService.adicionarUnidade(new Unidade(nome, simbolo));
            System.out.println("\n *** Unidade adicionada com sucesso! *** ");
        } catch (SQLException e) {
            System.out.println("ERRO: " + e);
            e.printStackTrace();
        }

    }

    public static void listarUnidades() {
        System.out.println("\n--- Lista de unidades ---");

        try (Connection conexao = ConexaoMySQL.obterConexao()) {
            UnidadeService unidadeService = new UnidadeService(conexao);
            for (Unidade unidade : unidadeService.listarUnidades()) {
                System.out.println("# " + unidade.getCodigo() + " Nome: " + unidade.getNome() + ", Simbolo: " + unidade.getSimbolo());
            }
        } catch (SQLException e) {
            System.out.println("ERRO: " + e);
            e.printStackTrace();
        }
    }

    public static void atualizarUnidade() {
        System.out.println("\n--- Atualizar unidade ---");

        System.out.print("Digite o codigo da unidade:");
        int codigo = scanner.nextInt();
        if (GerenciadorUnidade.encontrarUnidadePorId(codigo) != null) {

            scanner.nextLine();

            System.out.print("Digite o nome da unidade:");
            String nome = scanner.nextLine();

            System.out.print("Digite o simbolo da unidade:");
            String simbolo = scanner.nextLine();

            try (Connection conexao = ConexaoMySQL.obterConexao()) {
                UnidadeService unidadeService = new UnidadeService(conexao);
                unidadeService.atualizarUnidade(new Unidade(codigo, nome, simbolo));
                System.out.println("\n *** Unidade alterada com sucesso! *** ");
            } catch (SQLException e) {
                System.out.println("ERRO: " + e);
                e.printStackTrace();
            }

        } else {
            System.out.println("Unidade não encontrada");
        }


    }

    public static void deletarUnidade() {
        System.out.println("\n--- Deletar Unidade ---");
        System.out.print("Digite o codigo da unidade: ");
        int codigo = scanner.nextInt();

        try (Connection conexao = ConexaoMySQL.obterConexao()) {
            UnidadeService unidadeService = new UnidadeService(conexao);
            unidadeService.deletarUnidade(codigo);
            System.out.println("\n*** Codigo : " + codigo + " apagado ***");

        } catch (SQLException e) {
            System.out.println("ERRO: " + e);
            e.printStackTrace();
        }
    }

    public static Unidade encontrarUnidadePorId(int codigo) {

        try (Connection conexao = ConexaoMySQL.obterConexao()) {
            UnidadeService unidadeService = new UnidadeService(conexao);
            return unidadeService.encontrarUnidadePorId(codigo);

        } catch (SQLException e) {
            System.out.println("ERRO: " + e);
            e.printStackTrace();
            return null;
        }
    }
}
