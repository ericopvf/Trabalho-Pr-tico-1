package loja.model;

public class Produto {
    private int codigo;
    private String nome;
    private double preco;
    private int quantidadedeEstoque;


public Produto(int codigo, String nome, double preco, int quantidadedeEstoque) {
    this.codigo = codigo;
    this.nome = nome;
    this.preco = preco;
    this.quantidadedeEstoque = quantidadedeEstoque;
}

public int getCodigo() {
    if (codigo <= 0) {
        return 1;
    }
    else {
        return codigo;
    }
}

public void setCodigo(int codigo) {
    if (codigo <= 0) {
        System.out.println("Erro, não existe código negativo.");
    }
    else {
        this.codigo = codigo;
    }
}

public String getNome() {
    if (nome == null || nome.length() == 0) {
        return ("Erro, a variável nome está vazia.");
    }
    else {
        return nome;
    }
}

public void setNome(String nome) {
    if (nome == null || nome.trim().length() == 0) {
        System.out.println("Erro, não é possível alocar vazio ao nome de um produto.");
    }
    else {
        this.nome = nome;
    }
}

public double getPreco() {
    if (preco <= 0) {
        System.out.println("Erro, o preço está negativa ou igual a 0.");
        return 0;
    }
    else {
        return preco;
    }
}

public void setPreco(double preco) {
    if (preco <= 0) {
        System.out.println("Erro, preço fornecido é negativo ou igual a 0.");
    }
    else {
        this.preco = preco;
    }
}

public int getQuantidadedeEstoque() {
    if (quantidadedeEstoque < 0) {
        System.out.println("Erro, quantidade de estoque menor que 0.");
        return -1;
    }
    else {
        return quantidadedeEstoque;
    }
}

public void setQuantidadedeEstoque(int quantidadedeEstoque) {
    this.quantidadedeEstoque = quantidadedeEstoque;
}

public double aplicarDesconto() {
    this.preco = preco * 0.95;
    return (this.preco);
}

public double calcularPrecoComDesconto() {
    return this.preco * 0.95;
}

public String toString() {
    return "Informações do produto:" + "\n" + codigo + "\n" + nome + "\n" + preco + "\n" + quantidadedeEstoque + "\n";
}

}