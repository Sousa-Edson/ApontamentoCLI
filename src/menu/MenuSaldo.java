package menu;

import cli.GerenciadorMovimentacao;
import cli.GerenciadorProduto;

import java.util.Scanner;

public class MenuSaldo {

    private static Scanner scanner = new Scanner(System.in);

    public static void menuSaldo() {
        boolean sair = false;
        int codigoProduto = 0;
        while (!sair) {
            System.out.print("Digite o id do produto para saldo: ");
            codigoProduto = scanner.nextInt();
            if (GerenciadorProduto.encontrarProdutoPorId(codigoProduto) != null) {
                GerenciadorMovimentacao.saldoProduto(codigoProduto);
                System.out.println("");

                    sair = true;

            } else {
                System.out.println("*** Produto não encontrado! ***");
                sair = false;
            }

        }
    }
}






