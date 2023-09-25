package cli;

import conexao.ConexaoMySQL;
import model.Produto;
import services.ProdutoService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;


public class GerenciadorProduto {
    private static Scanner scanner = new Scanner(System.in);

    public static void adicionarProduto() {
        System.out.println("\n--- Adicionar produto ---");
        System.out.print("Digite o nome da produto:");
        String nome = scanner.nextLine();

        GerenciadorUnidade.listarUnidades();

        System.out.print("\nDigite o codigo da unidade:");
        int codigoUnidade = scanner.nextInt();
        scanner.nextLine();

        if (GerenciadorUnidade.encontrarUnidadePorId(codigoUnidade) != null) {
            try (Connection conexao = ConexaoMySQL.obterConexao()) {
                ProdutoService produtoService = new ProdutoService(conexao);
                produtoService.adicionarProduto(new Produto(nome, GerenciadorUnidade.encontrarUnidadePorId(codigoUnidade)));

                System.out.println("\n *** Produto adicionada com sucesso! *** ");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println(" *** Erro ao adicionar produto! *** ");
        }
    }

    public static void listarProdutos() {
        System.out.println("\n--- Lista de produtos ---");

        try (Connection conexao = ConexaoMySQL.obterConexao()) {
            ProdutoService produtoService = new ProdutoService(conexao);
            for (Produto produto : produtoService.listarProdutos()) {
                System.out.println("# " + produto.getCodigo() + " Nome: " + produto.getNome() + ", Un: " + produto.getUnidade().getSimbolo());
            }
            System.out.println("\n *** Produto adicionada com sucesso! *** ");

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void atualizarProduto() {
        System.out.println("\n--- Atualizar produto ---");

        System.out.print("Digite o codigo da produto:");
        int codigo = scanner.nextInt();

        if (GerenciadorProduto.encontrarProdutoPorId(codigo) != null) {
            Produto produto = GerenciadorProduto.encontrarProdutoPorId(codigo);
            scanner.nextLine();

            System.out.print("Digite o nome da produto:");
            String nome = scanner.nextLine();

            GerenciadorUnidade.listarUnidades();

            System.out.print("\nDigite o codigo da unidade:");
            int codigoUnidade = scanner.nextInt();

            scanner.nextLine();
            try (Connection conexao = ConexaoMySQL.obterConexao()) {
                if (!nome.isEmpty()) {
                    produto.setNome(nome);
                }
                produto.setUnidade(GerenciadorUnidade.encontrarUnidadePorId(codigoUnidade));
                ProdutoService produtoService = new ProdutoService(conexao);
                produtoService.atualizarProduto(produto);
                System.out.println("# " + produto.getCodigo() + " Nome: " + produto.getNome() + ", Un: " + produto.getUnidade().getSimbolo());

                System.out.println("\n *** Produto alterada com sucesso! *** ");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Produto não encontrada");
        }
    }

    public static void deletarProduto() {
        System.out.println("\n--- Deletar Produto ---");
        System.out.print("Digite o codigo da produto: ");
        int codigo = scanner.nextInt();
        if (GerenciadorProduto.encontrarProdutoPorId(codigo) != null) {
            Produto produto = GerenciadorProduto.encontrarProdutoPorId(codigo);

            try (Connection conexao = ConexaoMySQL.obterConexao()) {
                ProdutoService produtoService = new ProdutoService(conexao);
                produtoService.deletarProdutoPorCodigo(codigo);
                System.out.println("# " + produto.getCodigo() + " Nome: " + produto.getNome() + ", Un: " + produto.getUnidade().getSimbolo());
                System.out.println("\n*** Codigo : " + codigo + " apagado ***");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static Produto encontrarProdutoPorId(int codigo) {
        try (Connection conexao = ConexaoMySQL.obterConexao()) {
            ProdutoService produtoService = new ProdutoService(conexao);
            return produtoService.encontrarProdutoPorCodigo(codigo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
