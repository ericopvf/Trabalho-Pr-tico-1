package loja.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Alimento extends Produto {
    private String dataValidade; // Formato: DD / MM / AAAA
    private String tipo; // perecível ou não-perecível

    public Alimento(int codigo, String nome, double preco, int quantidadedeEstoque, String dataValidade, String tipo) {
        super(codigo, nome, preco, quantidadedeEstoque);
        this.dataValidade = dataValidade;
        this.tipo = tipo;
    }

    @Override
    public double aplicarDesconto() {
        setPreco(getPreco() * 0.97);
        return getPreco();
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public boolean estaVencido() {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/aaaa");
        LocalDate dataValidade2 = LocalDate.parse(this.dataValidade, formatador);
        return dataValidade2.isBefore(LocalDate.now());
    }

    @Override
    public String toString() {
        return super.toString() + dataValidade + "\n" + tipo + "\n";
    }
}