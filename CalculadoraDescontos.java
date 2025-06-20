/*
Classe CalculadoraDescontos (classe utilitária)
● Métodos:
○ double calcularTotal(Produto[] produtos) – Calcula o valor total dos produtos com descontos.
○ void listarProdutos(Produto[] produtos) – Lista todos os produtos da loja.
○ Produto encontrarProdutoMaisCaro(Produto[] produtos) – Retorna o mais caro (sem considerar desconto).
○ Produto encontrarProdutoMaisBarato(Produto[] produtos) – Retorna o mais barato (com desconto).
*/

package loja.util;

import loja.model.Produto;
import java.util.ArrayList;

public class CalculadoraDescontos {

    public static void listarProdutos(ArrayList<Produto> produtos) {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        System.out.println("Lista de Produtos cadastrados:");
        for (Produto p : produtos) {
            System.out.println(p.toString());
        }
    }

    public static void aplicarDescontoPorCodigo(ArrayList<Produto> produtos, int codigo) {
        boolean encontrado = false;
        for (Produto p : produtos) {
            if (p.getCodigo() == codigo) {
                System.out.println("Código do produto: " + p.getCodigo());
                System.out.println("Preço original: R$ " + p.getPreco());
                double novoPreco = p.aplicarDesconto(); 
                System.out.println("Novo preço com desconto: R$ " + novoPreco);
                encontrado = true;
                break;
            }
        }
        if (encontrado == false) {
            System.out.println("Produto não encontrado.");
        }
    }

    public static double calcularTotal(ArrayList<Produto> produtos) {
        double total = 0;
        System.out.println("Preço total desse tipo de produto vezes a quantidade em estoque dele:");
        for (Produto p : produtos) {
            total += p.calcularPrecoComDesconto();
        }
        return total;
    }

    public static Produto encontrarProdutoMaisCaro(ArrayList<Produto> produtos) {
        if (produtos.isEmpty()) return null;
        Produto maisCaro = produtos.get(0);
        for (Produto p : produtos) {
            if (p.getPreco() > maisCaro.getPreco()) {
                maisCaro = p;
            }
        }
        return maisCaro;
    }

    public static Produto encontrarProdutoMaisBarato(ArrayList<Produto> produtos) {
        if (produtos.isEmpty()) return null;
        Produto maisBarato = produtos.get(0);
        double menorPreco = maisBarato.calcularPrecoComDesconto();
        for (Produto p : produtos) {
            double precoComDesconto = p.calcularPrecoComDesconto();
            if (precoComDesconto < menorPreco) {
                menorPreco = precoComDesconto;
                maisBarato = p;
            }
        }
        return maisBarato;
    }
}