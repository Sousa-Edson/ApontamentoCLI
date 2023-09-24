package model;

public class Unidade {
    int codigo;
    String nome;
    String simbolo;


    public Unidade() {
    }

    public Unidade(String nome, String simbolo) {
        this.nome = nome;
        this.simbolo = simbolo;
    }

    public Unidade(int codigo, String nome, String simbolo) {
        this.codigo = codigo;
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
