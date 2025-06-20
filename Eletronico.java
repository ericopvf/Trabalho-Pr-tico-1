package loja.model;

public class Eletronico extends Produto {
    private String marca;
    private String modelo;
    private int garantiaMeses;
    
    public Eletronico(int codigo, String nome, double preco, int quantidadedeEstoque, String marca, String modelo, int garantiaMeses) {
        super(codigo, nome, preco, quantidadedeEstoque);
        this.marca = marca;
        this.modelo = modelo;
        this.garantiaMeses = garantiaMeses;
    }

    @Override
    public double aplicarDesconto() {
        setPreco(getPreco() * 0.93);
        return getPreco();
    }

    @Override
    public String toString() {
        return super.toString() + marca + "\n" + modelo + "\n" + garantiaMeses + "\n";
    }
}