package loja.model;

public class Roupa extends Produto {
    private String tamanho;
    private String cor;
    private String material;

    public Roupa(int codigo, String nome, double preco, int quantidadedeEstoque, String tamanho, String cor, String material) {
        super(codigo, nome, preco, quantidadedeEstoque);
        this.tamanho = tamanho;
        this.cor = cor;
        this.material = material;
    }

    @Override
    public double aplicarDesconto() {
        setPreco(getPreco() * 0.90);
        return getPreco();
    }    

    @Override
    public String toString() {
        return super.toString() + tamanho + "\n" + cor + "\n" + material + "\n";
    }
    
}