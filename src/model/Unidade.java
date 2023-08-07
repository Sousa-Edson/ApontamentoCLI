package model;

public class Unidade {
    private static int contador = 0;
    int codigo;
    String nome;
    String simbolo;


    public Unidade() {
    }

    public Unidade(String nome,String simbolo) {
        this.codigo = ++contador;
        this.nome = nome;
        this.simbolo = simbolo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    @Override
    public String toString() {
        return "Unidade{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", simbolo='" + simbolo + '\'' +
                '}';
    }
}
