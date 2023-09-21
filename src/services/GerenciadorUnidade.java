package services;

import model.Unidade;

import java.util.Scanner;


public class GerenciadorUnidade implements GerenciadorEstoque {
    private static Scanner scanner = new Scanner(System.in);

    public static void adicionarUnidade() {
        System.out.println("\n--- Adicionar unidade ---");
        System.out.print("Digite o nome da unidade:");
        String nome = scanner.nextLine();

        System.out.print("Digite o simbolo da unidade:");
        String simbolo = scanner.nextLine();

        unidades.add(new Unidade(nome, simbolo));
        System.out.println("\n *** Unidade adicionada com sucesso! *** ");
    }

    public static void listarUnidades() {
        System.out.println("\n--- Lista de unidades ---");
        for (Unidade unidade : unidades) {
            System.out.println("# " + unidade.getCodigo() + " Nome: " + unidade.getNome() + ", Simbolo: " + unidade.getSimbolo());
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

            for (Unidade unidade : unidades) {
                if (unidade.getCodigo() == codigo) {
                    unidade.setNome(nome);
                    unidade.setSimbolo(simbolo);
                    System.out.println("\n *** Unidade alterada com sucesso! *** ");
                    break;
                }
            }
        } else {
            System.out.println("Unidade não encontrada");
        }


    }

    public static void deletarUnidade() {
        System.out.println("\n--- Deletar Unidade ---");
        System.out.print("Digite o codigo da unidade: ");
        int codigo = scanner.nextInt();
        for (Unidade unidade : unidades) {
            if (unidade.getCodigo() == codigo) {
                unidades.remove(unidade);
                System.out.println("\n*** Codigo : " + codigo + " apagado ***");
                break;
            }
        }
    }

    public static Unidade encontrarUnidadePorId(int codigo) {
        for (Unidade unidade : unidades) {
            if (unidade.getCodigo() == codigo) {
                return unidade;
            }
        }
        return null;
    }
}
